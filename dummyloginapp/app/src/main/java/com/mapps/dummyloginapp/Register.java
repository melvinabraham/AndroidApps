package com.mapps.dummyloginapp;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;

import java.security.spec.ECField;

public class Register extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        final EditText etage = (EditText) findViewById(R.id.etRegAge);
        final EditText etusername = (EditText) findViewById(R.id.etRegUserName);
        final EditText etname = (EditText) findViewById(R.id.etRegName);
        final EditText etpassword= (EditText) findViewById(R.id.etRegPassword);
        final Button bRegister = (Button) findViewById(R.id.bRegister);
        bRegister.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {

                final String name = etname.getText().toString();

                final String username = etusername.getText().toString();

                final String password = etpassword.getText().toString();

                final int age = Integer.parseInt(etage.getText().toString());

                Response.Listener<String> listener = new Response.Listener<String>()
                {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonObject = new JSONObject(response);
                            boolean success = jsonObject.getBoolean("success");
                            if(success) {

                                Intent intent = new Intent(getApplicationContext(),LoginActivity.class);
                                startActivity(intent);

                            }
                            else {

                                AlertDialog.Builder builder = new AlertDialog.Builder(Register.this);
                                builder.setMessage("Registration Failed")
                                        .setNegativeButton("Retry",null)
                                        .create()
                                        .show();

                            }

                        }
                        catch (Exception e) {


                            e.printStackTrace();
                        }
                    }


                };



                RegisterRequest registerRequest = new RegisterRequest(name,username,age,password,listener);
                RequestQueue queue = Volley.newRequestQueue(Register.this);
                queue.add(registerRequest);

            }
        });



    }
}
