package com.example.aplikacjazaliczenie;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;

public class gra extends AppCompatActivity {

    private TextView countdown;
    private Button countownbtn1;
    private Button countownbtn2;
    private CountDownTimer countDownTimer;
    private long timeLeft = 15000; // 15 sekund
    private boolean timeRunning;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gra);

        TextView textView = (TextView)findViewById(R.id.tutorial);
        textView.startAnimation(AnimationUtils.loadAnimation(gra.this,R.anim.pulse));

        countdown = findViewById(R.id.countdown_txt);
        countownbtn1 = findViewById(R.id.krolik1);
        countownbtn2 = findViewById(R.id.krolik2);

        countownbtn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            startStop();
            }
        });

        countownbtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
             startStop();
            }
        });

        }

        public void startStop(){
        if (timeRunning){

        } else {
            startTimer();
        }
        }
        public void startTimer(){
        countDownTimer = new CountDownTimer(timeLeft,1000) {
            @Override
            public void onTick(long l) {
                timeLeft = l;
                updateTimer();


            }

            @Override
            public void onFinish() {

            }
        }.start();


        timeRunning = true;
        }
        public void stopTimer(){
        countDownTimer.cancel();
        timeRunning = false;
        }

        public void updateTimer(){
        int minutes = (int) timeLeft / 15000;
        int seconds = (int) timeLeft % 15000 / 1000;

        String timeLeftTxt;

        timeLeftTxt = "" + minutes;
        timeLeftTxt += ":";
        if(seconds < 10) timeLeftTxt += "0";
        timeLeftTxt += seconds;

        countdown.setText(timeLeftTxt);
        }
    }
