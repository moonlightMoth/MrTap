package com.example.user.clicker1;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.CountDownTimer;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.Random;

public class Game extends AppCompatActivity {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
    }

    @Override
    protected void onStart() {

        super.onStart();

        Vars vars = new Vars();

        vars.setPops(0);
        vars.setTaps(0);

        DisplayMetrics displayMetrics = new DisplayMetrics();


        WindowManager wm = (WindowManager) getApplicationContext().getSystemService(Context.WINDOW_SERVICE);
        wm.getDefaultDisplay().getMetrics(displayMetrics);


        vars.setDispalyHeight(displayMetrics.heightPixels);
        vars.setDispalyWidth(displayMetrics.widthPixels);


        final PublicButton greenButton = (PublicButton) findViewById(R.id.roundGreen);
        final PublicButton yellowButton = (PublicButton) findViewById(R.id.roundYellow);
        final TextView popsField = (TextView) findViewById(R.id.pops);
        final TextView tapsField = (TextView) findViewById(R.id.taps);
        final ProgressBar bar = (ProgressBar) findViewById(R.id.progressBar);
        final Bomb bomb = (Bomb) findViewById(R.id.bomb);
        final Coins coins = (Coins) findViewById(R.id.coins);
        final Heal heal = (Heal) findViewById(R.id.heal);


        new Timer(Integer.MAX_VALUE, 200, bar).start();



        setButtVision(greenButton,yellowButton,popsField,tapsField, bar,bomb,coins,heal);


    }

    public void setButtVision(PublicButton gb,
                              PublicButton yb,
                              TextView pops,
                              TextView taps,
                              ProgressBar hp,
                              Bomb bomb,
                                Coins coins,
                              Heal heal){
        int rand;
        rand=new Random().nextInt(new Vars().getNumOfRandObjects())+1;

        switch(rand)
        {
            case 1:  gb.init(rand, gb, yb, pops, taps, hp,bomb, coins, heal); break;
            case 2:  yb.init(rand, gb, yb, pops, taps, hp,bomb, coins, heal); break;
        }

    }

    public void endOfGame(){
        Vars vars = new Vars();
        findViewById(R.id.roundGreen).setVisibility(View.GONE);
        findViewById(R.id.roundYellow).setVisibility(View.GONE);
        findViewById(R.id.bomb).setVisibility(View.GONE);

        findViewById(R.id.endTitle).setVisibility(View.VISIBLE);

        findViewById(R.id.toMenu).setVisibility(View.VISIBLE);
        findViewById(R.id.Restart).setVisibility(View.VISIBLE);

        final Activity this_=this;

        findViewById(R.id.toMenu).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(this_,MainActivity.class);

                startActivity(intent);

            }
        });

        findViewById(R.id.Restart).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent( this_, Game.class );
                finish();
                startActivity(i);
            }
        });


        if (Vars.getPops()>vars.getHighscore()) Vars.setHighscore(Vars.getPops());

        if(vars.getMaxPops()< vars.getPops())
            vars.setMaxPops(vars.getPops());
        if(vars.getMaxTaps()< vars.getTaps())
            vars.setMaxTaps(vars.getTaps());


        vars.setPops(0);
        vars.setTaps(0);

    }

    protected void onPause(){
        super.onPause();
    }



    class Timer extends CountDownTimer{

        ProgressBar hpBar ;

        public Timer(long millisInFuture, long countDownInterval, ProgressBar hp) {
            super(millisInFuture, countDownInterval);
            hpBar=hp;
        }

        public void onTick(long millisUntilFinished) {
            hpBar.setProgress(hpBar.getProgress()-1);
            if(hpBar.getProgress()==0){
                endOfGame();
            }
        }
        public void onFinish() {

        }
    }
}







