package com.example.tipper

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class QuizzAnswer : AppCompatActivity() {
    private var score = 0
    private var answer: TextView? = null
    private var gotoMenu: Button? = null
    private var answerText: TextView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quizz_answer)
        answer = findViewById<View>(R.id.answer) as TextView
        answerText = findViewById<View>(R.id.answerText) as TextView
        val intent = intent
        score = intent.getIntExtra("score", 0)
        answer!!.text = score.toString()
        gotoMenu = findViewById<View>(R.id.goToMain) as Button
        gotoMenu!!.setOnClickListener {
            val switchActivityIntent = Intent(this@QuizzAnswer, MainActivity::class.java)
            startActivity(switchActivityIntent)
        }
    }
}