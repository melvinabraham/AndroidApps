package com.mapps.crosstheround;

import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    int turn=1;                                         //  1 denotes cross and 0 denotes round

    public void dropIn(View view)   {

        ImageView counter = (ImageView) view;
        counter.setTranslationY(-1000f);
        if(turn==1) {

            counter.setImageResource(R.drawable.x1);
            counter.animate()
                    .translationYBy(1000f)
                    .rotationBy(360f)
                    .setDuration(300);
            turn=0;
        }

        else    {

            counter.setImageResource(R.drawable.o1);
            counter.animate()
                    .translationYBy(1000f)
                    .rotationBy(360f)
                    .setDuration(300);
            turn=1;

        }


    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



    }
}
