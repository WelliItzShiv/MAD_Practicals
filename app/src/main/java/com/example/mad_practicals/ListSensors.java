package com.example.mad_practicals;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class ListSensors extends AppCompatActivity {

    private SensorManager sensorManager;
    private ListView sensorListView;
    private ArrayList<String> sensorList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_sensors);

        sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        sensorListView = findViewById(R.id.sensorListView);
        sensorList = new ArrayList<>();

        // Get a list of all available sensors
        if (sensorManager != null) {
            // Get all sensors
            for (Sensor sensor : sensorManager.getSensorList(Sensor.TYPE_ALL)) {
                // Add sensor name to the list
                sensorList.add(sensor.getName());
            }
        }

        // Set the adapter to display sensor names in the ListView
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, sensorList);
        sensorListView.setAdapter(adapter);
    }
}
