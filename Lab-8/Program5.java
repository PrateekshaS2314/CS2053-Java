import java.io.*;
import java.net.*;

public class ChatServer {
    public static void main(String[] args) {
        try {
            ServerSocket ss = new ServerSocket(5000);
            System.out.println("Server started. Waiting for client...");
            Socket s = ss.accept();
            System.out.println("Client connected.");

            BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
            String msg;
            while ((msg = in.readLine()) != null)
                System.out.println("Client: " + msg);

            s.close();
            ss.close();
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }
}
