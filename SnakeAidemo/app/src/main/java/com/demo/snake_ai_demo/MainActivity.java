package com.demo.snake_ai_demo;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.DragEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private GameView gameView  = null;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        gameView  = (GameView)findViewById(R.id.view2);
        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Thread(new DrawTest(gameView)).start();
            }
        });
    }
    class DrawTest implements Runnable{
        private GameView gameView;
        public DrawTest(GameView gameView) {
            this.gameView = gameView;
//            super();
        }

        @Override
        public void run() {
            Log.d("run","run");
//            this.gameView.drawTable();
        }
    }
}

