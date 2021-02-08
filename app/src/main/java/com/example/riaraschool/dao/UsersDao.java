package com.example.riaraschool.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.riaraschool.model.User;

import java.util.List;

import static androidx.room.OnConflictStrategy.REPLACE;

@Dao
public interface UsersDao {
    //insert Query
    @Insert(onConflict = REPLACE)
    void registerUser(User userData);

    //delete
    @Delete
    void delete(User userData);

    //reset to default
    @Query("DELETE FROM users")
    void reset();

    //Update
    @Update
    void update(User user);

    //add multiple
    @Insert
    void insertMultipleUsers(List<User> userList);

    //get all the data
    @Query("SELECT * FROM users ORDER BY email DESC")
    List<User> getUserList();

    //returns livedata with a list of all Users
    @Query("SELECT * FROM users ORDER BY email DESC")
    public LiveData<List<User>> getAll();

    @Query("SELECT * FROM users where email= :mail and password= :pass")
    boolean searchUser(String mail, String pass);

    @Query("SELECT * FROM users where email= :mail and password= :pass")
    User loginUser(String mail, String pass);
}

