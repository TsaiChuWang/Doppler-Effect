package com.example.doppler_effect;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.util.AttributeSet;
import android.view.View;

public class RMCanvasView extends View {
    private int origin_obseverSource_X=550;
    private int origin_obseverSource_Y=1100;
    private int waveSource_X=550;
    private int waveSource_Y=200;
    private int obseverSource_X=550;
    private int obseverSource_Y=1100;
    private int obseverspeed=20;
    private int wavespeed=20;
    private int[][] waves=new int[100][2]; //{圓心Y座標,半徑}
    private int[][] obsevers=new int[100][2]; //{圓心Y座標,半徑}
    private int index=0;

    public RMCanvasView(Context context) {
        super(context);
    }

    public RMCanvasView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public RMCanvasView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init(context);
    }

    private void init(Context context) {
        //do stuff that was in your original constructor...
    }

    @Override
    protected void onDraw(Canvas canvas){
        super.onDraw(canvas);
        //將畫布繪製成白色
        canvas.drawColor(Color.WHITE);

        if(index==-1){
            canvas.drawColor(0, PorterDuff.Mode.CLEAR);
            Paint paint =new Paint();
            paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
            canvas.drawPaint(paint);
            paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC));
        }

        //添加畫筆
        Paint paint = new Paint();

        // 繪製波源
        paint.setAntiAlias(true);
        paint.setColor(Color.RED);
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
        path_triangle.moveTo(65, 250);
        path_triangle.lineTo(125, 250);
        path_triangle.lineTo(95, 200);
        path_triangle.close();
        canvas.drawPath(path_triangle, paint);

        //繪製觀察者
        paint.setAntiAlias(true);
        paint.setColor(getResources().getColor(R.color.oxford));
        paint.setStyle(Paint.Style.FILL);
        paint.setStrokeWidth(3);
        canvas.drawCircle(obseverSource_X, obseverSource_Y, 25, paint);

        //添加文字
        paint.setTextSize(25);
        paint.setShader(null);
        paint.setColor(getResources().getColor(R.color.oxford));
        canvas.drawText("觀察者", obseverSource_X+50, obseverSource_Y, paint);
        paint.setColor(Color.RED);
        canvas.drawText("波源", waveSource_X+50, waveSource_Y, paint);


        //如果沒有任何波，新增波
        if(index==0){
            waves[index][0]=waveSource_Y;
            waves[index][1]=wavespeed;

            obsevers[index][0]=obseverSource_Y;
            obsevers[index][1]=Math.abs(Math.abs(obseverSource_Y-waveSource_Y)-waves[index][1]);
        }else{//有其他波
            waves[index][0]=waveSource_Y;
            waves[index][1]=wavespeed;

            obsevers[index][0]=obseverSource_Y;
            obsevers[index][1]=Math.abs(Math.abs(obseverSource_Y-waveSource_Y)-waves[index][1]);
        }//index增加1
        index++;

        //繪製波形
        for(int i=0;i<index;i++){
            //設置畫筆
            paint.setAntiAlias(true);
            paint.setColor(Color.RED);
            paint.setStyle(Paint.Style.STROKE);
            paint.setStrokeWidth(2);

            //波形擴展
            waves[i][1]+=wavespeed;

            //畫出波形
            canvas.drawCircle(waveSource_X, waves[i][0], waves[i][1], paint);
            paint.setColor(getResources().getColor(R.color.oxford));
            canvas.drawCircle(waveSource_X, obsevers[i][0],obsevers[i][1] , paint);
        }

        //向前移動
        obseverSource_Y-=obseverspeed;
        waveSource_Y+=wavespeed;
    }

    @Override
    public void invalidate() {
        super.invalidate();
    }

    public void setWaveSpeed(int speed){
        this.wavespeed=speed;
    }
    public void setObseverSpeed(int speed){
        this.obseverspeed=speed;
    }
}
