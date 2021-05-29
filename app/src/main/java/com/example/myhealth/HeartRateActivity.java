package com.example.myhealth;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.concurrent.Executor;

import static android.content.pm.PackageManager.PERMISSION_GRANTED;

public class HeartRateActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_heart_rate);


    }

    private String result;
    private static final String TAG = "HEART_RATE";
    private static final int BODY_SENSOR_PERMISSION_REQUEST = 1;


    private void connectHeartRateSensor(){


        int permission = ActivityCompat.checkSelfPermission(this, Manifest.permission.BODY_SENSORS);

        if(permission == PERMISSION_GRANTED) {
            doConnectHeartRateSensor();
        } else {
            if (ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.BODY_SENSORS)) {

                Log.d(TAG, "E' Necessario abilitare il sensore Misura Battito Cardiaco per procedere alla misurazione");

            }
            ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.BODY_SENSORS},BODY_SENSOR_PERMISSION_REQUEST);
        }

    }

    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           @NonNull String[] permissions,
                                           @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == BODY_SENSOR_PERMISSION_REQUEST &&
                grantResults.length > 0 &&
                grantResults[0] == PERMISSION_GRANTED) {
            doConnectHeartRateSensor();
        } else {
            Log.d(TAG, "Accesso ai sensori corporei negato");
        }
    }

    private void doConnectHeartRateSensor(){
        SensorManager sm = (SensorManager)getSystemService(getApplicationContext().SENSOR_SERVICE);
        Sensor heartRateSensor = sm.getDefaultSensor(Sensor.TYPE_HEART_RATE);

        if(heartRateSensor == null){
            Log.d(TAG, "Non e' presente alcun sensore Misura Battito Cardiaco sul dispositivo");
        } else {
            sm.registerListener(mHeartRateListener, heartRateSensor,SensorManager.SENSOR_DELAY_NORMAL);
        }

    }


    final SensorEventListener mHeartRateListener = new SensorEventListener() {
        @Override
        public void onSensorChanged(SensorEvent event) {
            if(event.sensor.getType() == Sensor.TYPE_HEART_RATE){
                if(event.accuracy == SensorManager.SENSOR_STATUS_NO_CONTACT || event.accuracy == SensorManager.SENSOR_STATUS_UNRELIABLE){
                    Log.d(TAG, "Il sensore risulta inaffidabile, occore ci sia contatto col corpo");
                }
            } else {
                float currentHeartRate = event.values[0];
                Log.d(TAG ," Il battito risulta essere di " + currentHeartRate + " pulsazioni per minuto");
            }
        }

        @Override
        public void onAccuracyChanged(Sensor sensor, int accuracy) {

        }
    };



    public void startHeartRate(View v) {
        Context context = getApplication();
        Toast toast = Toast.makeText(context, "Avvia la misura della Frequenza Cardiaca", Toast.LENGTH_SHORT);
        toast.show();


        new Thread(new Runnable() {






            @Override
            public void run() {
                try {
                    Thread.sleep(4000);
                    String result = "65";
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                // Attività conclusiva del Thread con aggiornamento della UI
                TextView txt=(TextView)findViewById(R.id.textViewHeartRate);
                txt.post(new Runnable() {
                    public void run() {
                        txt.setText(result);
                    }
                });
            }
        }).start();
    }

    public void stopHeartRate(View v) {
        Context context = getApplication();
        Toast toast = Toast.makeText(context, "Ferma la misura della Frequenza Cardiaca", Toast.LENGTH_SHORT);
        toast.show();

    }

    public void back(View v) {
        this.finish();
    }

}

