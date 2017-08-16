package io.salyangoz.scrollme;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.animation.LinearOutSlowInInterpolator;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by erkndeveci on 16/08/2017.
 */

public class ScrollMeView extends CoordinatorLayout implements View.OnClickListener {

    private RecyclerView mRecyclerView;
    private TopView mFloatingActionButton;

    public ScrollMeView(Context context, AttributeSet attrs) {

        super(context, attrs);

        inflate(getContext(), R.layout.scroll_me_options, this);

        TypedArray typedArray = context.obtainStyledAttributes(attrs,
                R.styleable.Options, 0, 0);
        @SuppressWarnings("ResourceAsColor")
        int floatingBackgroundColor = typedArray.getColor(R.styleable.Options_sm_backgroundColor, android.R.color.white);
        @SuppressWarnings("ResourceAsColor")
        int floatingTintColor = typedArray.getColor(R.styleable.Options_sm_tint, R.color.colorPrimary);
        @SuppressWarnings("ResourceAsBoolean")
        boolean clickable = typedArray.getBoolean(R.styleable.Options_sm_clickable, true);
        @SuppressWarnings("ResourceAsBoolean")
        boolean focusable = typedArray.getBoolean(R.styleable.Options_sm_focusable, true);
        @SuppressWarnings("ResourceAsDrawable")
        int icon = typedArray.getInteger(R.styleable.Options_sm_icon, R.drawable.ic_assessment_black_24dp);
        @SuppressWarnings("ResourceAsInteger")
        int size = typedArray.getInteger(R.styleable.Options_sm_size, 0);


        mRecyclerView = (RecyclerView) getChildAt(0);
        mRecyclerView.setLayoutManager(new SmoothScrollManager(getContext()));

        mFloatingActionButton = (TopView) getChildAt(1);
        mFloatingActionButton.setOnClickListener(this);
        mFloatingActionButton.animate().translationY(mFloatingActionButton.getHeight() * 2).setDuration(400).setInterpolator(new LinearOutSlowInInterpolator()).start();
        mFloatingActionButton.setBackgroundColor(getResources().getColor(android.R.color.white, null));
        mFloatingActionButton.setBackgroundTintList(ColorStateList.valueOf(floatingTintColor));
        mFloatingActionButton.setFocusable(focusable);
        mFloatingActionButton.setClickable(clickable);
        mFloatingActionButton.setImageResource(icon);
        mFloatingActionButton.setSize(size);

        typedArray.recycle();

    }

    public ScrollMeView(Context context) {

        this(context, null);
    }

    public RecyclerView getmRecyclerView() {

        return mRecyclerView;
    }

    public FloatingActionButton getmFloatingActionButton() {

        return mFloatingActionButton;
    }

    @Override
    public void onClick(View view) {

        //Smooth Scroll and Hide Top Button
        mRecyclerView.smoothScrollToPosition(0);
        mFloatingActionButton.animate().translationY(mFloatingActionButton.getHeight() * 2).setDuration(400).setInterpolator(new LinearOutSlowInInterpolator()).start();

    }
}
