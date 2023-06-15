package com.example.tipper;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class QuizzAnswer extends AppCompatActivity {

    private int score;
    private TextView answer;

    private TextView answerText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quizz_answer);
        answer = (TextView) findViewById(R.id.answer);
        answerText = (TextView) findViewById(R.id.answerText);
        Intent intent = getIntent();
        score = intent.getIntExtra("score", 0);
        answer.setText(String.valueOf(score));

    }
}