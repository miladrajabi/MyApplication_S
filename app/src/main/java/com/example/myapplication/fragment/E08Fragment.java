package com.example.myapplication.fragment;

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
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;

import com.example.myapplication.R;
import com.example.myapplication.adapter.ChatFragmentAdapter;
import com.example.myapplication.interfaces.ChatMessageListener;
import com.example.myapplication.objects.ChatFragmentObject;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class E08Fragment extends Fragment implements View.OnClickListener {

    public static ChatMessageListener listener;

    AppCompatEditText appEditText;
    AppCompatTextView firstNoMessage, title;
    AppCompatImageView imgSend, imgBack;
    RecyclerView rclChat;
    ChatFragmentAdapter adapter;
    List<ChatFragmentObject> list = new ArrayList<>();

    Boolean me = true;
    Boolean seen = false;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.layout_e08_fragment, container, false);

        appEditText = view.findViewById(R.id.appEditText);
        firstNoMessage = view.findViewById(R.id.firstNoMessage);
        title = view.findViewById(R.id.title);
        imgSend = view.findViewById(R.id.imgSend);
        imgBack = view.findViewById(R.id.imgBack);
        rclChat = view.findViewById(R.id.rclChat);

        adapter = new ChatFragmentAdapter(list);
        rclChat.setAdapter(adapter);
        rclChat.setLayoutManager(new LinearLayoutManager(getActivity()));
        rclChat.setLayoutAnimation(new LayoutAnimationController(AnimationUtils.loadAnimation(getActivity(), android.R.anim.slide_in_left)));

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

        me = !me;
        seen = !seen;
        if (appEditText.getText().toString().equals(null) || appEditText.getText().toString().isEmpty()) {
            return;
        } else {
            Calendar calendar = Calendar.getInstance();
            String dateTime = calendar.get(Calendar.HOUR) + ":" + calendar.get(Calendar.MINUTE) + ":" + calendar.get(Calendar.SECOND);
            firstNoMessage.setVisibility(View.GONE);
            ChatFragmentObject object = new ChatFragmentObject();
            object.setMessage(appEditText.getText().toString());
            object.setDate(dateTime);
            object.setSeen(seen);
            object.setMe(me);
            object.setType(ChatFragmentObject.TYPE_MESSAGE);
            if (listener != null) {
                listener.onMessage(object);
            }
            list.add(object);

            rclChat.smoothScrollToPosition(list.size());
            adapter.notifyDataSetChanged();
            appEditText.setText("");
        }
    }

    private void prepareData() {

    }
}