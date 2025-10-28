import java.net.*;
import java.util.Scanner;

public class FindIPAddress {
    public static void main(String[] args) {
        try {
            InetAddress local = InetAddress.getLocalHost();
            System.out.println("Your IP Address: " + local.getHostAddress());

            Scanner sc = new Scanner(System.in);
            System.out.print("Enter domain name: ");
            String domain = sc.nextLine();

            InetAddress[] addresses = InetAddress.getAllByName(domain);
            System.out.println("IP addresses of " + domain + ":");
            for (InetAddress addr : addresses)
                System.out.println(addr.getHostAddress());

            sc.close();
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }
}
