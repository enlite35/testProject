package ru.vologda.testproject;

import android.graphics.Canvas;
import android.graphics.Paint;

public class Ball {
    private float x, y, r,m;
    public float dx, dy;

    public Ball(float x, float y, float r, float dx, float dy, float m) {
        this.x = x;
        this.y = y;
        this.r = r;
        this.dx = dx;
        this.dy = dy;
        this.m = m;
    }
    public void draw(Canvas canvas){
        Paint p = new Paint();
        canvas.drawCircle(x,y,r,p);
        move();
    }
    public void move(){
        x+=dx; y+=dy;
    }
    public boolean collision(Ball ball){
        float R = r+ball.r;
        float distance = (float) Math.sqrt((x-ball.x)*(x-ball.x)+(y-ball.y)*(y-ball.y));
        return distance < R;
    }
    public void checkBounds(){
        if(x-r<0 || x+r> MyGraphics.width) dx=-dx;
        if(y-r<0 || y+r> MyGraphics.height) dy=-dy;
    }
}
