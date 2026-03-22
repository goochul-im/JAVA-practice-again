package FIleEx;

import java.io.*;

public class BufferStream {

    public static void main(String[] args) throws IOException {

        FileOutputStream fos = new FileOutputStream("/tmp/employee.dat");
        BufferedOutputStream bos = new BufferedOutputStream(fos);

        bos.write(0);
        bos.close();

        FileInputStream fis = new FileInputStream("/tmp/employee.dat");
        BufferedInputStream bis = new BufferedInputStream(fis);

        int ch = bis.read();
        System.out.println(ch);
        bis.close();

    }

}
