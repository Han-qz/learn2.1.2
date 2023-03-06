package com.example.learnsecond.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;

import com.example.learnsecond.R;

public class MainActivity2 extends AppCompatActivity implements SeekBar.OnSeekBarChangeListener {

    private ImageView mImageView;
    private TextView mTextView1;
    private SeekBar mSeekBar1;
    private TextView mTextView2;
    private SeekBar mSeekBar2;
    private final  static int MIN_WIDTH = 200;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

       findViewsById();
       setListener();
        setMaxValueForSeekBar1();

    }

    private void findViewsById(){
        mImageView = (ImageView) findViewById(R.id.imageview);
        mTextView1 = (TextView) findViewById(R.id.textview1);
        mSeekBar1 = (SeekBar) findViewById(R.id.seekbar1);
        mTextView2 = (TextView) findViewById(R.id.textview2);
        mSeekBar2 = (SeekBar) findViewById(R.id.seekbar2);
    }

    private void setListener(){
        mSeekBar1.setOnSeekBarChangeListener(this);
        mSeekBar2.setOnSeekBarChangeListener(this);
    }

    private void setMaxValueForSeekBar1(){
        DisplayMetrics dmDisplayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getRealMetrics(dmDisplayMetrics);
        mSeekBar1.setMax(dmDisplayMetrics.widthPixels - MIN_WIDTH);
    }


    @Override
    public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
        if (seekBar.getId() == R.id.seekbar1){
            int newWidth = i + MIN_WIDTH;
            int newHeight = (int) newWidth;
            mImageView.setLayoutParams(new LinearLayout.LayoutParams(newHeight,newHeight));
            mTextView1.setText(getResources().getString(R.string.image_width) + newWidth + " "
            +getResources().getString(R.string.image_height) + newHeight);
        } else if (seekBar.getId() == R.id.seekbar2) {
            Bitmap bitmap = ((BitmapDrawable) getResources().getDrawable(R.drawable.rabbit)).getBitmap();
            Matrix matrix = new Matrix();
            matrix.setRotate(i);
            bitmap = Bitmap.createBitmap(bitmap,0,0,bitmap.getWidth(),bitmap.getHeight(),matrix,true);
            mImageView.setImageBitmap(bitmap);
            mTextView2.setText(getResources().getString(R.string.rotate_degree) + i);
        }
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }
}