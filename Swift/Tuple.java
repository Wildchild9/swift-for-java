package SwiftFramework.Swift;

/*
 *
 * Tuple.java
 * ComputerScience
 *
 *
 * Last modified on 19/11/18 1:43 PM.
 *
 * Copyright © 2018 Noah Wilder. All rights reserved.
 * This file is subject to the terms and conditions defined in
 * file 'LICENSE', which is part of this source code package.
 *
 */

import java.util.Map;


public class Tuple<A, B> extends Pair<A, B> {

    public A a;
    public B b;

    // Initializers
    public Tuple(A a, B b) {
        this.a = a;
        this.b = b;
    }
    public Tuple(Map.Entry<A, B> entry) {
        this.a = entry.getKey();
        this.b = entry.getValue();
    }

    // Static Initializers
    public static <P, Q> Tuple<P, Q> of(P p, Q q) {
        return new Tuple(p, q);
    }
    public static <P, Q> Tuple<P, Q> of(Map.Entry<P, Q> entry) {
        return new Tuple(entry.getKey(), entry.getValue());
    }


    // Getters
    @Override public A getLeft() {
        return this.a;
    }
    @Override public B getRight() {
        return this.b;
    }

    // Setters
    @Override
    public B setValue(B value) {
        this.b = value;
        return b;
    }
    public A setKey(A key) {
        this.a = key;
        return a;
    }

}
