package com.example.milad_pc.my_application.Episods;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.milad_pc.my_application.R;

public class FragmentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment);
        setTitle(getClass().getSimpleName());
        init();
    }

    private void init() {
    }

}
