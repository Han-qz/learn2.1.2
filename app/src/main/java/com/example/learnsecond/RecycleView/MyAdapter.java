package com.example.learnsecond.RecycleView;

import android.text.InputFilter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.learnsecond.R;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

    private ItemObject[] mDataSet;

    public static class ViewHolder extends RecyclerView.ViewHolder{

        public TextView textView1;
        public TextView textView2;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textView1 = (TextView) itemView.findViewById(R.id.textView1);
            textView2 = (TextView) itemView.findViewById(R.id.textView2);
        }
    }

    public MyAdapter(ItemObject[] myDataSet){
        mDataSet = myDataSet;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item,parent,false);
        ViewHolder viewHolder = new ViewHolder(itemView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.textView1.setText(mDataSet[position].getText1());
        holder.textView2.setText(mDataSet[position].getText2());
    }

    @Override
    public int getItemCount() {
        return mDataSet.length;
    }
}
