package chapter3.stack.stack_generic;

import chapter3.stack.stack_notgeneric.StackEmptyException;
import chapter3.stack.stack_notgeneric.StackFullException;

import java.util.*;

public class Stack<T> {
    T[] arr;
    int capacity;
    int current;

    public Stack(int capacity) {
        this.capacity = capacity;
        arr = (T[]) new Object[capacity];
    }

    void pushAll(Collection<? extends T> items)
    {
        for (T item:items)
            push(item);
    }

    void push(T item)
    {
        if (current>=capacity) // Stack is full
            throw new StackFullException();

        arr[current++] = item;
    }

    void popAll(Collection<? super T> items)
    {
        while (!isEmpty())
            items.add(pop());
    }

    T pop()
    {
        if (current==0) // Stack is empty
            throw  new StackEmptyException();

        return arr[--current];
    }

    private boolean isEmpty() {
        return current<=0;
    }



    public static void main(String[] args) {
        Stack<Number> stack = new Stack<>(4);

        List<Integer> list = Arrays.asList(1,2,3,4);
        List<Double> dlist = Arrays.asList(1.0,2.2,3.4,4.1);
        stack.pushAll(list);
        stack.pushAll(dlist);

        Stack<Integer> s = new Stack(5);
        Stack<Double> ds = new Stack(5);

        List<Integer> items = Arrays.asList(1,2,3,5);

        s.pushAll(items);
        ds.pushAll(Arrays.asList(1.3, 5.6));

        List<Number> targetList= new ArrayList<>();
        s.popAll(targetList);
        ds.popAll(targetList);

        System.out.println(targetList);

    }



}
