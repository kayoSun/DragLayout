package com.kayo.drag;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;

/**
 * Kayo
 * 2018/8/25
 */
public class DragActivityHelper {
    private FragmentActivity mActivity;

    private DragLayout mDragLayout;

    public DragActivityHelper(FragmentActivity activity) {
        mActivity = activity;
    }

    @SuppressWarnings("deprecation")
    public void onActivityCreate() {
        mActivity.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        mActivity.getWindow().getDecorView().setBackgroundDrawable(null);
        mDragLayout = (DragLayout) LayoutInflater.from(mActivity).inflate(R.layout.swipeback_layout, null);
    }

    public void onPostCreate() {
        mDragLayout.attachToActivity(mActivity);
    }

    public View findViewById(int id) {
        if (mDragLayout != null) {
            return mDragLayout.findViewById(id);
        }
        return null;
    }

    public DragLayout getSwipeBackLayout() {
        return mDragLayout;
    }
}
