package com.example.mad_practicals;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class SQLiteDB extends AppCompatActivity {

    private EditText nameEditText, ageEditText;
    private Button insertButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sqlite_db);

        // Initialize the UI elements
        nameEditText = findViewById(R.id.nameEditText);
        ageEditText = findViewById(R.id.ageEditText);
        insertButton = findViewById(R.id.insertButton);

        // Set click listener for the insert button
        insertButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Get the input values
                String name = nameEditText.getText().toString();
                String age = ageEditText.getText().toString();

                if (name.isEmpty() || age.isEmpty()) {
                    // Show error message if any field is empty
                    Toast.makeText(SQLiteDB.this, "Please enter both name and age", Toast.LENGTH_SHORT).show();
                } else {
                    // Insert the data into the database
                    insertData(name, Integer.parseInt(age));
                }
            }
        });
    }

    // Method to insert data into the database
    private void insertData(String name, int age) {
        DBHelper dbHelper = new DBHelper(this);
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        // Create a ContentValues object to insert the data
        ContentValues values = new ContentValues();
        values.put(DBHelper.COLUMN_NAME, name);
        values.put(DBHelper.COLUMN_AGE, age);

        // Insert the data and get the row ID
        long rowId = db.insert(DBHelper.TABLE_NAME, null, values);

        // Check if the data was successfully inserted
        if (rowId != -1) {
            Toast.makeText(SQLiteDB.this, "Data inserted successfully", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(SQLiteDB.this, "Error inserting data", Toast.LENGTH_SHORT).show();
        }

        // Close the database
        db.close();
    }
}

