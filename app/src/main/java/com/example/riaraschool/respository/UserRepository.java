package com.example.riaraschool.respository;

import android.app.Application;
import android.os.AsyncTask;
import android.text.TextUtils;

import androidx.lifecycle.LiveData;

import com.example.riaraschool.dao.UsersDao;
import com.example.riaraschool.database.UserDB;
import com.example.riaraschool.model.User;

import java.util.List;

public class UserRepository {
    /*
    private UsersDao dao;
    private LiveData<List<User>> allUsers;

    public UserRepository(Application application){
        UserDB database =  UserDB.getInstance(application);
        dao = database.dao();
        allUsers = dao.getAll();
    }


    public void insert(User user){
        new InsertUserAsyncTask(dao).execute(user);
    }
    public void update(User user){
        new UpdateUserAsyncTask(dao).execute(user);

    }
    public void delete(User user){
        new DeleteUserAsyncTask(dao).execute(user);
    }
    public void reset(){
        new ResetUserAsyncTask(dao).execute();
    }
    public LiveData<List<User>> getAllUsers(){
        return allUsers;
    }

    //Room doesn't allow running threads in the foreground this could freeze the app
    private static class InsertUserAsyncTask extends AsyncTask<User, Void, Void>{
        private UsersDao usersDao;

        public InsertUserAsyncTask(UsersDao usersDao) {
            this.usersDao = usersDao;
        }

        @Override
        protected Void doInBackground(User... users) {
            //we access the data from the first row
            usersDao.insert(users[0]);
            return null;
        }
    }
    private static class DeleteUserAsyncTask extends AsyncTask<User, Void, Void>{
        private UsersDao usersDao;

        public DeleteUserAsyncTask(UsersDao usersDao) {
            this.usersDao = usersDao;
        }

        @Override
        protected Void doInBackground(User... users) {
            //we access the data from the first row
            usersDao.delete(users[0]);
            return null;
        }
    }
    private static class UpdateUserAsyncTask extends AsyncTask<User, Void, Void>{
        private UsersDao usersDao;

        public UpdateUserAsyncTask(UsersDao usersDao) {
            this.usersDao = usersDao;
        }

        @Override
        protected Void doInBackground(User... users) {
            //we access the data from the first row
            usersDao.update(users[0]);
            return null;
        }
    }
    private static class ResetUserAsyncTask extends AsyncTask<Void, Void, Void>{
        private UsersDao usersDao;

        public ResetUserAsyncTask(UsersDao usersDao) {
            this.usersDao = usersDao;
        }

        @Override
        protected Void doInBackground(Void... voids) {
            //we access the data from the first row
            usersDao.reset();
            return null;
        }
    }*/

}
