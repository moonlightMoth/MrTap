package com.example.user.clicker1;

import android.content.Context;
import android.content.Intent;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ProgressBar;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    public int min = 150;
    public int wid;
    public int hei;
    public int HP = 100;
    private int maxNOTTD; // max and min number of taps on circle to
    private int minNOTTD; // destroy it
    private int bombChance = 10;
    private int healChance = 20;

    private int clicked;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DisplayMetrics displayMetrics = new DisplayMetrics();


        final Button mbutton = (Button) findViewById(R.id.round);
        final Button bbutton = (Button) findViewById(R.id.bomb);
        final ProgressBar bar = (ProgressBar) findViewById(R.id.progressBar);
        final ProgressBar end = (ProgressBar) findViewById(R.id.progressBar2);
        final ImageButton heal = (ImageButton) findViewById(R.id.imageButton);



        WindowManager wm = (WindowManager) getApplicationContext().getSystemService(Context.WINDOW_SERVICE);
        wm.getDefaultDisplay().getMetrics(displayMetrics);

        bar.setMinimumWidth((int)displayMetrics.widthPixels);
        wid = (int)displayMetrics.widthPixels;
        hei =  (int)displayMetrics.heightPixels;
        bar.setMinimumWidth(999);
        Log.d("asd", Integer.toString(wid));
        bbutton.setVisibility(View.GONE);
        end.setVisibility(View.GONE);
        heal.setVisibility(View.GONE);




        new CountDownTimer(Integer.MAX_VALUE, 200) {

            public void onTick(long millisUntilFinished) {
                bar.setProgress(bar.getProgress()-1);
                if(bar.getProgress()==0){
                    mbutton.setVisibility(View.GONE);
                    bbutton.setVisibility(View.GONE);
                    heal.setVisibility(View.GONE);
                    end.setVisibility(View.VISIBLE);
                }
            }
            public void onFinish() {

            }
        }.start();





        maxNOTTD = 5;
        minNOTTD = 1;

        clicked = new Random().nextInt(maxNOTTD-minNOTTD+1)+minNOTTD;
        mbutton.setX(new Random().nextInt(wid-100));
        mbutton.setY(new Random().nextInt(hei-100));
        mbutton.setText(Integer.toString(clicked));

        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clicked--;
                Button butt = (Button) findViewById(R.id.round);
                Button bomb = (Button) findViewById(R.id.bomb);
                ProgressBar bar = (ProgressBar) findViewById(R.id.progressBar);
                bar.setProgress(bar.getProgress()+1);

                butt.setText(Integer.toString(clicked));

                if (clicked==0) {
                    butt.setVisibility(View.GONE);
                    bomb.setVisibility(View.GONE);
                    heal.setVisibility(View.GONE);
                    Log.d("button", "clicked");
                    if(new Random().nextInt(bombChance) != 1) {

                        butt.setX(new Random().nextInt(wid - 400)); //redo
                        butt.setY(new Random().nextInt(hei - 650)); //

                        clicked = new Random().nextInt(maxNOTTD - minNOTTD + 1) + minNOTTD;
                        butt.setText(Integer.toString(clicked));
                        butt.setVisibility(View.VISIBLE);
                    }
                    else
                        {
                        butt.setX(new Random().nextInt(wid - 400)); //redo bomb
                        butt.setY(new Random().nextInt(hei - 650)); //
                        bomb.setX(new Random().nextInt(wid - 400)); //redo bomb
                        bomb.setY(new Random().nextInt(hei - 650)); //

                        clicked = new Random().nextInt(maxNOTTD - minNOTTD + 1) + minNOTTD;
                        butt.setText(Integer.toString(clicked));
                        butt.setVisibility(View.VISIBLE);
                        bomb.setVisibility(View.VISIBLE);
                    }
                    if(new Random().nextInt(healChance) == 1){
                        heal.setX(new Random().nextInt(wid - 400)); //redo heal
                        heal.setY(new Random().nextInt(hei - 650)); //

                        heal.setVisibility(View.VISIBLE);
                    }
                }
            }
        };
        mbutton.setOnClickListener(listener);
        View.OnClickListener listener1 = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ProgressBar bar = (ProgressBar) findViewById(R.id.progressBar);
                Button butt = (Button) findViewById(R.id.round);
                Button bomb = (Button) findViewById(R.id.bomb);
                butt.setVisibility(View.GONE);
                bomb.setVisibility(View.GONE);
                heal.setVisibility(View.GONE);
                Log.d("bomb", "babah");

                    bar.setProgress(bar.getProgress()-20);

                    butt.setX(new Random().nextInt(wid - 400)); //redo
                    butt.setY(new Random().nextInt(hei - 650)); //

                    clicked = new Random().nextInt(maxNOTTD - minNOTTD + 1) + minNOTTD;
                    butt.setText(Integer.toString(clicked));
                    butt.setVisibility(View.VISIBLE);
            }
        };
        bbutton.setOnClickListener(listener1);

        View.OnClickListener listener2 = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ImageButton heal = (ImageButton) findViewById(R.id.imageButton);
                heal.setVisibility(View.GONE);
                bar.setProgress(bar.getProgress()+15);
            }
        };
        heal.setOnClickListener(listener2);
    }

}