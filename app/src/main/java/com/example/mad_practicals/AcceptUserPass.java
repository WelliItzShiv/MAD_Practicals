package com.example.mad_practicals;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class AcceptUserPass extends AppCompatActivity {
    @Override
    public void onCreate(Bundle SavedInstanceState) {
        super.onCreate(SavedInstanceState);
        setContentView(R.layout.accept_user_pass);

        EditText usernameField = (EditText) findViewById(R.id.username);
        EditText passwordField = (EditText) findViewById(R.id.password);

        Button sbmt = (Button) findViewById(R.id.submit);

        sbmt.setOnClickListener(v -> {
            String username = usernameField.getText().toString();
            String password = passwordField.getText().toString();

            Toast.makeText(AcceptUserPass.this, "Username is " + username + " and password is " + password, Toast.LENGTH_SHORT).show();
        });
    }
}
