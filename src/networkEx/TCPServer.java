package networkEx;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TCPServer {

    static void main() {

        try (ServerSocket serverSocket = new ServerSocket(7777)) {
            System.out.println("서버가 동작 중입니다.");
            while (true) {

                Socket socket = serverSocket.accept();
                System.out.printf("%s : %s enter\n", getTime(), socket.getInetAddress());

                OutputStream outputStream = socket.getOutputStream();
                OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream);
                PrintWriter printWriter = new PrintWriter(outputStreamWriter);

                printWriter.println("[Notice] Test Message from Server");
                System.out.println("메세지 전송 완료");

                printWriter.close();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static String getTime() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("[hh:mm:ss]");
        return simpleDateFormat.format(new Date());
    }

}
