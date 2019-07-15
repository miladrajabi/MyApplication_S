package com.example.myapplication.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.myapplication.R;
import com.example.myapplication.app.Application;
import com.example.myapplication.objects.CustomListViewObject;

import java.util.List;

public class CustomListViewAdapter extends ArrayAdapter<CustomListViewObject> {


    List<CustomListViewObject> objects;

    public CustomListViewAdapter(Context context, int resource, List<CustomListViewObject> objects) {
        super(context, resource, objects);
        this.objects = objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) Application.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View view = inflater.inflate(R.layout.layout_clv_row, parent, false);

        ImageView imgView = view.findViewById(R.id.imgView);
        TextView name = view.findViewById(R.id.name);
        TextView desc = view.findViewById(R.id.desc);

        name.setText(objects.get(position).getName());
        desc.setText(objects.get(position).getDesc());
        imgView.setImageResource(objects.get(position).getImageResId());

        return view;

    }
}
