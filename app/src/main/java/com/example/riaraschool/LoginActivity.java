package com.example.riaraschool;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


import com.example.riaraschool.database.UserDB;
import com.example.riaraschool.model.User;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class LoginActivity extends AppCompatActivity {
    @BindView(R.id.email)
    EditText email;
    @BindView(R.id.password)
    EditText password;
    @BindView(R.id.btnLogin)
    Button btnLogin;
    @BindView(R.id.txtRegister)
    TextView register;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        ButterKnife.bind(this);
        addMultipleUsers();

        register.setOnClickListener(v ->{
            Intent registerIntent = new Intent(LoginActivity.this, RegisterActivity.class);
            startActivity(registerIntent);
        });

        btnLogin.setOnClickListener(v->{
            String emailData = email.getText().toString();
            String passData = password.getText().toString();
            if (validateInput(emailData, passData)) {
              UserDB database = UserDB.getInstance(this);
                User user =database.dao().loginUser(emailData, passData);
                if(user == null){
                    Toast.makeText(this, "Invalid Credentials", Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(this, "Logged in", Toast.LENGTH_SHORT).show();
                    Intent lessonsIntent = new Intent(LoginActivity.this, MainActivity.class);
                    startActivity(lessonsIntent);
                }

            }
            else {
                Toast.makeText(this, "Fill in all Fields!", Toast.LENGTH_SHORT).show();
            }

        });
    }

    private void addMultipleUsers() {
        new Thread((Runnable) ()-> {
            List<User> users = new ArrayList<>();
            users.add(new User("admin@gmail.com", "admin"));
            users.add(new User("brie@gmail.com", "12345"));

            UserDB.getInstance(getApplicationContext())
                    .dao()
                    .insertMultipleUsers(users);
            Log.d("multipleadds", "inserts started ");
        }).start();
    }

    private Boolean validateInput(String mail, String pass){
        if (mail.isEmpty() || pass.isEmpty()) {
            return  false;
        }
        else
            return true;
    }

}