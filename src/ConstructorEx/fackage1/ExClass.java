package ConstructorEx.fackage1;

import java.io.IOException;

public class ExClass {

    private final String name;

    protected ExClass(String name) throws IOException {

        if (name.equals("exception")) {
            throw new IOException();
        }
        this.name = name;
    }

    public ExClass()  {
        this.name = "new";
    }

}
