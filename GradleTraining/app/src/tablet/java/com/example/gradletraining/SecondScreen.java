package com.example.gradletraining;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.gradletraining.activity.BaseActivity;
import com.example.gradletraining.fragment.BrowserFragment;

public class SecondScreen extends BaseActivity {

    private BrowserFragment mBrowserFragment;
    private EditText mUrlEditText;
    private Button mGoButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_screen);

        // Load browser fragment
        mBrowserFragment = new BrowserFragment();
        replaceFragment(mBrowserFragment, R.id.container_content);

        mUrlEditText = (EditText) findViewById(R.id.edittext_url);
        mGoButton = (Button) findViewById(R.id.button_go);
        mGoButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                loadUrl(mUrlEditText.getText().toString());
            }
        });

        loadUrl(Constants.BASE_URL);
    }

    private void loadUrl(String url) {
        mUrlEditText.setText(url);
        mBrowserFragment.loadUrl(url);
    }
}
