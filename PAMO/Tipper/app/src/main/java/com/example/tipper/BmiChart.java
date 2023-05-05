package com.example.tipper;

import android.graphics.Color;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import java.util.ArrayList;

public class BmiChart extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmichart);

        // Utworzenie instancji wykresu
        LineChart chart = findViewById(R.id.chart);

        // Ustawienie wykresu
        chart.setDragEnabled(true);
        chart.setScaleEnabled(false);

        // Dodanie danych
        ArrayList<Entry> entries = new ArrayList<>();
        entries.add(new Entry(1, 1));
        entries.add(new Entry(2, 2));
        entries.add(new Entry(2, 3));
        entries.add(new Entry(3, 2));
        entries.add(new Entry(4, 5));

        LineDataSet dataSet = new LineDataSet(entries, "Label"); // add entries to dataset
        dataSet.setColor(Color.RED);
        dataSet.setValueTextColor(Color.BLUE);

        // Utworzenie serii danych i ustawienie jej parametrów
        LineData lineData = new LineData(dataSet);
        chart.setData(lineData);
        chart.getDescription().setText("Wykres liniowy");

        // Opcjonalnie dodanie animacji
        chart.animateX(2000);
    }
}