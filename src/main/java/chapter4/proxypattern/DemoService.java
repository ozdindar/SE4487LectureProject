package chapter4.proxypattern;


import utils.ThreadUtil;

import java.security.SecureRandom;

public class DemoService implements Service{
    @Override
    public int funcA() {
        ThreadUtil.sleepFor(new SecureRandom().nextInt(20));
        return 0;
    }

    @Override
    public int funcB() {
        ThreadUtil.sleepFor(new SecureRandom().nextInt(30));
        return 1;
    }

    @Override
    public int funcC() {
        ThreadUtil.sleepFor(new SecureRandom().nextInt(40));
        return 2;
    }

    @Override
    public void printReport() {
        System.out.println("No audit report generated..");
    }
}
