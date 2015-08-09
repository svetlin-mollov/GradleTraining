package com.example.gradletraining;

import android.os.Bundle;

import com.example.gradletraining.activity.BaseActivity;
import com.example.gradletraining.fragment.BrowserFragment;

public class SecondScreen extends BaseActivity {

    private BrowserFragment mBrowserFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_screen);

        // Load browser fragment
        mBrowserFragment = new BrowserFragment();
        replaceFragment(mBrowserFragment, R.id.container_content);
        mBrowserFragment.loadUrl(Constants.BASE_URL);
    }
}
