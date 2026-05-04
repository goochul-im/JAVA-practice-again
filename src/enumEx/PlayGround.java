package enumEx;

public class PlayGround {

    private static final class myEnum {

        static void run() {
            System.out.println("run");
        }

    }



    static void main() {
        Class<ExEnum> declaringClass = ExEnum.Coin.getDeclaringClass();

        ExEnum coin = Enum.valueOf(ExEnum.class, "Coin");
        ExEnum.Coin.ordinal();


        System.out.println(ExEnum.Coin == coin);

    }

}
