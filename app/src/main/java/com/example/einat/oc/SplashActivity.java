package com.example.einat.oc;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;


public class SplashActivity extends AppCompatActivity {

    private static final long SPLASH_TIME = 3000; //3 seconds
    Handler mHandler;
    Runnable mJumpRunnable;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);

        mJumpRunnable = new Runnable() {

            public void run() {
                jump();
            }
        };
        mHandler = new Handler();
        mHandler.postDelayed(mJumpRunnable, SPLASH_TIME);
    }

    private void jump() {
        if(isFinishing())
            return;

        if (sharedPreferences.getBoolean("first", true)){
            editor = sharedPreferences.edit();
            editor.putBoolean("first", false);
            editor.commit();
            startActivity(new Intent(this, SettingsActivity.class));
        }
        else {
            startActivity(new Intent(this, MainActivity.class));
        }
        finish();
    }


    @Override
    public boolean onTouchEvent(MotionEvent event) {
        jump();
        return true;
    }


}
