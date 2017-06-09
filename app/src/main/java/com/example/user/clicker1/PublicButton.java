package com.example.user.clicker1;

        import android.content.Context;
        import android.util.AttributeSet;
        import android.util.Log;
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
                     final Bomb bomb,
                     final Coins coins) {
        setVisibility(View.VISIBLE);

        final Vars vars = new Vars();

        vars.setClicked(new Random().nextInt(vars.getMaxNuberOfTapToDestroy()-
                vars.getMinNuberOfTapToDestroy()+1)+vars.getMinNuberOfTapToDestroy());


        setText(Integer.toString(vars.getClicked()));

        int wid=(int)Math.round(vars.getDispalyWidth()/1.5);
        int hei=(int)Math.round(vars.getDispalyHeight()/1.5);

        vars.setX(new Random().nextInt(wid));
        vars.setY(new Random().nextInt(hei));

        setX(vars.getX());
        setY(vars.getX());
        Log.d("wid",Integer.toString(vars.getY()));
        Log.d("hei",Integer.toString(vars.getX()));

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
                    coins.setVisibility(View.GONE);


                    setButtVision(gb, yb,pops,taps,hp,bomb,coins);

                    setEvent(bomb,hp, coins);

                }
            }

        });
    }

    public void setButtVision(PublicButton gb,
                              PublicButton yb,
                              TextView pops,
                              TextView taps,
                              ProgressBar hp,
                              Bomb bomb,
                              Coins coins){
        int rand;
        rand=new Random().nextInt(new Vars().getNumOfRandObjects())+1;

        switch(rand)
        {
            case 1:  gb.init(rand, gb,yb,pops,taps,hp,bomb,coins); break;
            case 2:  yb.init(rand, gb,yb,pops,taps,hp,bomb,coins); break;
        }

    }

    public void setEvent(Bomb bomb, ProgressBar hp, Coins coins)
    {
        int rand = new Random().nextInt(15)+1;
        switch (rand){
            case 7:createBomb(bomb,hp);break;
            case 4:createBomb(bomb,hp);break;
            case 3:createCoins(coins);break;
            case 6:createCoins(coins);break;
        }

    }

    public void createBomb(Bomb bomb, ProgressBar hp)
    {
        bomb.init(hp);
    }


    public void createCoins(Coins coins)
    {
        coins.init();
    }



}
