package com.example.doppler_effect;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.Shader;
import android.media.MediaDrm;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import androidx.annotation.ColorInt;

public class CanvasView extends View {
    private int origin_waveSource_X=550;
    private int origin_waveSource_Y=100;
    private int waveSource_X=550;
    private int waveSource_Y=100;
    private int speed=20;
    private int[][] waves=new int[100][2]; //{圓心Y座標,半徑}
    private int index=0;

    public CanvasView(Context context) {
        super(context);
    }

    public CanvasView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public CanvasView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init(context);
    }

    private void init(Context context) {
        //do stuff that was in your original constructor...
    }

    @SuppressLint("ResourceAsColor")
    @Override
    protected void onDraw(Canvas canvas){
        super.onDraw(canvas);
        //將畫布繪製成白色
        canvas.drawColor(Color.WHITE);

        if(index==-1){
            canvas.drawColor(0,PorterDuff.Mode.CLEAR);
            Paint paint =new Paint();
            paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
            canvas.drawPaint(paint);
            paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC));
        }

        //添加畫筆
        Paint paint = new Paint();

        // 繪製波源
        paint.setAntiAlias(true);
        paint.setColor(getResources().getColor(R.color.oxford));
        paint.setStyle(Paint.Style.FILL);
        paint.setStrokeWidth(3);
        canvas.drawCircle(waveSource_X, waveSource_Y, 25, paint);

        //繪製方向箭頭
        paint.setColor(Color.BLACK);
        paint.setStyle(Paint.Style.FILL);
        paint.setStrokeWidth(3);
        canvas.drawRect(90, 250, 100, 990, paint);
        // 繪製三角形
        Path path_triangle = new Path();
        path_triangle.moveTo(65, 990);
        path_triangle.lineTo(125, 990);
        path_triangle.lineTo(95, 1040);
        path_triangle.close();
        canvas.drawPath(path_triangle, paint);

        //繪製觀察者
        paint.setAntiAlias(true);
        paint.setColor(Color.RED);
        paint.setStyle(Paint.Style.FILL);
        paint.setStrokeWidth(3);
        canvas.drawCircle(origin_waveSource_X, origin_waveSource_Y+900, 25, paint);

        //添加文字
        paint.setTextSize(25);
        paint.setShader(null);
        paint.setColor(Color.RED);
        canvas.drawText("觀察者", origin_waveSource_X+50, origin_waveSource_Y+900, paint);
        paint.setColor(getResources().getColor(R.color.oxford));
        canvas.drawText("波源", waveSource_X+50, waveSource_Y, paint);

        Log.v("Wave", "Index= "+Integer.toString(index));
        //如果沒有任何波，新增波
        if(index==0){
            waves[index][0]=waveSource_Y;
            waves[index][1]=speed;
        }else{//有其他波
            waves[index][0]=waveSource_Y;
            waves[index][1]=speed;
        }//index增加1
        index++;

        //繪製波形
        for(int i=0;i<index;i++){
            //設置畫筆
            paint.setAntiAlias(true);
            paint.setColor(getResources().getColor(R.color.oxford));
            paint.setStyle(Paint.Style.STROKE);
            paint.setStrokeWidth(2);

            //波形擴展
            waves[i][1]+=speed;

            //畫出波形
            canvas.drawCircle(waveSource_X, waves[i][0], waves[i][1], paint);
            Log.v("Wave", Integer.toString(waves[i][0]));
            Log.v("Wave", Integer.toString(waves[i][1]));
        }

        //向前移動
        waveSource_Y+=speed;
    }

    @Override
    public void invalidate() {
        super.invalidate();
    }

    public void setSpeed(int speed){
        this.speed=speed;
    }
}
