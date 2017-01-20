package com.mapps.braintrainer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    Random r = new Random();
    int a=0,b=0,sum=0;
    Button startButton;
    TextView sumTextView;
    TextView timerTextView;
    TextView pointTextView;
    TextView correctTextView;
    int locationofAnswer;
    ArrayList<Integer> answers = new ArrayList<Integer>();



    public void Start(View view)    {

        startButton.setVisibility(View.INVISIBLE);


    }
/*
    public void checkAnswer(){




    }
*/
    public int randomNumber()
    {

        return r.nextInt(100);

    }

    public void setNumbers(int a, int b)    {

        sumTextView = (TextView) findViewById(R.id.sumTextView);
        sumTextView.setText(Integer.toString(a)+"+"+Integer.toString(b));

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        startButton = (Button) findViewById(R.id.startButton);
        correctTextView = (TextView) findViewById(R.id.correctTextView);


        a= randomNumber();
        b= randomNumber();
        sum = a+b;    //Set this to the number on the button
        setNumbers(a,b);

        locationofAnswer = r.nextInt(4);        //Set answer at random location
        //Log.i("At position: 0",Integer.toString(answers.get(0)));


        for (int i = 0 ; i < 4 ; i ++){

            answers.add(i,randomNumber());

        }

        answers.set(locationofAnswer,sum);

       for (Integer i : answers){

           Log.i("RANDOM VALUES: ",Integer.toString(i));
       }

        if (sum == a+b){

            correctTextView.setText("Correct!");

        }


    }
}
