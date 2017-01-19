package com.mapps.countdown;


import android.media.MediaPlayer;
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


    boolean counterIsActive = false;
    int minutes=0,seconds=0;
    //SeekBar timeControl = (SeekBar) findViewById(R.id.seekTime);

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SeekBar timeControl = (SeekBar) findViewById(R.id.seekTime);
        timeControl.setMax(900);

        timeControl.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {

                Log.i("Main timer: ",Integer.toString(seekBar.getProgress()));
                //Update the value
                updateTimer(i);

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


    public void updateTimer(int secondsLeft)    {

        TextView myTime = (TextView) findViewById(R.id.t_time);
        minutes = (int) (secondsLeft / 60);
        seconds = secondsLeft - minutes*60;
        String secondsString = Integer.toString(seconds);
        if(seconds<=9)  {
            secondsString = "0"+secondsString;
        }
        myTime.setText(Integer.toString(minutes)+":"+ secondsString);


    }



    public void onClickTimer(View view)  {
        final MediaPlayer mp = MediaPlayer.create(this, R.raw.airhorn);
        final SeekBar timeControl = (SeekBar) findViewById(R.id.seekTime);
        final TextView myTime = (TextView) findViewById(R.id.t_time);
        if (!counterIsActive) {

            counterIsActive = true;
            timeControl.setEnabled(false);

            new CountDownTimer(timeControl.getProgress() * 1000, 1000) {
                @Override
                public void onTick(long l) {

                    updateTimer((int) l / 1000);
                    Log.i("seconds left",Integer.toString((int)l));

                }

                @Override
                public void onFinish() {

                    myTime.setText("00:00");
                    mp.start();
                    Log.i("Done ", "Counter False");
                    counterIsActive = false;
                    timeControl.setEnabled(true);

                }
            }.start();


        }
    }

}




