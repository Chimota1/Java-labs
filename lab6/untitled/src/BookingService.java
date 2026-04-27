import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class BookingService {
    private final Theater theater;
    private final ReentrantLock lock = new ReentrantLock();
    private final Condition condition = lock.newCondition();

    public BookingService(Theater theater) {
        this.theater = theater;
    }

    public boolean book(int seatId, String userName) {
        lock.lock();
        try {
            for (Seat seat : theater.getSeats()) {
                if (!seat.getIsBooked() && seat.getId() == seatId) {
                    seat.setIsBooked(true);
                    seat.setBookedBy(userName);
                    return true;
                }
            }
            return false;
        } finally {
            lock.unlock();
        }
    }

    public boolean tryBook(int seatId, String userName) {
        if (!lock.tryLock()) {
            return false;
        }
        try {
            for (Seat seat : theater.getSeats()) {
                if (!seat.getIsBooked() && seat.getId() == seatId) {
                    seat.setIsBooked(true);
                    seat.setBookedBy(userName);
                    return true;
                }
            }
            System.out.println(seatId + " заброньований " + userName);
            return false;
        } finally {
            lock.unlock();
        }
    }

    public void cancelBooking(int seatId) {
        lock.lock();
        try {
            for (Seat seat : theater.getSeats()) {
                if (seat.getId() == seatId) {
                    seat.setIsBooked(false);
                    seat.setBookedBy("");
                    condition.signal();
                    return;
                }
            }
        } finally {
            lock.unlock();
        }
    }
}