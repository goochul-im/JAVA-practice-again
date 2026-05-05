package ioEx;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;

public class BufferedReaderEx {

    public static void main(String[] args) {
        String currentPath = System.getProperty("user.dir");
        String fileName = currentPath + "/tmp/io2.txt";

        try {

            FileReader reader = new FileReader(fileName);
            BufferedReader reader1 = new BufferedReader(reader);


            String line;
            while ((line = reader1.readLine()) != null) {
                System.out.println(line);
            }
            System.out.println();
            reader1.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
