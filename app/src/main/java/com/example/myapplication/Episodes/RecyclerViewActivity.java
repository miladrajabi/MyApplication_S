package com.example.myapplication.Episodes;

import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;

import com.example.myapplication.R;
import com.example.myapplication.adapter.RclAdapter;
import com.example.myapplication.app.app;
import com.example.myapplication.objects.RclObject;

import java.util.ArrayList;
import java.util.List;

public class RecyclerViewActivity extends AppCompatActivity implements View.OnClickListener {

    RecyclerView rclView;
    FloatingActionButton fabGridShow;
    List<RclObject> list;

    RclAdapter adapter;
    public static final int LAYOUT_MANAGER_LINEAR = 1;
    public static final int LAYOUT_MANAGER_GRID = 2;
    int layoutManager = LAYOUT_MANAGER_LINEAR;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);
        setTitle(this.getClass().getSimpleName());
        init();
    }

    private void init() {

        fabGridShow = findViewById(R.id.fabGridShow);
        fabGridShow.setOnClickListener(this);
        rclView = findViewById(R.id.rclView);
        setLayoutManager();

        Animation animation = AnimationUtils.loadAnimation(this, android.R.anim.slide_in_left);
        LayoutAnimationController animationController = new LayoutAnimationController(animation);
        //animationController.setAnimation(this, android.R.anim.slide_in_left);
        rclView.setLayoutAnimation(animationController);
        list = prepareData();
        adapter = new RclAdapter(list);
        rclView.setAdapter(adapter);

    }

    private void setLayoutManager() {

        if (layoutManager == LAYOUT_MANAGER_LINEAR) {
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
            fabGridShow.setImageResource(R.drawable.ic_dehaze_black_24dp);
            rclView.setLayoutManager(linearLayoutManager);
        } else if (layoutManager == LAYOUT_MANAGER_GRID) {
            GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2);
            fabGridShow.setImageResource(R.drawable.ic_add_black_24dp);
            rclView.setLayoutManager(gridLayoutManager);
        }
    }

    private List<RclObject> prepareData() {

        List<RclObject> list = new ArrayList<>();
        RclObject object = new RclObject();
        object.setSongName(getString(R.string.Sina_Shabankhani_song));
        object.setSingerName(getString(R.string.sina_shabankhani));
        object.setSongLike(Integer.parseInt(getString(R.string.sina_shabankhani_like)));
        object.setSongView(Integer.parseInt(getString(R.string.sina_shabankhani_view)));
        object.setSongComment(Integer.parseInt(getString(R.string.sina_shabankhani_comment)));
        object.setSongDate(getString(R.string.sina_shabankhani_date));
        object.setSongImage(R.drawable.behishkinagoo);
        list.add(object);

        object = new RclObject();
        object.setSongName(getString(R.string.omid_shabani_song));
        object.setSingerName(getString(R.string.omid_shabani));
        object.setSongLike(Integer.parseInt(getString(R.string.omid_shabani_like)));
        object.setSongView(Integer.parseInt(getString(R.string.omid_shabani_view)));
        object.setSongComment(Integer.parseInt(getString(R.string.omid_shabani_comment)));
        object.setSongDate(getString(R.string.omid_shabani_date));
        object.setSongImage(R.drawable.doretbegardam);
        list.add(object);


        return list;
    }


    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.fabGridShow) {
            if (layoutManager == LAYOUT_MANAGER_LINEAR) {
                app.log("Milad");
                layoutManager = LAYOUT_MANAGER_GRID;
            } else {
                layoutManager = LAYOUT_MANAGER_LINEAR;
            }
            setLayoutManager();
        }

    }
}
