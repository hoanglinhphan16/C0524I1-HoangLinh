package MassageSalonManagement.service.booking;

import MassageSalonManagement.model.Booking;
import MassageSalonManagement.repository.booking.BookingRepo;
import MassageSalonManagement.repository.booking.IBookingRepo;

import java.util.List;

public class BookingService implements IBookingService{
    private IBookingRepo iBookingRepo = new BookingRepo();

    @Override
    public List<Booking> getAllBookings() {
        return iBookingRepo.getAllBookings();
    }

    @Override
    public void addBooking(Booking booking) {
        iBookingRepo.addBooking(booking);
    }

    @Override
    public void deleteBooking(Booking booking) {
        iBookingRepo.deleteBooking(booking);
    }

    @Override
    public void updateBooking(int index, Booking booking) {
        iBookingRepo.updateBooking(index, booking);
    }
}
