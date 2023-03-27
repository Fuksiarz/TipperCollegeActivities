package com.example.tipper;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;

import java.util.Objects;
import java.util.Timer;
import java.util.TimerTask;

/*
 * Main Activity class that loads {@link MainFragment}.
 */
public class hiPage extends AppCompatActivity {
    Timer timer;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hi_page);
        final Handler handler = new Handler();

        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                switchActivities();
            }
        },5000);
//        handler.postDelayed(switchActivities(),10000);
    }

    private void switchActivities() {
        Intent switchActivityIntent = new Intent(this, MainActivity.class);
        startActivity(switchActivityIntent);

    }



}