package com.example.learnsecond.ImageSwitcher;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;
import android.widget.ViewSwitcher;

import com.example.learnsecond.R;

public class MainActivity3 extends AppCompatActivity implements ViewSwitcher.ViewFactory {

    private LinearLayout mLinearLayout;
    private ImageSwitcher mImageSwitcher;

    private Integer[] mSmallImages = {
            R.drawable.android1,R.drawable.android2,R.drawable.android3,R.drawable.android4,
            R.drawable.android5,R.drawable.android6,R.drawable.android7,R.drawable.android8,
            R.drawable.android9,R.drawable.android10,R.drawable.android11,R.drawable.android12};

    private Integer[] mImages = {
            R.drawable.android_1,R.drawable.android_2,R.drawable.android_3,R.drawable.android_4,
            R.drawable.android_5,R.drawable.android_6,R.drawable.android_7,R.drawable.android_8,
            R.drawable.android_9,R.drawable.android_10,R.drawable.android_11,R.drawable.android_12};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        mImageSwitcher = (ImageSwitcher) findViewById(R.id.imageSwitcher);
        mImageSwitcher.setFactory(this);
        mImageSwitcher.setInAnimation(AnimationUtils.loadAnimation(this, android.R.anim.fade_in));
        mImageSwitcher.setOutAnimation(AnimationUtils.loadAnimation(this, android.R.anim.fade_out));
        mImageSwitcher.setImageResource(mImages[0]);

        mLinearLayout = (LinearLayout) findViewById(R.id.linearLayout);
        for (int i = 0; i < mSmallImages.length; i++) {
            mLinearLayout.addView(getImageView(i));
        }
    }

    private ImageView getImageView(int i){
        ImageView imageView = new ImageView(this);
        imageView.setImageResource(mSmallImages[i]);
        imageView.setId(i);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mImageSwitcher.setImageResource(mImages[view.getId()]);
                int a = (int) view.getId()+1;
                Toast.makeText(view.getContext(),"您选择了第" + a + "张图",Toast.LENGTH_SHORT).show();
            }
        });
        return imageView;
    }

    @Override
    public View makeView() {
        ImageView imageView = new ImageView(this);
        return imageView;
    }
}