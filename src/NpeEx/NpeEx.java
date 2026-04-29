package NpeEx;

public class NpeEx {

    static void main() {
        Exclass dd = new Exclass("dd");

        System.out.println(dd.name);
        System.out.println(dd.name.length());
    }

    private static class Exclass {

        private final String name;

        public Exclass(String name) {
            this.name = null;
        }
    }

}
