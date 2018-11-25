package Swift;

/*
 *
 * Pair.java
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


import java.io.Serializable;
import java.util.Map.Entry;
import java.util.Objects;


public abstract class Pair<L, R> implements Entry<L, R>, Serializable {

    private static final long serialVersionUID = 4954918890077093841L;

    public Pair() {
    }

    public static <L, R> Pair<L, R> of(L left, R right) {
        return new ImmutablePair(left, right);
    }

    public abstract L getLeft();

    public abstract R getRight();

    public final L getKey() {
        return this.getLeft();
    }

    public R getValue() {
        return this.getRight();
    }


    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        } else if (!(obj instanceof Entry)) {
            return false;
        } else {
            Entry<?, ?> other = (Entry)obj;
            return Objects.equals(this.getKey(), other.getKey()) && Objects.equals(this.getValue(), other.getValue());
        }
    }

    public int hashCode() {
        return (this.getKey() == null ? 0 : this.getKey().hashCode()) ^ (this.getValue() == null ? 0 : this.getValue().hashCode());
    }

    public String toString() {
        return "(" + this.getLeft() + ", " + this.getRight() + ')';
    }

    public String toString(String format) {
        return String.format(format, this.getLeft(), this.getRight());
    }

}




final class ImmutablePair<L, R> extends Pair<L, R> {
    private static final ImmutablePair NULL = of((Object) null, (Object) null);
    private static final long serialVersionUID = 4954918890077093841L;
    public final L left;
    public final R right;

    public static <L, R> ImmutablePair<L, R> nullPair() {
        return NULL;
    }

    public static <L, R> ImmutablePair<L, R> of(L left, R right) {
        return new ImmutablePair(left, right);
    }

    public ImmutablePair(L left, R right) {
        this.left = left;
        this.right = right;
    }

    public L getLeft() {
        return this.left;
    }

    public R getRight() {
        return this.right;
    }

    public R setValue(R value) {
        throw new UnsupportedOperationException();
    }


}
