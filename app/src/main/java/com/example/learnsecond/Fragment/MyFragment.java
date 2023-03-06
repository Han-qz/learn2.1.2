package com.example.learnsecond.Fragment;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.learnsecond.R;

public class MyFragment extends Fragment {
    //在该类中主要重写onCreate和onCreateView这两个方法

    //为了能够对添加的fragment进行计数，我们定义了一个计数器
    private static int COUNT = 0;
    private int mId = 0;
    //为了能够对添加的fragment进行颜色区分，我们定义了一个颜色数组
    private final int[] mColors = new int[]{Color.RED, Color.BLUE, Color.YELLOW, Color.GRAY, Color.LTGRAY};

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ++COUNT;
        mId = COUNT;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //解析fragment布局文件
        View view = inflater.inflate(R.layout.myfragment, container, false);
        //拿到TextView
        TextView textView = (TextView) view.findViewById(R.id.tv);
        //给TestView设置文本和背景颜色（从数组中取出，循环利用数组中所有的颜色）
        textView.setText("This is Fragment No." + mId);
        textView.setBackgroundColor(mColors[mId % mColors.length]);
        return view;
    }
}
