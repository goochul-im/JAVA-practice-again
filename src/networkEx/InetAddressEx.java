package networkEx;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;

public class InetAddressEx {

    public static void main(String[] args) throws UnknownHostException {
        System.out.println(Arrays.toString(InetAddress.getAllByName("www.google.com")));
        System.out.println(InetAddress.getByName("www.google.com"));

        InetAddress localHost = InetAddress.getLocalHost();
        System.out.println(localHost);
        System.out.println(localHost.getHostAddress());
        System.out.println(InetAddress.getLoopbackAddress());
    }

}
