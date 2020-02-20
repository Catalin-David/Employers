package com.example.roomdatabase2;

import androidx.room.Entity;
import androidx.room.ForeignKey;

@Entity(tableName = "employee_hobby_link",
        primaryKeys = {"employee_id", "hobby_id"},
        foreignKeys = {@ForeignKey(entity = Employee.class,
                                parentColumns = "_id",
                                childColumns = "employee_id"),
                       @ForeignKey(entity = Hobbies.class,
                                parentColumns = "_id",
                                childColumns = "hobby_id")})
public class EmployeeHobbyLink {
    private int employee_id;
    private int hobby_id;

    public EmployeeHobbyLink(int employee_id, int hobby_id) {
        this.employee_id = employee_id;
        this.hobby_id = hobby_id;
    }

    public int getEmployee_id() {
        return employee_id;
    }

    public int getHobby_id() {
        return hobby_id;
    }
}
