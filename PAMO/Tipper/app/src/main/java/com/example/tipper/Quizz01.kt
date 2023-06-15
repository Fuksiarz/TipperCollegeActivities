package com.example.tipper

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class Quizz01 : AppCompatActivity() {
    private var answer1Button: Button? = null
    private var answer2Button: Button? = null
    private var answer3Button: Button? = null
    private var answer4Button: Button? = null
    private var score = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quizz01)
        score = 0
        answer1Button = findViewById<View>(R.id.buttonAnswer1Question1) as Button
        answer2Button = findViewById<View>(R.id.buttonAnswer2Question1) as Button
        answer3Button = findViewById<View>(R.id.buttonAnswer3Question1) as Button
        answer4Button = findViewById<View>(R.id.buttonAnswer4Question1) as Button
        answer1Button!!.setOnClickListener {
            val switchActivityIntent = Intent(this@Quizz01, Quizz02::class.java)
            switchActivityIntent.putExtra("score", score) // Pass current score
            startActivity(switchActivityIntent)
        }
        answer2Button!!.setOnClickListener {
            val switchActivityIntent = Intent(this@Quizz01, Quizz02::class.java)
            switchActivityIntent.putExtra("score", score) // Pass current score
            startActivity(switchActivityIntent)
        }
        answer3Button!!.setOnClickListener {
            val switchActivityIntent = Intent(this@Quizz01, Quizz02::class.java)
            switchActivityIntent.putExtra("score", score) // Pass current score
            startActivity(switchActivityIntent)
        }
        answer4Button!!.setOnClickListener {
            val switchActivityIntent = Intent(this@Quizz01, Quizz02::class.java)
            switchActivityIntent.putExtra("score", score + 1) // Pass current score
            startActivity(switchActivityIntent)
        }
    }
}