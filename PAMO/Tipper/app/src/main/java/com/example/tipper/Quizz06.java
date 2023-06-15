package com.example.tipper;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Quizz06 extends AppCompatActivity {

    private Button answer1Button;
    private Button answer2Button;
    private Button answer3Button;
    private Button answer4Button;


    private int score;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quizz06);
        Intent intent = getIntent();
        score = intent.getIntExtra("score", 0);

        answer1Button = (Button) findViewById(R.id.buttonAnswer1Question1);
        answer2Button = (Button) findViewById(R.id.buttonAnswer2Question1);
        answer3Button = (Button) findViewById(R.id.buttonAnswer3Question1);
        answer4Button = (Button) findViewById(R.id.buttonAnswer4Question1);

        answer1Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent switchActivityIntent = new Intent(Quizz06.this, QuizzAnswer.class);
                switchActivityIntent.putExtra("score", score); // Pass current score
                startActivity(switchActivityIntent);
            }
        });
        answer2Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent switchActivityIntent = new Intent(Quizz06.this, QuizzAnswer.class);
                switchActivityIntent.putExtra("score", score); // Pass current score
                startActivity(switchActivityIntent);
            }
        });
        answer3Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent switchActivityIntent = new Intent(Quizz06.this, QuizzAnswer.class);
                switchActivityIntent.putExtra("score", score); // Pass current score
                startActivity(switchActivityIntent);
            }
        });
        answer4Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent switchActivityIntent = new Intent(Quizz06.this, QuizzAnswer.class);
                switchActivityIntent.putExtra("score", score+1); // Pass current score
                startActivity(switchActivityIntent);
            }
        });



    }
}