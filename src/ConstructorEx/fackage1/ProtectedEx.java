package ConstructorEx.fackage1;

import java.io.IOException;

public class ProtectedEx {

    public static void main(String[] args) throws IOException {
        ExClass name = new ExClass("name");

        Long i = 10l;
        long a = 10L;

        short s = 4000;

        char c = (char) 10.1d;

        double d = c;

        int k = 10;

        Integer aa = 127;
        Integer bb = 127;

        System.out.println(aa == bb);

    }

}
