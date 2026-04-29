package classEx;

public class AnonymousClassEx {

    interface Speakable{
        void speak();
    }

    public static void main(String[] args) {

        final int a = 10;

        final Speakable speakable;

        new Speakable() {
            @Override
            public void speak() {
                System.out.println("SPEAK");
                System.out.println(a); // 접근은 되는데
//                a = 20; // 변경은 안되네? final이니까
                final String name = "name";
            }
        }.speak();

        InnerStaticClassEx.InnerStatic.m1();
        InnerStaticClassEx.InnerStatic innerStatic = new InnerStaticClassEx.InnerStatic();
        innerStatic.m2();
    }


}
