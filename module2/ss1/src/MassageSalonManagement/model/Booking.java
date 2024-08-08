package MassageSalonManagement.model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Booking {
    private String idBooking;
    private LocalDate bookingDate;
    private String idCustomer;
    private long payment;

    public Booking(String idBooking, LocalDate bookingDate, String idCustomer, long payment) {
        this.idBooking = idBooking;
        this.bookingDate = bookingDate;
        this.idCustomer = idCustomer;
        this.payment = payment;
    }

    public Booking() {

    }

    public String getIdBooking() {
        return idBooking;
    }

    public void setIdBooking(String idBooking) {
        this.idBooking = idBooking;
    }

    public LocalDate getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(LocalDate bookingDate) {
        this.bookingDate = bookingDate;
    }

    public long getPayment() {
        return payment;
    }

    public void setPayment(long payment) {
        this.payment = payment;
    }

    public String getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(String idCustomer) {
        this.idCustomer = idCustomer;
    }

    public String toCSVRow() {
        return this.idBooking + "," + this.bookingDate.format(DateTimeFormatter.ofPattern("dd-MM-yyyy")) + "," + this.idCustomer+ "," + this.payment;
    }

    public static Booking fromCSVRow(String csvRow) {
        String[] data = csvRow.split(",");
        String id = data[0];
        LocalDate bookingDate = LocalDate.parse(data[1], DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        String idCustomer = data[2];
        long payment = Long.parseLong(data[3]);
        return new Booking(id, bookingDate, idCustomer, payment);
    }

    @Override
    public String toString() {
        return "Booking{" +
                "idBooking='" + idBooking + '\'' +
                ", bookingDate=" + bookingDate.format(DateTimeFormatter.ofPattern("dd-MM-yyyy")) +
                ", idCustomer='" + idCustomer + '\'' +
                ", payment='" + payment + '\'' +
                '}';
    }
}
