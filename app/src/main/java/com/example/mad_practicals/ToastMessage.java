package com.example.mad_practicals;

import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class ToastMessage extends AppCompatActivity {
    public void onCreate(Bundle SavedInstanceState) {
        super.onCreate(SavedInstanceState);
        setContentView(R.layout.toast_message);

        Button sbmt = (Button) findViewById(R.id.sbmt);

        sbmt.setOnClickListener(v -> {
            Toast.makeText(ToastMessage.this, "Button Clicked", Toast.LENGTH_LONG).show();
        });
    }
}
