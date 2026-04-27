import java.util.concurrent.atomic.AtomicBoolean;

public class Seat {
    private int id;
    private boolean isBooked = false;
    private String bookedBy;

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setIsBooked(boolean isBooked) {
        this.isBooked = isBooked;
    }

    public void setBookedBy(String bookedBy) {
        this.bookedBy = bookedBy;
    }

    public boolean getIsBooked() {
        return isBooked;
    }

    public String getBookedBy() {
        return bookedBy;
    }
}
