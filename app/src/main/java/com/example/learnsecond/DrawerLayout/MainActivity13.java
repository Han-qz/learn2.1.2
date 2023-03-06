package com.example.learnsecond.DrawerLayout;

import static androidx.constraintlayout.widget.ConstraintLayoutStates.TAG;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.example.learnsecond.R;

//使用要点
//1.创建Drawer布局文件
//2、初始化Drawer列表
//3、响应Drawer列表的点击事件
public class MainActivity13 extends AppCompatActivity {
    private DrawerLayout drawerLayout;
    private ListView mDrawerList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main13);

        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mDrawerList = (ListView) findViewById(R.id.left_drawer);
        String[] mItemArray = getResources().getStringArray(R.array.item_array);
        //给drawerLayout设置初始化数据
        mDrawerList.setAdapter(new ArrayAdapter<>(this, R.layout.drawer_list_item, mItemArray));
        //设置item点击事件
        mDrawerList.setOnItemClickListener(new DrawerItemClickListener());
    }

    private class DrawerItemClickListener implements ListView.OnItemClickListener {
        @Override
        public void onItemClick(AdapterView adapterView, View view, int i, long l) {
            selectItem(i);
        }
    }

    private void selectItem(int position) {
        //当点击某个item时，就要先生成一个fragment，并把该fragment作为当前可见的fragment
        //并且将这个fragment中textview的文本设置为drawerList中选中的那个item的文本并且将drawerList关闭
        Fragment fragment = new MyFragment();
        //定义一个Bundle把当前的编号传进去作为fragment的一个参数
        Bundle args = new Bundle();
        args.putInt(MyFragment.ITEM_NUMBER_STRING, position);
        fragment.setArguments(args);
        //把当前这个fragment作为当前可视的fragment替换之前的fragment
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.content_frame, fragment).commit();
        mDrawerList.setItemChecked(position, true);
        //将drawerList关闭
        drawerLayout.closeDrawer(mDrawerList);
    }

    //1、自定义一个fragment
    public static class MyFragment extends Fragment {
        //定义一个字符串常量
        public static final String ITEM_NUMBER_STRING = "item_number";
        public MyFragment() {

        }

        //重写onCreateView方法
        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            //解析fragment对应的布局文件
            View rootView = inflater.inflate(R.layout.fragment_item, container, false);
            //得到当前选中的是第几个item
            assert getArguments() != null;
            int i = getArguments().getInt(ITEM_NUMBER_STRING);
            //得到第几个item的字符串
            String itemName = getResources().getStringArray(R.array.item_array)[i];
            Log.d(TAG, "onCreateView: " + itemName);
            //给textView设置文本
            ((TextView) (rootView.findViewById(R.id.tv111))).setText(itemName);
            return rootView;
        }
    }
}