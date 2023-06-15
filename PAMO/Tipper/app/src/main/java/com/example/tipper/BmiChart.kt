package com.example.tipper

import android.graphics.Color
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.github.mikephil.charting.charts.LineChart
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.LineData
import com.github.mikephil.charting.data.LineDataSet

class BmiChart : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bmichart)

        // Utworzenie instancji wykresu
        val chart = findViewById<LineChart>(R.id.chart)

        // Ustawienie wykresu
        chart.isDragEnabled = true
        chart.setScaleEnabled(false)

        // Dodanie danych
        val entries = ArrayList<Entry>()
        entries.add(Entry(1f, 1f))
        entries.add(Entry(2f, 2f))
        entries.add(Entry(2f, 3f))
        entries.add(Entry(3f, 2f))
        entries.add(Entry(4f, 5f))
        val dataSet = LineDataSet(entries, "Label") // add entries to dataset
        dataSet.color = Color.RED
        dataSet.valueTextColor = Color.BLUE

        // Utworzenie serii danych i ustawienie jej parametrów
        val lineData = LineData(dataSet)
        chart.data = lineData
        chart.description.text = "Wykres liniowy"

        // Opcjonalnie dodanie animacji
        chart.animateX(2000)
    }
}