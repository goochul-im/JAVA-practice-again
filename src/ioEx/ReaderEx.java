package ioEx;

import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;

public class ReaderEx {

    public static void main(String[] args) {
        String currentPath = System.getProperty("user.dir");
        String fileName = currentPath + "/tmp/io.txt";

        try {

            FileInputStream inputStream = new FileInputStream(fileName);
            FileReader reader = new FileReader(fileName);

            int data;
            while ((data = inputStream.read()) != -1) {
                System.out.print((char)data);
            }

            System.out.println();

            while ((data = reader.read()) != -1) {
                System.out.print((char)data);
            }
            System.out.println();
            inputStream.close();
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
