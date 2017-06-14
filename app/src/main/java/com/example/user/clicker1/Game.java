package com.example.user.clicker1;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.CountDownTimer;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
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

public class Game extends AppCompatActivity {

    final CountDownTimer the=new CountDownTimer(Integer.MAX_VALUE, 5) {
        @Override
        public void onTick(long millisUntilFinished) {
            ProgressBar a=(ProgressBar)findViewById(R.id.progressBar);
            a.setProgress(a.getProgress()-Vars.getReduceHpPerTick());
            if (a.getProgress()<=0) {

                endOfGame();
            }
        }

        @Override
        public void onFinish() {

        }



    };

    final Game this_=this;
    final int DIALOG_EXIT=1;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        Vars.setMaxPops(Settings.getRecord());
        Vars.setMaxTaps(Settings.getTaps());
    }

    @Override
    protected void onStart() {

        super.onStart();

        Vars vars = new Vars();


        DisplayMetrics displayMetrics = new DisplayMetrics();


        WindowManager wm = (WindowManager) getApplicationContext().getSystemService(Context.WINDOW_SERVICE);
        wm.getDefaultDisplay().getMetrics(displayMetrics);

        vars.setPops(0);
        vars.setTaps(0);
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

        bar.setProgress(1000);


        the.start();
        Button Pause=(Button)findViewById(R.id.Pause);
        Pause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                the.cancel();
                Dialog dialog=onCreateDialog(DIALOG_EXIT);
                dialog.show();
            }
        });


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
                finish();

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


        if (Vars.getPops()>vars.getMaxPops()) Vars.setMaxPops(Vars.getPops());

        if (Vars.getTaps()>vars.getMaxTaps()) Vars.setMaxTaps(Vars.getTaps());

        Settings.setRecord(Vars.getMaxPops());
        Settings.setTaps(Vars.getMaxTaps());



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
            hpBar.setProgress(hpBar.getProgress()-new Vars().getReduceHpPerTick());
            if(hpBar.getProgress()==0){
                endOfGame();

            }
        }
        public void onFinish() {

        }
    }

    protected Dialog onCreateDialog (int id)
    {
        if (id == DIALOG_EXIT) {
            AlertDialog.Builder adb = new AlertDialog.Builder(this);
            adb.setTitle("Game Paused");

            adb.setPositiveButton("Resume", myClickListener);
            adb.setNegativeButton("Restart", myClickListener);
            adb.setNeutralButton("Main Menu", myClickListener);
            adb.setCancelable(false);
            AlertDialog dialog = adb.create();

            return dialog;
        }
        return super.onCreateDialog(id);
    }

    protected DialogInterface.OnClickListener myClickListener = new DialogInterface.OnClickListener()
    {
        public void onClick(DialogInterface dialog, int which)
        {
            switch (which)
            {
                case Dialog.BUTTON_POSITIVE:
                    the.start();
                    break;
                case Dialog.BUTTON_NEGATIVE:
                    Intent i=new Intent(this_, Game.class);
                    finish();
                    startActivity(i);
                    break;
                case Dialog.BUTTON_NEUTRAL:
                    Intent intent = new Intent(this_, MainActivity.class);
                    finish();
                    startActivity(intent);
                    break;
            }
        }
    };
}







