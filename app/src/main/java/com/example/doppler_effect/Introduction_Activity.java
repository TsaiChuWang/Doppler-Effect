package com.example.doppler_effect;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Introduction_Activity extends AppCompatActivity {
    private Button history_button;
    private Button formula_button;
    private Button observer_button;
    private Button wave_Circle_button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_introduction);

        history_button= (Button) findViewById(R.id.history_button);
        formula_button= (Button) findViewById(R.id.formula_button);
        observer_button= (Button) findViewById(R.id.observer_button);
        observer_button= (Button) findViewById(R.id.wave_Circle_button);
    }

    public void history_button_onClick(View view) {
        Intent intent = new Intent();
        intent.setClass(Introduction_Activity.this,History_Activity.class);
        startActivity(intent);
    }

    public void formula_button_onClick(View view) {
        Intent intent = new Intent();
        intent.setClass(Introduction_Activity.this,Formula_Activity.class);
        startActivity(intent);
    }

    public void observer_button_onClick(View view) {
        Intent intent = new Intent();
        intent.setClass(Introduction_Activity.this,Observer_Activity.class);
        startActivity(intent);
    }

    public void wave_Circle_button_onClick(View view) {
        Intent intent = new Intent();
        intent.setClass(Introduction_Activity.this,waveCircle_Activity.class);
        startActivity(intent);
    }
}