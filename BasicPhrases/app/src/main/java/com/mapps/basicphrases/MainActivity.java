package com.mapps.basicphrases;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;




public class MainActivity extends AppCompatActivity {

    //  MediaPlayer mp;     HOW I DID IT.

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClick(View view) {

        /*      HOW I DID IT. LONGER WAY, TAKE UP WAY MORE SPACE AND FUNCTION.

        mp = MediaPlayer.create(this,R.raw.doyouspeakenglish);

        switch (view.getId())   {

            case R.id.b1:

                mp.reset();
                mp = MediaPlayer.create(this,R.raw.doyouspeakenglish);
                mp.start();
                break;


            case R.id.b2:

                mp.reset();
                mp = MediaPlayer.create(this,R.raw.goodevening);
                mp.start();
                break;

            case R.id.b3:

                mp.reset();
                mp = MediaPlayer.create(this,R.raw.hello);
                mp.start();
                break;

            case R.id.b4:

                mp.reset();
                mp = MediaPlayer.create(this,R.raw.howareyou);
                mp.start();
                break;

            case R.id.b5:

                mp.reset();
                mp = MediaPlayer.create(this,R.raw.ilivein);
                mp.start();
                break;


            case R.id.b6:

                mp.reset();
                mp = MediaPlayer.create(this,R.raw.mynameis);
                mp.start();
                break;

            case R.id.b7:

                mp.reset();
                mp = MediaPlayer.create(this,R.raw.welcome);
                mp.start();
                break;

            case R.id.b8:

                mp.reset();
                mp = MediaPlayer.create(this,R.raw.please);
                mp.start();
                break;


        }

        */

        int id=view.getId();
        String ourID = "";
        ourID=view.getResources().getResourceEntryName(id);         // HOW TO GET THE BUTTON WHICH WAS TAPPED !!!!! IMP !!!!!
        int resourceID = view.getResources().getIdentifier(ourID,"raw","com.mapps.basicphrases");

        MediaPlayer mp = MediaPlayer.create(this,resourceID);
        mp.start();
        Log.i("ID: ",ourID);





    }


}
