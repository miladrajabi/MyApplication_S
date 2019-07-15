package com.example.myapplication.app;

import android.content.Context;

import pl.com.salsoft.sqlitestudioremote.SQLiteStudioService;

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
        SQLiteStudioService.instance().start(this);
        context = this;

    }

    @Override
    public void onTerminate() {
        SQLiteStudioService.instance().stop();
        super.onTerminate();
    }
}
