package com.example.user.clicker1;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.util.Random;

/**
 * Created by user on 6/7/17.
 */

public class GreenButton extends android.support.v7.widget.AppCompatButton {

    private int clicked;

    public GreenButton(Context context) {
        super(context);
        init();
    }

    public GreenButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public GreenButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }


    private void init() {
        setVisibility(View.VISIBLE);

        final Vars vars = new Vars();

        vars.setClicked(new Random().nextInt(vars.getMaxNuberOfTapToDestroy()-
                vars.getMinNuberOfTapToDestroy()+1)+vars.getMinNuberOfTapToDestroy());
        clicked = vars.getClicked();

        setText(Integer.toString(clicked));

        setX(new Random().nextInt(vars.getDispalyWidth()-100));
        setY(new Random().nextInt(vars.getDispalyHeight()-100));

        setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {

                clicked-=vars.getNumOfClicksPerTap();

                setText(Integer.toString(clicked));

                if (clicked<=0)
                {
                    setVisibility(View.GONE);
                    vars.setMaxNuberOfTapToDestroy(vars.getMaxNuberOfTapToDestroy()+2);
                    vars.setMinNuberOfTapToDestroy(vars.getMinNuberOfTapToDestroy()+2);
                }
            }

        });
    }


}
