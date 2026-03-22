package FIleEx;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class OutputStreamEx2 {

    public static void main(String[] args) throws IOException {
        String currentPath = System.getProperty("user.dir");
        System.out.println(currentPath);

        FileOutputStream fileOutputStream = new FileOutputStream(currentPath + "/tmp/test2.dat");

        byte[] data = {'A','B','C','D','E','F'};

        fileOutputStream.write(data,3,2); //3번째 오프셋부터 2개의 길이만큼의 data를 write 해라
        fileOutputStream.close(); //flush가 포함됨

        FileInputStream fileInputStream = new FileInputStream(currentPath + "/tmp/test2.dat");
        int curData;

        while ((curData = fileInputStream.read()) != -1) {
            System.out.println((char)curData);
        }

    }

}
