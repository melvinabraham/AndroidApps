package com.mapps.jsondemo;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class MainActivity extends AppCompatActivity {


    public class DownloadTask extends AsyncTask<String ,Void,String>    {

        @Override
        protected String doInBackground(String... urls) {

            String result ="";
            URL url;
            HttpURLConnection connection = null;
            try     {

                url = new URL(urls[0]);

                connection = (HttpURLConnection) url.openConnection();

                InputStream in = connection.getInputStream();

                InputStreamReader reader = new InputStreamReader(in);

                int data = reader.read();

                while (data!=-1)    {

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

        public void onPostExecute(String result)    {

            //      !!!!!!!!!!!! GENERAL PURPOSE JSON EXTRACTION SCRIPT !!!!!!!!!!!!!!!!!!!!!!!!

            try {

                JSONObject jsonObject = new JSONObject(result);
                String weatherInfo = jsonObject.getString("weather");
                Log.i("Weather content: ",weatherInfo);
                JSONArray arr = new JSONArray(weatherInfo);
                for(int i=0;i<arr.length();i++) {

                    JSONObject part = arr.getJSONObject(i);
                    Log.i("Main: ", part.getString("main"));
                    Log.i("description: ",part.getString("description"));

                }

            }

            catch (JSONException e) {

                e.printStackTrace();

            }

            Log.i("Website content: ",result);

        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DownloadTask task = new DownloadTask();
        task.execute("http://www.google.co.in");

    }
}
