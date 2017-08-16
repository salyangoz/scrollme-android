package io.salyangoz.scrollme;

import android.support.annotation.NonNull;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.animation.LinearOutSlowInInterpolator;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.animation.LinearInterpolator;


public class ScrollMeBehavior extends CoordinatorLayout.Behavior<FloatingActionButton> {

    private static final int TOP_GRAVITY = 49;
    private static final int BOTTOM_GRAVITY = 81;
    private int sign = 1;

    @Override
    public boolean layoutDependsOn(CoordinatorLayout parent, FloatingActionButton child, View dependency) {

        if (dependency instanceof RecyclerView)
            return true;

        return false;
    }

    @Override
    public void onStopNestedScroll(@NonNull CoordinatorLayout coordinatorLayout, @NonNull FloatingActionButton child, @NonNull View target, int type) {

        super.onStopNestedScroll(coordinatorLayout, child, target, type);

        RecyclerView recyclerView = (RecyclerView) target;
        int scrollRange = recyclerView.computeVerticalScrollOffset();
        int translateHeight = sign * child.getHeight() * 2;


        if (scrollRange <= recyclerView.getHeight())
            child.animate().translationY(translateHeight).setDuration(400).setInterpolator(new LinearOutSlowInInterpolator()).start();
        else
            child.animate().translationY(0).setInterpolator(new LinearInterpolator()).start();

    }

    @Override
    public void onNestedScroll(@NonNull CoordinatorLayout
                                       coordinatorLayout, @NonNull FloatingActionButton child, @NonNull View target, int dxConsumed,
                               int dyConsumed, int dxUnconsumed, int dyUnconsumed, int type) {

        super.onNestedScroll(coordinatorLayout, child, target, dxConsumed, dyConsumed, dxUnconsumed, dyUnconsumed, type);

    }


    @Override
    public boolean onStartNestedScroll(@NonNull CoordinatorLayout
                                               coordinatorLayout, @NonNull FloatingActionButton child, @NonNull View
                                               directTargetChild, @NonNull View target, int axes, int type) {

        int gravity = ((CoordinatorLayout.LayoutParams) child.getLayoutParams()).anchorGravity;
        if (gravity == TOP_GRAVITY)
            sign = -1;

        if (axes == ViewCompat.SCROLL_AXIS_VERTICAL) {

            child.animate().translationY(sign * child.getHeight() * 2).setDuration(300).setInterpolator(new LinearOutSlowInInterpolator()).start();


        }
        return axes == ViewCompat.SCROLL_AXIS_VERTICAL;
    }
}

