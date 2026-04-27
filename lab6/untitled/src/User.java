import java.util.concurrent.Semaphore;

public class User extends Thread{
    private String userName;
    private BookingService bookingService;
    private int seatId;

    public User (String userName, BookingService bookingService, int seatId){
        this.userName = userName;
        this.bookingService = bookingService;
        this.seatId = seatId;
    }

    public void setSleep(int miliseconds){
        try {
            Thread.sleep(miliseconds);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void setAttributeToThread(String name, int priority){
        this.setName(name);
        this.setPriority(priority);
    }

    public void setJoin(){
        try {
            this.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }



    @Override
    public void run(){
        boolean result = bookingService.book(seatId, userName);
        System.out.println("Задане місце " + seatId + " забронював " + userName + " " + result );
    }
}
