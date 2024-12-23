package chapter9.synchronizeddemo;

public class PromptTask implements Runnable{
    final Prompter prompter;
    final String msg;

    public PromptTask(Prompter prompter, String msg) {
        this.prompter = prompter;
        this.msg = msg;
    }


    @Override
    public void run() {
        try {
            prompter.prompt(msg);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
