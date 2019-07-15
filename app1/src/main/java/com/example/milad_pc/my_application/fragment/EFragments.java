package com.example.milad_pc.my_application.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.AppCompatEditText;
import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.milad_pc.my_application.Adapter.FragmentRecyclerViewAdapter;
import com.example.milad_pc.my_application.R;
import com.example.milad_pc.my_application.objects.ChatPageObject;

import java.util.ArrayList;
import java.util.List;

public class EFragments extends Fragment implements View.OnClickListener {


    AppCompatEditText appEditText;
    AppCompatImageView imgSend, imgBack;
    AppCompatTextView firstNoMessage;
    TextView title;
    RecyclerView recyclerView;
    FragmentRecyclerViewAdapter adapter;
    List<ChatPageObject> list = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.layout_fragment_e08, container, false);

        appEditText = view.findViewById(R.id.appEditText);
        imgSend = view.findViewById(R.id.imgSend);
        imgBack = view.findViewById(R.id.imgBack);
        firstNoMessage = view.findViewById(R.id.firstNoMessage);
        title = view.findViewById(R.id.title);
        recyclerView = view.findViewById(R.id.recyclerView);
        adapter = new FragmentRecyclerViewAdapter(list);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        imgBack.setOnClickListener(this);
        imgSend.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.imgBack: {
                getActivity().finish();
                break;
            }
            case R.id.imgSend: {
                sendMessage();
                break;
            }


        }

    }

    private void sendMessage() {
        if (appEditText.getText().toString().equals(null)) {
            return;
        }
        ChatPageObject object = new ChatPageObject();
        object.setMessage(appEditText.getText().toString());
        list.add(object);
        adapter.notifyDataSetChanged();
        appEditText.setText("");


    }
}
