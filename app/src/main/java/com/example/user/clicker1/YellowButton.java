package com.example.user.clicker1;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.Random;

/**
 * Created by user on 6/7/17.
 */

public class YellowButton extends android.support.v7.widget.AppCompatButton {


    public YellowButton(Context context) {
        super(context);
        setVisibility(View.GONE);
    }

    public YellowButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        setVisibility(View.GONE);
    }

    public YellowButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setVisibility(View.GONE);
    }


    public void init(final GreenButton gb,
                     final YellowButton yb,
                     final TextView pops,
                     final TextView taps,
                     final ProgressBar hp) {

        setVisibility(View.VISIBLE);

        final Vars vars = new Vars();

        vars.setClicked(new Random().nextInt(vars.getMaxNuberOfTapToDestroy()-
                vars.getMinNuberOfTapToDestroy()+1)+vars.getMinNuberOfTapToDestroy());


        setText(Integer.toString(vars.getClicked()));

        setX(new Random().nextInt(vars.getDispalyWidth()-100));
        setY(new Random().nextInt(vars.getDispalyHeight()-100));

        setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {

                vars.setClicked(vars.getClicked()-vars.getNumOfClicksPerTap());
                setText(Integer.toString(vars.getClicked()));
                vars.setTaps(vars.getTaps()+vars.getNumOfClicksPerTap());
                taps.setText("taps: " + vars.getTaps());
                hp.setProgress(hp.getProgress()+1);

                if (vars.getClicked()<=0)
                {
                    vars.setPops(vars.getPops()+1);
                    hp.setProgress(hp.getProgress()+5);
                    pops.setText("pops: " + vars.getPops());
                    //vars.setMaxNuberOfTapToDestroy(vars.getMaxNuberOfTapToDestroy()+2);
                    //vars.setMinNuberOfTapToDestroy(vars.getMinNuberOfTapToDestroy()+2);
                    setVisibility(View.GONE);
                    setButtVision(gb, yb,pops,taps,hp);
                }
            }

        });
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
            case 1:  gb.init(gb,yb,pops,taps,hp); break;
            case 2:  yb.init(gb,yb,pops,taps,hp); break;
        }

    }


}
