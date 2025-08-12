// write a program in java to sum all the digits in a number
import java.util.Scanner;
class Main{
    public static void main(String[] args)
    {
        int sum=0;
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number:");
        int num = sc.nextInt();
        for(int i=num; i>0; i/=10)
        {
            sum+= i%10;
        }
        System.out.println("Sum of digits:" +sum);
    }
}
