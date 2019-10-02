package com.example.harsh.geniusplaza;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;

public class SplashScreen extends Activity {


    Handler mHandler;
    Runnable mRunnable;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_screen);
        mHandler = new Handler();

        new Thread(new Runnable() {
            @Override
            public void run() {

                try {
                    Thread.sleep(1000);
                    runOnUiThread(new Runnable() {


                        @Override
                        public void run() {
                            finish();
                            Intent intent = new Intent(SplashScreen.this, MainActivity.class);
                            startActivity(intent);

                        }

                    });

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }).start();

    }

}

