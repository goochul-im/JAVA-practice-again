package classEx;

public class DowncastingEx {

    public static void main(String[] args) {
        Animal animal = new Dog("멍멍이", 19, 119929);

        if (animal instanceof Dog dog) {
            System.out.println(dog.getMyInfo());
        }

    }

    private static class Animal {
        String name;
        int age;

        public Animal(String name, int age) {
            this.name = name;
            this.age = age;
        }
    }

    private static class Dog extends Animal {
        int specifiNumber;

        public Dog(String name, int age, int specifiNumber) {
            super(name, age);
            this.specifiNumber = specifiNumber;
        }

        public String getMyInfo() {
            return "name : " + name + ", age : " + age + ", specifiNumber : " + specifiNumber;
        }

    }

}
