package com.example.myapplication.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.myapplication.R;
import com.example.myapplication.app.Application;
import com.example.myapplication.objects.RclObject;

import java.util.List;

import io.supercharge.shimmerlayout.ShimmerLayout;

public class RclAdapter extends RecyclerView.Adapter<RclAdapter.MyViewHolder> {


    List<RclObject> objects;

    public RclAdapter(List<RclObject> list) {

        this.objects = list;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view = LayoutInflater.from(Application.getContext()).inflate(R.layout.layout_rclview_row, viewGroup, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {

        RclObject object = objects.get(i);
        myViewHolder.txtSongName.setText(object.getSongName());
        myViewHolder.txtSinger.setText(object.getSingerName());
        myViewHolder.txtSongView.setText(object.getSongView() + "");
        myViewHolder.txtSongLike.setText(object.getSongLike() + "");
        myViewHolder.txtSongDate.setText(object.getSongDate());
        myViewHolder.txtSongComment.setText(object.getSongComment() + "");
        myViewHolder.imgSong.setImageResource(object.getSongImage());

    }

    @Override
    public int getItemCount() {
        return objects.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView txtSongName, txtSinger, txtSongView, txtSongLike, txtSongDate, txtSongComment;
        ImageView imgSong;
        ShimmerLayout shimmerLayout;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            txtSongName = itemView.findViewById(R.id.txtSongName);
            txtSinger = itemView.findViewById(R.id.txtSinger);
            txtSongView = itemView.findViewById(R.id.txtSongView);
            txtSongLike = itemView.findViewById(R.id.txtSongLike);
            txtSongDate = itemView.findViewById(R.id.txtSongDate);
            txtSongComment = itemView.findViewById(R.id.txtSongComment);
            imgSong = itemView.findViewById(R.id.imgSong);
            shimmerLayout = itemView.findViewById(R.id.shimmerLayout);
            shimmerLayout.startShimmerAnimation();
        }
    }
}
