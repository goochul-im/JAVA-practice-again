package FIleEx;

import java.io.*;

public class ScrambledOutputStream extends FilterOutputStream {

    private int[] map;
    public ScrambledOutputStream(OutputStream out, int[] map) {
        super(out);
        if (map == null) {
            throw new NullPointerException("map is NULL");
        }
        if (map.length != 256) {
            throw new IllegalArgumentException("map.length != 256");
        }
        this.map = map;
    }

    @Override
    public void write(int b) throws IOException {
        out.write(map[b]);
    }

}
