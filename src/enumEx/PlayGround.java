package enumEx;

public class PlayGround {

    static void main() {
        Class<ExEnum> declaringClass = ExEnum.Coin.getDeclaringClass();

        ExEnum coin = Enum.valueOf(ExEnum.class, "Coin");

        System.out.println(ExEnum.Coin == coin);

    }

}
