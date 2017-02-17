package com.mapps.dummyloginapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        final EditText username = (EditText) findViewById(R.id.etLoginUsername);
        final EditText password = (EditText) findViewById(R.id.etLoginPassword);
        final Button b = (Button) findViewById(R.id.bLogin);
        final TextView registerText = (TextView) findViewById(R.id.textRegisterHere);

        registerText.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                Intent registerIntent = new Intent(getApplicationContext(),Register.class);
                startActivity(registerIntent);


                  }
        }

        );




    }
}
