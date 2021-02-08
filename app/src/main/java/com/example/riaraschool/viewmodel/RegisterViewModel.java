package com.example.riaraschool.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.room.RoomDatabase;

import com.example.riaraschool.database.UserDB;
import com.example.riaraschool.model.User;

import java.util.List;

public class RegisterViewModel extends AndroidViewModel {

    UserDB userDatabase;
    User user;

    public RegisterViewModel(@NonNull Application application) {
        super(application);
        userDatabase = UserDB.getInstance(application.getApplicationContext());
        user = new User();
    }

    //create a method that returns a list of all users
    public LiveData<List<User>> getAllUsers(){
        return userDatabase.dao().getAll();
    }

    public void registerUser(User userdata){

    }

}
