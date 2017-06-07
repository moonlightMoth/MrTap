package com.example.user.clicker1;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.lang.reflect.Method;
import java.util.Random;

/**
 * Created by user on 6/7/17.
 */

public class GreenButton extends android.support.v7.widget.AppCompatButton {

    private int clicked;

    public GreenButton(Context context) {
        super(context);
        setVisibility(View.GONE);
    }

    public GreenButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        setVisibility(View.GONE);
    }

    public GreenButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setVisibility(View.GONE);
    }


    public void init(final GreenButton one, final YellowButton two) {
        setVisibility(View.VISIBLE);

        final Vars vars = new Vars();

        vars.setClicked(new Random().nextInt(vars.getMaxNuberOfTapToDestroy()-
                vars.getMinNuberOfTapToDestroy()+1)+vars.getMinNuberOfTapToDestroy());
        clicked = vars.getClicked();

        setText(Integer.toString(clicked));

        setX(new Random().nextInt(vars.getDispalyWidth()-1000));
        setY(new Random().nextInt(vars.getDispalyHeight()-1000));

        setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {

                clicked-=vars.getNumOfClicksPerTap();

                setText(Integer.toString(clicked));

                if (clicked<=0)
                {

                    setVisibility(View.GONE);


                    setButtVision(one, two);
                }
            }

        });
    }

    public void setButtVision(GreenButton one,
                              YellowButton two){
        int rand;
        rand=new Random().nextInt(new Vars().getNumOfRandObjects())+1;

        switch(rand)
        {
            case 1:  one.init(one,two); break;
            case 2:  two.init(one,two); break;
        }

    }




}
