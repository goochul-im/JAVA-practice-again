package ExceptionEx;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class TryWithResourcesEx {

    static void main() throws Throwable{

        try (FileInputStream fis = new FileInputStream("1.txt");
             FileOutputStream fos = new FileOutputStream("1.txt")) {
            fos.write(1);
        }

    }

}
