package networkEx;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.URL;

public class URLExV3 {

    static void main() {
        URL url;
        InputStream in;
        FileOutputStream out;

        String currentPath = System.getProperty("user.dir");
        System.out.println(currentPath);
        String fileName = currentPath + "/tmp/javabasic_src.jpg";

        try {

            url = new URL("https://images.unsplash.com/photo-1441974231531-c6227db76b6e?q=80&w=2560&auto=format&fit=crop");
            in = url.openStream();
            BufferedInputStream bin = new BufferedInputStream(in);
            out = new FileOutputStream(fileName);
            BufferedOutputStream bout = new BufferedOutputStream(out);

            int ch;
            while ((ch = bin.read()) != -1) {
                bout.write(ch);
            }

            bin.close();
            bout.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
