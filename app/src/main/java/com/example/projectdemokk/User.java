package com.example.projectdemokk;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "users")
public class User {
    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo(name = "first_name")
    private String FirstName;

    @ColumnInfo(name = "last_name")
    private String LastName;

    @ColumnInfo(name = "email")
    private String Email;

    @ColumnInfo(name = "username")
    private String Username;

    @ColumnInfo(name = "password")
    private String Password;

    public User(String FirstName, String LastName, String Email, String Username, String Password){
        this.FirstName = FirstName;
        this.LastName = LastName;
        this.Email = Email;
        this.Username = Username;
        this.Password = Password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        Username = username;
    }
}
