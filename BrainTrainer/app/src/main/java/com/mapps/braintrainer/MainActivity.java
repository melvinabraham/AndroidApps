package com.mapps.braintrainer;

import android.support.annotation.IntegerRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.Interpolator;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.L;

public class MainActivity extends AppCompatActivity {

    int correctFlag = 1;
    String clickedButtonString=null;
    int clickedButton =0;
    Random r = new Random();
    int a=0,b=0,sum=0;
    Button startButton;
    TextView sumTextView;
    TextView timerTextView;
    TextView pointTextView;
    TextView correctTextView;
    int locationofAnswer;
    Button b1,b2,b3,b4;
    ArrayList<Integer> answers = new ArrayList<Integer>();
    int num=0,den=0;
    String points [];

    public void Start(View view)    {

        startButton.setVisibility(View.INVISIBLE);


    }


    public void updatePoints(int flag) {

        pointTextView = (TextView) findViewById(R.id.pointTextView);
        points = (pointTextView.getText().toString()).split("/");
        num = Integer.valueOf(points[0]);
        den = Integer.valueOf(points[1]);
        if(flag == 1) {
            num++;
            den++;
        }
        else {
            den++;
        }
        pointTextView.setText(Integer.toString(num)+"/"+Integer.toString(den));
    }


    public void checkAnswer(int a){

        correctTextView = (TextView) findViewById(R.id.correctTextView);
        if (sum == answers.get(a)){
            correctTextView.setText("Correct!");
            correctFlag = 1;

        }
        else{
            correctTextView.setText("Incorrect!");
            correctFlag = 0;
        }
        updatePoints(correctFlag);


    }


    public int randomNumber()
    {

        return r.nextInt(100);

    }

    public void setNumbers(int a, int b)    {

        sumTextView = (TextView) findViewById(R.id.sumTextView);
        sumTextView.setText(Integer.toString(a)+"+"+Integer.toString(b));

    }

    public void onClickButton (View view)   {

        clickedButtonString  =  (view.getTag().toString());
        clickedButton = Integer.valueOf(clickedButtonString);
        Log.i("Found button clicked: ", clickedButtonString);

        checkAnswer(clickedButton);


    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        startButton = (Button) findViewById(R.id.startButton);
        correctTextView = (TextView) findViewById(R.id.correctTextView);
        b1 = (Button) findViewById(R.id.b1);
        b2 = (Button) findViewById(R.id.b2);
        b3 = (Button) findViewById(R.id.b3);
        b4 = (Button) findViewById(R.id.b4);


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

        b1.setText(Integer.toString(answers.get(0)));

        b2.setText(Integer.toString(answers.get(1)));

        b3.setText(Integer.toString(answers.get(2)));

        b4.setText(Integer.toString(answers.get(3)));;





    }
}
