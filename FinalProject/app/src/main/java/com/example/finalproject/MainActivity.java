package com.example.finalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.example.day4app.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Handler h = new Handler(getMainLooper());
        h.postDelayed(new Runnable() {
            @Override
            public void run() {


                Intent k = new Intent(MainActivity.this, MainPage.class);
                startActivity(k);
            }
        }, 3000);
    }
}