package com.example.projectdemokk;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

public class UserViewModel extends AndroidViewModel {
    private final UserRepository repository;

    public UserViewModel(@NonNull Application application){
        super(application);
        repository = new UserRepository(application);
    }

    public void registerUser(String FirstName, String LastName, String Email, String Username, String Password){
        User user = new User(FirstName,LastName,Email,Username,Password);
        repository.inserUser(user);
    }

    public void loginUser(String username, String password, UserRepository.LoginCallback callback) {
       repository.login(username, password, callback);
    }
}
