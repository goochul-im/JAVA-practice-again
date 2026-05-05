package ioEx;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

public class StandardIOEx {

    static void main() {
        String currentPath = System.getProperty("user.dir");
        String fileName = currentPath + "/tmp/io3.txt";

        PrintStream ps = null;
        FileOutputStream fos = null;

        try {

            fos = new FileOutputStream(fileName);
            ps = new PrintStream(fos);
            System.setOut(ps); // 표준 출력을 ps로 변경. ps는 fos를 감싸고 있음.
        } catch (FileNotFoundException e) {
            System.err.println("File Not Found");
        }

        String s1 = new String();
        String s2 = new String();
        System.out.println(s1.equals(s2));

        System.out.println("Hello By System");
        System.err.println("Hello By err");
    }

}
