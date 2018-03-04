package com.dayal.animapp;

import android.graphics.drawable.AnimationDrawable;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    private AnimationDrawable runAnim;
    private ImageView runImage ;
    private Button frameBtn, fadeBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        frameBtn=(Button)findViewById(R.id.frame_btn);
        fadeBtn=(Button)findViewById(R.id.fade_btn);
        runImage=(ImageView) findViewById(R.id.run_image);
        runImage.setBackgroundResource(R.drawable.run_anim);
        runAnim=(AnimationDrawable)runImage.getBackground();
        frameBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                frameAnimate();
            }
        });
        fadeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fadeAnimate();
            }
        });


    }
    public void frameAnimate(){
        runAnim.start();
        Handler mHandler=new Handler();
        mHandler.postDelayed(new Runnable() {           //  .postDelayed(runnable,TIME_IN_MS);
            @Override
            public void run() {
                 runAnim.stop();
            }
        },5000);     //animate for 5 sec
    }
    public void fadeAnimate(){
        Handler mHandler=new Handler();
        mHandler.postDelayed(new Runnable() {           //  .postDelayed(runnable,TIME_IN_MS);
            @Override
            public void run() {
               Animation startanimation= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fadein_animation);
                runImage.startAnimation(startanimation);
            }
        },50);
    }
}
