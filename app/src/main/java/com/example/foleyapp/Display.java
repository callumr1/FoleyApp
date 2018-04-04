package com.example.foleyapp;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PointF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by Callum on 4/04/2018.
 */

public class Display extends View {
    private String message;
    private Paint paint;
    public Display(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        message = "Display";
        paint = new Paint();
        paint.setTextSize(100);
        paint.setTextAlign(Paint.Align.CENTER);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return super.onTouchEvent(event);
    }

    private PointF getCenter(){
        return new PointF(getWidth() / 2f, getHeight() / 2f);
    }

    public void setMessage(String message){
        this.message = message;
        invalidate();
    }

    public Position getPosition(float x, float y){
        PointF center = getCenter();

        if(x < center.x && y < center.y){
            return Position.TOP_LEFT;
        }
        else if (x < center.x && y > center.y){
            return Position.BOTTOM_LEFT;
        }
        else if (x > center.x && y < center.y){
            return Position.TOP_RIGHT;
        }
        else if (x > center.x && y > center.y){
            return Position.BOTTOM_RIGHT;
        }
        else {
            return Position.MIDDLE;
        }
    }

    @Override
    public void draw(Canvas canvas) {
        super.draw(canvas);

        PointF center = getCenter();
        canvas.drawText(message, center.x, center.y, paint);
    }
}
