package com.example.tipper

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.text.NumberFormat

// for EditText event handling
// EditText listener
// for bill amount input
// for displaying text
// for currency formatting
class MainActivity : AppCompatActivity() {
    val handler = Handler()
    private var weight = 0.0 // bill amount entered by the user
    private var height = 0.0 // bill amount entered by the user
    private var age = 0
    private var recipiesButton: Button? = null
    private var quizzButton: Button? = null
    private var addToChart: Button? = null
    private var chart: Button? = null
    private var weightTextView // shows formatted bill amount
            : TextView? = null
    private var heightTextView // shows formatted bill amount
            : TextView? = null
    private var genderGroup: RadioGroup? = null
    private var genderMan: RadioButton? = null
    private var genderWoman: RadioButton? = null
    private var totalTextView // shows calculated total bill amount
            : TextView? = null
    private var calCalc // shows calculated total bill amount
            : TextView? = null
    private var ageTextView: TextView? = null

    // called when the activity is first created
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState) // call superclass onCreate
        setContentView(R.layout.activity_main) // inflate the GUI

        // get references to programmatically manipulated TextViews
        weightTextView = findViewById<View>(R.id.weight) as TextView
        heightTextView = findViewById<View>(R.id.height) as TextView
        genderGroup = findViewById<View>(R.id.genderGroup) as RadioGroup
        genderMan = findViewById<View>(R.id.radioMan) as RadioButton
        genderWoman = findViewById<View>(R.id.radioWoman) as RadioButton
        calCalc = findViewById<View>(R.id.calCalc) as TextView
        totalTextView = findViewById<View>(R.id.totalTextView) as TextView
        ageTextView = findViewById<View>(R.id.ageTextView) as TextView
        totalTextView!!.text = currencyFormat.format(0)
        calCalc!!.text = currencyFormat.format(0)
        //
        recipiesButton = findViewById<View>(R.id.recipesButton) as Button
        recipiesButton!!.setOnClickListener {
            val switchActivityIntent = Intent(this@MainActivity, Recipes::class.java)
            startActivity(switchActivityIntent)
        }
        addToChart = findViewById<View>(R.id.addToChart) as Button
        chart = findViewById<View>(R.id.chart) as Button
        chart!!.setOnClickListener {
            val switchActivityIntent = Intent(this@MainActivity, BmiChart::class.java)
            startActivity(switchActivityIntent)
        }
        quizzButton = findViewById<View>(R.id.quizzButton) as Button
        quizzButton!!.setOnClickListener {
            val switchActivityIntent = Intent(this@MainActivity, Quizz01::class.java)
            startActivity(switchActivityIntent)
        }


        // set amountEditText's TextWatcher
        val amountEditText = findViewById<View>(R.id.weightEdit) as EditText
        amountEditText.addTextChangedListener(weightWatcher)
        val amountEditText2 = findViewById<View>(R.id.heightEdit) as EditText
        amountEditText2.addTextChangedListener(heightWatcher)
        val amountEditText3 = findViewById<View>(R.id.ageEdit) as EditText
        amountEditText3.addTextChangedListener(ageWatcher)
        val amountEditText4 = findViewById<View>(R.id.radioMan) as RadioButton
        amountEditText4.addTextChangedListener(genderWatcher)


        // set percentSeekBar's OnSeekBarChangeListener
    }

    // calculate and display tip and total amounts
    private fun calculate() {
        // format percent and display in percentTextView

        // calculate the tip and total
        var calories = 0.0
        val total = weight / Math.pow(height, 2.0)
        if (genderMan!!.isChecked) {
            calories = 66.47 + 13.7 * weight + 5 * height * 100 - 6.76 * age
        } else if (genderWoman!!.isChecked) calories = 655.1 + 9.567 * weight + 1.85 * height * 100 - 4.68 * age
        // display tip and total formatted as currency
        totalTextView!!.text = currencyFormat.format(total)
        calCalc!!.text = currencyFormat.format(calories)
    }

    // listener object for the SeekBar's progress changed events
    // listener object for the EditText's text-changed events
    private val weightWatcher: TextWatcher = object : TextWatcher {
        // called when the user modifies the bill amount
        override fun onTextChanged(s: CharSequence, start: Int,
                                   before: Int, count: Int) {
            try { // get bill amount and display currency formatted value
                weight = s.toString().toDouble() / 100.0
                weightTextView!!.text = currencyFormat.format(weight)
            } catch (e: NumberFormatException) { // if s is empty or non-numeric
                weightTextView!!.text = ""
                weight = 0.0
            }
            calculate() // update the tip and total TextViews
        }

        override fun afterTextChanged(s: Editable) {}
        override fun beforeTextChanged(
                s: CharSequence, start: Int, count: Int, after: Int) {
        }
    }
    private val heightWatcher: TextWatcher = object : TextWatcher {
        // called when the user modifies the bill amount
        override fun onTextChanged(s: CharSequence, start: Int,
                                   before: Int, count: Int) {
            try { // get bill amount and display currency formatted value
                height = s.toString().toDouble() / 100.0
                heightTextView!!.text = currencyFormat.format(height)
            } catch (e: NumberFormatException) { // if s is empty or non-numeric
                heightTextView!!.text = ""
                height = 0.0
            }
            calculate() // update the tip and total TextViews
        }

        override fun afterTextChanged(s: Editable) {}
        override fun beforeTextChanged(
                s: CharSequence, start: Int, count: Int, after: Int) {
        }
    }
    private val ageWatcher: TextWatcher = object : TextWatcher {
        // called when the user modifies the bill amount
        override fun onTextChanged(s: CharSequence, start: Int,
                                   before: Int, count: Int) {
            try { // get bill amount and display currency formatted value
                age = s.toString().toInt()
                ageTextView!!.text = currencyFormat.format(age.toLong())
            } catch (e: NumberFormatException) { // if s is empty or non-numeric
                ageTextView!!.text = "1"
                age = 1
            }
            calculate() // update the tip and total TextViews
        }

        override fun afterTextChanged(s: Editable) {}
        override fun beforeTextChanged(
                s: CharSequence, start: Int, count: Int, after: Int) {
        }
    }
    private val genderWatcher: TextWatcher = object : TextWatcher {
        // called when the user modifies the bill amount
        override fun onTextChanged(s: CharSequence, start: Int,
                                   before: Int, count: Int) {
            calculate() // update the tip and total TextViews
        }

        override fun afterTextChanged(s: Editable) {}
        override fun beforeTextChanged(
                s: CharSequence, start: Int, count: Int, after: Int) {
        }
    }

    private fun switchActivitiesToRecipes() {
        val switchActivityIntent = Intent(this, Recipes::class.java)
        startActivity(switchActivityIntent)
    }

    private fun switchActivitiesToQuizz01() {
        val switchActivityIntent = Intent(this, Quizz01::class.java)
        startActivity(switchActivityIntent)
    }

    companion object {
        // currency and percent formatter objects
        private val currencyFormat = NumberFormat.getInstance()
    }
}