package com.codingmortals.learncodeonline.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.codingmortals.learncodeonline.R;
import com.codingmortals.learncodeonline.fragments.SplashFragment;
import com.codingmortals.learncodeonline.fragments.WelcomeFragment;
import com.codingmortals.learncodeonline.utils.TypeWriterEffect;

public class SplashActivity extends AppCompatActivity{


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        getSupportFragmentManager().beginTransaction().add(R.id.content,new SplashFragment(),"splash").commit();
    }
}
