package com.example.aplikacjazaliczenie;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;

public class gra extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gra);

        TextView textView = (TextView)findViewById(R.id.tutorial);
        textView.startAnimation(AnimationUtils.loadAnimation(gra.this,R.anim.pulse));
    }

}