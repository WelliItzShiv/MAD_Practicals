package com.example.mad_practicals;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class StudRegister extends AppCompatActivity {
    public void onCreate(Bundle SavedInstanceState) {
        super.onCreate(SavedInstanceState);
        setContentView(R.layout.stud_register);

        Button loginBtn = (Button) findViewById(R.id.loginBtn);

        EditText username = (EditText) findViewById(R.id.username);
        EditText password = (EditText) findViewById(R.id.password);

        loginBtn.setOnClickListener(v -> {
            String name = username.getText().toString();
            String pass = password.getText().toString();

            if(name.isEmpty() || pass.isEmpty()) {
             Toast.makeText(StudRegister.this, "Enter both username and password", Toast.LENGTH_LONG).show();
             return;
            }
            else if(name.equals("Shivam") && pass.equals("1234")) {
                Toast.makeText(StudRegister.this, "Login Successful", Toast.LENGTH_LONG).show();
            }
            else {
                Toast.makeText(StudRegister.this, "Login Failed", Toast.LENGTH_LONG).show();
            }
        });
    }
}
