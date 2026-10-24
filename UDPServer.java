
import java.net.*;

public class UDPServer {
    public static void main(String[] args) throws Exception {

        DatagramSocket server = new DatagramSocket(5000);
        byte[] buffer = new byte[1024];

        System.out.println("UDP Server is waiting...");

        DatagramPacket request =
            new DatagramPacket(buffer, buffer.length);

        server.receive(request);

        String message = new String(
            request.getData(), 0, request.getLength()
        );

        String upper = message.toUpperCase();

        Thread.sleep(6);

        byte[] data = upper.getBytes();

        DatagramPacket reply = new DatagramPacket(
            data, data.length,
            request.getAddress(), request.getPort()
        );

        server.send(reply);

        System.out.println("Received: " + message);
        System.out.println("Sent: " + upper);

        server.close();
    }
}

 