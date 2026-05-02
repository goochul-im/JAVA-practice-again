package bigInteger;

import java.math.BigInteger;

public class FactComp {

    static BigInteger factorial(BigInteger n) {
        if (n.equals(BigInteger.ZERO)) {
            return BigInteger.ONE;
        } else
            return n.multiply(factorial(n.subtract(BigInteger.ONE)));
    }

    static double factorial(double n) {
        if (n == 0.0) {
            return 1;
        }else
            return n * factorial(n - 1);
    }

    public static void main(String[] args) {
        System.out.println(factorial(new BigInteger("171")));
        System.out.println(factorial(171.0));
        System.out.println(BigInteger.ZERO.negate());
    }

}
