package com.mapps.intenttest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Toast.makeText(getApplicationContext(),"hello",Toast.LENGTH_SHORT);


    }

    public void onClickLoginButton(View view)   {

        EditText username = (EditText) findViewById(R.id.userTextField);
        EditText password = (EditText) findViewById(R.id.passwordTextField);


        if(username.getText().toString().equals("Melvin")
                && !username.getText().toString().equals("") &&
                password.getText().toString().equals("Abraham") && !password.getText().toString().equals("")) {
            Toast.makeText(this, "LOGIN SUCCEEDED", Toast.LENGTH_SHORT).show();

        }

        else
        {
            Toast.makeText(this, "Please Check the credentials", Toast.LENGTH_SHORT).show();
        }

    }

}
