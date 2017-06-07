package com.example.user.clicker1;

import android.content.Context;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        Vars vars = new Vars();

        DisplayMetrics displayMetrics = new DisplayMetrics();


        WindowManager wm = (WindowManager) getApplicationContext().getSystemService(Context.WINDOW_SERVICE);
        wm.getDefaultDisplay().getMetrics(displayMetrics);


        vars.setDispalyHeight(displayMetrics.heightPixels);
        vars.setDispalyWidth(displayMetrics.widthPixels);

        setContentView(R.layout.activity_main);


        final GreenButton greenButton = (GreenButton) findViewById(R.id.roundGreen);
        final YellowButton yellowButton = (YellowButton) findViewById(R.id.roundYellow);
        final TextView popsField = (TextView) findViewById(R.id.pops);
        final TextView tapsField = (TextView) findViewById(R.id.taps);
        final ProgressBar bar = (ProgressBar) findViewById(R.id.progressBar);
        final Bomb bomb = (Bomb) findViewById(R.id.bomb);


        new Timer(Integer.MAX_VALUE, 200, bar).start();



        setButtVision(greenButton,yellowButton,popsField,tapsField, bar,bomb);


    }

    public void setButtVision(GreenButton gb,
                              YellowButton yb,
                              TextView pops,
                              TextView taps,
                              ProgressBar hp,
                              Bomb bomb){
        int rand;
        rand=new Random().nextInt(new Vars().getNumOfRandObjects())+1;

        switch(rand)
        {
            case 1:  gb.init(gb, yb, pops, taps, hp,bomb); break;
            case 2:  yb.init(gb, yb, pops, taps, hp,bomb); break;
        }

    }

    public void endOfGame(){
        findViewById(R.id.roundGreen).setVisibility(View.GONE);
        findViewById(R.id.roundYellow).setVisibility(View.GONE);
        findViewById(R.id.bomb).setVisibility(View.GONE);

        findViewById(R.id.endTitle).setVisibility(View.VISIBLE);

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

















