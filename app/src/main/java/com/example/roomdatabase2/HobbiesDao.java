package com.example.roomdatabase2;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface HobbiesDao {

    @Insert
    void insert(Hobbies hobby);

    @Query("SELECT * FROM hobbies")
    List<Hobbies> getAllHobbies();

    @Query("SELECT _id FROM hobbies WHERE name = :name")
    int getHobbyIdByName(String name);
}
