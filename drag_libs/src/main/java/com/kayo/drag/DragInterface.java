package com.kayo.drag;

/**
 * Kayo
 * 2018/8/25
 */
public interface DragInterface {
    DragLayout getDragLayout();

    void setDragEnable(boolean enable);

    void scrollToFinishActivity();
}
