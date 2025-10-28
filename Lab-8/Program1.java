import java.util.ArrayList;
import java.util.Scanner;

public class StudentList {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<String> students = new ArrayList<>();

        while (true) {
            System.out.println("\n1. Add Student");
            System.out.println("2. Insert Student at Index");
            System.out.println("3. Update Student Name");
            System.out.println("4. Remove Student");
            System.out.println("5. Display Students");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter student name: ");
                    students.add(sc.nextLine());
                    break;

                case 2:
                    System.out.print("Enter index: ");
                    int index = sc.nextInt();
                    sc.nextLine();
                    if (index >= 0 && index <= students.size()) {
                        System.out.print("Enter student name: ");
                        students.add(index, sc.nextLine());
                    } else {
                        System.out.println("Invalid index");
                    }
                    break;

                case 3:
                    System.out.print("Enter index to update: ");
                    int i = sc.nextInt();
                    sc.nextLine();
                    if (i >= 0 && i < students.size()) {
                        System.out.print("Enter new name: ");
                        students.set(i, sc.nextLine());
                    } else {
                        System.out.println("Invalid index");
                    }
                    break;

                case 4:
                    System.out.print("Remove by (1) Name or (2) Index: ");
                    int type = sc.nextInt();
                    sc.nextLine();
                    if (type == 1) {
                        System.out.print("Enter name: ");
                        students.remove(sc.nextLine());
                    } else if (type == 2) {
                        System.out.print("Enter index: ");
                        int rm = sc.nextInt();
                        if (rm >= 0 && rm < students.size()) {
                            students.remove(rm);
                        } else {
                            System.out.println("Invalid index");
                        }
                    }
                    break;

                case 5:
                    System.out.println("Student List: " + students);
                    break;

                case 0:
                    System.out.println("Exiting...");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice");
            }

            System.out.println("Current List: " + students);
        }
    }
}
