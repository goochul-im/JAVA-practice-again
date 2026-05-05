package ioEx;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Arrays;

public class ByteArrayEx {

    public static void main(String[] args) {
        byte[] inSrc = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        byte[] outSrc = null;
        byte[] temp = new byte[4];

        ByteArrayInputStream inputStream = new ByteArrayInputStream(inSrc);
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

        System.out.println("Input Source : " + Arrays.toString(inSrc));

        try {
            while (inputStream.available() > 0) {
                int len = inputStream.read(temp);
                outputStream.write(temp, 0, len);

                outSrc = outputStream.toByteArray();
                printArrays(temp, outSrc);
            }
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    private static void printArrays(byte[] temp, byte[] outSrc) {
        System.out.println("temp : " + Arrays.toString(temp));
        System.out.println("outSrc : " + Arrays.toString(outSrc));
    }

}
