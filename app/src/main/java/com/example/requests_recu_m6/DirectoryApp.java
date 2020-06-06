package com.example.requests_recu_m6;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;

import androidx.annotation.Nullable;

import com.example.requests_recu_m6.Repository.Repository;
import com.google.firebase.database.core.Repo;

public class DirectoryApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        Repository.get(getApplicationContext());
    }

    @Override
    public void onTerminate() {
        super.onTerminate();


    }
}
