package com.aoaydesign.firstmvvm;

import android.app.Application;

import com.facebook.stetho.Stetho;

public class QuizApp extends Application {

    public void onCreate() {
        super.onCreate();
        Stetho.initializeWithDefaults(this);
    }
}
