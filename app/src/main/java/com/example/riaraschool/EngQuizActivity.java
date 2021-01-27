package com.example.riaraschool;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;
import com.example.riaraschool.model.EnglishModel;
import com.example.riaraschool.model.GradeModel;
import com.example.riaraschool.viewmodel.EnglishViewModel;
import com.example.riaraschool.viewmodel.GradeListViewModel;
import com.squareup.picasso.Picasso;

import java.io.File;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class EngQuizActivity extends AppCompatActivity {
    @BindView(R.id.txtQstn)
    TextView qstn;
    @BindView(R.id.image1)
    ImageView image1;
    @BindView(R.id.image2)
    ImageView image2;
    @BindView(R.id.image3)
    ImageView image3;
    @BindView(R.id.correct)
    ImageView correct;
    @BindView(R.id.wrong)
    ImageView wrong;

    private Context context;
    private List<EnglishModel> englishModelList;
    private EnglishViewModel englishViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eng_quiz);

        ButterKnife.bind(this);

        getEnglishView();


        englishViewModel.getModelVal();


        image1.setOnClickListener(v->{

        });
        image2.setOnClickListener(v->{

        });
        image3.setOnClickListener(v->{

        });
    }
    public void getEnglishView(){
        //populate the components
        //data binding
        String qstnVal = englishViewModel.getModelVal().getTitle().toString();
        qstn.setText(qstnVal);
        String img1Val = englishViewModel.getModelVal().getImage1().toString();
        /*Glide.with(context)
                .load(img1Val)
                .apply(RequestOptions.bitmapTransform(new RoundedCorners(12)).override(70,70))
                .into(image1);*/

        Picasso.get()
                .load(img1Val)
                .fit()
                .into(image1);

        String img2Val = englishViewModel.getModelVal().getImage2().toString();
        Picasso.get()
                .load(img2Val)
                .fit()
                .into(image2);
        String img3Val = englishViewModel.getModelVal().getImage3().toString();
        Picasso.get()
                .load(img3Val)
                .fit()
                .into(image3);
    }
}