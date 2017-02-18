package com.mapps.firebaselogin;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    ProgressDialog progressDialog;
    EditText email;
    EditText password;
    Button b;
    TextView loginText;
    FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
         email = (EditText) findViewById(R.id.etLoginEmail);
         password= (EditText) findViewById(R.id.etLoginPassword);
         b= (Button) findViewById(R.id.bLogin);
         loginText= (TextView) findViewById(R.id.textLogin);
        progressDialog = new ProgressDialog(this);
        firebaseAuth = FirebaseAuth.getInstance();
        if(firebaseAuth.getCurrentUser() != null)   {

            finish();
            startActivity(new Intent(getApplicationContext(),UserProfile.class));



            // profile activity

        }
        b.setOnClickListener(this);





    }


    public void LoginUser() {


        String mail = email.getText().toString().trim();
        String pass = password.getText().toString().trim();

        if(TextUtils.isEmpty(mail)) {
            // email empty

            Toast.makeText(this, "Enter E-Mail", Toast.LENGTH_SHORT).show();
            return;
        }
        if(TextUtils.isEmpty(pass)) {
            // password empty
            Toast.makeText(this, "Enter Password", Toast.LENGTH_SHORT).show();
            return;

        }

        progressDialog.setMessage("Logging IN");
        progressDialog.show();

        firebaseAuth.signInWithEmailAndPassword(mail,pass)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {

                         if(task.isSuccessful())    {

                             // Logged In
                             finish();
                             startActivity(new Intent(getApplicationContext(),UserProfile.class));
                             progressDialog.hide(); if(firebaseAuth.getCurrentUser() != null)   {

            finish();
            startActivity(new Intent(getApplicationContext(),UserProfile.class));



            // profile activity

        }


                         }

                        else    {

                             progressDialog.hide();
                             Toast.makeText(LoginActivity.this, "Incorrect Details", Toast.LENGTH_SHORT).show();
                             return;
                             //Wrong credentials

                         }




                    }
                });

    }


    @Override
    public void onClick(View v) {


        if(v == b)
        {

            LoginUser();

        }

        if(v == loginText){

            finish();
            startActivity(new Intent(this,Register.class));

        }


    }
}
