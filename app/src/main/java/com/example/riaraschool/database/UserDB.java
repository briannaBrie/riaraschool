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
    //define database name
    private static String DATABASE_NAME = "database";

    public abstract UsersDao dao();

    //singleton instance
    public static synchronized  UserDB getInstance(Context context) {
        //check if the database is null
        if (instance == null) {
            //initialise the database is there is no instance
            instance = Room.databaseBuilder(context.getApplicationContext(),
                    UserDB.class,DATABASE_NAME)
                    .fallbackToDestructiveMigration()//if version number is increased then delete this one and recreate it
                    .allowMainThreadQueries()//not recommended
                    //.addCallback(userDatabaseCallback)
                    .build();

        }
        //return the existing instance if not null
        return instance;
    }
  /*  private static RoomDatabase.Callback userDatabaseCallback = new RoomDatabase.Callback(){
        @Override
        public void onOpen(@NonNull SupportSQLiteDatabase db) {
            super.onOpen(db);
            // If you want to keep the data through app restarts,
            // comment out the following line.
            new PopulateDbAsync(INSTANCE).execute();
        }
    }*/
}


