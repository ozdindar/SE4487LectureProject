package chapter6.delayedExecution;

import java.util.function.Supplier;

public class Logger {

    LogLevel level;

    public Logger(LogLevel level) {
        this.level = level;
    }

    void log(LogLevel level, Supplier<String> logGenerator )
    {
        if (level ==this.level) {
            System.out.println(logGenerator.get()+ " is logged..");
        }
    }

    public static void main(String[] args) {
        Logger logger = new Logger(LogLevel.Debug);

        logger.log(LogLevel.Debug,Logger::createInfo);

    }

    private static String createInfo() {
        System.out.println("a very expensive operation performed...");
        return "Generated Info";
    }


}
