package com.example.riaraschool.viewmodel;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.riaraschool.model.GradeModel;
import com.example.riaraschool.network.APIService;
import com.example.riaraschool.network.RetrofitInstance;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class GradeListViewModel extends ViewModel {
    //Observer for the live data that we update user changes to the recyclerview
    private MutableLiveData<List<GradeModel>> gradeList;

    public GradeListViewModel() {
        gradeList = new MutableLiveData<>();
    }

    //returns the live data
    public MutableLiveData<List<GradeModel>> getGradeListObserver() {
        return gradeList;
    }

    public void makeApiCall() {
        APIService service = RetrofitInstance.getRetrofitClient().create(APIService.class);
        Call<List<GradeModel>> call = service.getGradeList();
        call.enqueue(new Callback<List<GradeModel>>() {
            @Override
            public void onResponse(Call<List<GradeModel>> call, Response<List<GradeModel>> response) {
                gradeList.postValue(response.body());
                Log.e("Success", response.body().toString());
            }

            @Override
            public void onFailure(Call<List<GradeModel>> call, Throwable t) {
                gradeList.postValue(null);
                //nothing is displayed on the recyclerview
                Log.e("Failure", t.getLocalizedMessage());
            }
        });
    }
}
