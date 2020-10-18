package blog.helpers;


import org.apache.log4j.Logger;

public class Log {
    public static org.apache.log4j.Logger getLogger() {
        final Throwable t = new Throwable();
        final StackTraceElement methodCaller = t.getStackTrace()[2];
        return Logger.getLogger(methodCaller.getClassName());
    }

    public static int numberOfLine() {
        final Throwable t = new Throwable();
        final StackTraceElement methodCaller = t.getStackTrace()[2];
        return methodCaller.getLineNumber();
    }


    public static void consoleMessage(String text) {
            getLogger().info(numberOfLine() + " " + text);
    }


}