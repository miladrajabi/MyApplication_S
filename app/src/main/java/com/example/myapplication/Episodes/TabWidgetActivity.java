package com.example.myapplication.Episodes;

import android.app.TabActivity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TabHost;

import com.example.myapplication.R;
import com.example.myapplication.app.app;

public class TabWidgetActivity extends TabActivity {

    TabHost tabHost;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab_widget);
        setTitle(this.getClass().getSimpleName());
        init();
    }

    private void init() {
        tabHost = findViewById(android.R.id.tabhost);

        TabHost.TabSpec tab1 = tabHost.newTabSpec("tab1");
        TabHost.TabSpec tab2 = tabHost.newTabSpec("tab2");


        tab1.setIndicator("ListView");
        tab1.setContent(new Intent(this, CustomListViewActivity.class));

        tab2.setIndicator("RecyclerView");
        tab2.setContent(new Intent(this, RecyclerViewActivity.class));

        tabHost.addTab(tab1);
        tabHost.addTab(tab2);

        tabHost.setOnTabChangedListener(new TabHost.OnTabChangeListener() {
            @Override
            public void onTabChanged(String tabId) {
                app.toas(tabId);
            }
        });
    }
}
