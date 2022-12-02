package com.example.bada1.recyclerview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.bada1.R;
import com.example.bada1.modelClass.User;

import java.util.ArrayList;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.CustomViewHolder> {

    private ArrayList<User> arrayList;
    private Context context;

    public CustomAdapter(ArrayList<User> arrayList, Context context) {
        this.arrayList = arrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);
        CustomViewHolder holder = new CustomViewHolder(view);

        return holder;
    }

    //각 아이템들에 대한 매칭
    @Override
    public void onBindViewHolder(@NonNull CustomViewHolder holder, int position) {
        if (arrayList.get(position).getProfile() ==null){
            holder.iv_profile.setBackgroundResource(R.drawable.luny);
        }else{
            Glide.with(holder.itemView)
                    .load(arrayList.get(position).getProfile())
                    .into(holder.iv_profile);
        }


        holder.tv_id.setText(arrayList.get(position).getEmailId());
        holder.tv_location.setText(arrayList.get(position).getLocation());
        holder.tv_topic.setText(arrayList.get(position).getTopic());


    }

    @Override
    public int getItemCount() {
        //삼항 연산자
        return (arrayList != null ? arrayList.size() : 0);
    }

    public class CustomViewHolder extends RecyclerView.ViewHolder {
        ImageView iv_profile;
        TextView tv_id;
        TextView tv_location;
        TextView tv_topic;

        public CustomViewHolder(@NonNull View itemView) {
            super(itemView);
            this.iv_profile = itemView.findViewById(R.id.iv_profile);
            this.tv_id = itemView.findViewById(R.id.tv_id);
            this.tv_location = itemView.findViewById(R.id.tv_location);
            this.tv_topic = itemView.findViewById(R.id.tv_topic);
        }
    }
}