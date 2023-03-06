package com.example.learnsecond.GridView;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.SimpleAdapter;

import com.example.learnsecond.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity5 extends AppCompatActivity implements AdapterView.OnItemClickListener {

    private GridView gridView;
    private ImageView imageView;
    private int[] mImageArrays = new int[]{
            R.drawable.android_1,R.drawable.android_2,R.drawable.android_3,R.drawable.android_4,
            R.drawable.android_5,R.drawable.android_6,R.drawable.android_7,R.drawable.android_8,
            R.drawable.android_9,R.drawable.android_10,R.drawable.android_11,R.drawable.android_12
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);

        gridView = (GridView) findViewById(R.id.gridView);
        imageView = (ImageView) findViewById(R.id.imageView);

        List<Map<String,Object>> cells = new ArrayList<Map<String,Object>>();
        for (int i = 0; i < mImageArrays.length; i++) {
            Map<String,Object> cell = new HashMap<String,Object>();
            cell.put("cellImageView",mImageArrays[i]);
            cells.add(cell);
        }

        SimpleAdapter simpleAdapter = new SimpleAdapter(this,cells,R.layout.grid,
                new String[]{"cellImageView"},new int[]{R.id.cellImageView});
        gridView.setAdapter(simpleAdapter);
        gridView.setOnItemClickListener(this);

        imageView.setImageResource(mImageArrays[0]);

    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        imageView.setImageResource(mImageArrays[i]);
    }
}