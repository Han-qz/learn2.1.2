package com.example.learnsecond.ActionBar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.learnsecond.R;

public class MainActivity8 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main8);

        //显示并设置actionbar图标
        ActionBar supportActionBar = getSupportActionBar();
        supportActionBar.setDisplayShowHomeEnabled(true);
        supportActionBar.setIcon(R.drawable.rabbit);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.actionitem_add:
                Toast.makeText(this, "添加", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.actionitem_delete:
                Toast.makeText(this, "删除", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.actionitem_email:
                Toast.makeText(this, "发送邮件", Toast.LENGTH_SHORT).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.actionitems,menu);
        return super.onCreateOptionsMenu(menu);
    }
}