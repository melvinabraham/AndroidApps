package com.mapps.guessthepokemon;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.channels.AsynchronousCloseException;

public class MainActivity extends AppCompatActivity {

    public class DownloadTask extends AsyncTask< String,Void,String >  {
        @Override
        protected String doInBackground(String... urls) {

            String result = "";
            URL url;
            HttpURLConnection urlConnection = null;


            try {

                url = new URL(urls[0]);

                urlConnection = (HttpURLConnection) url.openConnection();

                InputStream in = urlConnection.getInputStream();

                InputStreamReader reader = new InputStreamReader(in);

                int data = reader.read();

                while(data!= -1)    {

                   char current = (char) data;

                    result += current;

                    data = reader.read();




                }

                return result;

            }
            catch (Exception e) {

                e.printStackTrace();
            }



            return null;
        }


        @Override
        protected void onPostExecute(String result) {

           System.out.println(result);

        }


    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DownloadTask downloadTask = new DownloadTask();
        String result = null;
        try {


            //result = downloadTask.execute("https://www.google.co.in").get();

           // Log.i("URL : ",result);

            downloadTask.execute("http://www.facebook.com");


        }

        catch (Exception e){

            e.printStackTrace();
            Log.i("Not","Working");
        }


    }
}
