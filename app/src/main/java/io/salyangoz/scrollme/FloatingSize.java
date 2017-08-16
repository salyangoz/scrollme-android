package io.salyangoz.scrollme;


/**
 * Created by erkndeveci on 16/08/2017.
 */

public enum FloatingSize {
    SMALL(1), NORMAL(0);

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
