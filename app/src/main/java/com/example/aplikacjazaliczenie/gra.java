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
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.view.View;
import org.w3c.dom.Text;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

public class gra extends AppCompatActivity {

    TextView textView;
    TextView zegarek;
    int wynik = 0;

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
                global global = new global();

                Toast.makeText(getApplicationContext(),"KONIEC CZASU", Toast.LENGTH_LONG).show();
                Toast.makeText(getApplicationContext(),"WYNIK: " + wynik , Toast.LENGTH_LONG).show();
                setContentView(R.layout.activity_main);

            }
        }.start();

        }


        public void addpoints1(View view){
        Button guziklewy = (Button)findViewById(R.id.buttonkrolik1);
        Button guzikprawy = (Button)findViewById(R.id.buttonkrolik2);
        ImageView kroliklewy = (ImageView)findViewById(R.id.krolik1);
        ImageView krolikprawy = (ImageView)findViewById(R.id.krolik2);
        kroliklewy.setVisibility(View.INVISIBLE);
        guziklewy.setVisibility(View.INVISIBLE);
        krolikprawy.setVisibility(View.VISIBLE);
        guzikprawy.setVisibility(View.VISIBLE);
        wynik++;
        }

        public void addpoints2(View view){
        Button guziklewy = (Button)findViewById(R.id.buttonkrolik1);
        Button guzikprawy = (Button)findViewById(R.id.buttonkrolik2);
        ImageView kroliklewy = (ImageView)findViewById(R.id.krolik1);
        ImageView krolikprawy = (ImageView)findViewById(R.id.krolik2);
        krolikprawy.setVisibility(View.INVISIBLE);
        guzikprawy.setVisibility(View.INVISIBLE);
        kroliklewy.setVisibility(View.VISIBLE);
        guziklewy.setVisibility(View.VISIBLE);
        wynik++;
    }

    }
