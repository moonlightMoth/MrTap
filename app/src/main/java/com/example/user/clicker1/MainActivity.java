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




        setButtVision(greenButton,yellowButton);


    }

    public void setButtVision(GreenButton one,
                              YellowButton two){
        int rand;
        rand=new Random().nextInt(new Vars().getNumOfRandObjects())+1;

        switch(rand)
        {
            case 1:  one.init(one, two); break;
            case 2:  two.init(one, two); break;
        }

    }



}