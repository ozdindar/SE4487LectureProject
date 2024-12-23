package chapter9.synchronizeddemo;

public class Demo {
    public static void main(String[] args) {
        Prompter prompter= new Prompter();

        PromptTask task1 = new PromptTask(prompter,"Hello");
        PromptTask task2 = new PromptTask(prompter,"Java");
        PromptTask task3 = new PromptTask(prompter,"World");

        new Thread(task1).start();
        new Thread(task2).start();
        new Thread(task3).start();
    }
}
