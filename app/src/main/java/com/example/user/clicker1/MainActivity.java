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
        setContentView(R.layout.activity_main);

        DisplayMetrics displayMetrics = new DisplayMetrics();

        Button mbutton = (Button) findViewById(R.id.round);

        WindowManager wm = (WindowManager) getApplicationContext().getSystemService(Context.WINDOW_SERVICE);
        wm.getDefaultDisplay().getMetrics(displayMetrics);

        wid = (int)displayMetrics.widthPixels;
        hei =  (int)displayMetrics.heightPixels;

        Log.d("asd", Integer.toString(wid));



        maxNOTTD = 1;
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
                butt.setText(Integer.toString(clicked));

                if (clicked==0) {
                    butt.setVisibility(View.GONE);
                    Log.d("button", "clicked");

                    butt.setX(new Random().nextInt(wid-400)); //redo
                    butt.setY(new Random().nextInt(hei-650)); //

//vars.setMinNumOfTapsToDestroy(vars.getMinNumOfTapsToDestroy()+2);
//vars.setMaxNumOfTapsToDestroy(vars.getMaxNumOfTapsToDestroy()+2);
//minNOTTD+=2;
// maxNOTTD+=2;

                    clicked = new Random().nextInt(maxNOTTD-minNOTTD+1)+minNOTTD;
                    butt.setText(Integer.toString(clicked));
                    butt.setVisibility(View.VISIBLE);
                }
            }
        };
        mbutton.setOnClickListener(listener);
    }

}