package com.example.milad_pc.my_application.Episods;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.example.milad_pc.my_application.R;
import com.example.milad_pc.my_application.app.app;

public class ActionBarsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_action_bars);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.e07_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {

            case R.id.menu_settings: {
                app.toas("Setting Click");
                break;
            }
            case R.id.menu_contacts: {
                app.toas("Setting Contacts");
                break;
            }
            case R.id.menu_status: {
                app.toas("Setting Status");
                break;
            }


        }
        return super.onOptionsItemSelected(item);
    }
}
