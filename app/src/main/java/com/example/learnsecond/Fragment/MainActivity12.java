package com.example.learnsecond.Fragment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.learnsecond.R;


//1、定义布局文件
//2、定义fragment的添加和删除
public class MainActivity12 extends AppCompatActivity{

    private FragmentManager fragmentManager;
    private Button button_add;
    private Button button_remove;
    private Fragment fragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main12);

        fragmentManager = getSupportFragmentManager();
        button_add = (Button) findViewById(R.id.add_f);
        button_remove = (Button) findViewById(R.id.remove_f);
        //为两个Button分别设置点击事件监听器
        button_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               addFragment();
            }
        });
        button_remove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                removeFragment();
            }
        });
    }

    //添加Fragment
    private  void addFragment(){
        //添加一个fragment时，首先要new一个fragment，所以要首先定义一个fragment
        //因此新建一个MyFragment类继承Fragment类
        fragment = new MyFragment();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        //标准动画，用setTransition API
        //fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_CLOSE);
        //自定义动画,用setCustomAnimations API
        fragmentTransaction.setCustomAnimations(R.anim.enter,R.anim.exit,R.anim.pop_enter,R.anim.pop_exit);

        fragmentTransaction.add(R.id.container,fragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

    //删除Fragment
    private void removeFragment(){
        fragmentManager.popBackStack();
    }


}