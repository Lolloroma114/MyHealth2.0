package com.example.myhealth;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

public class VisualizzazioneRisultati extends AppCompatActivity {

    private RecyclerView r;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_visualizzazione_risultati);

        r = findViewById(R.id.recycleview);
        Adapter adapter = new Adapter(new String[]{"Bob","John"});
        r.setAdapter(adapter);

    }




    public void esci(View v) {
        this.finish();
    }
}