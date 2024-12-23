package org.live.chapter1.singledton;

public class Logger {

    private static Logger instance;

    private Logger()
    {

    }

    public synchronized static Logger getInstance()
    {
        if (instance==null)
            instance =new Logger();
        return instance;
    }

}
