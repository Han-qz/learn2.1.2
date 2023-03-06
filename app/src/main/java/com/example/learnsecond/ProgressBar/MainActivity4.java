package com.example.learnsecond.ProgressBar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

import com.example.learnsecond.R;

public class MainActivity4 extends AppCompatActivity implements View.OnClickListener {

    private ProgressBar progressBarHorizontal;
    private Button button1;
    private Button button2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        progressBarHorizontal = (ProgressBar) findViewById(R.id.horizontal_progressbar);
        button1 = (Button) findViewById(R.id.button1);
        button2 = (Button) findViewById(R.id.button2);

        button1.setOnClickListener(this);
        button2.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button1:
                progressBarHorizontal.incrementProgressBy(10);
                progressBarHorizontal.incrementSecondaryProgressBy(10);
                break;
            case R.id.button2:
                progressBarHorizontal.incrementProgressBy(-10);
                progressBarHorizontal.incrementSecondaryProgressBy(-10);
                break;
            default:
                break;
        }
    }
}