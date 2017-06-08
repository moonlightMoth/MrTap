package com.example.user.yahotelcrasivononet;

import android.animation.Animator;
import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.CountDownTimer;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;

public class Game extends AppCompatActivity
{
    final String llog="ADMIN";
    final Activity this_=this;
    final String log="ADDMIN";
    final int DIALOG_EXIT=1;
    Bundle bundle=new Bundle();
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        findViewById(R.id.button3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onSaveInstanceState(bundle);
                showDialog(DIALOG_EXIT);
            }
        });

        final ProgressBar bar = (ProgressBar) findViewById(R.id.progressBar1);
        bar.setProgress(100);
        new CountDownTimer(Integer.MAX_VALUE, 200)
        {

            @Override
            public void onTick(long millisUntilFinished) {
                bar.setProgress(bar.getProgress()-1);
            }

            @Override
            public void onFinish() {

            }

        }.start();

    }

    protected Dialog onCreateDialog(int id)
    {
        if (id == DIALOG_EXIT)
        {
            AlertDialog.Builder adb = new AlertDialog.Builder(this);
            adb.setTitle("Game Paused");
            adb.setPositiveButton("Resume", myClickListener);
            adb.setNegativeButton("Restart", myClickListener);
            adb.setNeutralButton("Main Menu", myClickListener);
            adb.setCancelable(false);
            return adb.create();
        }
        return super.onCreateDialog(id);
    }

    DialogInterface.OnClickListener myClickListener = new DialogInterface.OnClickListener() {
        public void onClick(DialogInterface dialog, int which) {

            switch (which) {
                case Dialog.BUTTON_POSITIVE:
                    onRestoreInstanceState(bundle);
                    break;
                case Dialog.BUTTON_NEGATIVE:
                    Intent intent = new Intent(this_, Game.class);
                    startActivity(intent);
                    break;
                case Dialog.BUTTON_NEUTRAL:
                    Intent intent1 = new Intent(this_, MainActivity.class);
                    startActivity(intent1);
                    break;
            }
        }
    };
}





