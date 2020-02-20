package com.example.roomdatabase2;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface EmployeeDao {

    @Insert
    void insert(Employee employee);

    @Query("SELECT * FROM employees")
    List<Employee> getAllEmployees();

    @Query("SELECT name, email FROM employees")
    List<AbstractEmployee> getAbstractEmployees();

    @Query("SELECT _id FROM employees WHERE name = :name")
    int getEmployeeIdByName(String name);
}
