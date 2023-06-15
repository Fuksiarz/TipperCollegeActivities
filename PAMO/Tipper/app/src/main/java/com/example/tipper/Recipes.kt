package com.example.tipper

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class Recipes : AppCompatActivity() {
    private var backButton: Button? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recipes)
        backButton = findViewById<View>(R.id.backButton) as Button
        backButton!!.setOnClickListener {
            val switchActivityIntent = Intent(this@Recipes, MainActivity::class.java)
            startActivity(switchActivityIntent)
        }
    }
}