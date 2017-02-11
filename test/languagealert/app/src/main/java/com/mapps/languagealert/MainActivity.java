package com.mapps.languagealert;

import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        sharedPreferences = this.getSharedPreferences("com.mapps.languagealert", Context.MODE_PRIVATE);

        if(!sharedPreferences.contains("language")) {
                
            Alert();
        }





    }


    public void Alert() {


        final TextView textView = (TextView) findViewById(R.id.lang);

        sharedPreferences = this.getSharedPreferences("com.mapps.languagealert", Context.MODE_PRIVATE);



            new AlertDialog.Builder(this)
                    .setIcon(android.R.drawable.ic_menu_set_as)
                    .setTitle("Select Language")
                    .setMessage("Please select your language")
                    .setPositiveButton("English", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                            sharedPreferences.edit().putString("language", "English").apply();
                            textView.setText("English");

                        }
                    })
                    .setNegativeButton("Spanish", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                            sharedPreferences.edit().putString("language", "Spanish").apply();
                            textView.setText("Spanish");

                            //   Log.i("string",sharedPreferences.getString("language",""));

                        }
                    })
                    .show();



        }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.add) {

            Alert();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
