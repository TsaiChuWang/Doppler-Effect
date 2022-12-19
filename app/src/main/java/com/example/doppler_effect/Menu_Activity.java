package com.example.doppler_effect;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Menu_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
    }

    //跳轉到Introduction_Activity
    public void introduction_button_onclick(View view) {
        Intent intent = new Intent();
        intent.setClass(Menu_Activity.this,Introduction_Activity.class);
        startActivity(intent);
    }

    //跳轉到obsever_static_Activity
    public void observer_static_button_onclick(View view) {
        Intent intent = new Intent();
        intent.setClass(Menu_Activity.this,observer_static_Activity.class);
        startActivity(intent);
    }

    //跳轉到waveSource_static_Activity
    public void waveSource_static_button_onclick(View view) {
        Intent intent = new Intent();
        intent.setClass(Menu_Activity.this,waveSource_static_Activity.class);
        startActivity(intent);
    }

    //跳轉到Relative_Motion_Activity
    public void relative_Motion_button_onclick(View view) {
        Intent intent = new Intent();
        intent.setClass(Menu_Activity.this,Relative_Motion_Activity.class);
        startActivity(intent);
    }

    //跳回主頁面
    public void back_button_onclick(View view) {
        Intent intent = new Intent();
        intent.setClass(Menu_Activity.this,MainActivity.class);
        startActivity(intent);
    }
}