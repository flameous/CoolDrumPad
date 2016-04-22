package com.example.flameous.firstapplication;

import android.media.AudioManager;
import android.media.SoundPool;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;


public class MainActivity extends AppCompatActivity {

    public final int NUM_OF_PADS = 9;

    SoundPool soundPool;

    int[] sound_ids = new int[NUM_OF_PADS];

    float leftVolume = 1f;
    float rightVolume = 1f;

    int priority = 0;
    int loop = 0;
    float normRate = 1;
    float lowRate = 0.5f;
    float fastRate = 1.5f;

    //Посвящается Александру Алексеевичу!

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        int[] rawIDs = new int[NUM_OF_PADS];

        rawIDs[0] = R.raw.hihatdist01;
        rawIDs[1] = R.raw.kickbig;
        rawIDs[2] = R.raw.kickdry;
        rawIDs[3] = R.raw.snareanalog;
        rawIDs[4] = R.raw.snarevinyl01;
        rawIDs[5] = R.raw.tomanalog;
        rawIDs[6] = R.raw.yoo;
        rawIDs[7] = R.raw.yoo;
        rawIDs[8] = R.raw.yoo;

        soundPool = new SoundPool(10, AudioManager.STREAM_MUSIC, 0);

        for (int i = 0; i < NUM_OF_PADS; i++) {
            sound_ids[i] = soundPool.load(this, rawIDs[i], 1);
        }
    }

    public void musicClick(View view) {

        int index = 0;
        float rate = normRate;

        switch (view.getId()) {
            case (R.id.l1):
                index = 0;
                break;
            case (R.id.l2):
                index = 1;
                break;
            case (R.id.l3):
                index = 2;
                break;
            case (R.id.l4):
                index = 3;
                break;
            case (R.id.l5):
                index = 4;
                break;
            case (R.id.l6):
                index = 5;
                break;
            case (R.id.l7):
                index = 6;
                rate = lowRate;
                break;
            case (R.id.l8):
                index = 7;
                rate = normRate;
                break;
            case (R.id.l9):
                index = 8;
                rate = fastRate;
            default:
                break;
        }

        soundPool.play(sound_ids[index], leftVolume, rightVolume, priority, loop, rate);
    }

}