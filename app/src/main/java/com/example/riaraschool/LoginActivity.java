package com.example.riaraschool;


import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.riaraschool.R;
import com.example.riaraschool.callbacks.LoginCallBacks;
import com.example.riaraschool.databinding.ActivityLoginBinding;
import com.example.riaraschool.model.User;
import com.example.riaraschool.viewmodel.GradeListViewModel;
import com.example.riaraschool.viewmodel.LoginViewModel;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class LoginActivity extends AppCompatActivity implements LoginCallBacks {
    @BindView(R.id.email)
    EditText email;
    @BindView(R.id.password)
    EditText pass;


    private LoginViewModel viewModel;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        ButterKnife.bind(this);

        ActivityLoginBinding activityLoginBinding = DataBindingUtil.setContentView(this, R.layout.activity_login);
        activityLoginBinding.setViewmodel(new ViewModelProvider(this).get(LoginViewModel.class));


/*
        viewModel = new ViewModelProvider(this).get(LoginViewModel.class);
        viewModel.getAllUsers().observe(this, new Observer<List<User>>() {
            @Override
            public void onChanged(List<User> users) {
                //update the user data
                Toast.makeText(LoginActivity.this, "On changed", Toast.LENGTH_SHORT).show();

            }
        });*/

    }

    @Override
    public void onSuccess(String message) {
        Toast.makeText(this, "Success", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onFailure(String message) {
        Toast.makeText(this, "Failure", Toast.LENGTH_SHORT).show();
    }
}