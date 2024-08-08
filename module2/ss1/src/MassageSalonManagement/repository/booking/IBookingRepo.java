package MassageSalonManagement.repository.booking;

import MassageSalonManagement.model.Booking;
import MassageSalonManagement.model.Customer;

import java.util.List;

public interface IBookingRepo {
    List<Booking> getAllBookings();
    void addBooking(Booking booking);
    void deleteBooking(Booking booking);
    void updateBooking(int index, Booking booking);
}
