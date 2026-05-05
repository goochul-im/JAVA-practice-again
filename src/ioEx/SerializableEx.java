package ioEx;

import java.io.*;
import java.util.ArrayList;

public class SerializableEx {

    static void main() {
        String currentPath = System.getProperty("user.dir");
        String filename = currentPath + "/tmp/serial.bat";

        FileOutputStream outputStream = null;
        BufferedOutputStream bufferedOutputStream = null;
        ObjectOutputStream objectOutputStream = null;

        try {
            outputStream = new FileOutputStream(filename);
            bufferedOutputStream = new BufferedOutputStream(outputStream);
            objectOutputStream = new ObjectOutputStream(bufferedOutputStream);

            ArrayList<UserInfo> userInfos = new ArrayList<>();
            UserInfo u1 = new UserInfo();
            userInfos.add(u1);
            UserInfo u2 = new UserInfo("민수", "12344", 21);
            userInfos.add(u2);
            UserInfo u3 = new UserInfo("철수", "566778", 28);
            userInfos.add(u3);

            objectOutputStream.writeObject(u1);
            objectOutputStream.writeObject(u2);
            objectOutputStream.writeObject(u3);
            objectOutputStream.writeObject(userInfos);

            System.out.println("직렬화 끝");
            objectOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
