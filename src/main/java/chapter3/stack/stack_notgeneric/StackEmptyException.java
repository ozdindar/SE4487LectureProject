package chapter3.stack.stack_notgeneric;

public class StackEmptyException extends RuntimeException {
    public StackEmptyException() {
        super("Stack is empty");
    }
}
