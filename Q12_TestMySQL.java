
import java.sql.*;

public class Q12_TestMySQL {
    public static void main(String[] args) {
        try {
            Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/ICE_PUST",
                "root", "");

            System.out.println("Connected Successfully!");
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
