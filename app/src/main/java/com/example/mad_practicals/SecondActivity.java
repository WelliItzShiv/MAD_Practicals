package com.example.mad_practicals;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_activity);

        // Get the factorial result from the intent
        long factorial = getIntent().getLongExtra("factorialResult", 0);

        // Display the result
        TextView resultText = findViewById(R.id.resultText);
        resultText.setText("Factorial: " + factorial);
    }
}
