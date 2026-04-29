package loggingEx;

public class Console implements Logger {

    private String dstName;
    public Console(String s) {
        dstName = s;
    }

    @Override
    public boolean connect() {
        return true;
    }

    @Override
    public boolean disconnect() {
        return true;
    }

    @Override
    public boolean log(String message) {
        System.out.println(message);
        return true;
    }
}
