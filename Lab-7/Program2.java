import java.util.Scanner;

public class MatrixMiddleElement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of rows: ");
        int rows = sc.nextInt();
        System.out.print("Enter the number of columns: ");
        int cols = sc.nextInt();

        int[][] matrix = new int[rows][cols];

        System.out.println("Enter the elements of the matrix:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }

        System.out.println("\nThe matrix is:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println("\nMiddle element(s):");

        if (rows % 2 == 1 && cols % 2 == 1) {
            int midRow = rows / 2;
            int midCol = cols / 2;
            System.out.println(matrix[midRow][midCol]);
        } else {
            int midRow1 = (rows / 2) - 1;
            int midRow2 = rows / 2;
            int midCol2 = cols / 2;

            System.out.println(matrix[midRow1][midCol2]);
            System.out.println(matrix[midRow2][midCol2]);
        }
    }
}
