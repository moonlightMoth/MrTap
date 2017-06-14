package com.example.user.clicker1;

import android.content.Context;
import android.support.v7.widget.AppCompatButton;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;

import java.util.Random;

public class Heal extends AppCompatButton {
    public Heal(Context context) {
        super(context);
    }

    public Heal(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public Heal(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public void init(final ProgressBar hp){

        final Vars vars = new Vars();

        int wid=(int)Math.round(vars.getDispalyWidth()/1.5);
        int hei=(int)Math.round(vars.getDispalyHeight()/1.5);

        int err=0;
        while (err==0){
            int xx = new Random().nextInt(wid);
            int yy = new Random().nextInt(hei);
            if(Math.abs(yy-vars.getY())>300){
                setX(xx);
                setY(yy);
                err=1;
                Log.d("widCoin",Integer.toString(xx));
                Log.d("heiCoin",Integer.toString(yy));
            }
        }
        err=0;

        setVisibility(View.VISIBLE);

        setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                Vars vars = new Vars();
                hp.setProgress(hp.getProgress()+vars.getHealPerHealCircle());
                setVisibility(GONE);
            }
        });
    }

}