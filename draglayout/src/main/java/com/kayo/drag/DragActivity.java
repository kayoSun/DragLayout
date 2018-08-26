package com.kayo.drag;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.kayo.drag.util.Utils;

/**
 * Kayo
 * 2018/8/25
 */
public class DragActivity extends AppCompatActivity implements DragInterface {
    private DragActivityHelper mHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mHelper = new DragActivityHelper(this);
        mHelper.onActivityCreate();
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        mHelper.onPostCreate();
    }

    @Override
    public  <T extends View> T  findViewById(int id) {
        View v = super.findViewById(id);
        if (v == null && mHelper != null)
            return mHelper.findViewById(id);
        return (T) v;
    }

    @Override
    public DragLayout getDragLayout() {
        return mHelper.getSwipeBackLayout();
    }

    @Override
    public void setDragEnable(boolean enable) {
        getDragLayout().setEnableGesture(enable);
    }

    @Override
    public void scrollToFinishActivity() {
        Utils.convertActivityToTranslucent(this);
        getDragLayout().scrollToFinishActivity();
    }
}