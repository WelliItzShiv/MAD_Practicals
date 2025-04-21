package com.example.mad_practicals;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class AcceptStudInfo extends AppCompatActivity {
    public void onCreate(Bundle SavedInstanceState) {
        super.onCreate(SavedInstanceState);
        setContentView(R.layout.accept_stud_info);

        EditText nameField = (EditText) findViewById(R.id.studName);
        EditText ageField = (EditText) findViewById(R.id.studAge);
        EditText contactField = (EditText) findViewById(R.id.studContact);

        Button sbmt = (Button) findViewById(R.id.submit);

        sbmt.setOnClickListener(v -> {
           String name = nameField.getText().toString();
           String age = ageField.getText().toString();
           String contact = contactField.getText().toString();

           Toast.makeText(AcceptStudInfo.this, "Name is " + name + " Age is " + age + " Contact is " + contact, Toast.LENGTH_LONG).show();
        });
    }
}
