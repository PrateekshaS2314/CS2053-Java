// write a program in java to reverese the number
import java.util.Scanner;
class Main{
    public static void main(String[] args)
    {
        int reveresed = 0;
        int digit;
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number:");
        int num = sc.nextInt();
        for (int i=num; i>0; i/=10)
        {
            digit = i%10;
            reveresed = reveresed * 10 + digit;
        }
        System.out.println("Reveresed number is:" +reveresed);
    }
}
