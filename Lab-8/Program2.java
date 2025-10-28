import java.util.*;

public class MusicPlaylist {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LinkedList<String> playlist = new LinkedList<>();

        while (true) {
            System.out.println("\n1. Add song at beginning");
            System.out.println("2. Add song at end");
            System.out.println("3. Remove first song");
            System.out.println("4. Remove last song");
            System.out.println("5. Replace song at index");
            System.out.println("6. Display playlist");
            System.out.println("0. Exit");
            System.out.print("Enter choice: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter song name: ");
                    playlist.addFirst(sc.nextLine());
                    break;
                case 2:
                    System.out.print("Enter song name: ");
                    playlist.addLast(sc.nextLine());
                    break;
                case 3:
                    if (!playlist.isEmpty()) playlist.removeFirst();
                    else System.out.println("Playlist is empty");
                    break;
                case 4:
                    if (!playlist.isEmpty()) playlist.removeLast();
                    else System.out.println("Playlist is empty");
                    break;
                case 5:
                    System.out.print("Enter index: ");
                    int i = sc.nextInt();
                    sc.nextLine();
                    if (i >= 0 && i < playlist.size()) {
                        System.out.print("Enter new song name: ");
                        playlist.set(i, sc.nextLine());
                    } else System.out.println("Invalid index");
                    break;
                case 6:
                    System.out.println("Playlist: " + playlist);
                    break;
                case 0:
                    sc.close();
                    return;
                default:
                    System.out.println("Invalid choice");
            }
        }
    }
}
