package com.example.android.scorekeeperapp;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Build;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.transition.Explode;

public class SplashActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Explode explode = new Explode();
            explode.setDuration(800);
            getWindow().setExitTransition(explode);
        }
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Bundle bundle;
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    Intent intent = new Intent(SplashActivity.this,MainActivity.class);
                    bundle = ActivityOptions.makeSceneTransitionAnimation(SplashActivity.this).toBundle();
                    startActivity(intent,bundle);
                    finish();
                }
            }
        }, 1500);
    }
}
