package com.example.gradletraining.fragment;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.xwalk.core.XWalkResourceClient;
import org.xwalk.core.XWalkUIClient;
import org.xwalk.core.XWalkView;

/**
 * Created by Svetlin Mollov on 8/8/2015.
 */
public class BrowserFragment extends Fragment {

    private XWalkView mXwalkView;
    private String mLastUrl;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mXwalkView = new XWalkView(getActivity(), getActivity());
        mXwalkView.setResourceClient(new XWalkResourceClient(mXwalkView));
        mXwalkView.setUIClient(new XWalkUIClient(mXwalkView));
        return mXwalkView;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        if (mLastUrl != null) {
            mXwalkView.load(mLastUrl, null);
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        if (mXwalkView != null) {
            mXwalkView.resumeTimers();
            mXwalkView.onShow();
        }
    }

    @Override
    public void onPause() {
        super.onPause();
        if (mXwalkView != null) {
            mXwalkView.pauseTimers();
            mXwalkView.onHide();
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (mXwalkView != null) {
            mXwalkView.onDestroy();
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (mXwalkView != null) {
            mXwalkView.onActivityResult(requestCode, resultCode, data);
        }
    }

    public void loadUrl(String bookmarkUrl) {
        mLastUrl = bookmarkUrl;
        if (mXwalkView != null) {
            mXwalkView.load(bookmarkUrl, null);
        }
    }
}
