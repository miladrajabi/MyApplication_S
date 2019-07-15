package com.example.myapplication.Episodes;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.example.myapplication.R;
import com.example.myapplication.app.app;

public class ActionBarActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_action_bar);
        setTitle(this.getClass().getSimpleName());
        init();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_custom, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.mnuSetting: {
                app.toas(getString(R.string.settings) + getString(R.string.Clicked));
                break;
            }
            case R.id.mnuContact: {
                app.toas(getString(R.string.contacts) + getString(R.string.Clicked));
                break;
            }
            case R.id.mnuStatus: {
                app.toas(getString(R.string.status) + getString(R.string.Clicked));
                break;
            }
        }
        return super.onOptionsItemSelected(item);
    }

    private void init() {
    }
}
