package FIleEx;

import java.io.File;
import java.io.IOException;

public class FileInfoClass {

    public static void main(String[] args) throws IOException {

        File file = new File("src/", "bj7");
        file.createNewFile();

        System.out.println("canExecute : "+ file.canExecute());
        System.out.println("canRead : "+ file.canRead());
        System.out.println("canWrite : "+ file.canWrite());
        System.out.println("exists : "+ file.exists());
        System.out.println("isDirectory : "+ file.isDirectory());
        System.out.println("isFile : "+ file.isFile());
        System.out.println("isHidden : "+ file.isHidden());
        System.out.println("lastModified : "+ file.lastModified());
        System.out.println("length : "+ file.length());

    }

}
