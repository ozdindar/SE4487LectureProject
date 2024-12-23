package chapter3.stack.stack_notgeneric;

public class Stack {
    Object[] arr;
    int capacity;
    int current;

    public Stack(int capacity) {
        this.capacity = capacity;
        arr= new Object[capacity];
        current=0;
    }

    void push(Object item)
    {
        if (current>=capacity) // Stack is full
            throw new StackFullException();

        arr[current++] = item;
    }

    Object pop()
    {
        if (current==0) // Stack is empty
            throw  new StackEmptyException();

        return arr[--current];
    }

    public static void main(String[] args) {
        Stack s = new Stack(3);

        s.push(1);
        s.push("Object");
        s.push(2);
        s.push(3);
        System.out.println(s.pop());
        s.pop();
        s.pop();
        s.pop();
    }

}
