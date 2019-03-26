package com.kson.eventdemo;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;


public class ParentViewOuter extends FrameLayout {

    private int yDown;
    private int yMove;
    private int xDown;
    private int xMove;
    private int onceMoveX;
    private int onceMoveY;
    private int mLastX;
    private int mLastY;


    public ParentViewOuter(Context context) {
        super(context);
    }

    public ParentViewOuter(Context context, AttributeSet attrs) {
        super(context, attrs);
    }


    /**
     *
     * @param ev
     * @return
     */
    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        return super.dispatchTouchEvent(ev);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
            int x = (int) event.getX();
            int y = (int) event.getY();
            switch (event.getAction()) {
                case MotionEvent.ACTION_MOVE:
                    xMove = x;
                    yMove = y;
                    onceMoveX = xMove - mLastX;
                    onceMoveY = yMove - mLastY;
                    layout(getLeft() + onceMoveX, getTop() + onceMoveY, getRight() + onceMoveX, getBottom() + onceMoveY);
                    break;

            }

        return true;
    }


    /**
     * 拦截方法
     * @param event
     * @return
     */
    public boolean onInterceptTouchEvent(MotionEvent event) {
        boolean intercepted = false;
        int x = (int) event.getX();//相对于父控件x距离
        int y = (int) event.getY();
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                xDown = (int) event.getX();
                yDown = (int) event.getY();
                intercepted = false;
                break;
            case MotionEvent.ACTION_MOVE:
                if (Math.abs(x - mLastX) < Math.abs(y - mLastY)) {
                    intercepted = true;
                } else {
                    intercepted = false;
                }
                break;
            case MotionEvent.ACTION_UP:
                intercepted = false;
                break;
            default:
                break;
        }
        mLastX = x;
        mLastY = y;
        return intercepted;
    }


}
