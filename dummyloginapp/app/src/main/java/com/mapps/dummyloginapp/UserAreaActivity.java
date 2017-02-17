package com.mapps.dummyloginapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class UserAreaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_area);

        TextView username = (TextView) findViewById(R.id.etMainUsername);
        TextView age = (TextView) findViewById(R.id.etMainAge); 


    }
}
