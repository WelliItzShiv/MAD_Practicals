package com.example.mad_practicals;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class DisplayStudNameAndMarks extends AppCompatActivity {
    @Override
    public void onCreate(Bundle SavedInstanceState) {
        super.onCreate(SavedInstanceState);
        setContentView(R.layout.student_info);

        String name = "Shivam Bandekar";
        int marks = 90;

        TextView output = (TextView) findViewById(R.id.StudInfo);

        output.setText("Name is " + name + "\nMarks are " + marks);
    }
}
