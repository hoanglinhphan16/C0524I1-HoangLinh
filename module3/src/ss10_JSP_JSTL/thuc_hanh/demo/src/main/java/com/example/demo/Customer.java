package com.example.demo;

public class Customer {
    private String name;
    private String dob;
    private String address;
    private String photoUrl;

    public Customer(String name, String dob, String address, String photoUrl) {
        this.name = name;
        this.dob = dob;
        this.address = address;
        this.photoUrl = photoUrl;
    }

    // Getters
    public String getName() {
        return name;
    }

    public String getDob() {
        return dob;
    }

    public String getAddress() {
        return address;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }
}