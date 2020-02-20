package com.example.roomdatabase2;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "hobbies")
public class Hobbies {
    @PrimaryKey(autoGenerate = true)
    private int _id;
    private int popularity;
    private String name;

    public Hobbies(int popularity, String name) {
        this.popularity = popularity;
        this.name = name;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public int get_id() {
        return _id;
    }

    public int getPopularity() {
        return popularity;
    }

    public String getName() {
        return name;
    }
}
