package com.example.projectdemokk;

import android.app.Application;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class UserRepository {
    private UserDao userDao;

    public UserRepository(Application application){
        AppDatabase db = AppDatabase.getInstance(application);
        userDao = db.userDao();
    }

    public void inserUser(User user){
        new Thread(() -> userDao.insertUser(user)).start();
    }

    public void login(String username, String password, LoginCallback callback) {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        executor.execute(() -> {
            User user = userDao.login(username, password); // Background operation
            new Handler(Looper.getMainLooper()).post(() -> callback.onResult(user)); // UI thread
        });
    }
    public interface LoginCallback {
        void onResult(User user);
    }
}
