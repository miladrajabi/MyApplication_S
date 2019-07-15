package com.example.myapplication.Episodes;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.myapplication.R;
import com.example.myapplication.adapter.CustomListViewAdapter;
import com.example.myapplication.app.app;
import com.example.myapplication.objects.CustomListViewObject;

import java.util.ArrayList;
import java.util.List;

public class CustomListViewActivity extends AppCompatActivity implements AdapterView.OnItemClickListener, AdapterView.OnItemLongClickListener {

    ListView lstMovie;
    List<CustomListViewObject> list;
    CustomListViewAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_list_view);
        setTitle(this.getClass().getSimpleName());

        init();
    }

    private void init() {
        lstMovie = findViewById(R.id.lstMovie);
        list = prepareData();
        adapter = new CustomListViewAdapter(this, 0, list);
        lstMovie.setAdapter(adapter);
        lstMovie.setOnItemClickListener(this);
        lstMovie.setOnItemLongClickListener(this);
    }

    private List<CustomListViewObject> prepareData() {

        List<CustomListViewObject> list = new ArrayList<>();

        CustomListViewObject object = new CustomListViewObject();
        object.setName(getString(R.string.Pledge));
        object.setDesc(getString(R.string.Pledge_desc));
        object.setImageResId(R.drawable.pledge);

        list.add(object);

        object = new CustomListViewObject();
        object.setName(getString(R.string.DogsWayHome));
        object.setDesc(getString(R.string.DogsWayHome_desc));
        object.setImageResId(R.drawable.dogswayhome);

        list.add(object);

        object = new CustomListViewObject();
        object.setName(getString(R.string.Highwaymen));
        object.setDesc(getString(R.string.Highwaymen_desc));
        object.setImageResId(R.drawable.highwaymen);

        list.add(object);

        object = new CustomListViewObject();
        object.setName(getString(R.string.WhiteChamber));
        object.setDesc(getString(R.string.WhiteChamber_desc));
        object.setImageResId(R.drawable.whitechamber);

        list.add(object);
        return list;

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        app.toas(list.get(position).getName());

    }

    @Override
    public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {

        app.toas(list.get(position).getName() + " Removed !");
        list.remove(position);
        adapter.notifyDataSetChanged();
        return true;
    }
}
