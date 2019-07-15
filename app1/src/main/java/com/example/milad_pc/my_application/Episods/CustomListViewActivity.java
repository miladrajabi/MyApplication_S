package com.example.milad_pc.my_application.Episods;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.milad_pc.my_application.Adapter.ListViewAdapter;
import com.example.milad_pc.my_application.R;
import com.example.milad_pc.my_application.app.app;
import com.example.milad_pc.my_application.objects.ListViewObject;

import java.util.ArrayList;
import java.util.List;

public class CustomListViewActivity extends AppCompatActivity implements AdapterView.OnItemClickListener, AdapterView.OnItemLongClickListener {

    ListView lstView;
    List<ListViewObject> list;
    ListViewAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_list_view);
        setTitle(this.getClass().getSimpleName());

        init();

    }

    private void init() {

        lstView = findViewById(R.id.lstView);
        list = prepareData();
        adapter = new ListViewAdapter(this, 0, list);
        lstView.setAdapter(adapter);
        lstView.setOnItemClickListener(this);
        lstView.setOnItemLongClickListener(this);
    }

    private List<ListViewObject> prepareData() {
        List<ListViewObject> list = new ArrayList<>();

        ListViewObject object = new ListViewObject();
        object.setName(getString(R.string.devils_men));
        object.setDescription(getString(R.string.devils_men_desc));
        object.setImageResId(R.drawable.devils_men);
        list.add(object);

        object = new ListViewObject();
        object.setName(getString(R.string.last_laugh));
        object.setDescription(getString(R.string.last_laugh_desc));
        object.setImageResId(R.drawable.last_laugh);
        list.add(object);

        object = new ListViewObject();
        object.setName(getString(R.string.norm));
        object.setDescription(getString(R.string.norm_desc));
        object.setImageResId(R.drawable.norm);
        list.add(object);

        object = new ListViewObject();
        object.setName(getString(R.string.pledge));
        object.setDescription(getString(R.string.pledge_desc));
        object.setImageResId(R.drawable.pledge);

        list.add(object);


        return list;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        app.toas(list.get(position).getName());

    }

    @Override
    public boolean onItemLongClick(AdapterView<?> parent, View view, final int position, long id) {

        app.toas(list.get(position).getName() + "Remove !");


        Animation animation = AnimationUtils.loadAnimation(this, android.R.anim.slide_out_right);
        view.startAnimation(animation);

        animation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                list.remove(position);
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });


        return true;
    }
}
