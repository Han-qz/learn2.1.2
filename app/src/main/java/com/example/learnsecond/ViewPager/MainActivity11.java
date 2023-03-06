package com.example.learnsecond.ViewPager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

import com.example.learnsecond.R;

import java.util.ArrayList;

//ViewPager使用要点
//1、定义ViewPager的布局文件
//2、定义每个页面的布局文件
//3、将所有页面添加到ViewPager中
//4、继承PageAdapter
public class MainActivity11 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main11);

        //拿到解析布局文件的类
        LayoutInflater layoutInflater = LayoutInflater.from(this);
        //分别解析每个布局文件
        @SuppressLint("InflateParams") View view1 = layoutInflater.inflate(R.layout.view1,null);
        @SuppressLint("InflateParams") View view2 = layoutInflater.inflate(R.layout.view2,null);
        @SuppressLint("InflateParams") View view3 = layoutInflater.inflate(R.layout.view3,null);
        @SuppressLint("InflateParams") View view4 = layoutInflater.inflate(R.layout.view4,null);
        @SuppressLint("InflateParams") View view5 = layoutInflater.inflate(R.layout.view5,null);
        //将这5个view添加到一个ArrayList中作为Adapter的参数
        ArrayList<View> arrayList = new ArrayList<>();
        arrayList.add(view1);
        arrayList.add(view2);
        arrayList.add(view3);
        arrayList.add(view4);
        arrayList.add(view5);
        //拿到布局文件中定义的ViewPager
        ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager);
        //给ViewPager设置一个Adapter,该Adapter要继承系统提供的ViewAdapter类
        viewPager.setAdapter(new MyViewPagerAdapter(arrayList));
        //给ViewPager设置第一个显示的页面
        viewPager.setCurrentItem(0);
    }
}