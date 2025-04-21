package com.example.mad_practicals;

import android.bluetooth.BluetoothAdapter;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.widget.Toast;
import android.widget.ToggleButton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

public class BluetoothOnOff extends AppCompatActivity {

    BluetoothAdapter bluetoothAdapter;
    private static final int REQUEST_PERMISSION_BLUETOOTH = 1;

    @Override
    public void onCreate(Bundle SavedInstanceState) {
        super.onCreate(SavedInstanceState);
        setContentView(R.layout.bluetooth_on_off);

        ToggleButton tgbtn = findViewById(R.id.toggleOnOff);
        bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();

        if (bluetoothAdapter == null) {
            Toast.makeText(this, "Bluetooth not supported", Toast.LENGTH_LONG).show();
            tgbtn.setEnabled(false);
        } else {
            if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.BLUETOOTH_CONNECT)
                    != PackageManager.PERMISSION_GRANTED) {

                ActivityCompat.requestPermissions(this,
                        new String[]{android.Manifest.permission.BLUETOOTH_CONNECT},
                        REQUEST_PERMISSION_BLUETOOTH);
                return;
            }

            tgbtn.setChecked(bluetoothAdapter.isEnabled());
            updateStatusText();

            tgbtn.setOnCheckedChangeListener((buttonView, isChecked) -> {
                if (isChecked) {
                    bluetoothAdapter.enable();
                    Toast.makeText(this, "Turning Bluetooth ON...", Toast.LENGTH_SHORT).show();
                } else {
                    bluetoothAdapter.disable();
                    Toast.makeText(this, "Turning Bluetooth OFF...", Toast.LENGTH_SHORT).show();
                }
            });
        }
    }

    public void updateStatusText() {
        if (bluetoothAdapter.isEnabled()) {
            Toast.makeText(this, "Bluetooth is ON", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Bluetooth is OFF", Toast.LENGTH_SHORT).show();
        }
    }
}
