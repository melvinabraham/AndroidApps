package com.mapps.animations;

import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    public void fade(View view) {

        ImageView img1=(ImageView) findViewById(R.id.first);
        img1.animate(   )
                .translationXBy(1000f)
                .translationYBy(1000f)
                .rotationBy(3600)
                .setDuration(2000);

        //ImageView img2=(ImageView) findViewById(R.id.images);
        //img2.animate().alpha(1f).setDuration(2000);


    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView img1=(ImageView) findViewById(R.id.first);
        img1.setTranslationX(-1000f);
        img1.setTranslationY(-1000f);





    }


}
