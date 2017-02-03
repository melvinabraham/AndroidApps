package com.mapps.a_labb;

import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Date;


public class MainActivity extends AppCompatActivity {


    TextView username,password,date;
    RadioGroup radioGroup;
    RadioButton radioButton;
    int selectedr = 1;
    String errmessage = "";
    int errflag = 1;

    public void onClickButton(View view)    {

        selectedr=1;

        username = (TextView) findViewById(R.id.b_uname);

        password= (TextView) findViewById(R.id.b_pass);

        date = (TextView) findViewById(R.id.b_date);

        RadioGroup radioGroup = (RadioGroup) findViewById(R.id.r_rdiogroup);

        selectedr = radioGroup.getCheckedRadioButtonId();
        radioButton = (RadioButton) findViewById(selectedr);


        if (!username.getText().toString().matches("[a-zA-Z]*") || username.getText().toString().length()==0)   {

            errflag=0;
            errmessage="Please check username.";        

        }



        if(errflag==0)  {

            Toast.makeText(getApplicationContext(),errmessage,Toast.LENGTH_LONG).show();

            username.setText(null);
        }

        else {


            Log.i("Uname: ", username.getText().toString());

            Log.i("Password: ", password.toString());

            Log.i("Uname: ", date.getText().toString());

            Log.i("Gender: ", radioButton.getText().toString());

            Toast.makeText(getApplicationContext(),"Successful",Toast.LENGTH_LONG).show();
        }


    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }









}
