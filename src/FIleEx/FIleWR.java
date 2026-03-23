package FIleEx;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class FIleWR {

    public static void main(String[] args) throws IOException {
        String currentPath = System.getProperty("user.dir");
        String FILE_NAME = currentPath + "/tmp/file_wr.txt";


        try (BufferedWriter bfw = new BufferedWriter(new FileWriter(FILE_NAME, StandardCharsets.UTF_8))){
            bfw.write("Hello World");
        }

        try (BufferedReader bfr = new BufferedReader(new FileReader(FILE_NAME, StandardCharsets.UTF_8))) {
            int data;
            while ((data = bfr.read()) != -1) {
                System.out.print((char)data); // 한 글자씩 출력
            }
        }

    }

}
