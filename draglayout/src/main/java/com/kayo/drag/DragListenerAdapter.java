package com.kayo.drag;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentActivity;

import com.kayo.drag.listener.DragListenerII;
import com.kayo.drag.util.Utils;

import java.lang.ref.WeakReference;

/**
 * Kayo
 * 2018/8/25
 */
public class DragListenerAdapter implements DragListenerII {
    private final WeakReference<FragmentActivity> mActivity;

    public DragListenerAdapter(@NonNull FragmentActivity activity) {
        mActivity = new WeakReference<>(activity);
    }

    @Override
    public void onScrollStateChange(int state, float scrollPercent) {

    }

    @Override
    public void onEdgeTouch(int edgeFlag) {
        FragmentActivity activity = mActivity.get();
        if (null != activity) {
            Utils.convertActivityToTranslucent(activity);
        }
    }

    @Override
    public void onScrollOverThreshold() {

    }

    @Override
    public void onContentViewDragLimit() {
        Activity activity = mActivity.get();
        if (null != activity && !activity.isFinishing()) {
            activity.finish();
            activity.overridePendingTransition(0, 0);
        }
    }
}