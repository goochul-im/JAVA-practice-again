package formatEx;

import java.text.DecimalFormat;

public class DecimalFormatEx {

    static void main() {
        double number = 1234567.89;

        DecimalFormat df = new DecimalFormat("0.#######E0");
        System.out.println(df.format(number));

        df = new DecimalFormat("###,###.0000");
        System.out.println(df.format(number));

        df = new DecimalFormat("00000000000.####");
        System.out.println(df.format(number));

    }

}
