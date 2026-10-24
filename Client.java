
import java.net.*;
import java.io.*;

public class Client {
    public static void main(String[] args) throws IOException {

        Socket socket = new Socket("localhost", 5000);

        BufferedReader keyboard = new BufferedReader(
            new InputStreamReader(System.in)
        );

        PrintWriter output = new PrintWriter(
            socket.getOutputStream(), true
        );

        BufferedReader input = new BufferedReader(
            new InputStreamReader(socket.getInputStream())
        );

        System.out.print("Enter a message: ");
        String message = keyboard.readLine();

        output.println(message);

        String response = input.readLine();

        System.out.println("Server response: " + response);

        socket.close();
    }
}
