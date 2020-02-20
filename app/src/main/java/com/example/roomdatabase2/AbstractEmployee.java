package com.example.roomdatabase2;

public class AbstractEmployee {
    private String name;
    private String email;

    public AbstractEmployee(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }
}
