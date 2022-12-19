package com.example.doppler_effect;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class waveSource_static_Activity extends AppCompatActivity {
    WRCanvasView canvasView;
    Button submit_button;
    EditText speed_editText;
    Button forw_button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wave_source_static);

        canvasView=(WRCanvasView) findViewById(R.id.wrcanvasView);
        submit_button=(Button) findViewById(R.id.submit_button);
        speed_editText=(EditText) findViewById(R.id.speed_editText);
        forw_button=(Button) findViewById(R.id.forw_button);
    }

    public void submit_button_onclick(View view) {
        if(((String)submit_button.getText()).equals("提交")){
            //設置速度
            int speed=Integer.parseInt(String.valueOf(speed_editText.getText()));
            canvasView.setSpeed(speed);

            //改變當前文字
            submit_button.setText("暫停");
            //啟用前進按鈕
            forw_button.setEnabled(true);
        }else{
            //設置速度
            canvasView.setSpeed(-1);
            canvasView.invalidate();

            //改變當前文字
            submit_button.setText("提交");
            //啟用前進按鈕
            forw_button.setEnabled(false);
        }
    }

    public void forw_button_onclick(View view) {
        canvasView.invalidate();
    }
}