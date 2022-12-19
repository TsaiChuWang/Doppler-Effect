package com.example.doppler_effect;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button start_button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        start_button=(Button) findViewById(R.id.start_button);
    }

    public void start_button_onclick(View view) {
        Intent intent = new Intent();
        intent.setClass(MainActivity.this,Menu_Activity.class);
        startActivity(intent);
    }

    public void teach_button_onclick(View view) {
        Intent intent = new Intent();
        intent.setClass(MainActivity.this,Teach_Activity.class);
        startActivity(intent);
    }
}