package loggingEx;

public interface Logger {

    boolean connect();

    boolean disconnect();

    boolean log(String message);

}
