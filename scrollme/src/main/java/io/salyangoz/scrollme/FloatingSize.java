package io.salyangoz.scrollme;


import android.support.design.widget.FloatingActionButton;

/**
 * Created by erkndeveci on 16/08/2017.
 */

public enum FloatingSize {
    SMALL(FloatingActionButton.SIZE_MINI), NORMAL(FloatingActionButton.SIZE_NORMAL);

    int id;

    FloatingSize(int id) {

        this.id = id;
    }

    static FloatingSize fromId(int id) {

        for (FloatingSize f : values()) {
            if (f.id == id) return f;
        }
        throw new IllegalArgumentException();
    }


}
