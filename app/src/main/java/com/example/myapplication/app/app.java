package com.example.myapplication.app;

import android.util.Log;
import android.widget.Toast;

public class app {

    public static class main {
        public static final String TAG = "My_App";
        public static final int DbVersion = 1;
        public static final String DbName = "MyDb.db";
    }

    public static void log(String msg) {
        Log.e(main.TAG, msg);
    }

    public static void toas(String msg) {
        Toast.makeText(Application.getContext(), msg, Toast.LENGTH_LONG).show();
    }
}
