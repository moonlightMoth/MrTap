package com.example.user.yahotelcrasivononet;

import android.content.Context;
import android.support.v7.widget.AppCompatButton;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ProgressBar;

import java.util.Random;


public class Bomb extends AppCompatButton {
    public Bomb(Context context) {
        super(context);
    }

    public Bomb(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public Bomb(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public void init(final ProgressBar hp){

        final Vars vars = new Vars();

        setX(new Random().nextInt(vars.getDispalyWidth()-1000));
        setY(new Random().nextInt(vars.getDispalyHeight()-1000));

        setVisibility(View.VISIBLE);

        setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                hp.setProgress(hp.getProgress()/2);
                setVisibility(View.GONE);

            }
        });
    }


}
