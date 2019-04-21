package com.exhibits.showcase;

import android.app.Application;
import android.content.Context;

import java.lang.ref.WeakReference;

/**
 * Created by Tourdyiev Roman on 4/21/19.
 */
public class CustomApplication extends Application {

    private WeakReference<Context> context;


    @Override
    public void onCreate() {
        super.onCreate();
        context = new WeakReference<>(getApplicationContext());
    }

    public Context getContext() {
        return context.get();
    }
}
