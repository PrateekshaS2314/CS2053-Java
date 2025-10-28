import java.io.*;
import java.net.*;
import java.util.Scanner;

public class WhoisLookup {
    public static void main(String[] args) {
        try {
            Scanner sc = new Scanner(System.in);
            System.out.print("Enter domain name: ");
            String domain = sc.nextLine();

            Socket socket = new Socket("whois.internic.net", 43);
            OutputStream out = socket.getOutputStream();
            out.write((domain + "\r\n").getBytes());
            out.flush();

            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String line;
            while ((line = in.readLine()) != null)
                System.out.println(line);

            socket.close();
            sc.close();
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }
}
