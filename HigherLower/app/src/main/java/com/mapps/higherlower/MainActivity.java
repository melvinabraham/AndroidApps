package com.mapps.higherlower;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    Random randgenerator=new Random();
    int rno;
    public void onClickRandom(View view)    {

        rno=randgenerator.nextInt(100);
        Log.i("RandomNo.: ",Integer.toString(rno));
        Toast.makeText(getApplicationContext(), "Random No. in 0-100 Has been generated!", Toast.LENGTH_SHORT).show();

    }


    public void onClickTry(View view)  {

        String message=null;
        EditText no_inp = (EditText) findViewById(R.id.number);
        Log.i("InputField: ",no_inp.getText().toString());
        int inp=Integer.parseInt(no_inp.getText().toString());
        if(inp==rno)
        {
            message="Exactly Right!";
            Log.i("Match found for:  ",no_inp.toString());

        }
        if(inp>rno) {
            message="Lower!";

        }
        if(inp<rno) {

            message="Higher!";

        }

        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_LONG).show();
    }









    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
