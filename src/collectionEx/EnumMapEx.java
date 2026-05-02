package collectionEx;

import java.util.EnumMap;

public class EnumMapEx {

    enum Coin{
        PENNY, NICKEL, DIME, QUARTER
    }

    public static void main(String[] args) {

        EnumMap<Coin, Integer> map = new EnumMap<>(Coin.class);

        map.put(Coin.PENNY, 1);
        map.put(Coin.NICKEL, 2);
        map.put(Coin.DIME, 3);
        map.put(Coin.QUARTER, 4);
        map.put(Coin.QUARTER, 5);

        EnumMap<Coin, Integer> copy = new EnumMap<>(map);
        copy.put(Coin.PENNY, 200);
        System.out.println("1 : " + map);
        System.out.println("2 : " + copy);

    }

}
