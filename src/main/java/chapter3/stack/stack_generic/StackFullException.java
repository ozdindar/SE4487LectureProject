package chapter3.stack.stack_generic;

public class StackFullException extends RuntimeException {
    public StackFullException() {
        super("Stack is full");
    }
}
