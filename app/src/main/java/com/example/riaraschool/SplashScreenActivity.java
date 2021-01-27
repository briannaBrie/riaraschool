package com.example.riaraschool;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SplashScreenActivity extends AppCompatActivity {
    @BindView(R.id.imgLogo)
    ImageView imgLogo;
    @BindView(R.id.slogan)
    TextView slogan;
    @BindView(R.id.logo_name)
    TextView txtlogo;
    @BindView(R.id.first_line)
    View firstView;
    @BindView(R.id.second_line)
    View secondView;
    @BindView(R.id.third_line)
    View thirdView;
    @BindView(R.id.fourth_line)
    View fourthView;
    @BindView(R.id.fifth_line)
    View fifthView;
    @BindView(R.id.sixth_line)
    View sixthView;

    //Animations
    Animation topAnim, bottomAnim, middleAnim;
    private Handler handler = new Handler();

    private static int SPLASH_TIME_OUT = 5000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splash_screen);

        ButterKnife.bind(this);

        topAnim = AnimationUtils.loadAnimation(this, R.anim.top_animation);
        middleAnim = AnimationUtils.loadAnimation(this, R.anim.middle_animation);
        bottomAnim = AnimationUtils.loadAnimation(this, R.anim.bottom_animation);

        //set animations
        firstView.setAnimation(topAnim);
        secondView.setAnimation(topAnim);
        thirdView.setAnimation(topAnim);
        fourthView.setAnimation(topAnim);
        fifthView.setAnimation(topAnim);
        sixthView.setAnimation(topAnim);
        imgLogo.setAnimation(middleAnim);
        txtlogo.setAnimation(middleAnim);
        slogan.setAnimation(bottomAnim);

        //splash screen
        handler.postDelayed(() -> {
            Intent intent = new Intent(SplashScreenActivity.this, LoginActivity.class);
            startActivity(intent);
            finish();
        }, SPLASH_TIME_OUT);
    }

}