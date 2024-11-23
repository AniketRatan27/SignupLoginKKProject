package com.example.projectdemokk;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

@Dao
public abstract interface UserDao {
    @Insert
    void insertUser(User user);

    @Query("SELECT * FROM  users WHERE username=:username AND password=:password")
    User login(String username, String password);
}
