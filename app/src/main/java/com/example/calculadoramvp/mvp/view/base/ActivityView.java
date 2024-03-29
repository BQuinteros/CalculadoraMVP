package com.example.calculadoramvp.mvp.view.base;

import android.app.Activity;
import android.app.FragmentManager;
import android.content.Context;
import androidx.annotation.Nullable;
import java.lang.ref.WeakReference;


public class ActivityView extends Activity {
    private WeakReference<Activity> activityRef;

    public ActivityView(Activity activity){
        activityRef = new WeakReference<>(activity);
    }

    @Nullable
    public Activity getActivity() {
        return activityRef.get();
    }

    @Nullable
    public Context getContext() {
        return getActivity();
    }

}