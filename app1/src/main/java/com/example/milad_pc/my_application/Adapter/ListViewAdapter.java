package com.example.milad_pc.my_application.Adapter;

import android.app.Application;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.milad_pc.my_application.R;
import com.example.milad_pc.my_application.objects.ListViewObject;

import java.util.List;

public class ListViewAdapter extends ArrayAdapter<ListViewObject>  {
    List<ListViewObject> objects;

    public ListViewAdapter(@NonNull Context context, int resource, @NonNull List<ListViewObject> objects) {
        super(context, resource, objects);
        this.objects = objects;
    }


    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) com.example.milad_pc.my_application.app.Application.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.layout_listview_row, parent, false);

        ImageView imageView = view.findViewById(R.id.imgView);
        TextView txtName    = view.findViewById(R.id.txtName);
        TextView txtDesc    = view.findViewById(R.id.txtDesc);

        txtName.setText(objects.get(position).getName());
        txtDesc.setText(objects.get(position).getDescription());
        imageView.setImageResource(objects.get(position).getImageResId());
        return view;
    }


}
