package com.example.milad_pc.my_application.app;

import android.util.Log;
import android.widget.Toast;

public class app {
    public static class main {
        public static final String TAG = "My App";
    }

    public static void log(String msg) {
        Log.e(main.TAG, msg);
    }

    public static void toas(String msg) {
        Toast.makeText(Application.getContext(), msg, Toast.LENGTH_LONG).show();
    }

}
