package com.example.gradletraining.activity;

import android.app.Fragment;
import android.support.v7.app.ActionBarActivity;

import com.example.gradletraining.BuildConfig;

import net.hockeyapp.android.CrashManager;
import net.hockeyapp.android.UpdateManager;

/**
 * Created by Svetlin Mollov on 8/8/2015.
 */
public class BaseActivity extends ActionBarActivity
{

    @Override
    protected void onResume()
    {
        super.onResume();
        checkForCrashes();
        checkForUpdates();
    }

    private void checkForCrashes()
    {
        CrashManager.register(this, "d3b68a22b635b031583a99b5fa4dfadc");
    }

    private void checkForUpdates()
    {
        // Remove this for store builds!
        if(BuildConfig.DEBUG)
        {
            UpdateManager.register(this, "d3b68a22b635b031583a99b5fa4dfadc");
        }
    }

    protected void replaceFragment(Fragment fragment, int layoutContainerId)
    {
        getFragmentManager().beginTransaction().replace(layoutContainerId, fragment, fragment.getClass().getSimpleName()).commit();
    }
}
