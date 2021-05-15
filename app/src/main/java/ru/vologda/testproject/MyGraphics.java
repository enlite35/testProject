package ru.vologda.testproject;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.CountDownTimer;
import android.util.DisplayMetrics;
import android.view.View;

import java.util.ArrayList;

public class MyGraphics extends View {
    public static int height, width;
    ArrayList<Ball> balls;

    public MyGraphics(Context context) {
        super(context);
        createBalls();
        MyTimer timer = new MyTimer(100000, 50);
        timer.start();
        DisplayMetrics metrics = new DisplayMetrics();
        ((Activity) getContext()).getWindowManager().getDefaultDisplay().getMetrics(metrics);

         height = metrics.heightPixels;
         width = metrics.widthPixels;

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Paint p = new Paint();
        for (Ball b : balls){
            b.draw(canvas);
            b.checkBounds();
        }

    }

    private void createBalls(){
        balls = new ArrayList<>();
        balls.add(new Ball(200,200,100,1,0,10));
        balls.add(new Ball(600,200,100,-2,0,10));
    }
    public class MyTimer extends CountDownTimer{

        public MyTimer(long millisInFuture, long countDownInterval) {
            super(millisInFuture, countDownInterval);
        }

        @Override
        public void onTick(long l) {

            invalidate();
        }

        @Override
        public void onFinish() {

        }
    }
}
