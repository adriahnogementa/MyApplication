package com.example.myapplication;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.databinding.ActivitySensorBinding;

public class SensorActivity extends AppCompatActivity {

    private SensorManager sensorManager;
    private SensorEventListener sensorEventListener;
    private ActivitySensorBinding binding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sensor);
        sensorManager = getSystemService(SensorManager.class);
        TextView text = findViewById(R.id.textViewSensor);

        sensorEventListener = new SensorEventListener() {
            @Override
            public void onSensorChanged(SensorEvent event) {
                Log.d(SensorActivity.class.getSimpleName(), String.valueOf(event.values[0]));

                text.setText(String.valueOf(event.values[0]));
            }

            @Override
            public void onAccuracyChanged(Sensor sensor, int accuracy) {
                Log.d(SensorActivity.class.getSimpleName(), sensor + ": " + accuracy);


            }
        };
    }

    @Override
    protected void onResume() {
        super.onResume();
        Sensor sensor = sensorManager.getDefaultSensor(Sensor.TYPE_PRESSURE);
        sensorManager.registerListener(sensorEventListener, sensor,
                                       SensorManager.SENSOR_DELAY_NORMAL);
    }

    @Override
    protected void onPause() {
        super.onPause();
        sensorManager.unregisterListener(sensorEventListener);
    }
}
