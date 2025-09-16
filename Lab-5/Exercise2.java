import java.util.Scanner;

// Custom Exception class
class WeakPasswordException extends Exception {
    public WeakPasswordException(String message) {
        super(message);
    }
}

public class PasswordCheck {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter password: ");
        String password = sc.nextLine();

        try {
            if (password.length() < 6) {
                throw new WeakPasswordException("Password too short! Must be at least 6 characters.");
            } else {
                System.out.println("Password accepted.");
            }
        } catch (WeakPasswordException e) {
            System.out.println("Error: " + e.getMessage());
        }

        sc.close();
    }
}
