package com.mapps.downloadimages;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.style.URLSpan;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.ExecutionException;

public class MainActivity extends AppCompatActivity {

    ImageView  imageView;

    public void onClickButton(View view)    {

        Log.i("Button ","Tapped");

        ImageDownloader task = new ImageDownloader();

        Bitmap myImage;

        try {
            myImage = task.execute("https://upload.wikimedia.org/wi" +
                    "kipedia/en/thumb/0/0d/Simpsons_FamilyPicture.png/220px-Simpsons_FamilyPicture.png").get();
            imageView.setImageBitmap(myImage);
        }

        catch (Exception e) {


            e.printStackTrace();

        }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = (ImageView) findViewById(R.id.imageView);
        imageView.setImageResource(android.R.color.transparent);

    }

    public class ImageDownloader extends AsyncTask<String,Void,Bitmap>  {


        @Override
        protected Bitmap doInBackground(String... urls) {

            try {
                URL url = new URL(urls[0]);

                HttpURLConnection connection = (HttpURLConnection) url.openConnection();

                Log.i("Connecting","Wait");

                connection.connect();

                Log.i("connected","getting stream");


                InputStream inputStream = connection.getInputStream();

                Log.i("got stream","converting to bitmap");

                Bitmap mybitmap = BitmapFactory.decodeStream(inputStream);

                Log.i("got bitmap","now returning");

                return mybitmap;

            }


            catch (MalformedURLException e) {
                e.printStackTrace();
            }

            catch (IOException e) {
                e.printStackTrace();
            }

            return null;
        }


    }



}