package classEx;

public class AnonymousClassEx {

    interface Speakable{
        void speak();
    }

    public static void main(String[] args) {

        new Speakable() {
            @Override
            public void speak() {
                System.out.println("SPEAK");
            }
        }.speak();

    }


}
