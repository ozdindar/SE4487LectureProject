package chapter4.redundantcall;

public class Demo {
    public static void main(String[] args) throws Throwable{

        System.out.println("Started...");
        DemoInterface di = RedundantCaller.createObject(new DemoClass());

        di.calculate1();

        System.out.println(di.calculate2());
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
