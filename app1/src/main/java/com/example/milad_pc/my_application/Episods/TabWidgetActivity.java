package com.example.milad_pc.my_application.Episods;

import android.app.TabActivity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TabHost;
import android.widget.TabWidget;

import com.example.milad_pc.my_application.R;
import com.example.milad_pc.my_application.app.app;

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
        tabHost.setup();

        TabHost.TabSpec tb1 = tabHost.newTabSpec("tab1");
        TabHost.TabSpec tb2 = tabHost.newTabSpec("tab2");
        TabHost.TabSpec tb3 = tabHost.newTabSpec("tab3");

        tb1.setIndicator("Tab1", getResources().getDrawable(R.drawable.last_laugh));
        tb1.setContent(new Intent(this, CustomListViewActivity.class));

        tb2.setIndicator("Tab2");
        tb2.setContent(new Intent(this, MainActivity.class));

        tb3.setIndicator("Tab3");
        tb3.setContent(new Intent(this, CustomListViewActivity.class));


        tabHost.addTab(tb1);
        tabHost.addTab(tb2);
        tabHost.addTab(tb3);
        tabHost.setOnTabChangedListener(new TabHost.OnTabChangeListener() {
            @Override
            public void onTabChanged(String tabId) {
                app.toas(tabId);
            }
        });
        tabHost.setCurrentTab(2);
    }
}
