package MassageSalonManagement.repository.booking;

import MassageSalonManagement.model.Booking;
import MassageSalonManagement.util.FileHandler;

import java.util.ArrayList;
import java.util.List;

public class BookingRepo implements IBookingRepo{
    private static List<Booking> bookingList = new ArrayList<>();
    private static Booking bookingInstance = new Booking();
    private static final String PATH = "E:\\Codegym\\module2\\ss1\\src\\MassageSalonManagement\\data\\bookings.csv";

    static {
        bookingList = FileHandler.readFile(bookingInstance, PATH);
    }

    @Override
    public List<Booking> getAllBookings() {
        return bookingList;
    }

    @Override
    public void addBooking(Booking booking) {
        bookingList.add(booking);
        FileHandler.writeFile(booking, PATH, true);
    }

    @Override
    public void deleteBooking(Booking booking) {
        bookingList.remove(booking);
        FileHandler.writeListToFile(bookingList, PATH, false);
    }

    @Override
    public void updateBooking(int index, Booking booking) {
        bookingList.set(index, booking);
        FileHandler.writeListToFile(bookingList, PATH, false);
    }
}
