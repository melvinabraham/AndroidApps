package com.mapps.crosstheround;

import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayout;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    int number_turns=0;

    boolean gameisActive=true;

    int i=0;

    //  1 denotes cross and 0 denotes round

    int turn=1;

    //  2 Denotes an Unplayed Game State

    int[] gameState={2,2,2,2,2,2,2,2,2};

    //LinearLayout linearLay = (LinearLayout)findViewById(R.id.playAgainLayout);

    int [][] winningPositions={{0,1,2},{3,4,5},{6,7,8},{0,3,6},{1,4,7},{2,5,8},{0,4,8},{2,4,6}};

    String winner=null;

    public void restartGame(View view) {
        LinearLayout linearLay = (LinearLayout)findViewById(R.id.playAgainLayout);
        turn=1;
        gameisActive=true;
        for(i=0;i<gameState.length;i++) gameState[i] = 2;
        GridLayout grid= (GridLayout) findViewById(R.id.grdlayout);
        for(i=0;i<grid.getChildCount();i++)
        {
            Log.i("Reset the view at: ",Integer.toString(grid.getChildAt(i).getId()));
            ((ImageView)grid.getChildAt(i)).setImageResource(0);

        }
        winner=null;
        linearLay.setVisibility(View.INVISIBLE);



    }


    public void dropIn(View view)   {

        LinearLayout linearLay = (LinearLayout)findViewById(R.id.playAgainLayout);
        TextView winText = (TextView) findViewById(R.id.winMessage);
        ImageView counter = (ImageView) view;
        counter.setTranslationY(-1000f);
        int tappedCounter=Integer.parseInt(counter.getTag().toString());
        Log.i("Counter Tapped: ", Integer.toString(tappedCounter));


        // To make sure that only Unplayed Counters are tapped on.

        //Entering the Game here.

        if (gameState[tappedCounter] ==2 && gameisActive == true)
            {

            number_turns++;
            gameState[tappedCounter]=turn;


            if (turn == 1) {

                counter.setImageResource(R.drawable.x1);
                turn = 0;
            }

            else {

                counter.setImageResource(R.drawable.o1);
                turn = 1;

            }
            counter.animate()
                    .translationYBy(1000f)
                    .rotationBy(360f)
                    .setDuration(300);
        }

        for(int[] winningPosition:winningPositions) {

            if( gameState[winningPosition[0]] == gameState[winningPosition[1]] &&
                gameState[winningPosition[1]] == gameState[winningPosition[2]] &&
                    gameState[winningPosition[0]]!= 2)
            {

                //Toast.makeText(getApplicationContext(),"YOU WON!!!", Toast.LENGTH_LONG).show();
                if (gameState[winningPosition[0]] == 0)   {

                    winner="Round";


                }

                if (gameState[winningPosition[0]] == 1 )    {

                    winner="Cross";

               }


                winText.setText(winner+"  Wins!");
                linearLay.setVisibility(View.VISIBLE);
                gameisActive=false;


            }

            if (number_turns==9 && winner==null)
            {
                restartGame(view);
            }

        }




    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



    }
}
