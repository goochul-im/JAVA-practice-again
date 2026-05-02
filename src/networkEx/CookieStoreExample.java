package networkEx;

import java.net.*;

public class CookieStoreExample {

    public static void main(String[] args) throws Exception {
        CookieManager manager = new CookieManager();
        CookieHandler.setDefault(manager);

        URL url = new URL("https://google.com");
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();

        conn.getInputStream().close();

        CookieStore store = manager.getCookieStore();

        for (HttpCookie cookie : store.getCookies()) {
            System.out.println("name = " + cookie.getName());
            System.out.println("value = " + cookie.getValue());
            System.out.println("domain = " + cookie.getDomain());
            System.out.println("path = " + cookie.getPath());
            System.out.println();
        }
    }

}
