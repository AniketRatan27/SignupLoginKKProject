package com.example.projectdemokk;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {User.class}, version = 1, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {
    private static AppDatabase Instance;

    public abstract UserDao userDao();

    public static synchronized AppDatabase getInstance(Context context){
        if (Instance == null){
            Instance = Room.databaseBuilder(context.getApplicationContext(),
                    AppDatabase.class,"app_database")
                    .build();
        }
        return Instance;
    }
}
