package io.salyangoz.scrollme;


/**
 * Created by erkndeveci on 16/08/2017.
 */

public enum FloatingGravity {
    LEFT(0), RIGHT(1), CENTER(2);

    int id;

    FloatingGravity(int id) {

        this.id = id;
    }

    static FloatingGravity fromId(int id) {

        for (FloatingGravity f : values()) {
            if (f.id == id) return f;
        }
        throw new IllegalArgumentException();
    }


}
