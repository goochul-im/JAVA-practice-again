package FIleEx;

import java.io.*;

public class ExternalizableEx {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        String currentPath = System.getProperty("user.dir");
        String FILENAME = currentPath + "/tmp/external2.dat";

        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILENAME));
        oos.writeObject(new Employee("구철",28));
        oos.close();

        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILENAME));
        Employee employee = (Employee) ois.readObject();
        System.out.println(employee.sayHello());
        ois.close();
    }

    private static class Employee implements Externalizable{

        private String name;
        private int age;

        public Employee() {
        }

        public Employee(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public String sayHello() {
            return "Hello";
        }

        @Override
        public void writeExternal(ObjectOutput out) throws IOException {
            System.out.println("writeExternal called");
            out.writeUTF(name);
            out.writeInt(age);
        }

        @Override
        public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
            System.out.println("readExternal called");
            name = in.readUTF();
            age = in.readInt();
        }
    }

}
