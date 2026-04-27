import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Theater {
    private List<Seat> seats = new ArrayList<Seat>();
    private final ReentrantReadWriteLock rwLock = new ReentrantReadWriteLock();

    public Theater(int count) {
        for (int i = 0; i < count; i++) {
            Seat seat = new Seat();
            seat.setId(i + 1);
            seats.add(seat);
        }
    }

    public List<Seat> getSeats() {
        rwLock.readLock().lock();
        try {
            return seats;
        } finally {
            rwLock.readLock().unlock();
        }
    }

    public void addSeat(Seat seat) {
        rwLock.writeLock().lock();
        try {
            seats.add(seat);
        } finally {
            rwLock.writeLock().unlock();
        }
    }
}
