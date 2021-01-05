package com.example.aplikacjazaliczenie;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.Locale;
import java.util.concurrent.TimeUnit;

public class gra extends AppCompatActivity {

    TextView textView;
    TextView zegarek;

//    private TextView countdown;
//    private Button countownbtn1;
//    private Button countownbtn2;
//    private CountDownTimer countDownTimer;
//    private long timeLeft = 15000; // 15 sekund
//    private boolean timeRunning;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gra);

        TextView textView = (TextView)findViewById(R.id.tutorial);
        textView.startAnimation(AnimationUtils.loadAnimation(gra.this,R.anim.pulse));

        final TextView zegarek = (TextView)findViewById(R.id.zegarek);
        final TextView ikona = (TextView)findViewById(R.id.zegar);
        ikona.startAnimation(AnimationUtils.loadAnimation(gra.this,R.anim.pulse));

        long duration = TimeUnit.MINUTES.toMillis(1);

        new CountDownTimer(duration, 1000) {
            @Override
            public void onTick(long l) {
                TextView zegarek = (TextView)findViewById(R.id.zegarek);

                String sDuration = String.format(Locale.ENGLISH,"%02d: %02d", TimeUnit.MILLISECONDS.toMinutes(l),
                        TimeUnit.MILLISECONDS.toSeconds(l) - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(l)));
                zegarek.setText(sDuration);

            }

            @Override
            public void onFinish() {

                Toast.makeText(getApplicationContext(),"KONIEC CZASU", Toast.LENGTH_LONG).show();
                Toast.makeText(getApplicationContext(),"WYNIK: ", Toast.LENGTH_LONG).show();
                setContentView(R.layout.activity_main);

            }
        }.start();

//        countdown = findViewById(R.id.countdown_txt);
//        countownbtn1 = findViewById(R.id.krolik1);
//        countownbtn2 = findViewById(R.id.krolik2);

//        countownbtn1.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//            startStop();
//            }
//        });
//
//        updateTimer();
//
//        countownbtn2.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//             startStop();
//            }
//        });
//
//        }
//
//        public void startStop(){
//        if (timeRunning){
//
//        } else {
//            startTimer();
//        }
//        }
//        public void startTimer(){
//        countDownTimer = new CountDownTimer(timeLeft,1000) {
//            @Override
//            public void onTick(long l) {
//                timeLeft = l;
//                updateTimer();
//
//
//            }
//
//            @Override
//            public void onFinish() {
//
//            }
//        }.start();
//
//
//        timeRunning = true;
//        }
//        public void stopTimer(){
//        countDownTimer.cancel();
//        timeRunning = false;
//        }
//
//        public void updateTimer(){
//        int minutes = (int) timeLeft / 15000;
//        int seconds = (int) timeLeft % 15000 / 1000;
//
//        String timeLeftTxt;
//
//        timeLeftTxt = "" + minutes;
//        timeLeftTxt += ":";
//        if(seconds < 10) timeLeftTxt += "0";
//        timeLeftTxt += seconds;
//
//        countdown.setText(timeLeftTxt);
        }
    }
