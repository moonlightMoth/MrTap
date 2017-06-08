package com.example.user.clicker1;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.Random;

/**
 * Created by user on 6/7/17.
 */

public class PublicButton extends android.support.v7.widget.AppCompatButton {



    public PublicButton(Context context) {
        super(context);
        setVisibility(View.GONE);
    }

    public PublicButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        setVisibility(View.GONE);
    }

    public PublicButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setVisibility(View.GONE);
    }


    public void init(final int type,
                     final PublicButton gb,
                     final PublicButton yb,
                     final TextView pops,
                     final TextView taps,
                     final ProgressBar hp,
                     final Bomb bomb) {
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
                hp.setProgress(hp.getProgress()+vars.getAddHpPerTap());




                if (vars.getClicked()<=0)
                {
                    vars.setPops(vars.getPops()+1);
                   // hp.setProgress(hp.getProgress()+vars.getAddHpPerPop());
                    pops.setText("pops: " + vars.getPops());
                    //vars.setMaxNuberOfTapToDestroy(vars.getMaxNuberOfTapToDestroy()+2);
                    //vars.setMinNuberOfTapToDestroy(vars.getMinNuberOfTapToDestroy()+2);
                    setVisibility(View.GONE);
                    bomb.setVisibility(View.GONE);

                    setBombVision(bomb,hp);

                    setButtVision(gb, yb,pops,taps,hp,bomb);
                }
            }

        });
    }

    public void setButtVision(PublicButton gb,
                              PublicButton yb,
                              TextView pops,
                              TextView taps,
                              ProgressBar hp,
                              Bomb bomb){
        int rand;
        rand=new Random().nextInt(new Vars().getNumOfRandObjects())+1;

        switch(rand)
        {
            case 1:  gb.init(rand, gb,yb,pops,taps,hp,bomb); break;
            case 2:  yb.init(rand, gb,yb,pops,taps,hp,bomb); break;
        }

    }

    public void setBombVision(Bomb bomb, ProgressBar hp)
    {
        int rand = new Random().nextInt(15)+1;

        switch (rand)
        {
            case 7: createBomb(bomb,hp); break;
            case 4: createBomb(bomb,hp); break;
        }
    }

    public void createBomb(Bomb bomb, ProgressBar hp)
    {
        bomb.init(hp);
    }




}
