package ExceptionEx;

import java.io.FileNotFoundException;
import java.io.IOException;

public class MultiCatchEx {

    static void main() {

        try {
            try {
                throw new IOException("IOE 발생함 !!");
            } catch (IOException ioe) {
                throw new RuntimeException(ioe);
            }

        } catch (RuntimeException e) {
            System.out.println(e.getCause());
        }

    }

}
