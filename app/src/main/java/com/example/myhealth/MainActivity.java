package com.example.myhealth;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void apriMisure(View v) {
        Intent intent = new Intent(this, MisureActivity.class);
        startActivity(intent);
    }

    public void apriStorico(View v) {
        Context context = getApplication();
        Toast toast = Toast.makeText(context, "Apro l'activity con lo storico delle misure", Toast.LENGTH_SHORT);
        toast.show();
        Intent intent = new Intent (this,VisualizzazioneRisultati.class);
        startActivity(intent);
    }

    public void apriCondividi(View v) {
        Context context = getApplication();
        Toast toast = Toast.makeText(context, "Apro l'activity per la condivisione delle misure", Toast.LENGTH_SHORT);
        toast.show();
    }

    public void esci(View v) {
        this.finishAffinity();
    }
}