package com.example.riaraschool.database;

import android.content.Context;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.example.riaraschool.model.User;
import com.example.riaraschool.dao.UsersDao;

@Database(entities = {User.class}, version = 1, exportSchema = false)
public abstract class UserDB extends RoomDatabase {
    //create a Database instance
    private static UserDB instance;
    public abstract UsersDao dao();

    //define database name
    private static String DATABASE_NAME = "database";

    //singleton instance
    public synchronized static UserDB getInstance(Context context) {
        //check if the database is null
        if (instance == null) {
            //initialise the database is there is no instance
            instance = Room.databaseBuilder(context.getApplicationContext(),
                    UserDB.class,DATABASE_NAME)
                    .allowMainThreadQueries()
                    .fallbackToDestructiveMigration()//if version number is increased then delete this one and recreate it
                   // .addCallback(roomCallBack)//to populate our database
                    .build();
        }
        //return the existing instance if not null
        return instance;
    }
/*
    //populate database
    private static RoomDatabase.Callback roomCallBack = new RoomDatabase.Callback(){
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);
            //called once when db is created
            new PopulateDbAsyncTask(instance).execute();
        }
    };

    private static class PopulateDbAsyncTask extends AsyncTask<Void, Void, Void>{

        private UsersDao dao;

        public PopulateDbAsyncTask(UserDB db) {
            dao = db.dao();
        }

        @Override
        protected Void doInBackground(Void... voids) {
            dao.insert(new User(1, "brie@gmail.com", "12345"));
            dao.insert(new User(2, "admin@gmail.com", "admin"));
            return null;
        }
    }*/
}
