package com.example.roomdatabase2;

import androidx.room.Embedded;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "employees")
public class Employee {
    @PrimaryKey(autoGenerate = true)
    private int _id;
    private String name;
    private String email;
    @Embedded
    private Address address;

    public Employee(String name, String email, Address address) {
        this.name = name;
        this.email = email;
        this.address = address;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public int get_id() {
        return _id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public Address getAddress() {
        return address;
    }
}
