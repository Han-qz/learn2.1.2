package com.example.learnsecond.ViewPager;

import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import java.util.List;

public class MyViewPagerAdapter extends PagerAdapter {

    //把MainActivity11中定义的ArrayList作为该PagerAdapter的参数
    private List<View> arrayList;

    //在构造方法中把arrayList作为参数
    public MyViewPagerAdapter(List<View> arrayList) {
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    //初始化Item,把arrayList中某个位置（position）的view添加到容器（container）中
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        container.addView(arrayList.get(position), 0);
        return arrayList.get(position);
    }

    @Override
    //销毁Item,把view从容器（container）中移除
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView(arrayList.get(position));
    }

    @Override
    //得到arrayList中所有的数量
    public int getCount() {
        return arrayList.size();
    }

    @Override
    //得到的对象是不是View
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }
}
