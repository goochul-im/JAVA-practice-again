package FIleEx;

import java.io.*;

public class ObjectStream {

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        String FILENAME = "/tmp/test_object.dat";

        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILENAME));
        oos.writeObject(new TestObject("안녕하세요"));
        oos.close();

        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILENAME));
        TestObject o = (TestObject) ois.readObject();

        System.out.println(o.sayHello());
        ois.close();
    }

    private static class TestObject implements Serializable{
        private int i;
        public int k;
        public String str;

        public TestObject(String str) {
            this.str = str;
        }

        public String sayHello() {
            return str;
        }
    }

}
