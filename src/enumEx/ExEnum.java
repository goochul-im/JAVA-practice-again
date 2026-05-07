package enumEx;

public enum ExEnum {

    Coin(1), Penny(2), Quater(3),
    ;

    {
        System.out.println("ExEnum init");
    }

    static {
        System.out.println("ExEnum static init");
    }

    public final int money;

    ExEnum(int money) {
        this.money = money;
        System.out.println(money + " init");
    }
}
