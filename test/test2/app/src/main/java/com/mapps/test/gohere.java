package com.mapps.test;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class gohere extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gohere);

        Intent intent = getIntent();
        Bundle bundle  = intent.getExtras();
        Log.i("Recievedd: ",bundle.getString("name"));
    }
}
