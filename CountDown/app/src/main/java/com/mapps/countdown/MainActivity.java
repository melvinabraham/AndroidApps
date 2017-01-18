package com.mapps.countdown;


import android.os.CountDownTimer;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.Interpolator;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class MainActivity extends AppCompatActivity {

    int minutes=0,seconds=0;


    public void onClickTimer(View view)  {

        final TextView myTime = (TextView) findViewById(R.id.t_time);
        final SeekBar timeControl = (SeekBar) findViewById(R.id.seekTime);
        new CountDownTimer(900000,100)  {

            public void onTick(long millisecondsUntilDone)  {

                seconds = seconds -1;
                if(seconds<0)  {
                    seconds=60+seconds;
                    minutes=minutes-1;
                }
                timeControl.setProgress(seconds+minutes*60);
                Log.i("Mins:Secs",Integer.toString(minutes)+Integer.toString(seconds));
                timeControl.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
                    @Override
                    public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                        minutes = (int) i / 60;
                        seconds = i - minutes*60;
                        myTime.setText(Integer.toString(minutes)+":"+ Integer.toString(seconds));

                    }

                    @Override
                    public void onStartTrackingTouch(SeekBar seekBar) {

                    }

                    @Override
                    public void onStopTrackingTouch(SeekBar seekBar) {

                    }
                });



            }

            public void onFinish()  {




            }

        }.start();


    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SeekBar timeControl = (SeekBar) findViewById(R.id.seekTime);
        final TextView myTime = (TextView) findViewById(R.id.t_time);
        timeControl.setMax(900);
        timeControl.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {

                //Update the value
               minutes = (int) i / 60;
               seconds = i - minutes*60;
               myTime.setText(Integer.toString(minutes)+":"+ Integer.toString(seconds));

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

                //Go to that point

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

                //Stop

            }
        } );



    }
}




