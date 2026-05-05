package ioEx;

import java.io.*;
import java.util.ArrayList;

public class DeserializableEx {

    static void main() {
        String currentPath = System.getProperty("user.dir");
        String filename = currentPath + "/tmp/serial.bat";

        FileInputStream outputStream = null;
        BufferedInputStream bufferedOutputStream = null;
        ObjectInputStream objectOutputStream = null;

        try {
            outputStream = new FileInputStream(filename);
            bufferedOutputStream = new BufferedInputStream(outputStream);
            objectOutputStream = new ObjectInputStream(bufferedOutputStream);

            //객체를 읽을 때는 출력한 순서와 일치해야 한다.
            UserInfo u1 = (UserInfo) objectOutputStream.readObject();
            UserInfo u2 = (UserInfo) objectOutputStream.readObject();
            UserInfo u3 = (UserInfo) objectOutputStream.readObject();
            ArrayList userInfos = (ArrayList) objectOutputStream.readObject();


            System.out.println("u1 : "  + (u1==userInfos.get(0)));
            System.out.println("u2 : "  + (u2==userInfos.get(1)));
            System.out.println("u3 : "  + (u3==userInfos.get(2)));

            System.out.println("직렬화 끝");
            objectOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            System.err.println("Class를 찾지 못함");
        }

    }

}
