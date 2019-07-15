package com.example.myapplication.adapter;

import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.myapplication.R;
import com.example.myapplication.app.Application;
import com.example.myapplication.objects.ChatFragmentObject;

import java.util.List;

public class ChatFragmentAdapter extends RecyclerView.Adapter<ChatFragmentAdapter.MyViewHolder> {

    List<ChatFragmentObject> objects;

    public ChatFragmentAdapter(List<ChatFragmentObject> objects) {
        this.objects = objects;
    }

    @NonNull
    @Override
    public ChatFragmentAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(Application.getContext()).inflate(R.layout.layout_chat_row_me, viewGroup, false);
        return new ChatFragmentAdapter.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ChatFragmentAdapter.MyViewHolder myViewHolder, int i) {
        myViewHolder.msg.setText(objects.get(i).getMessage());
        myViewHolder.txtTime.setText(objects.get(i).getDate());
        if (!objects.get(i).getSeen()) {
            myViewHolder.imgSeen.setImageResource(R.drawable.ic_done_black_24dp);
        } else {
            myViewHolder.imgSeen.setImageResource(R.drawable.ic_done_all_black_24dp);
        }

        if (objects.get(i).getMe()) {
            myViewHolder.msg.setTextColor(Color.DKGRAY);
        } else {
            myViewHolder.msg.setTextColor(Color.BLACK);
        }
    }

    @Override
    public int getItemCount() {
        return objects.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView msg, txtTime;
        AppCompatImageView imgSeen;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            msg = itemView.findViewById(R.id.txtMessage);
            txtTime = itemView.findViewById(R.id.txtTime);
            imgSeen = itemView.findViewById(R.id.imgSeen);

        }
    }
}
