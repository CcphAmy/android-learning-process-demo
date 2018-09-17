package com.demo.snake_ai_demo;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;

public class GameView extends View {

    private static final int GAME_COUNT = 25 ;
    private int[][] gameData = new int[GAME_COUNT][GAME_COUNT];

    private static final int PADDING_LEFT = 10;
    private static final int PADDING_TOP = 10;
    private static final int PADDING_RIGHT = 10;
    private static final int PADDING_BOTTOM = 50;

    private Canvas mCanvas;
    private Paint mPaint;
    public GameView(Context context) {
        super(context);
        mPaint = new Paint();
    }

    public GameView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        mPaint = new Paint();
    }

    public GameView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mPaint = new Paint();
    }


    public static int[] getScreenSize(Context context) {
        WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        DisplayMetrics outMetrics = new DisplayMetrics();
        wm.getDefaultDisplay().getMetrics(outMetrics);
        return new int[]{outMetrics.widthPixels, outMetrics.heightPixels};
    }
    @Override
    protected void onDraw(Canvas canvas) {
        this.mCanvas = canvas;
        super.onDraw(canvas);
//        canvas.drawRGB(255,255,255);
//        drawTable(canvas);
        drawTable();
    }

    public void drawTable(){
        Canvas canvas = this.mCanvas;
        int window[] = getScreenSize(getContext());

        int winWidth = window[0] - PADDING_LEFT - PADDING_RIGHT;
        int winHeight = window[1] - PADDING_TOP - PADDING_BOTTOM;
        int minWidth = window[0] < window[1] ? window[0] : window[1];
        float winTop = this.getTop() + 100;
        float tabWidth = minWidth / GAME_COUNT;
        int numCount = (int)(minWidth / tabWidth);
        Log.d("Window:", String.valueOf(window[0]) + "|"+ String.valueOf(window[1]));
//        mPaint.setColor(Color.rgb(0,0,0));
//        canvas.drawRect(PADDING_LEFT,PADDING_TOP,window[0] - PADDING_RIGHT,window[1] -  PADDING_BOTTOM,mPaint);

        mPaint.setColor(Color.rgb(193 ,210,240));
        for( int i = 0 ; i < numCount ; i++){
//            mPaint.setColor(Color.RED);
            canvas.drawLine(PADDING_TOP + i * tabWidth,winTop + PADDING_TOP,PADDING_LEFT + i * tabWidth, winTop + minWidth - PADDING_TOP,mPaint); //X
            canvas.drawLine(PADDING_TOP,winTop + PADDING_LEFT + i * tabWidth,minWidth - PADDING_LEFT, winTop + PADDING_TOP + i * tabWidth,mPaint); //Y

        }
    }
}
