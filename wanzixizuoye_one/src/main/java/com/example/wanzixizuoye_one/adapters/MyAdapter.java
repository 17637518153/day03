package com.example.wanzixizuoye_one.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.wanzixizuoye_one.R;
import com.example.wanzixizuoye_one.beans.DataBean;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context context;
    private List<DataBean> foodlist;

    public MyAdapter(Context context, List<DataBean> foodlist) {
        this.context = context;
        this.foodlist = foodlist;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        if (i == 0) {
            View view = View.inflate(context, R.layout.my_item1_layout, null);
            return new ViewHolder1(view);
        } else {
            View view = View.inflate(context, R.layout.my_item2_layout, null);
            return new ViewHolder2(view);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, final int i) {
        int type = getItemViewType(i);
        if (type == 0) {
            ViewHolder1 holder1 = (ViewHolder1) viewHolder;
            holder1.myTitle1.setText(foodlist.get(i).getTitle());
            holder1.myFoot_str1.setText(foodlist.get(i).getFood_str());
            Glide.with(context).load(foodlist.get(i).getPic()).into(holder1.myImg1);
        } else {
            ViewHolder2 holder2 = (ViewHolder2) viewHolder;
            holder2.myTitle2.setText(foodlist.get(i).getTitle());
            holder2.myFoot_str2.setText(foodlist.get(i).getFood_str());
            Glide.with(context).load(foodlist.get(i).getPic()).into(holder2.myImg2);
        }
        viewHolder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                onItemLongClickListener.OnItemLongClick(i);
                return false;
            }
        });
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onItemLongClickListener.OnItemClick(i);
            }
        });
    }

    @Override
    public int getItemCount() {
        return foodlist.size();
    }

    @Override
    public int getItemViewType(int position) {
        if (position % 2 == 0) {
            return 0;
        } else {
            return 1;
        }
    }

    class ViewHolder1 extends RecyclerView.ViewHolder {
        ImageView myImg1;
        TextView myTitle1;
        TextView myFoot_str1;
        public ViewHolder1(@NonNull View itemView) {
            super(itemView);
            myTitle1 = itemView.findViewById(R.id.myTitle1);
            myFoot_str1 = itemView.findViewById(R.id.myFood_str1);
            myImg1 = itemView.findViewById(R.id.myImg1);
        }
    }

    class ViewHolder2 extends RecyclerView.ViewHolder {
        ImageView myImg2;
        TextView myTitle2;
        TextView myFoot_str2;
        public ViewHolder2(@NonNull View itemView) {
            super(itemView);

            myTitle2 = itemView.findViewById(R.id.myTitle2);
            myFoot_str2 = itemView.findViewById(R.id.myFood_str2);
            myImg2 = itemView.findViewById(R.id.myImg2);
        }
    }

    public void setOnItemLongClickListener(OnItemLongClickListener onItemLongClickListener) {
        this.onItemLongClickListener = onItemLongClickListener;
    }

    public OnItemLongClickListener onItemLongClickListener;
    public interface OnItemLongClickListener{
        void OnItemLongClick(int i);
        void OnItemClick(int i);
    }
}
