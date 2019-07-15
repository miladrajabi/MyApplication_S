package com.example.milad_pc.my_application.app;

import android.content.Context;

public class Application extends android.app.Application {
    private static Context context;

    public static Context getContext() {
        return context;
    }

    public static void setContext(Context context) {
        Application.context = context;
    }


    @Override
    public void onCreate() {
        super.onCreate();
        context = this;

    }
}
