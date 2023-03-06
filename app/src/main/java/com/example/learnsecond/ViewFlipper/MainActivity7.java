package com.example.learnsecond.ViewFlipper;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.ViewFlipper;

import com.example.learnsecond.R;

public class MainActivity7 extends AppCompatActivity implements View.OnTouchListener {

    private ViewFlipper viewFlipper;
    private float mTouchDownX;
    private float mTouchUpX;
    private GestureDetector gestureDetector;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main7);
        viewFlipper = (ViewFlipper) findViewById(R.id.viewFlipper);

        viewFlipper.setOnTouchListener(this);

        gestureDetector = new GestureDetector(this, new MySimpleOnGestureListener());

        //自动切换
//        viewFlipper.setAutoStart(true);
//        viewFlipper.setFlipInterval(2000);
    }

    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        gestureDetector.onTouchEvent(motionEvent);
        return true;
//        //方法一
//        //当手指在屏幕上按下时
//        if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
//            //取得左右滑动时手指按下的X坐标
//            mTouchDownX = motionEvent.getX();
//            return true;
//            //当手指在屏幕上松开时
//        } else if (motionEvent.getAction() == MotionEvent.ACTION_UP) {
//            //取得左右滑动时手指松开的X坐标
//            mTouchUpX = motionEvent.getX();
//            //手指右滑，切换到上一个view
//            if (mTouchUpX - mTouchDownX > 100) {
//                //设置切换时的动画
//                viewFlipper.setInAnimation(AnimationUtils.loadAnimation(this, R.anim.push_right_in));
//                viewFlipper.setOutAnimation(AnimationUtils.loadAnimation(this, R.anim.push_right_out));
//                viewFlipper.showPrevious();
//                //手指左滑，切换到下一个view
//            } else if (mTouchDownX - mTouchUpX > 100) {
//                viewFlipper.setInAnimation(AnimationUtils.loadAnimation(this, R.anim.push_left_in));
//                viewFlipper.setOutAnimation(AnimationUtils.loadAnimation(this, R.anim.push_left_out));
//                viewFlipper.showNext();
//            }
//            return true;
//        }
//        return false;
    }

    //定义一个内部类
    class MySimpleOnGestureListener extends GestureDetector.SimpleOnGestureListener {
        @Override
        public boolean onFling(@NonNull MotionEvent e1, @NonNull MotionEvent e2, float velocityX, float velocityY) {
            if (e2.getX() - e1.getX() > 100) {
                //设置切换时的动画
                viewFlipper.setInAnimation(AnimationUtils.loadAnimation(MainActivity7.this, R.anim.push_right_in));
                viewFlipper.setOutAnimation(AnimationUtils.loadAnimation(MainActivity7.this, R.anim.push_right_out));
                viewFlipper.showPrevious();
            } else if (e1.getX() - e2.getX() > 100) {
                viewFlipper.setInAnimation(AnimationUtils.loadAnimation(MainActivity7.this, R.anim.push_left_in));
                viewFlipper.setOutAnimation(AnimationUtils.loadAnimation(MainActivity7.this, R.anim.push_left_out));
                viewFlipper.showNext();
            }

            return true;
        }
    }
}