package loggingEx;

public class File implements Logger {

    private String dstName;
    public File(String s) {
        dstName = s;
    }

    @Override
    public boolean connect() {
        if (dstName == null) {
            return false;
        }
        System.out.println("opening file " + dstName);
        return true;
    }

    @Override
    public boolean disconnect() {
        if (dstName == null) return false;
        System.out.println("closing file " + dstName);
        return true;
    }

    @Override
    public boolean log(String message) {
        if (dstName == null) return false;
        System.out.println("writing " + message +" to file " + dstName);
        return true;
    }
}
