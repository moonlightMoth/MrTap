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

    private int clicked = 6;

    @Override
    protected void onCreate(Bundle savedInstanceState)  {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        DisplayMetrics displayMetrics = new DisplayMetrics();
        Button mbutton = (Button) findViewById(R.id.round);
        WindowManager wm = (WindowManager) getApplicationContext().getSystemService(Context.WINDOW_SERVICE); // the results will be higher than using the activity context object or the getWindowManager() shortcut
        wm.getDefaultDisplay().getMetrics(displayMetrics);
        mbutton.setX((displayMetrics.widthPixels)/4);
        mbutton.setY((displayMetrics.heightPixels)/4);
        wid = displayMetrics.widthPixels;
        hei = displayMetrics.heightPixels;
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

                    butt.setX(new Random().nextInt(wid-400));
                    butt.setY(new Random().nextInt(hei-650));
                    clicked = new Random().nextInt(3)+1;
                    butt.setText(Integer.toString(clicked));
                    butt.setVisibility(View.VISIBLE);
                }
            }
        };
        mbutton.setOnClickListener(listener);
    }


    }
