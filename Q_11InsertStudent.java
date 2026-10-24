
import java.sql.*;
import java.util.*;

public class Q_11InsertStudent {
    public static void main(String[] args) throws Exception {
        Connection c = DriverManager.getConnection(
            "jdbc:ucanaccess://D:/JavaDatabase/ICE_PUST.accdb");

        Scanner s = new Scanner(System.in);
        System.out.print("Enter Name: ");
        String n = s.nextLine();
        System.out.print("Enter Email: ");
        String e = s.nextLine();
        System.out.print("Enter Phone: ");
        String p = s.nextLine();

        PreparedStatement ps = c.prepareStatement(
            "INSERT INTO Student (StudentName, Email, Phone) VALUES (?, ?, ?)");
        ps.setString(1, n);
        ps.setString(2, e);
        ps.setString(3, p);
        ps.executeUpdate();

        System.out.println("Inserted Successfully!");
        c.close();
    }
}
