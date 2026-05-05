package classEx;

class NewInnerEx {

    int i = 10;

    class NNInner {

        int i = 20;

        void run() {
            int i = 30;
            System.out.println(i);
            System.out.println(this.i);
            System.out.println(NewInnerEx.this.i);
        }

    }

}

public class InnerNonStaticClassEx {

    public static void main(String[] args) {

        NewInnerEx.NNInner nnInner = new NewInnerEx().new NNInner();
        nnInner.run();

        new Object(){void run() {
            System.out.println("hi");
        }}.run();

    }

}

