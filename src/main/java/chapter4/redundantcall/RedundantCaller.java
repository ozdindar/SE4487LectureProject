package chapter4.redundantcall;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.*;
import java.util.concurrent.Callable;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.Future;




/**
 * Created by dindar.oz on 5/9/2018.
 */
public class RedundantCaller<I> implements InvocationHandler{

    public class Task implements Callable<Object> {

        private Object targetObject;
        private Method method;
        private Object[] args;

        public Task(Object targetObject,Method method, Object[] args) {
            this.method = method;
            this.args = args;
            this.targetObject= targetObject;
        }

        @Override
        public Object call() throws Exception {
            return method.invoke(targetObject, args);
        }

    }

    private final Class<?> targetClass;
    Object target;

    List<Object> targetCopies= new ArrayList<>();

    RedundantCaller(Object target)
    {
        this.targetCopies.add( target);
        this.targetClass = target.getClass();
        this.target = target;
    }


    public static <I> I createObject(Object target)
    {
        return (I) Proxy.newProxyInstance(target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),
                new RedundantCaller<I>(target));
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        // Some methods are supposed to be run for the proxy object itself
        if(Object.class == method.getDeclaringClass()) {
            String name = method.getName();
            if("equals".equals(name)) {
                return proxy == args[0];
            } else if("hashCode".equals(name)) {
                return System.identityHashCode(proxy);
            } else if("toString".equals(name)) {
                return proxy.getClass().getName() + "@" +
                        Integer.toHexString(System.identityHashCode(proxy)) +
                        ", with InvocationHandler " + this;
            } else {
                throw new IllegalStateException(String.valueOf(method));
            }
        }
        // check if the method is annotated as RedundantCall
        if (method.isAnnotationPresent(RedundantCall.class))
        {
            int voteCount = method.getAnnotation(RedundantCall.class).voteCount();
            buildTargetCopies(voteCount);

            boolean multithreaded =  method.getAnnotation(RedundantCall.class)
                                    .multithreaded();
            if (multithreaded) {
                List<Future<Object>> list = redundantRun(method, args,voteCount);
                return threadedVoting(list);
            }
            else return singleThreadedVoting(method, args,voteCount);
        }
        // Run the original method once otherwise
        else{
            return method.invoke(target,args);
        }

    }

    private void buildTargetCopies(int voteCount) throws Throwable{
        if (voteCount>targetCopies.size())
        {
            while (targetCopies.size()!=voteCount)
            {
                targetCopies.add(targetClass.getMethod("clone").invoke(targetCopies.get(0)));
            }
        }

        while (targetCopies.size()!=voteCount)
        {
            targetCopies.remove(0);
        }

    }

    private Object singleThreadedVoting(Method method, Object[] args, int voteCount) {
        System.out.println("Calling the method: " + method.getName() + " redundantly with vote count:"+ voteCount);
        System.out.println("Single Threaded Voting");
        List<Object> returnValueList = new ArrayList<Object>();
        for (int i = 0; i < voteCount; i++) {

            try {
                returnValueList.add(method.invoke(targetCopies.get(i), args));
            } catch (Exception e) {
                // Not expecting to enter here
                e.printStackTrace();
            }

        }
        return resolveVoting(returnValueList);
    }


    private List<Future<Object>> redundantRun(Method method, Object[] args, int voteCount) {

        System.out.println("Calling the method: " + method.getName() + " redundantly with vote count:"+ voteCount);
        System.out.println("Multi Threaded Voting");
        ForkJoinPool fjp = new ForkJoinPool(voteCount);
        Collection<Callable<Object> > callables= new ArrayList<>();

        for (int i = 0; i < voteCount; i++) {

            Callable<Object> callableObj = new Task(targetCopies.get(i),method, args);
            callables.add(callableObj);
        }

        List<Future<Object> > list = fjp.invokeAll(callables);
        return list;
    }

    private Object threadedVoting(List<Future<Object>> list) {
        List<Object> returnValueList = new ArrayList<Object>();
        for (Future<Object> future : list) {
            try {
              //Waits if necessary for the computation to complete, and then retrieves its result.
                returnValueList.add(future.get());

            } catch (Exception e) {
                // Not expecting to enter here
                e.printStackTrace();
            }
        }
        return resolveVoting(returnValueList);
    }

    private Object resolveVoting(List<Object> returnValueList) 
    {
        Dictionary<Object,Integer> dictionary= buildDictionary(returnValueList);
        Object mostFrequent = getMostFrequent(dictionary);
        return mostFrequent;
    }

    private Object getMostFrequent(Dictionary<Object, Integer> dictionary) {

        if (dictionary.size()==1)
            return dictionary.keys().nextElement();

        Enumeration<Object> keys = dictionary.keys();
        Object mostFrequent = keys.nextElement();
        int mostFrequency = dictionary.get(mostFrequent);

        while (keys.hasMoreElements())
        {
            Object o = keys.nextElement();
            int frequency = dictionary.get(o);
            if (frequency>mostFrequency)
            {
                mostFrequency=frequency;
                mostFrequent=o;
            }
        }
        return mostFrequent;

    }

    private Dictionary<Object,Integer> buildDictionary(List<Object> returnValueList) {
        Dictionary<Object,Integer> dictionary = new Hashtable<>();
        for(Object returnValue: returnValueList){
            if (dictionary.get(returnValue)==null)
                dictionary.put(returnValue,1);
            else
                dictionary.put(returnValue,dictionary.get(returnValue)+1);
        }
        return dictionary;
    }


    public static void main(String[] args) {

       
       // IMatrix rm = RedundantCaller.createObject(m);

    }
}
