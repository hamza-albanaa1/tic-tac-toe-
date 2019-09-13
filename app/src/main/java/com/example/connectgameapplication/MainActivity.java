package com.example.connectgameapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.gridlayout.widget.GridLayout;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    //active player 0:j 1:b 2:empty
    int[] gameState ={2 , 2, 2, 2, 2, 2, 2, 2, 2};
    int [][] winPostions={{0,1,2},{3,4,5},{6,7,8},{0,3,6},{1,4,7},{2,5,8},{0,4,8},{2,4,6}};
    int x= 0;
    boolean gameactive = true;
    public void dropIn(View view) {



        ImageView counter = (ImageView) view;
        int tagCounter = Integer.parseInt(counter.getTag().toString());
        if(gameState[tagCounter] == 2 && gameactive) {
            gameState[tagCounter] = x;
            counter.setTranslationY(-1500);
            if (x == 0) {
                counter.setImageResource(R.drawable.joking);
                x = 1;
            } else {
                counter.setImageResource(R.drawable.boring);
                x = 0;
            }
            counter.animate().translationYBy(1500).setDuration(300);

            for (int[] winPostion : winPostions) {
                if (gameState[winPostion[0]] == gameState[winPostion[1]] && gameState[winPostion[1]] == gameState[winPostion[2]] && gameState[winPostion[0]] != 2) {

                    String winner = "";
                    gameactive =false;


                   if (x==0){
                        winner = "Bored ";

                   }


                    else {
                        winner = "Joking";
                    }
                    if(x==9){
                        winner ="Game Draw";
                    }

                    Button playagain = (Button) findViewById(R.id.button);
                    TextView show = (TextView) findViewById(R.id.textView2);
                    show.setText(winner + " has Won");
                    show.setVisibility(View.VISIBLE);
                    playagain.setVisibility(View.VISIBLE);
                   // Toast.makeText(MainActivity.this,winner + "winner",Toast.LENGTH_SHORT).show();


            }
            }
        }


    }


    public void playAgin (View view){
        Button playagain = (Button) findViewById(R.id.button);
        TextView show = (TextView) findViewById(R.id.textView2);

        show.setVisibility(View.INVISIBLE);
        playagain.setVisibility(View.INVISIBLE);

        GridLayout myGridView = (GridLayout) findViewById(R.id.GridLayout);
        for(int i=0; i<myGridView.getChildCount(); i++) {
            ImageView counter = (ImageView) myGridView.getChildAt(i);
            counter.setImageDrawable(null);
        }



        for(int i = 0; i<gameState.length; i++){
            gameState[i]= 2;
        }
        x= 0;
        gameactive = true;



    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
