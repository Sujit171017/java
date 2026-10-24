
import java.sql.*;

public class Q_11TestConnection {
    public static void main(String[] args) throws Exception {
        String url = "jdbc:ucanaccess://D:/JavaDatabase/ICE_PUST.accdb";
        Connection con = DriverManager.getConnection(url);

        System.out.println("Connected Successfully!");
        con.close();
    }
}
