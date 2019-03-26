package com.kson.eventdemo;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;


public class HorizontalViewOuter extends View {

    private int xDown;
    private int xMove;
    private int onceMove;


    public HorizontalViewOuter(Context context) {
        super(context);
    }

    public HorizontalViewOuter(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        System.out.println("ontouchevent");
        int x = (int) event.getX();
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                xDown = x;
                break;
            case MotionEvent.ACTION_MOVE:
                xMove = x;
                onceMove = xMove - xDown;
                layout(getLeft() + onceMove, getTop(), getRight() + onceMove, getBottom());
                break;
        }
        return true;
    }
}
