class TicketBooking {
    private int availableTickets = 5;

    // synchronized method to prevent double booking
    public synchronized void bookTicket(String user, int numTickets) {
        if (numTickets <= availableTickets) {
            System.out.println(user + " is booking " + numTickets + " ticket(s)...");
            try {
                Thread.sleep(500); // simulate processing delay
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            availableTickets -= numTickets;
            System.out.println(user + " successfully booked " + numTickets + " ticket(s).");
            System.out.println("Tickets left: " + availableTickets);
        } else {
            System.out.println(user + " tried to book " + numTickets +
                               " ticket(s), but only " + availableTickets + " left!");
        }
    }
}

class User extends Thread {
    private TicketBooking booking;
    private String userName;
    private int ticketsToBook;

    User(TicketBooking booking, String name, int numTickets) {
        this.booking = booking;
        this.userName = name;
        this.ticketsToBook = numTickets;
    }

    public void run() {
        booking.bookTicket(userName, ticketsToBook);
    }
}

public class TicketBookingDemo {
    public static void main(String[] args) {
        TicketBooking bookingSystem = new TicketBooking();

        // Users trying to book tickets
        User u1 = new User(bookingSystem, "User-1", 2);
        User u2 = new User(bookingSystem, "User-2", 3);
        User u3 = new User(bookingSystem, "User-3", 2);

        u1.start();
        u2.start();
        u3.start();
    }
}
