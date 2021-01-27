package com.example.riaraschool.network;

import com.example.riaraschool.model.EnglishModel;
import com.example.riaraschool.model.GradeModel;

import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface APIService {

    //selete all grades
    @GET("grades")
    Call<List<GradeModel>> getGradeList();

    // create grade
    @POST("new")
    Call<ResponseBody> addGrade(@Body GradeModel gradeModel);

    //edit
    // update user
    @PUT("api/update")
    Call<ResponseBody> updateUser(
            @Query("subject") String subject,
            @Query("lessons") String no_of_lessons
    );
    //delete
    // delete user
    @DELETE("api/delete")
    Call<ResponseBody> deleteGrade(
            @Query("lesson") String lesson
    );

    //selete all quizzes
    @GET("english")
    Call<EnglishModel> getEnglishQuiz();

}
