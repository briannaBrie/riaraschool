package com.example.riaraschool;


import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.room.Room;

import com.example.riaraschool.R;
import com.example.riaraschool.dao.UsersDao;
import com.example.riaraschool.database.UserDB;
import com.example.riaraschool.databinding.ActivityLoginBinding;
import com.example.riaraschool.model.User;
import com.example.riaraschool.respository.UserRepository;
import com.example.riaraschool.viewmodel.GradeListViewModel;
import com.example.riaraschool.viewmodel.LoginViewModel;
import com.example.riaraschool.viewmodel.TrialLogin;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class LoginActivity extends AppCompatActivity {
    @BindView(R.id.email)
    EditText email;
    @BindView(R.id.password)
    EditText pass;
    @BindView(R.id.btnLogin)
    Button btnLogin;


    private LoginViewModel viewModel;
    private TrialLogin trialLogin;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        ButterKnife.bind(this);

        btnLogin.setOnClickListener(v->{
           /* String mail = email.getText().toString().trim();
            String password = pass.getText().toString().trim();
            if(trialLogin.login(mail, password) && isValid()){*/
                Intent moveToLessons = new Intent(LoginActivity.this, MainActivity.class);
                startActivity(moveToLessons);
                Toast.makeText(LoginActivity.this, "Login Success", Toast.LENGTH_SHORT).show();
                finish();
            /*}
            else
                Toast.makeText(LoginActivity.this, "Invalid Login", Toast.LENGTH_SHORT).show();*/

        });

        //dao = dataBase.dao();

        //      ActivityLoginBinding activityLoginBinding = DataBindingUtil.setContentView(this, R.layout.activity_login);
        //       activityLoginBinding.setViewmodel(new ViewModelProvider(this).get(LoginViewModel.class));


 //       viewModel = new ViewModelProvider(this).get(LoginViewModel.class);
 /*       viewModel.getAllUsers().observe(this, new Observer<List<User>>() {
            @Override
            public void onChanged(List<User> users) {
                //update the user data
                Toast.makeText(LoginActivity.this, "On changed", Toast.LENGTH_SHORT).show();

            }

        });*/
   /*     btnLogin.setOnClickListener(v -> {
            String mail = email.getText().toString().trim();
            String pwd = pass.getText().toString().trim();
            if(isValid()){
                viewModel.checkUser(mail, pwd);
                Intent i = new Intent(LoginActivity.this, MainActivity.class);
               // i.putExtra("User", String.valueOf(user));
                startActivity(i);
                finish();

            }
            else
                Toast.makeText(LoginActivity.this, "Unregistered user, or incorrect", Toast.LENGTH_SHORT).show();
        });*/


   /*     btnLogin.setOnClickListener(v->{
            String mail = email.getText().toString().trim();
            String password = pass.getText().toString().trim();

            User user = dao.getUser(mail, password);
            if(user!=null){
                Intent i = new Intent(LoginActivity.this, MainActivity.class);
                i.putExtra("User", String.valueOf(user));
                startActivity(i);
                finish();
            }
            else{
                Toast.makeText(LoginActivity.this, "Unregistered user, or incorrect", Toast.LENGTH_SHORT).show();
            }
        });


   /*     btnLogin.setOnClickListener(v->{
            String emailaddress = email.getText().toString().trim();
            String password = pass.getText().toString().trim();
            if(dao.getUser(emailaddress, password)){
                Intent moveToLessons = new Intent(LoginActivity.this, MainActivity.class);
                startActivity(moveToLessons);
                Toast.makeText(LoginActivity.this, "Login Success", Toast.LENGTH_SHORT).show();
                finish();
            }
            else
                Toast.makeText(LoginActivity.this, "Invalid Login", Toast.LENGTH_SHORT).show();
        });

      viewModel.getAllUsers().observe(this, new Observer<List<User>>() {
            @Override
            public void onChanged(List<User> users) {
                //update the user data
                Toast.makeText(LoginActivity.this, "On changed", Toast.LENGTH_SHORT).show();

            }
        });*/

     /*   btnLogin.setOnClickListener(v->{
            String mail = email.getText().toString().trim();
            String password = pass.getText().toString().trim();

            if(viewModel.getCheckLogin(mail, password)){
                Intent moveToLessons = new Intent(LoginActivity.this, MainActivity.class);
                startActivity(moveToLessons);
                Toast.makeText(LoginActivity.this, "Login Success", Toast.LENGTH_SHORT).show();
                finish();
            }
            else
                Toast.makeText(LoginActivity.this, "Invalid Login", Toast.LENGTH_SHORT).show();
        });


    }
    public boolean getCheckLogin(String mail, String pass) {
        if (isValid()) {
            User user = dao.getUser(mail,pass);
            if(user!=null){
                return true;
            }
            else
                return false;
        }
        else
            return false;
    }
    */}
    public boolean isValid() {
        String mail = email.getText().toString().trim();
        String password = pass.getText().toString().trim();
        return !TextUtils.isEmpty(mail) && !TextUtils.isEmpty(password) &&
                password.length() > 4;
    }

    //if(mail.equalsIgnoreCase(emailaddress)&& password.equalsIgnoreCase(pass))



}