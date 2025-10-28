import java.net.*;
import java.util.*;

public class HttpHeaderAnalyzer {
    public static void main(String[] args) {
        try {
            Scanner sc = new Scanner(System.in);
            System.out.print("Enter URL: ");
            String urlStr = sc.nextLine();

            URL url = new URL(urlStr);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();

            System.out.println("Request Method: " + conn.getRequestMethod());
            System.out.println("Response Code: " + conn.getResponseCode());
            System.out.println("Response Message: " + conn.getResponseMessage());

            System.out.println("\nHTTP Headers:");
            Map<String, List<String>> headers = conn.getHeaderFields();
            for (String key : headers.keySet())
                System.out.println(key + ": " + headers.get(key));

            sc.close();
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }
}
