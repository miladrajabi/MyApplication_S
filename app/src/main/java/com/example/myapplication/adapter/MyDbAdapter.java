package com.example.myapplication.adapter;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.myapplication.Episodes.SQliteUpdateActivity;
import com.example.myapplication.R;
import com.example.myapplication.app.Application;
import com.example.myapplication.app.app;
import com.example.myapplication.app.db;
import com.example.myapplication.app.dbConnector;
import com.example.myapplication.objects.MyDbObject;

import java.util.List;

public class MyDbAdapter extends RecyclerView.Adapter<MyDbAdapter.MyViewHolder> {
    List<MyDbObject> objects;
    Activity activity;
    dbConnector dbConnector;

    public MyDbAdapter(Activity activity, List<MyDbObject> objects, dbConnector dbConnector) {
        this.objects = objects;
        this.activity = activity;
        this.dbConnector = dbConnector;


    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(activity).inflate(R.layout.layout_mydb_row, viewGroup, false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {

        MyDbObject object = objects.get(i);
        myViewHolder.txtFname.setText(object.getName());
        myViewHolder.txtMsg.setText(object.getMessage());
        myViewHolder.txtNumber.setText(object.getName().substring(0, 1).toUpperCase());

        if (object.getSeen() == 0) {
            myViewHolder.imgSeen.setImageResource(R.drawable.ic_remove_red_eye_black_24dp);
            myViewHolder.imgSeen.setColorFilter(Color.BLACK);
        } else {
            myViewHolder.imgSeen.setImageResource(R.drawable.ic_check_black_24dp);
            myViewHolder.imgSeen.setColorFilter(Color.RED);
        }
    }

    @Override
    public int getItemCount() {
        return objects.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener, View.OnLongClickListener {

        TextView txtNumber, txtFname, txtMsg;
        AppCompatImageView imgSeen;
        RelativeLayout mydbParent;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            txtNumber = itemView.findViewById(R.id.txtNumber);
            txtFname = itemView.findViewById(R.id.txtFname);
            txtMsg = itemView.findViewById(R.id.txtMsg);
            imgSeen = itemView.findViewById(R.id.imgSeen);
            mydbParent = itemView.findViewById(R.id.mydbParent);

            imgSeen.setOnClickListener(this);
            mydbParent.setOnClickListener(this);
            mydbParent.setOnLongClickListener(this);
        }

        @Override
        public void onClick(View v) {

            MyDbObject obj = objects.get(getAdapterPosition());

            if (v == mydbParent) {
                Intent intent = new Intent(activity, SQliteUpdateActivity.class);
                intent.putExtra(db.tbNotes.ID, obj.getId());
                activity.startActivity(intent);
                return;
            } else {

                int seenValue = obj.getSeen();
                seenValue = seenValue == 0 ? 1 : 0;

                if (seenValue == 0) {
                    imgSeen.setImageResource(R.drawable.ic_remove_red_eye_black_24dp);
                    imgSeen.setColorFilter(Color.BLACK);
                } else {
                    imgSeen.setImageResource(R.drawable.ic_check_black_24dp);
                    imgSeen.setColorFilter(Color.RED);
                }
                obj.setSeen(seenValue);
                objects.set(getAdapterPosition(), obj);

                // dbConnector.get().execSQL("UPDATE " + db.tables.tbNotes + " SET " + db.tbNotes.SEEN + "=" + seenValue + " Where " + db.tbNotes.ID + " = " + obj.getId());

                String where = db.tbNotes.ID + " = " + obj.getId();
                ContentValues values = new ContentValues();
                values.put(db.tbNotes.SEEN, seenValue);

                dbConnector.get().update(db.tables.tbNotes, values, where, null);
            }

        }

        @Override
        public boolean onLongClick(View v) {
            app.toas("Long click");
            return true;
        }
    }
}
