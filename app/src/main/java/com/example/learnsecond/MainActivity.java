package com.example.learnsecond;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import com.example.learnsecond.ActionBar.MainActivity8;
import com.example.learnsecond.CardView.MainActivity6;
import com.example.learnsecond.DrawerLayout.MainActivity13;
import com.example.learnsecond.Fragment.MainActivity12;
import com.example.learnsecond.GridView.MainActivity5;
import com.example.learnsecond.ImageView.MainActivity2;
import com.example.learnsecond.ImageSwitcher.MainActivity3;
import com.example.learnsecond.ProgressBar.MainActivity4;
import com.example.learnsecond.RecycleView.MainActivity10;
import com.example.learnsecond.SwipeRefreshLayout.MainActivity1;
import com.example.learnsecond.ViewFlipper.MainActivity7;
import com.example.learnsecond.ViewPager.MainActivity11;
import com.example.learnsecond.WebView.MainActivity9;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Button button1 = (Button) findViewById(R.id.bt1);
        Button button2 = (Button) findViewById(R.id.bt2);
        Button button3 = (Button) findViewById(R.id.bt3);
        Button button4 = (Button) findViewById(R.id.bt4);
        Button button5 = (Button) findViewById(R.id.bt5);
        Button button6 = (Button) findViewById(R.id.bt6);
        Button button7 = (Button) findViewById(R.id.bt7);
        Button button8 = (Button) findViewById(R.id.bt8);
        Button button9 = (Button) findViewById(R.id.bt9);
        Button button10 = (Button) findViewById(R.id.bt10);
        Button button11 = (Button) findViewById(R.id.bt11);
        Button button12 = (Button) findViewById(R.id.bt12);
        Button button13 = (Button) findViewById(R.id.bt13);

        button1.setOnClickListener(v -> {
            Intent intent=new Intent(MainActivity.this, MainActivity1.class);
            startActivity(intent);
        });
        button2.setOnClickListener(v -> {
            Intent intent=new Intent(MainActivity.this, MainActivity2.class);
            startActivity(intent);
        });
        button3.setOnClickListener(v -> {
            Intent intent=new Intent(MainActivity.this, MainActivity3.class);
            startActivity(intent);
        });
        button4.setOnClickListener(v -> {
            Intent intent=new Intent(MainActivity.this, MainActivity4.class);
            startActivity(intent);
        });
        button5.setOnClickListener(v -> {
            Intent intent=new Intent(MainActivity.this, MainActivity5.class);
            startActivity(intent);
        });
        button6.setOnClickListener(v -> {
            Intent intent=new Intent(MainActivity.this, MainActivity6.class);
            startActivity(intent);
        });
        button7.setOnClickListener(v -> {
            Intent intent=new Intent(MainActivity.this, MainActivity7.class);
            startActivity(intent);
        });
        button8.setOnClickListener(v -> {
            Intent intent=new Intent(MainActivity.this, MainActivity8.class);
            startActivity(intent);
        });
        button9.setOnClickListener(v -> {
            Intent intent=new Intent(MainActivity.this, MainActivity9.class);
            startActivity(intent);
        });
        button10.setOnClickListener(v -> {
            Intent intent=new Intent(MainActivity.this, MainActivity10.class);
            startActivity(intent);
        });
        button11.setOnClickListener(v -> {
            Intent intent=new Intent(MainActivity.this, MainActivity11.class);
            startActivity(intent);
        });
        button12.setOnClickListener(v -> {
            Intent intent=new Intent(MainActivity.this, MainActivity12.class);
            startActivity(intent);
        });
        button13.setOnClickListener(v -> {
            Intent intent=new Intent(MainActivity.this, MainActivity13.class);
            startActivity(intent);
        });

    }
}