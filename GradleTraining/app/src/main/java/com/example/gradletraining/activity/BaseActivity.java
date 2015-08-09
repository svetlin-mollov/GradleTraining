package com.example.gradletraining.activity;

import android.app.Fragment;
import android.support.v7.app.ActionBarActivity;

/**
 * Created by Svetlin Mollov on 8/8/2015.
 */
public class BaseActivity extends ActionBarActivity {

    protected void replaceFragment(Fragment fragment, int layoutContainerId) {
        getFragmentManager()
                .beginTransaction()
                .replace(layoutContainerId, fragment, fragment.getClass().getSimpleName())
                .commit();
    }
}
