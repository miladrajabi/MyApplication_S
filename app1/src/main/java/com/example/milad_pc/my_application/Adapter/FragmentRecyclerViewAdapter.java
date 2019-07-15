package com.example.milad_pc.my_application.Adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.milad_pc.my_application.R;
import com.example.milad_pc.my_application.app.Application;
import com.example.milad_pc.my_application.objects.ChatPageObject;

import java.util.List;

public class FragmentRecyclerViewAdapter extends RecyclerView.Adapter<FragmentRecyclerViewAdapter.chatPageViewHolder> {
    List<ChatPageObject> objects;

    public FragmentRecyclerViewAdapter(List<ChatPageObject> objects) {
        this.objects = objects;
    }

    public FragmentRecyclerViewAdapter() {
    }

    @NonNull
    @Override
    public chatPageViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(Application.getContext()).inflate(R.layout.layout_chatpage_row_me, viewGroup, false);
        return new chatPageViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull chatPageViewHolder chatPageViewHolder, int i) {

        chatPageViewHolder.message.setText(objects.get(i).getMessage());
    }

    @Override
    public int getItemCount() {
        return objects.size();
    }

    public class chatPageViewHolder extends RecyclerView.ViewHolder {

        TextView message;

        public chatPageViewHolder(@NonNull View itemView) {
            super(itemView);
            message = itemView.findViewById(R.id.chatMessage);
        }
    }
}
