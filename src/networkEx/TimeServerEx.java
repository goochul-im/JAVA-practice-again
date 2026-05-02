package networkEx;

import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;

public class TimeServerEx {

    public static void main(String[] args) {

        if (args.length != 1) {
            System.err.println("인자가 잘못됨");
            return;
        }

        try (Socket socket = new Socket(args[0], 13)) {
            InputStream inputStream = socket.getInputStream();
            InputStreamReader isr = new InputStreamReader(inputStream);
            BufferedReader br = new BufferedReader(isr);

            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }

        } catch (IOException e) {
            System.err.println(e.getMessage());
        }

    }

}
