package Swift;

//
// EnumeratedPair.java
// Swift for Java
//
//
// Last modified on 27/11/18 11:13 AM.
//
// Copyright © 2018 Noah Wilder. All rights reserved.
// This file is subject to the terms and conditions defined in
// file 'LICENSE', which is part of this source code package.
//

public class EnumeratedPair<Element> extends Pair<Integer, Element> {

    private static final long serialVersionUID = 4954918890077093841L;

    public final int offset;
    public Element element;

    public static <T> EnumeratedPair<T> of(int offset, T element) {
        return new EnumeratedPair<T>(offset, element);
    }

    public EnumeratedPair(int offset, Element element) {
        this.offset = offset;
        this.element = element;
    }
    public EnumeratedPair(Integer offset, Element element) {
        this.offset = offset;
        this.element = element;
    }

    public EnumeratedPair(Pair<Integer, Element> pair) {
        this.offset = pair.getLeft();
        this.element = pair.getRight();
    }

    @Override
    public Integer getLeft() {
        return offset;
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

