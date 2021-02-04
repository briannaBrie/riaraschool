package com.example.riaraschool.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;


import com.example.riaraschool.dao.UsersDao;
import com.example.riaraschool.model.User;
import com.example.riaraschool.respository.UserRepository;

import java.util.List;

public class LoginViewModel extends ViewModel {

    //prepare the database for the UI
    private UserRepository repo;
    private LiveData<List<User>> allUsers;
    private User user;
    private UsersDao dao;


    public LoginViewModel() {
        //repo = new UserRepository(application);
        allUsers = dao.getAll();
    }

    public void insert(User user) {
        dao.insert(user);
    }

    public void update(User user) {
        dao.update(user);
    }

    public void delete(User user) {
        dao.delete(user);
    }

    public void reset(User user) {
        dao.reset();
    }

    public LiveData<List<User>> getAllUsers() {
        return dao.getAll();
    }

    public boolean checkUser(String email, String Password){
        dao.getUser(email, Password);
        return true;
    }

   /* public boolean getCheckLogin(String mail, String pass) {
        if (isValid()) {
            User user = dao.getUser(mail,pass)
            if(user!=null){
                return true;
            }
            else
                return false;
        }
        else
            return false;
    }

    public boolean isValid() {
        return !TextUtils.isEmpty(user.getEmail()) && !TextUtils.isEmpty(user.getPassword()) &&
                user.getPassword().length() > 4;
    }*/


}

