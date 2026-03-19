import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class OutputStreamEx {

    public static void main(String[] args) throws IOException {
        String currentPath = System.getProperty("user.dir");
        System.out.println(currentPath);

        FileOutputStream fileOutputStream = new FileOutputStream(currentPath + "/tmp/test.dat");

        byte[] data = new byte[3] ;
        data[0] = 16;
        data[1] = 32;
        data[2] = 64;

        fileOutputStream.write(data);
        fileOutputStream.close();
    }

}
