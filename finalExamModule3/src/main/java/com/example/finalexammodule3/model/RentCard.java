package com.example.finalexammodule3.model;

import java.sql.Date;

public class RentCard {
    private String id;
    private String status;
    private Date rentDate;
    private Date returnDate;
    private int studentId;
    private String bookId;

    public RentCard(String id, String status, Date rentDate, Date returnDate, int studentId, String bookId) {
        this.id = id;
        this.status = status;
        this.rentDate = rentDate;
        this.returnDate = returnDate;
        this.studentId = studentId;
        this.bookId = bookId;
    }

    public RentCard(String status, Date rentDate, Date returnDate, int studentId, String bookId) {
        this.status = status;
        this.rentDate = rentDate;
        this.returnDate = returnDate;
        this.studentId = studentId;
        this.bookId = bookId;
    }

    public RentCard(){};

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getRentDate() {
        return rentDate;
    }

    public void setRentDate(Date rentDate) {
        this.rentDate = rentDate;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    @Override
    public String toString() {
        return "RentCard{" +
                "id='" + id + '\'' +
                ", status='" + status + '\'' +
                ", rentDate=" + rentDate +
                ", returnDate=" + returnDate +
                ", studentId=" + studentId +
                ", bookId='" + bookId + '\'' +
                '}';
    }
}
