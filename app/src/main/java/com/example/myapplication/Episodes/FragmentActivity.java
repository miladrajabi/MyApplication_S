package com.example.myapplication.Episodes;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.myapplication.R;
import com.example.myapplication.app.app;
import com.example.myapplication.fragment.E08Fragment;
import com.example.myapplication.interfaces.ChatMessageListener;
import com.example.myapplication.objects.ChatFragmentObject;

public class FragmentActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment);
        setTitle(this.getClass().getSimpleName());
        init();
    }

    private void init() {
        E08Fragment.listener = new ChatMessageListener() {
            @Override
            public void onMessage(ChatFragmentObject object) {
                app.toas(object.getMessage());
            }
        };
    }
}
