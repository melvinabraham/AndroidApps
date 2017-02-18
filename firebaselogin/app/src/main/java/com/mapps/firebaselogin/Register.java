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

public class Register extends AppCompatActivity implements View.OnClickListener{

    EditText email;
    EditText password;
    Button b;
    TextView registerText;

    private ProgressDialog progress;
    private FirebaseAuth firebaseAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        firebaseAuth = FirebaseAuth.getInstance();
        if(firebaseAuth.getCurrentUser() != null)   {

            finish();
            startActivity(new Intent(getApplicationContext(),UserProfile.class));



            // profile activity

        }
        progress = new ProgressDialog(this);
        email = (EditText) findViewById(R.id.etRegEmail);
        password= (EditText) findViewById(R.id.etRegPassword);
        b= (Button) findViewById(R.id.bRegister);
        registerText = (TextView) findViewById(R.id.textLogin);
        b.setOnClickListener(this);
        registerText.setOnClickListener(this);


    }

    public void registerUser()  {

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
        //they have been entered
        progress.setMessage("Registering");
        progress.show();

        firebaseAuth.createUserWithEmailAndPassword(mail,pass)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {

                        if(task.isSuccessful()) {

                            //Successful

                            Toast.makeText(Register.this, "Registered Successfuly", Toast.LENGTH_SHORT).show();
                            progress.hide();
                        }

                        else {

                            Toast.makeText(Register.this, "Failed to Reigster", Toast.LENGTH_SHORT).show();
                            task.getException().getMessage();

                        }


                    }
                });



    }


    @Override
    public void onClick(View v) {

        if(v == b)
        {

            registerUser();

        }

        if(v == registerText){
            finish();
            startActivity(new Intent(getApplicationContext(),LoginActivity.class));

        }
    }
}
