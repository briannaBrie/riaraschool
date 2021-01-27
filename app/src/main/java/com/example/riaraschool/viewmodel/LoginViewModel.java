package com.example.riaraschool.viewmodel;

import android.app.Application;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.riaraschool.callbacks.LoginCallBacks;
import com.example.riaraschool.database.UserDB;
import com.example.riaraschool.model.User;
import com.example.riaraschool.respository.UserRepository;

import java.util.List;

public class LoginViewModel extends AndroidViewModel {
    //prepare the database for the UI
    private UserRepository repo;
    private LiveData<List<User>> allUsers;
    private LoginCallBacks callBacks;
    private User user;


    public LoginViewModel(@NonNull Application application) {
        super(application);
        repo = new UserRepository(application);
        allUsers = repo.getAllUsers();
    }

    public void insert(User user) {
        repo.insert(user);
    }

    public void update(User user) {
        repo.update(user);
    }

    public void delete(User user) {
        repo.delete(user);
    }

    public void reset(User user) {
        repo.reset();
    }

    public LiveData<List<User>> getAllUsers() {
        return repo.getAllUsers();
    }

    //callbacks
    public LoginViewModel(@NonNull Application application, LoginCallBacks callBacks) {
        super(application);
        this.callBacks = callBacks;
    }

    public LoginCallBacks getCallBacks() {
        return callBacks;
    }

    public void setCallBacks(LoginCallBacks callBacks) {
        this.callBacks = callBacks;
    }
    public TextWatcher emailTextWatcher(){
        return new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                user.setEmail(s.toString());
            }
        };
    }

    public TextWatcher passTextWatcher(){
        return new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                user.setPassword(s.toString());
            }
        };
    }

    public void onLoginBtnClick(View view){
        if(user.isValid()){
            callBacks.onSuccess("Successful");
        }
        else{
            callBacks.onFailure("Failed");
        }
    }
}

