import java.util.Scanner;

public class MatrixDiagonalSum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the size of the square matrix: ");
        int n = sc.nextInt();

        int[][] matrix = new int[n][n];

        System.out.println("Enter the elements of the matrix:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }

        int diagonalSum = 0;
        int upperSum = 0;
        int lowerSum = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) {
                    diagonalSum += matrix[i][j];   
                } else if (i < j) {
                    upperSum += matrix[i][j];      
                } else {
                    lowerSum += matrix[i][j];      
                }
            }
        }

        System.out.println("\nSum of diagonal elements = " + diagonalSum);
        System.out.println("Sum of upper diagonal elements = " + upperSum);
        System.out.println("Sum of lower diagonal elements = " + lowerSum);

    }
}
