package chapter3.stack.stack_notgeneric;

public class StackFullException extends RuntimeException {
    public StackFullException() {
        super("Stack is full");
    }
}
