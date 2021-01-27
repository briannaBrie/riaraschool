package com.example.riaraschool.network;

import android.util.Log;

import com.example.riaraschool.model.EnglishModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitInstance {

    public static String BASE_URL = "https://private-d67e0a-riaraschools.apiary-mock.com/";

    private static Retrofit retrofit;
    private final EnglishModel model =new EnglishModel();

    public static Retrofit getRetrofitClient(){
        if(retrofit == null){
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }

    public static APIService getApiService(){
        return getRetrofitClient().create(APIService.class);
    }

    public EnglishModel makeEnglishApiCall() {
        APIService service = RetrofitInstance.getRetrofitClient().create(APIService.class);
        Call<EnglishModel> call = service.getEnglishQuiz();
        //Call<List<EnglishModel>> call = service.getEnglishQuiz();
        call.enqueue(new Callback<EnglishModel>() {
            @Override
            public void onResponse(Call<EnglishModel> call, Response<EnglishModel> response) {
                EnglishModel eng = response.body();
                model.setTitle(eng.getTitle());
                model.setImage1(eng.getImage1());
                model.setImage2(eng.getImage2());
                model.setImage3(eng.getImage3());

                Log.e("Success", response.body().toString());
            }

            @Override
            public void onFailure(Call<EnglishModel> call, Throwable t) {
                //nothing is displayed in the components
                Log.e("Failure", t.getLocalizedMessage());
            }
        });
        return model;
    }


}
