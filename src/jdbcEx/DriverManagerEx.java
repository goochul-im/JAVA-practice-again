package jdbcEx;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Iterator;

public class DriverManagerEx {

    public static void main(String[] args) {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            try (Connection connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3500/jdbc_study",
                    "study",
                    "study1234"
            )) {
                System.out.println("연결 성공");
            }

        } catch (SQLException e) {
            Iterator<Throwable> iterator = e.iterator();

            while (iterator.hasNext()) {
                System.out.println(iterator.next().getMessage());
            }

            System.err.println("연결 실패");
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
            System.err.println("드라이버 못 찾음");
        }


    }

}
