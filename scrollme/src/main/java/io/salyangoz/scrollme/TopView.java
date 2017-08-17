package io.salyangoz.scrollme;

import android.content.Context;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.util.AttributeSet;

/**
 * Created by erkndeveci on 16/08/2017.
 */
@CoordinatorLayout.DefaultBehavior(ScrollMeBehavior.class)
public class TopView extends FloatingActionButton {

    public TopView(Context context) {

        super(context);
    }

    public TopView(Context context, AttributeSet attrs) {

        super(context, attrs);

    }

    public TopView(Context context, AttributeSet attrs, int defStyleAttr) {

        super(context, attrs, defStyleAttr);
    }

}
