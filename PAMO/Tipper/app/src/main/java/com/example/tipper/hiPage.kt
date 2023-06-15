package com.example.tipper

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import java.util.Timer
import java.util.TimerTask

/*
 * Main Activity class that loads {@link MainFragment}.
 */
class hiPage : AppCompatActivity() {
    var timer: Timer? = null
    public override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hi_page)
        val handler = Handler()
        timer = Timer()
        timer!!.schedule(object : TimerTask() {
            override fun run() {
                switchActivities()
            }
        }, 5000)
        //        handler.postDelayed(switchActivities(),10000);
    }

    private fun switchActivities() {
        val switchActivityIntent = Intent(this, MainActivity::class.java)
        startActivity(switchActivityIntent)
    }
}