package enumEx;

public enum ExEnum {

    Coin(1), Penny(2), Quater(3),
    ;

    public final int money;

    ExEnum(int money) {
        this.money = money;
    }
}
