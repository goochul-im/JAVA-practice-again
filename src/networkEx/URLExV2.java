package networkEx;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

public class URLExV2 {

    static void main() {
        URL url = null;
        BufferedReader reader = null;
        String address = "https://api.remotion.online";
        String line = "";

        try {
            url = new URL(address);
            reader = new BufferedReader(new InputStreamReader(url.openStream()));

            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }

            reader.close();
        } catch (Exception e) {
            System.err.println("Error");
        }

    }

}
