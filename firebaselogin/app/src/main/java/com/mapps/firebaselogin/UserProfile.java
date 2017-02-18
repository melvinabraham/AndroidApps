package com.mapps.firebaselogin;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class UserProfile extends AppCompatActivity implements View.OnClickListener {

    FirebaseAuth firebaseAuth;
    Button button;
    TextView email;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile);

        email = (TextView) findViewById(R.id.tvUsername);
        button = (Button) findViewById(R.id.bLogout);
        firebaseAuth = FirebaseAuth.getInstance();
        if(firebaseAuth.getCurrentUser() == null)   {

            finish();
            startActivity(new Intent(getApplicationContext(),LoginActivity.class));

        }

        FirebaseUser user = firebaseAuth.getCurrentUser();
        email.setText("Welcome "+user.getEmail());


        button.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        if(v == button) {

            firebaseAuth.signOut();
            finish();
            startActivity(new Intent(this,LoginActivity.class));

        }

    }
}
