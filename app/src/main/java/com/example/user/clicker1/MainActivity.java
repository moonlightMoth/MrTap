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


        new Timer(Integer.MAX_VALUE, 200, bar).start();



        setButtVision(greenButton,yellowButton,popsField,tapsField, bar);


    }

    public void setButtVision(GreenButton gb,
                              YellowButton yb,
                              TextView pops,
                              TextView taps,
                              ProgressBar hp){
        int rand;
        rand=new Random().nextInt(new Vars().getNumOfRandObjects())+1;

        switch(rand)
        {
            case 1:  gb.init(gb, yb, pops, taps, hp); break;
            case 2:  yb.init(gb, yb, pops, taps, hp); break;
        }

    }
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
            //end of game
        }
    }
    public void onFinish() {

    }
}














