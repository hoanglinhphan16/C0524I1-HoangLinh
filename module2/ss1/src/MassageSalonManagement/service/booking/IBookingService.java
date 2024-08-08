package MassageSalonManagement.service.booking;

import MassageSalonManagement.model.Booking;

import java.util.List;

public interface IBookingService {
    List<Booking> getAllBookings();
    void addBooking(Booking booking);
    void deleteBooking(Booking booking);
    void updateBooking(int index, Booking booking);
}
