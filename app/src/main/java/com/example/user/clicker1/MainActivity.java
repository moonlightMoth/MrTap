package com.example.user.clicker1;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    public int min = 150;
    public int wid;
    public int hei;
    private int maxNOTTD; // max and min number of taps on circle to
    private int minNOTTD; // destroy it

    private int clicked;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        Vars vars = new Vars();

        DisplayMetrics displayMetrics = new DisplayMetrics();


        WindowManager wm = (WindowManager) getApplicationContext().getSystemService(Context.WINDOW_SERVICE);
        wm.getDefaultDisplay().getMetrics(displayMetrics);

        wid = displayMetrics.widthPixels;
        vars.setDispalyHeight(displayMetrics.heightPixels);
        vars.setDispalyWidth(displayMetrics.widthPixels);

        setContentView(R.layout.activity_main);


    }


    public void setButtVision(){
        int rand;
        rand=new Random().nextInt();
    }

}