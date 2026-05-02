package networkEx;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

public class URLEx {

    public static void main(String[] args) {

        try {
            URL url = new URL("https://www.harudew.site");

            InputStream inputStream = url.openStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }

            System.out.println();

        } catch (MalformedURLException e) {
            System.err.println("열기 실패");
        } catch (IOException e) {
            System.err.println("스트림 실패");
        }

    }

}
