package com.example.sensorik_app;

import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;

import androidx.appcompat.app.AppCompatActivity;

import android.widget.TextView;

public class TempActivity extends AppCompatActivity implements SensorEventListener {
    private TextView textView;
    private SensorManager sensorManager;
    private Sensor tempSensor;
    private Boolean isTempsensor;
    private TextView text_fahrenheit;
    private TextView text_kelvin;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_temp);
        textView = findViewById(R.id.textView1);
        text_fahrenheit = findViewById(R.id.textView2);
        text_kelvin = findViewById(R.id.textView3);
        sensorManager= (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        if(sensorManager.getDefaultSensor(Sensor.TYPE_AMBIENT_TEMPERATURE)!=null){

            tempSensor = sensorManager.getDefaultSensor(Sensor.TYPE_AMBIENT_TEMPERATURE);
            isTempsensor = true;

        }
        else{

            textView.setText("Sensor not found");
        isTempsensor = false;
        }

    }


    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
    textView.setText(sensorEvent.values[0]+" °c");
    text_fahrenheit.setText(sensorEvent.values[0]*9/5+32+" °f");
    text_kelvin.setText(sensorEvent.values[0]+ 273.15 +" °k");
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }

    @Override
    protected void onResume() {
        super.onResume();
        if(isTempsensor == true){
            sensorManager.registerListener(this,tempSensor,SensorManager.SENSOR_DELAY_NORMAL);

        }
    }

    @Override
    protected void onPause() {
        super.onPause();
    if(isTempsensor == true)
        sensorManager.unregisterListener(this);
    }
}


