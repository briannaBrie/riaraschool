package com.example.riaraschool;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.content.Context;
import android.content.Intent;
import android.nfc.Tag;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.riaraschool.dao.UsersDao;
import com.example.riaraschool.database.UserDB;
import com.example.riaraschool.model.User;
import com.example.riaraschool.viewmodel.RegisterViewModel;
import com.google.android.material.tabs.TabLayout;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RegisterActivity extends AppCompatActivity {

    @BindView(R.id.reg_email)
    EditText email;
    @BindView(R.id.reg_password)
    EditText password;
    @BindView(R.id.btnRegister)
    Button register;
    @BindView(R.id.txtLogin)
    TextView login;

    RegisterViewModel registerViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        ButterKnife.bind(this);
        registerViewModel = new ViewModelProvider(this).get(RegisterViewModel.class);

        registerViewModel.getAllUsers().observe(this, new Observer<List<User>>() {
            @Override
            public void onChanged(List<User> userList) {
                Log.d("Users", "onChanged: "+userList.toString());
                Log.d("Users", "onChanged: "+userList.size());
            }
        });


        login.setOnClickListener(v ->{
            Intent loginIntent = new Intent(RegisterActivity.this, LoginActivity.class);
            startActivity(loginIntent);
        });

        register.setOnClickListener(v -> {
            //create model
            User user = new User();
            user.setEmail(email.getText().toString());
            user.setPassword(password.getText().toString());
 /*               UserDB db = UserDB.getInstance(this);

                db.dao().registerUser(user);
                Toast.makeText(this, "Registered", Toast.LENGTH_SHORT).show();
*/
                registerUser(v);
        });
    }

    public void registerUser(View view) {
        User user = new User();
        user.setEmail(email.getText().toString());
        user.setPassword(password.getText().toString());
        if(validateInput(user)){
            RegAsyncTask regAsyncTask = new RegAsyncTask();
            regAsyncTask.execute(user);
        }else{
            Toast.makeText(getApplicationContext(), "Fill all fields!", Toast.LENGTH_SHORT).show();
        }


    }

    public void getAllUsers(View view){
        Thread thread = new Thread((Runnable) ()->{
            List<User> userlis = UserDB.getInstance(getApplicationContext())
                    .dao()
                    .getUserList();
            Log.d("getall", "getAllUsers: "+userlis.toString());
        });
        thread.start();
    }

    private Boolean validateInput(User user){
        if (user.getEmail().isEmpty() || user.getPassword().isEmpty()) {
            return  false;
        }
        else
            return true;
    }
    class RegAsyncTask extends AsyncTask<User, Void, Void> {

        @Override
        protected Void doInBackground(User... users) {
            UserDB.getInstance(getApplicationContext())
                    .dao()
                    .delete(users[0]);
            return null;
        }
    }
    class AddAsynTask extends AsyncTask<List<User>, Void, Void> {

        @Override
        protected Void doInBackground(List<User>... lists) {
            UserDB.getInstance(getApplicationContext())
                    .dao()
                    .insertMultipleUsers(lists[0]);
            return null;
        }
    }
}