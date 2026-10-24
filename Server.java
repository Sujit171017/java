
import java.net.*;
import java.io.*;

public class Server {
    public static void main(String[] args) throws IOException {

        ServerSocket server = new ServerSocket(5000);
        System.out.println("Server is waiting for client...");

        Socket socket = server.accept();
        System.out.println("Client connected!");

        BufferedReader input = new BufferedReader(
            new InputStreamReader(socket.getInputStream())
        );

        PrintWriter output = new PrintWriter(
            socket.getOutputStream(), true
        );

        String message = input.readLine();

        String upperMessage = message.toUpperCase();

        output.println(upperMessage);

        System.out.println("Received: " + message);
        System.out.println("Sent: " + upperMessage);

        socket.close();
        server.close();
    }
}
