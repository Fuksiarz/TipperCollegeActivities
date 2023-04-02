package com.example.tipper;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.Editable; // for EditText event handling
import android.text.TextWatcher; // EditText listener
import android.view.View;
import android.widget.Button;
import android.widget.EditText; // for bill amount input
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView; // for displaying text
import java.lang.Math;
import java.text.NumberFormat; // for currency formatting

public class MainActivity extends AppCompatActivity {

    // currency and percent formatter objects
    private static final NumberFormat currencyFormat =
            NumberFormat.getInstance();
    final Handler handler = new Handler();
    private double weight = 0.0; // bill amount entered by the user
    private double height = 0.0; // bill amount entered by the user
    private int age = 0;
    private Button recipiesButton;

    private Button quizzButton;
    private TextView weightTextView; // shows formatted bill amount
    private TextView heightTextView; // shows formatted bill amount
    private RadioGroup genderGroup;
    private RadioButton genderMan;
    private RadioButton genderWoman;
    private TextView totalTextView; // shows calculated total bill amount
    private TextView calCalc; // shows calculated total bill amount
    private TextView ageTextView;
    // called when the activity is first created
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState); // call superclass onCreate
        setContentView(R.layout.activity_main); // inflate the GUI

        // get references to programmatically manipulated TextViews
        weightTextView = (TextView) findViewById(R.id.weight);
        heightTextView = (TextView) findViewById(R.id.height);
        genderGroup = (RadioGroup) findViewById(R.id.genderGroup);
        genderMan = (RadioButton) findViewById(R.id.radioMan);
        genderWoman = (RadioButton) findViewById(R.id.radioWoman);
        calCalc = (TextView) findViewById(R.id.calCalc);
        totalTextView = (TextView) findViewById(R.id.totalTextView);
        ageTextView = (TextView) findViewById(R.id.ageTextView);
        totalTextView.setText(currencyFormat.format(0));
        calCalc.setText(currencyFormat.format(0));
//
        recipiesButton =(Button) findViewById(R.id.recipesButton);
        recipiesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent switchActivityIntent = new Intent(MainActivity.this, Recipes.class);
                startActivity(switchActivityIntent);
            }
        });
        quizzButton =(Button) findViewById(R.id.quizzButton);
        quizzButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent switchActivityIntent = new Intent(MainActivity.this, Quizz01.class);
                startActivity(switchActivityIntent);
            }
        });


        // set amountEditText's TextWatcher
        EditText amountEditText =
                (EditText) findViewById(R.id.weightEdit);
        amountEditText.addTextChangedListener(weightWatcher);

        EditText amountEditText2 =
                (EditText) findViewById(R.id.heightEdit);
        amountEditText2.addTextChangedListener(heightWatcher);

        EditText amountEditText3 =
                (EditText) findViewById(R.id.ageEdit);
        amountEditText3.addTextChangedListener(ageWatcher);

        RadioButton amountEditText4 =
                (RadioButton) findViewById(R.id.radioMan);
        amountEditText4.addTextChangedListener(genderWatcher);



        // set percentSeekBar's OnSeekBarChangeListener

    }

    // calculate and display tip and total amounts
    private void calculate() {
        // format percent and display in percentTextView

        // calculate the tip and total
        double calories = 0;
        double total = weight / Math.pow(height,2);
        if(genderMan.isChecked()){
            calories = 66.47 + (13.7 * weight) + ( 5 * height * 100) - 6.76 * age;
        }else if(genderWoman.isChecked())
            calories = 655.1 + (9.567 * weight) + (1.85 * height * 100) - 4.68 * age;
        // display tip and total formatted as currency

        totalTextView.setText(currencyFormat.format(total));

        calCalc.setText(currencyFormat.format(calories));


    }

    // listener object for the SeekBar's progress changed events


    // listener object for the EditText's text-changed events
    private final TextWatcher weightWatcher = new TextWatcher() {
        // called when the user modifies the bill amount
        @Override
        public void onTextChanged(CharSequence s, int start,
                                  int before, int count) {

            try { // get bill amount and display currency formatted value
                weight = Double.parseDouble(s.toString())/100.0;
                weightTextView.setText(currencyFormat.format(weight));
            }
            catch (NumberFormatException e) { // if s is empty or non-numeric
                weightTextView.setText("");
                weight = 0.0;
            }

            calculate(); // update the tip and total TextViews
        }

        @Override
        public void afterTextChanged(Editable s) { }

        @Override
        public void beforeTextChanged(
                CharSequence s, int start, int count, int after) { }
    };
    private final TextWatcher heightWatcher = new TextWatcher() {
        // called when the user modifies the bill amount
        @Override
        public void onTextChanged(CharSequence s, int start,
                                  int before, int count) {

            try { // get bill amount and display currency formatted value
                height = Double.parseDouble(s.toString()) / 100.0;
                heightTextView.setText(currencyFormat.format(height));
            }
            catch (NumberFormatException e) { // if s is empty or non-numeric
                heightTextView.setText("");
                height = 0.0;
            }

            calculate(); // update the tip and total TextViews
        }

        @Override
        public void afterTextChanged(Editable s) { }

        @Override
        public void beforeTextChanged(
                CharSequence s, int start, int count, int after) { }
    };

    private final TextWatcher ageWatcher = new TextWatcher() {
        // called when the user modifies the bill amount
        @Override
        public void onTextChanged(CharSequence s, int start,
                                  int before, int count) {

            try { // get bill amount and display currency formatted value
                age = Integer.parseInt(s.toString());
                ageTextView.setText(currencyFormat.format(age));
            }
            catch (NumberFormatException e) { // if s is empty or non-numeric
                ageTextView.setText("1");
                age = 1;
            }

            calculate(); // update the tip and total TextViews
        }

        @Override
        public void afterTextChanged(Editable s) { }

        @Override
        public void beforeTextChanged(
                CharSequence s, int start, int count, int after) { }
    };

    private final TextWatcher genderWatcher = new TextWatcher() {
        // called when the user modifies the bill amount
        @Override
        public void onTextChanged(CharSequence s, int start,
                                  int before, int count) {



            calculate(); // update the tip and total TextViews
        }

        @Override
        public void afterTextChanged(Editable s) { }

        @Override
        public void beforeTextChanged(
                CharSequence s, int start, int count, int after) { }
    };
    private void switchActivitiesToRecipes() {
        Intent switchActivityIntent = new Intent(this, Recipes.class);
        startActivity(switchActivityIntent);

    }
    private void switchActivitiesToQuizz01() {
        Intent switchActivityIntent = new Intent(this, Quizz01.class);
        startActivity(switchActivityIntent);

    }


}


