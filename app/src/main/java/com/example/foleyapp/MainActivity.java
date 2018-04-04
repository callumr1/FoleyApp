package com.example.foleyapp;

import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private SoundManager soundManager;
    private Display display;
    private int bigDrum, medDrum, smallDrum, bigSnare, medSnare, smallSnare;
    private Button smallSnareButton, medSnareButton, bigSnareButton, smallDrumButton, smallDrum2Button, medDrumButton, medDrum2Button, bigDrumButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Remove title bar
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        //Remove notification bar
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

        soundManager = new SoundManager(this);
        //Big single Drum
        bigDrum = soundManager.addSound(R.raw.bass);
        //Medium Drums
        medDrum = soundManager.addSound(R.raw.kick);
        //Small Drums
        smallDrum = soundManager.addSound(R.raw.snare);
        //Big snare
        bigSnare = soundManager.addSound(R.raw.openhat);
        //Medium snare
        medSnare = soundManager.addSound(R.raw.ride);
        //Small snare
        smallSnare = soundManager.addSound(R.raw.hihat);

        smallSnareButton = findViewById(R.id.smallSnare);
        medSnareButton = findViewById(R.id.medSnare);
        bigSnareButton = findViewById(R.id.bigSnare);
        smallDrumButton = findViewById(R.id.smallDrum);
        smallDrum2Button = findViewById(R.id.smallDrum2);
        medDrumButton = findViewById(R.id.medDrum);
        medDrum2Button = findViewById(R.id.medDrum2);
        bigDrumButton = findViewById(R.id.bigDrum);

        smallSnareButton.setOnClickListener(this);
        medSnareButton.setOnClickListener(this);
        bigSnareButton.setOnClickListener(this);
        smallDrumButton.setOnClickListener(this);
        smallDrum2Button.setOnClickListener(this);
        medDrumButton.setOnClickListener(this);
        medDrum2Button.setOnClickListener(this);
        bigDrumButton.setOnClickListener(this);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        /*Position position = display.getPosition(event.getX(), event.getY());

        switch (position){
            case BOTTOM_LEFT:
                display.setMessage("bass");
                soundManager.play(bigDrum);
                break;
            case BOTTOM_RIGHT:
                display.setMessage("kick");
                soundManager.play(medDrum);
                break;
            case TOP_LEFT:
                display.setMessage("open hi hat");
                soundManager.play(bigSnare);
                break;
            case TOP_RIGHT:
                display.setMessage("ride");
                soundManager.play(medSnare);
                break;
            case MIDDLE:
                display.setMessage("kick");
                break;

        }*/

        return super.onTouchEvent(event);
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.smallSnare:
                soundManager.play(smallSnare);
                break;
            case R.id.medSnare:
                soundManager.play(medSnare);
                break;
            case R.id.bigSnare:
                soundManager.play(bigSnare);
                break;
            case R.id.smallDrum:
                soundManager.play(smallDrum);
                break;
            case R.id.smallDrum2:
                soundManager.play(smallDrum);
                break;
            case R.id.medDrum:
                soundManager.play(medDrum);
                break;
            case R.id.medDrum2:
                soundManager.play(medDrum);
                break;
            case R.id.bigDrum:
                soundManager.play(bigDrum);
                break;
        }

    }
}
