package com.example.foleyapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;

public class MainActivity extends AppCompatActivity {

    private Display display;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        display = findViewById(R.id.display);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        Position position = display.getPosition(event.getX(), event.getY());

        switch (position){
            case BOTTOM_LEFT:
                display.setMessage("bass");
                break;
            case BOTTOM_RIGHT:
                display.setMessage("clap");
                break;
            case TOP_LEFT:
                display.setMessage("hihat");
                break;
            case TOP_RIGHT:
                display.setMessage("snare");
                break;
            case MIDDLE:
                display.setMessage("kick");
                break;

        }
        return super.onTouchEvent(event);
    }
}
