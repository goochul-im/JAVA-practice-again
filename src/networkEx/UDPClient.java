package networkEx;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Arrays;

public class UDPClient {

    static void main() {

        try (DatagramSocket datagramSocket = new DatagramSocket()) {

            InetAddress inetAddress = InetAddress.getByName("127.0.0.1");

            byte[] buf = new byte[100];
            DatagramPacket outPacket = new DatagramPacket(buf, 1, inetAddress, 7777); // 아마 health-check인가?
            DatagramPacket inPacket = new DatagramPacket(buf, buf.length);

            datagramSocket.send(outPacket);
            datagramSocket.receive(inPacket);

            byte[] data = inPacket.getData();// 패킷 내에 있는 데이터 가져오기
            System.out.println(new String(data));

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
