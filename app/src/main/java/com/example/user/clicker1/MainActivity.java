package com.example.user.clicker1;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    final String llog="ADMIN";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Activity this_=this;

        Log.d(llog,"App started");

        //достать рекорд
        TextView highscoree=(TextView)findViewById(R.id.point47);
        Settings.setSharedPreferences(getSharedPreferences("appSetings", Context.MODE_PRIVATE));
        highscoree.setText(Integer.toString(Settings.getRecord()));


        TextView taps=(TextView)findViewById(R.id.point999);
        Settings.setSharedPreferences(getSharedPreferences("appSetings", Context.MODE_PRIVATE));
        taps.setText(Integer.toString(Settings.getTaps()));


        ImageView imageView = (ImageView)findViewById(R.id.imageView);
        imageView.setImageResource(R.drawable.imagemainmenu);

        findViewById(R.id.start_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(this_, Game.class);
                startActivity(intent);
                Log.d(llog,"Gone to Game");
            }
        });

        findViewById(R.id.shop_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(this_, Shop.class);
                startActivity(intent);
                Log.d(llog,"Gone to Shop");
            }
        });

        findViewById(R.id.reset).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Settings.setTaps(0);
//                Settings.setRecord(0);
//                TextView p47 = (TextView)findViewById(R.id.point47);
//                TextView p999 = (TextView)findViewById(R.id.point999);
//                p47.setText(Integer.toString(Settings.getRecord()));
//                p999.setText(Integer.toString(Settings.getTaps()));
            }
        });

    }

    protected void onPause(){
        super.onPause();
        Log.d(llog,"MainMenu paused");

    }

    protected void onDestroy(){
        super.onDestroy();
        Log.d(llog,"App sdoh nahui");
    }

    protected void onResume(){
        super.onResume();
        Log.d(llog,"MainMenu resumed");

        //установить рекорд
        TextView highscoree=(TextView)findViewById(R.id.point47);
        highscoree.setText(Integer.toString(Settings.getRecord()));

        TextView taps=(TextView)findViewById(R.id.point999);
        taps.setText(Integer.toString(Settings.getTaps()));

    }
}
