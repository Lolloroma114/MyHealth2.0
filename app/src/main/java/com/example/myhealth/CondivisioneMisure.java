package com.example.myhealth;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class CondivisioneMisure extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_condivisione_misure);
    }

    public void condivisioneDatabase(View v){
        Context context = getApplication();
        Toast toast = Toast.makeText(context, "Condivido sul Database", Toast.LENGTH_SHORT);
        toast.show();
    }
}