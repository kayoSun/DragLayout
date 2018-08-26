package com.kayo.drag.listener;

/**
 * Kayo
 * 2018/8/25
 */
public interface DragListener {
    /**
     * 滑动状态更改
     * @param state         flag to describe scroll state
     * @param scrollPercent scroll percent of this view
     * @see #STATE_IDLE
     * @see #STATE_DRAGGING
     * @see #STATE_SETTLING
     */
    void onScrollStateChange(int state, float scrollPercent);

    /**
     * 敏感区被触摸时
     * @param edgeFlag edge flag describing the edge being touched
     * @see #EDGE_LEFT
     * @see #EDGE_RIGHT
     * @see #EDGE_BOTTOM
     */
    void onEdgeTouch(int edgeFlag);

    /**
     * Invoke when scroll percent over the threshold for the first time
     */
    void onScrollOverThreshold();
}
