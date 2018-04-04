package com.example.foleyapp;

import android.content.Context;
import android.media.SoundPool;

/**
 * Created by Callum on 4/04/2018.
 */

public class SoundManager {
    private SoundPool soundPool;
    private Context context;

    public SoundManager(Context context){
        this.context = context;
        SoundPool.Builder builder = new SoundPool.Builder();
        builder.setMaxStreams(10);
        soundPool = builder.build();
    }

    public int addSound(int resourceID){
        return soundPool.load(context, resourceID, 1);
    }

    public void play(int soundID){
        soundPool.play(soundID, 1, 1, 1, 0, 1);
    }
}
