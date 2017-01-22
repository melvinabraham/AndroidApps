package com.mapps.braintrainer;

import android.graphics.Color;
import android.os.CountDownTimer;
import android.support.annotation.IntegerRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.Interpolator;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

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
    CountDownTimer countDownTimer;
    TextView scoreTextView;
    Button playAgain;


    public void Start(View view)    {

        startButton.setVisibility(View.INVISIBLE);


    }

          //        Updates the points on the textview


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



    //          Checks the tag returned by the button with the string values of answers



    public void checkAnswer(int a){


        correctTextView = (TextView) findViewById(R.id.correctTextView);
        if (sum == answers.get(a)){
            correctTextView.setText("Correct!");
            correctFlag = 1;
            correctTextView.setTextColor(Color.GREEN);

        }
        else{
            correctTextView.setText("Incorrect!");
            correctFlag = 0;
            correctTextView.setTextColor(Color.RED);

        }
        correctTextView.setVisibility(View.VISIBLE);
        updatePoints(correctFlag);
        nextQuestion();



    }

    /*
    public void resetPoints()   {

        pointTextView = (TextView) findViewById(R.id.pointTextView);

        num = 0;
        den = 0;
        points = null;


    }
    */


        //          Next Question Funciton. Resets everythin including clearing the initial values in answers.


    public void nextQuestion()  {


        answers.clear();
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

    //      Returns the random integer for all of the buttons as well as the QUestion.


    public void playAgain(View view){




        scoreTextView.setVisibility(View.INVISIBLE);
        playAgain = (Button) findViewById(R.id.b_playAgain);
        playAgain.setVisibility(View.INVISIBLE);
        correctTextView.setText("");
        correctTextView.setVisibility(View.VISIBLE);
        a=0;
        b=0;
        sum=0;




        Log.i("Button Clicked","this");


    }



    public int randomNumber()
    {

        return r.nextInt(100);

    }

    //      Sets the numbers to the Question

    public void setNumbers(int a, int b)    {

        sumTextView = (TextView) findViewById(R.id.sumTextView);
        sumTextView.setText(Integer.toString(a)+"+"+Integer.toString(b));

    }


    //          Single Function which handles all of the buttons. buttons are identified by their tags.

    public void onClickButton (View view)   {

        clickedButtonString  =  (view.getTag().toString());
        clickedButton = Integer.valueOf(clickedButtonString);
        Log.i("Found button clicked: ", clickedButtonString);

        checkAnswer(clickedButton);


    }

    public void countDownTimer()    {

        timerTextView = (TextView) findViewById(R.id.timertextView);



        countDownTimer = new CountDownTimer(3000,1000) {
            @Override
            public void onTick(long l) {

                timerTextView.setText(Long.toString(l/1000));
               // Log.i("Minus: ",Long.toString(l));

            }

            @Override
            public void onFinish() {

                correctTextView.setVisibility(View.INVISIBLE);
                scoreTextView.setVisibility(View.VISIBLE);
                playAgain.setVisibility(View.VISIBLE);
                scoreTextView.setText("Your score is "+pointTextView.getText().toString());


            }
        }.start();


    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        startButton = (Button) findViewById(R.id.startButton);
        playAgain = (Button) findViewById(R.id.b_playAgain);
        scoreTextView = (TextView) findViewById(R.id.scoreTextView);
        correctTextView = (TextView) findViewById(R.id.correctTextView);
        b1 = (Button) findViewById(R.id.b1);
        b2 = (Button) findViewById(R.id.b2);
        b3 = (Button) findViewById(R.id.b3);
        b4 = (Button) findViewById(R.id.b4);
        correctTextView.setVisibility(View.VISIBLE);
        playAgain.setVisibility(View.INVISIBLE);
        scoreTextView.setVisibility(View.INVISIBLE);
        correctTextView.setText("");
        countDownTimer();
        nextQuestion();


    }
}
