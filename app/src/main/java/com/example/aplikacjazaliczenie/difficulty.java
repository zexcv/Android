package com.example.aplikacjazaliczenie;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;
import android.view.View;
import android.widget.Button;

public class difficulty extends AppCompatActivity {
    private Button button;

   public void set_easy(View view){
        global global = new global();
        global.setDlevel(3);
        Intent intent = new Intent(difficulty.this, MainActivity.class);
        startActivity(intent);
    }
    public void set_medium(View view){
       global global = new global();
       global.setDlevel(2);
       Intent intent = new Intent(difficulty.this, MainActivity.class);
       startActivity(intent);
    }
    public void set_hard(View view){
       global global = new global();
       global.setDlevel(1);
       Intent intent = new Intent(difficulty.this, MainActivity.class);
       startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_difficulty);

    }


}