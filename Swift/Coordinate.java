package Swift;

/*
 *
 * Coordinate.java
 * Swift for Java
 *
 *
 * Last modified on 27/11/18 10:56 AM.
 *
 * Copyright © 2018 Noah Wilder. All rights reserved.
 * This file is subject to the terms and conditions defined in
 * file 'LICENSE', which is part of this source code package.
 *
 */

public class Coordinate {

    public int x;
    public int y;

    public Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public static Coordinate of(int x, int y) {
        return new Coordinate(x, y);
    }

    @Override public String toString() {
        return "(" + x + ", " + y + ")";
    }
}
