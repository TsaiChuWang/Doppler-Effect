package com.example.doppler_effect;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Canvas;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class observer_static_Activity extends AppCompatActivity {
    CanvasView canvasView;
    Button submmitbutton;
    EditText waveSpeed_editText;
    Button forward_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_observer_static);

        canvasView=(CanvasView) findViewById(R.id.canvasview);
        submmitbutton=(Button) findViewById(R.id.submmitbutton);
        waveSpeed_editText=(EditText) findViewById(R.id.waveSpeed_editText);
        forward_button=(Button) findViewById(R.id.forward_button);
    }

    public void submmit_onclick(View view) {
        //如果文字是提交
        Log.v("msg", (String) submmitbutton.getText());
        if(((String)submmitbutton.getText()).equals("提交")){
            //設置速度
            int speed=Integer.parseInt(String.valueOf(waveSpeed_editText.getText()));
            canvasView.setSpeed(speed);

            //改變當前文字
            submmitbutton.setText("暫停");
            //啟用前進按鈕
            forward_button.setEnabled(true);
        }else{
            //設置速度
            canvasView.setSpeed(-1);
            canvasView.invalidate();

            //改變當前文字
            submmitbutton.setText("提交");
            //啟用前進按鈕
            forward_button.setEnabled(false);
        }
    }

    public void forward_button_onclick(View view) {
        canvasView.invalidate();
    }
}