package SwiftFramework.Swift;

/*
 *
 * EnumeratedPair.java
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

public class EnumeratedPair<Element> extends Pair<Integer, Element> {

    private static final long serialVersionUID = 4954918890077093841L;

    public final int index;
    public Element element;

    public static <T> EnumeratedPair<T> of(int index, T element) {
        return new EnumeratedPair<T>(index, element);
    }

    public EnumeratedPair(int index, Element element) {
        this.index = index;
        this.element = element;
    }
    public EnumeratedPair(Integer index, Element element) {
        this.index = index;
        this.element = element;
    }

    public EnumeratedPair(Pair<Integer, Element> pair) {
        this.index = pair.getLeft();
        this.element = pair.getRight();
    }

//    public Integer index() {
//        return index;
//    }
//    public Element element() {
//        return element;
//    }

    @Override
    public Integer getLeft() {
        return index;
    }

    @Override
    public Element getRight() {
        return element;
    }

    @Override
    public Element setValue(Element value) {
        element = value;
        return element;
        //throw new UnsupportedOperationException();
    }
}


//    private static final ImmutablePair NULL = of((Object) null, (Object) null);
//    private static final long serialVersionUID = 4954918890077093841L;
//    public final L left;
//    public final R right;
//
//    public static <L, R> ImmutablePair<L, R> nullPair() {
//        return NULL;
//    }
//
//    public static <L, R> ImmutablePair<L, R> of(L left, R right) {
//            return new ImmutablePair(left, right);
//        }
//
//    public ImmutablePair(L left, R right) {
//            this.left = left;
//            this.right = right;
//    }
//
//    public L getLeft() {
//        return this.left;
//    }
//
//    public R getRight() {
//        return this.right;
//    }
//
//    public R setValue(R value) {
//        throw new UnsupportedOperationException();
//    }