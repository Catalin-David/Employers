package com.example.roomdatabase2;

import androidx.room.ColumnInfo;

public class Address {

    private String city;
    private String street;
    @ColumnInfo(name = "zip_code")
    private String zipCode;

    public Address(String city, String street, String zipCode) {
        this.city = city;
        this.street = street;
        this.zipCode = zipCode;
    }

    public String getCity() {
        return city;
    }

    public String getStreet() {
        return street;
    }

    public String getZipCode() {
        return zipCode;
    }
}
