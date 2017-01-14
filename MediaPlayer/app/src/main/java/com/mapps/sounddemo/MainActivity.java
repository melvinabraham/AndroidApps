package com.mapps.sounddemo;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    AudioManager audioManager;
    MediaPlayer mp;
    public void onPause(View view) {

        mp.pause();

    }

    public void onPlay(View view)   {

        mp.start();

    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        mp = MediaPlayer.create(this,R.raw.raw);

        SeekBar volumecontrol=(SeekBar) findViewById(R.id.seekBar);
        audioManager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);
        int maxvol = audioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC );
        int curvol = audioManager.getStreamVolume(AudioManager.STREAM_MUSIC);
        volumecontrol.setMax(maxvol);
        volumecontrol.setProgress(curvol);


        volumecontrol.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {

                Log.i("Value: ",Integer.toString(i));
                audioManager.setStreamVolume(audioManager.STREAM_MUSIC,i,0);


            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {



            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });


        int maxsong = mp.getDuration();
        final SeekBar songControl = (SeekBar) findViewById(R.id.songBar);
        songControl.setMax(maxsong);

        new Timer().scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {

            songControl.setProgress(mp.getCurrentPosition());

            }
        },0,1000);      //Run the code , immediately(0) for every second(1000ms)


        songControl.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {

                mp.seekTo(i);


            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {


                mp.pause();

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

                mp.start();

            }
        });

    }
}
