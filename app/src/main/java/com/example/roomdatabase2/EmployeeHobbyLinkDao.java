package com.example.roomdatabase2;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface EmployeeHobbyLinkDao {

    @Insert
    void insert(EmployeeHobbyLink link);

    @Query("SELECT employees._id, employees.name, employees.email, employees.city, employees.street, employees.zip_code " +
            "FROM employees INNER JOIN employee_hobby_link ON employees._id = employee_hobby_link.employee_id " +
            "INNER JOIN hobbies ON employee_hobby_link.hobby_id = hobbies._id WHERE hobbies.name = :hobbyName")
    List<Employee> getEmployeesByHobby(String hobbyName);
}
