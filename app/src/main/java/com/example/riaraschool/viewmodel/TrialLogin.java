package com.example.riaraschool.viewmodel;

import android.content.Context;
import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.room.Room;

import com.example.riaraschool.dao.UsersDao;
import com.example.riaraschool.database.UserDB;

import java.util.List;



public class TrialLogin extends ViewModel{
    private UsersDao dao;
    private UserDB db;
    Context context;

    public TrialLogin(Context context) {
        this.context = context;
    }

    public void makeDbCall(){
        db = Room.databaseBuilder(context, UserDB.class, "user_db")
                .allowMainThreadQueries()
                .build();

        dao = db.dao();
    }
    public boolean login(String email, String password) {
        if(dao.searchUser(email, password))
            return true;
        else
            return false;
    }

}