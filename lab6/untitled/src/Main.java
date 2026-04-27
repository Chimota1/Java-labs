public class Main {
    public static void main(String[] args) {
        Theater theater = new Theater(10);
        BookingService bookingService = new BookingService(theater);

        Seat extraSeat = new Seat();
        extraSeat.setId(11);
        theater.addSeat(extraSeat);

        User user1 = new User("Андрій", bookingService, 1);
        User user2 = new User("Олена", bookingService, 1);
        User user3 = new User("Василь", bookingService, 2);
        User user4 = new User("Марія", bookingService, 6);
        User user5 = new User("Петро", bookingService, 7);
        User user6 = new User("Іван", bookingService, 9);

        user1.start();
        user2.start();

        user1.setJoin();

        bookingService.cancelBooking(1);

        user3.start();
        user4.start();
        user5.start();
        user6.start();

        user4.interrupt();

        boolean tryResult = bookingService.tryBook(5, "Тест");
        System.out.println("tryBook місце 5: " + tryResult);
    }
}