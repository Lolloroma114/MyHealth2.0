package com.example.myhealth;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MisureActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_misure);
    }

    public void apriHeartRate(View v) {
        Intent intent = new Intent(this, HeartRateActivity.class);
        startActivity(intent);
    }

    public void back(View v) {
        this.finish();
    }
}