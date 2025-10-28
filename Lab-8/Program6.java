import java.net.*;
import java.io.*;
import java.util.Date;
import java.util.Scanner;

public class WebsiteInfo {
    public static void main(String[] args) {
        try {
            Scanner sc = new Scanner(System.in);
            System.out.print("Enter URL: ");
            String urlStr = sc.nextLine();

            URL url = new URL(urlStr);
            URLConnection conn = url.openConnection();

            System.out.println("Protocol: " + url.getProtocol());
            System.out.println("Content Type: " + conn.getContentType());
            System.out.println("Date: " + new Date(conn.getDate()));
            System.out.println("Content Length: " + conn.getContentLength());

            System.out.println("First few lines of content:");
            BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            for (int i = 0; i < 5; i++) {
                String line = br.readLine();
                if (line == null) break;
                System.out.println(line);
            }

            sc.close();
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }
}
