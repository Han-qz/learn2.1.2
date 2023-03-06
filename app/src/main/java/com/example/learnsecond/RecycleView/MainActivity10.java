package com.example.learnsecond.RecycleView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.learnsecond.R;

public class MainActivity10 extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private RecyclerView.Adapter<MyAdapter.ViewHolder> adapter;
    private ItemObject[] mMyDataset = new ItemObject[100];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main10);

        recyclerView = (RecyclerView) findViewById(R.id.recycleView);
        //如果一直内容的变化不会改变RecyclerView的布局大小,则使用这个设置来提高性能
        recyclerView.setHasFixedSize(true);
        //设置布局管理器
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        //数组初始化
        for (int i = 0; i < 100; i++) {
            ItemObject itemObject = new ItemObject();
            itemObject.setText1("item" + i + "_Text1");
            itemObject.setText2("item" + i + "_Text2");
            mMyDataset[i] = itemObject;
        }
        //设置Adapter
        adapter = new MyAdapter(mMyDataset);
        recyclerView.setAdapter(adapter);
    }
}