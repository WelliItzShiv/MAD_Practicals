package com.example.mad_practicals;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class FirstActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.first_activity);

        EditText inputNumber = findViewById(R.id.inputNumber);
        Button factorialButton = findViewById(R.id.factorialButton);

        factorialButton.setOnClickListener(v -> {
            String input = inputNumber.getText().toString();
            if (input.isEmpty()) {
                Toast.makeText(FirstActivity.this, "Please enter a number", Toast.LENGTH_SHORT).show();
            } else {
                int number = Integer.parseInt(input);
                // Calculate factorial
                long factorial = calculateFactorial(number);

                // Create an explicit intent to go to the second screen
                Intent intent = new Intent(FirstActivity.this, SecondActivity.class);
                intent.putExtra("factorialResult", factorial);  // Passing the factorial result
                startActivity(intent);
            }
        });
    }

    private long calculateFactorial(int n) {
        long result = 1;
        for (int i = 1; i <= n; i++) {
            result *= i;
        }
        return result;
    }
}

