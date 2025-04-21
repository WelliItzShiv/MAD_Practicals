package com.example.mad_practicals;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TimePicker;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Calendar;
import java.util.Date;

public class DateTimePicker extends AppCompatActivity {
    public void onCreate(Bundle SavedInstanceState) {
        super.onCreate(SavedInstanceState);
        setContentView(R.layout.date_time_picker);

        Button dateBtn = (Button) findViewById(R.id.dateBtn);
        Button timeBtn = (Button) findViewById(R.id.timeBtn);

        Calendar calendar = Calendar.getInstance();

        dateBtn.setOnClickListener(v -> {
            int year = calendar.get(Calendar.YEAR);
            int month = calendar.get(Calendar.MONTH);
            int day = calendar.get(Calendar.DAY_OF_MONTH);

            DatePickerDialog datePickerDialog = new DatePickerDialog(DateTimePicker.this, (view, year1, month1, dayOfMonth) -> {
                String selectedDate = dayOfMonth + "/" + (month1 + 1) + "/" + year1;
                Toast.makeText(DateTimePicker.this, "Selected date = " + selectedDate, Toast.LENGTH_LONG).show();
            }, year, month, day);
            datePickerDialog.show();
        });

        timeBtn.setOnClickListener(v -> {
            int hour = calendar.get(Calendar.HOUR_OF_DAY);
            int minute = calendar.get(Calendar.MINUTE);

            TimePickerDialog timePickerDialog = new TimePickerDialog(
                    DateTimePicker.this,
                    (view, hourOfDay, minute1) -> {
                        String selectedTime = String.format("%02d:%02d", hourOfDay, minute1);
                        Toast.makeText(DateTimePicker.this, "Selected Time: " + selectedTime, Toast.LENGTH_SHORT).show();
                    },
                    hour, minute, true);
            timePickerDialog.show();
        });
    }
}
