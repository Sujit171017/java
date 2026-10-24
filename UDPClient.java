
import java.net.*;
import java.util.Scanner;

public class UDPClient {
    public static void main(String[] args) throws Exception {

        DatagramSocket client = new DatagramSocket();
        Scanner sc = new Scanner(System.in);

        byte[] buffer;

        System.out.print("Enter message (max 1024 bytes): ");
        String message = sc.nextLine();

        buffer = message.getBytes();

        if (buffer.length > 1024) {
            System.out.println("Message is too long!");
            client.close();
            sc.close();
            return;
        }

        InetAddress address = InetAddress.getByName("localhost");

        DatagramPacket request = new DatagramPacket(
            buffer, buffer.length, address, 5000
        );

        client.send(request);

        byte[] responseBuffer = new byte[1024];

        DatagramPacket response = new DatagramPacket(
            responseBuffer, responseBuffer.length
        );

        client.receive(response);

        String reply = new String(
            response.getData(), 0, response.getLength()
        );

        System.out.println("Server response: " + reply);

        client.close();
        sc.close();
    }
}
