package chapter4.redundantcall;

public interface DemoInterface {

   // @RedundantCall(voteCount = 3,multithreaded = true)
    int calculate1() throws Throwable;

    @RedundantCall(voteCount = 5,multithreaded = true)
    int calculate2() throws Throwable;


}
