package networkEx;

import java.net.URI;

public class URIEx {

    public static void main(String[] args) {

        URI uri = URI.create("https://example.com/docs/chapter1/index.html");
        URI relative = URI.create("../images/log.png");

        URI resolve = uri.resolve(relative);

        System.out.println(resolve);

    }

}
