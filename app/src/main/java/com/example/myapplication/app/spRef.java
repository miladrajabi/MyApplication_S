package com.example.myapplication.app;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;

import com.example.myapplication.R;

public class spRef {


    private static SharedPreferences sharedPreferences;

    public static SharedPreferences getSharedPreferences(String tag) {
        if (sharedPreferences != null)
            return sharedPreferences;
        sharedPreferences = Application.getContext().getSharedPreferences(tag, Context.MODE_PRIVATE);
        return sharedPreferences;
    }

    public static class tagse {
        public static final String MyApp = "MyApp";
    }

    public static class Form {
        public static final String FIRSTNMAE = "firstName";
        public static final String FIRSTNMAE_VALUE = "";
        public static final String lastName = "lastName";
        public static final String lastName_VALUE = "";
        public static final String STAY_LOGIN = "stayLogin";
        public static final boolean STAY_LOGIN_VALUE = false;
        public static final String PAGE_BACKGROUND = "PAGEBACKGROUND";
        public static final int PAGE_BACKGROUND_VALUE = Color.parseColor(String.valueOf(Application.getContext().getResources().getColor(R.color.black)));
        public static final String AGE = "AGE";
        public static final int AGE_VALUE = 18;


    }
}
