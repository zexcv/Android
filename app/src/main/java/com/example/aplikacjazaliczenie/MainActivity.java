package com.example.aplikacjazaliczenie;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button button;



    public void settings(View view){
        Intent intent = new Intent(MainActivity.this, difficulty.class);
        startActivity(intent);
    }

    public void start_game(View view){
        Intent intent = new Intent(MainActivity.this, gra.class);
        startActivity(intent);
    }
    

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ddiff();

        }

    private void ddiff() {
        global global = new global();
        global.setDlevel(2);
    }

}


