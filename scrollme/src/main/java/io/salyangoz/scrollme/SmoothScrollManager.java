package io.salyangoz.scrollme;

import android.content.Context;
import android.graphics.PointF;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.LinearSmoothScroller;
import android.support.v7.widget.RecyclerView;

public class SmoothScrollManager extends LinearLayoutManager {

    public SmoothScrollManager(Context context) {

        super(context, VERTICAL, false);
    }

    public SmoothScrollManager(Context context, int orientation, boolean reverseLayout) {

        super(context, orientation, reverseLayout);
    }

    @Override
    public void smoothScrollToPosition(RecyclerView recyclerView, RecyclerView.State state,
                                       int position) {

        RecyclerView.SmoothScroller smoothScroller = new TopSnappedSmoothScroller(recyclerView.getContext());
        smoothScroller.setTargetPosition(position);
        startSmoothScroll(smoothScroller);
    }

    private class TopSnappedSmoothScroller extends LinearSmoothScroller {

        public TopSnappedSmoothScroller(Context context) {

            super(context);

        }

        @Override
        public PointF computeScrollVectorForPosition(int targetPosition) {

            return SmoothScrollManager.this
                    .computeScrollVectorForPosition(targetPosition);
        }

        @Override
        protected int getVerticalSnapPreference() {

            return SNAP_TO_START;
        }
    }
}