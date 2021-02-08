package com.example.riaraschool.repository;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import com.example.riaraschool.dao.UsersDao;
import com.example.riaraschool.database.UserDB;
import com.example.riaraschool.model.User;

import java.util.List;

public class UserRepository {
    private UsersDao userDao;
    private LiveData<List<User>> allUsers;
    private User user;
    //private String mail, pass;


    public UserRepository(Application application) {
        UserDB database = UserDB.getInstance(application);
        this.userDao = database.dao();
        this.allUsers = userDao.getAll();
        //userDao.registerUser(user);
    }
    public LiveData<List<User>> getAllUsers(){
        return allUsers;
    }
    public void register(User user){
        new registerAsyncTask(userDao).execute(user);
    }





    private class registerAsyncTask  extends AsyncTask<User, Void, Void> {
        private UsersDao asyncTaskDao;
         registerAsyncTask(UsersDao dao) {
             asyncTaskDao = dao;
        }
        @Override
        protected Void doInBackground(final User... users) {
             asyncTaskDao.registerUser(users[0]);
            return null;
        }
    }


}
