package chapter3.stack.stack_generic;

public class StackEmptyException extends RuntimeException {
    public StackEmptyException() {
        super("Stack is empty");
    }
}
