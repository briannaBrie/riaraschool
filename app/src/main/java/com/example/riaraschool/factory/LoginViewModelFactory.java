package com.example.riaraschool.factory;

import android.app.Application;
import android.content.Context;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;

import com.example.riaraschool.callbacks.LoginCallBacks;
import com.example.riaraschool.viewmodel.LoginViewModel;

public class LoginViewModelFactory extends ViewModelProvider.NewInstanceFactory {

    private LoginCallBacks callBacks;
    Application application;

    public LoginViewModelFactory(LoginCallBacks callBacks) {
        this.callBacks = callBacks;
    }
    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        return (T) new LoginViewModel(application, callBacks);
    }




}
