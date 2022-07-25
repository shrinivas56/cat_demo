package com.intuit.catdemo.presentation;

import android.app.Application;

import dagger.hilt.android.HiltAndroidApp;

@HiltAndroidApp
public final class MyApplication extends Application {

  @Override public void onCreate() {
    super.onCreate();
  }
}