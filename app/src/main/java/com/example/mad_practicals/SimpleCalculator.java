package com.example.mad_practicals;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;


public class SimpleCalculator extends AppCompatActivity {
    @Override
    public void onCreate(Bundle SavedInstanceState) {
        super.onCreate(SavedInstanceState);
        setContentView(R.layout.simple_calculator);

        EditText num1 = (EditText) findViewById(R.id.num1);
        EditText num2 = (EditText) findViewById(R.id.num2);

        Button add = (Button) findViewById(R.id.add);
        Button subtract = (Button) findViewById(R.id.subtract);
        Button multiply = (Button) findViewById(R.id.multiply);
        Button divide = (Button) findViewById(R.id.divide);

        TextView output = (TextView) findViewById(R.id.output);

        View.OnClickListener listener = v -> {
            String s1 = num1.getText().toString();
            String s2 = num2.getText().toString();

            if(s1.isEmpty() || s2.isEmpty()) {
                Toast.makeText(SimpleCalculator.this, "Enter both numbers", Toast.LENGTH_LONG).show();
                return;
            }

            double n1 = Double.parseDouble(s1);
            double n2 = Double.parseDouble(s2);
            double res = 0;

            int viewId = v.getId();

            if(viewId == R.id.add) {
                res = n1 + n2;
            }
            else if (viewId == R.id.subtract) {
                res = n1 - n2;
            }
            else if (viewId == R.id.multiply) {
                res = n1 * n2;
            }
            else {
                if(n2 == 0) {
                    Toast.makeText(SimpleCalculator.this, "Cannot divide by zero", Toast.LENGTH_LONG).show();
                    return;
                }
                    res = n1 / n2;
            }
            output.setText("Output = " + res);
        };

        add.setOnClickListener(listener);
        subtract.setOnClickListener(listener);
        multiply.setOnClickListener(listener);
        divide.setOnClickListener(listener);
    }
}
