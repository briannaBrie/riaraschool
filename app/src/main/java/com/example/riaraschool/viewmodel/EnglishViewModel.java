package com.example.riaraschool.viewmodel;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.riaraschool.model.EnglishModel;
import com.example.riaraschool.model.GradeModel;
import com.example.riaraschool.network.APIService;
import com.example.riaraschool.network.RetrofitInstance;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class EnglishViewModel extends ViewModel {
    private MutableLiveData<EnglishModel> english;
    private EnglishModel model;
    private RetrofitInstance retro = new RetrofitInstance();

    public EnglishViewModel() {
        english = new MutableLiveData<>();
    }

    //returns the live data
    public MutableLiveData<EnglishModel> getEnglishObserver() {
        return english;
    }

    public EnglishModel getModelVal(){
        if(model == null){
            model=retro.makeEnglishApiCall();
        }
        return model;
    }
}

