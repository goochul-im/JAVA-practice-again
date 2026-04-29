package ExceptionEx;

import java.io.IOException;
import java.sql.SQLException;

public class FinalRethrowEx {

    public static void rethrows(boolean b) throws IOException, SQLException { // 구체적인 타입 명시 가능!
        try {
            if (b) throw new IOException();
            else throw new SQLException();
        } catch (Exception e) {
            // 여기서 e는 Exception 타입으로 잡혔지만,
            // 컴파일러는 "실제로 e에 들어올 수 있는 건 IOException이나 SQLException뿐이네?"라고 추론함
            throw e;
        }
    }

    static void main() {
        try {
            rethrows(false);
        } catch (IOException e) {
            System.out.println("IOE");
        } catch (SQLException e) {
            System.out.println("SQL");
        }
    }

}
