package mathEx;

import static java.lang.Float.*;

public class MathEx {

    static void main() {

        System.out.println(Math.max(NaN, 10)); //NaN
        System.out.println(Math.min(NaN, 20)); //NaN
        System.out.println(NaN == NaN); // false
        System.out.println(Double.isNaN(NaN)); // true
        System.out.println(Math.asin(-2)); // NaN - sin 값의 범위 넘음
        System.out.println(Math.abs(Long.MIN_VALUE)); // 2의 보수 써봤자 다시 돌아감 Long.MIN_VALUE
        System.out.println(Math.abs(Integer.MIN_VALUE)); // Integer.MIN_VLAUE

        System.out.println(Math.round(Long.MAX_VALUE)); // Integer.MAX_VALUE
        System.out.println(Math.round(Long.MIN_VALUE)); // Integer.MIN_VALUE

        System.out.println(Math.round(NaN)); // 0

        System.out.println(NEGATIVE_INFINITY * 0.0); // NaN

    }

}
