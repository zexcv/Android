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
import android.view.View;
import org.w3c.dom.Text;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

public class gra extends AppCompatActivity {

    TextView textView;
    TextView zegarek;
    double wynik = 0;

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

        public void addpoints(View view){
        wynik++;
        }

    }
