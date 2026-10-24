
import java.sql.*;
import java.util.Scanner;

public class Q12_StudentCRUD {
    public static void main(String[] args) throws Exception {
        Connection c = DriverManager.getConnection(
            "jdbc:mysql://localhost:3306/ICE_PUST", "root", "");
        Scanner s = new Scanner(System.in);

        while (true) {
            System.out.println("\n1.Insert 2.Delete 3.Edit");
            System.out.print("Choice: ");
            int ch = s.nextInt();

            if (ch == 1) {
                System.out.print("Roll: ");
                int r = s.nextInt();
                s.nextLine();
                System.out.print("Name: ");
                String n = s.nextLine();

                PreparedStatement p = c.prepareStatement(
                    "INSERT INTO Student VALUES(?,?)");
                p.setInt(1, r);
                p.setString(2, n);
                p.executeUpdate();
                System.out.println("Inserted!");
            }
            else if (ch == 2) {
                System.out.print("Roll: ");
                int r = s.nextInt();

                PreparedStatement p = c.prepareStatement(
                    "DELETE FROM Student WHERE Roll=?");
                p.setInt(1, r);
                p.executeUpdate();
                System.out.println("Deleted!");
            }
            else if (ch == 3) {
                System.out.print("Roll: ");
                int r = s.nextInt();
                s.nextLine();
                System.out.print("New Name: ");
                String n = s.nextLine();

                PreparedStatement p = c.prepareStatement(
                    "UPDATE Student SET StudentName=? WHERE Roll=?");
                p.setString(1, n);
                p.setInt(2, r);
                p.executeUpdate();
                System.out.println("Updated!");
            }
        }
    }
}
