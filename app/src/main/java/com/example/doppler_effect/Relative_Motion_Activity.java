package com.example.doppler_effect;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Relative_Motion_Activity extends AppCompatActivity {
    RMCanvasView canvasView;
    Button sub_button;
    EditText obsspeed_editText;
    EditText wsspeed_editText;
    Button fwbutton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_relative_motion);

        canvasView=(RMCanvasView) findViewById(R.id.rmcanvasView);
        sub_button=(Button) findViewById(R.id.sub_button);
        obsspeed_editText=(EditText) findViewById(R.id.obsspeed_editText);
        wsspeed_editText=(EditText) findViewById(R.id.wsspeed_editText);
        fwbutton=(Button) findViewById(R.id.fwbutton);
    }

    public void sub_button_onclick(View view) {
        if(((String)sub_button.getText()).equals("提交")){
            //設置速度
            int obsspeed=Integer.parseInt(String.valueOf(obsspeed_editText.getText()));
            canvasView.setObseverSpeed(obsspeed);
            int wsspeed=Integer.parseInt(String.valueOf(wsspeed_editText.getText()));
            canvasView.setWaveSpeed(wsspeed);

            //改變當前文字
            sub_button.setText("暫停");
            //啟用前進按鈕
            fwbutton.setEnabled(true);
        }else{
            //設置速度
            canvasView.setObseverSpeed(-1);
            canvasView.setWaveSpeed(-1);
            canvasView.invalidate();

            //改變當前文字
            sub_button.setText("提交");
            //啟用前進按鈕
            fwbutton.setEnabled(false);
        }
    }

    public void fwbutton_onclick(View view) {
        canvasView.invalidate();
    }
}