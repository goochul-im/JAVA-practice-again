package networkEx;

import java.net.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class UDPServer {

    static void main() {

        try (DatagramSocket socket = new DatagramSocket(7777)) {

            System.out.println("UDP 서버 ready");
            while (true) {

                byte[] buf = new byte[100];
                DatagramPacket inPacket = new DatagramPacket(buf, buf.length);
                socket.receive(inPacket); //소켓에서 받아서 inPacket 인스턴스에 넣어라

                InetAddress address = inPacket.getAddress(); // 수신한 패킷으로부터 주소 획득
                int port = inPacket.getPort();
                System.out.printf("[Client] : %s:%d\n", address.getHostAddress(), port);

                SimpleDateFormat format = new SimpleDateFormat("[hh:mm:ss]");
                String today = "서버 시간 = " + format.format(new Date());
                buf = today.getBytes();
                DatagramPacket outPacket = new DatagramPacket(buf, buf.length, address, port); // 패킷 자체에
                socket.send(outPacket); //outPacket 인스턴스에 있는 내용으로 socket을 통해 send해라
            }

        } catch (Exception e) {
            e.printStackTrace();
        }


    }

}
