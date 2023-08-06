package com.rafter.socialmedia;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ProgressBar;

import androidx.appcompat.app.AppCompatActivity;

public class Splash extends AppCompatActivity {
    private ProgressBar intro_progress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        intro_progress=(ProgressBar)  findViewById(R.id.intro_progress);
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                intro_progress.setVisibility(View.GONE);
                startActivity(new Intent(getApplicationContext(),MainActivity.class));
            }
        },1700);

    }
}
