package Swift;

/*
 *
 * SwiftRange.java
 * ComputerScience
 *
 *
 * Last modified on 15/11/18 9:20 AM.
 *
 * Copyright © 2018 Noah Wilder. All rights reserved.
 * This file is subject to the terms and conditions defined in
 * file 'LICENSE', which is part of this source code package.
 *
 */


import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;


public class SwiftRange implements Iterable<Integer> {

    // Internal variables
    private final SwiftRangeIterator swiftRangeIterator;
    private int upperBound;
    private int lowerBound;

    // Constructors
    public SwiftRange(int lowerBound, int upperBound) {

        assert lowerBound <= upperBound: "Cannot form range with upperBound > lowerBound";

        this.swiftRangeIterator = new SwiftRangeIterator(lowerBound);

        this.lowerBound = (int) lowerBound;
        this.upperBound = (int) upperBound;
    }

    // Iterable methods
    @NotNull
    @Override
    public Iterator<Integer> iterator() {
        return swiftRangeIterator;
    }

    // Methods
    public boolean contains(Integer n) {
        if (n >= lowerBound && n <= upperBound) return true;
        return false;
    }
    public boolean contains(Long    n) {
        if (n >= lowerBound && n <= upperBound) return true;
        return false;
    }
    public boolean contains(Double  n) {
        if (n >= lowerBound && n <= upperBound) return true;
        return false;
    }
    public boolean contains(int     n) {
        if (n >= lowerBound && n <= upperBound) return true;
        return false;
    }
    public boolean contains(long    n) {
        if (n >= lowerBound && n <= upperBound) return true;
        return false;
    }
    public boolean contains(double  n) {
        if (n >= lowerBound && n <= upperBound) return true;
        return false;
    }

    // Count
    public int count() {
        return upperBound - lowerBound + 1;
    }

    // Stream
    public Stream<Integer> stream()         {
        return this.toSwiftArray().stream();
    }
    public Stream<Integer> parallelStream() {
        return this.toSwiftArray().parallelStream();
    }

    // Bounds
    public int lowerBound() { return lowerBound; }
    public int upperBound() { return upperBound; }

    // Conversion methods
    public SwiftArray<Integer> toSwiftArray() {
        return SwiftArray.fromRange(lowerBound, upperBound);
    }
    public ArrayList<Integer>  toArrayList()  {
         var arrayList = new ArrayList<Integer>();
         arrayList.ensureCapacity(upperBound - lowerBound + 1);
         for (int i = lowerBound; i <= upperBound; i++) {
             arrayList.add(i);
         }
         return arrayList;
    }
    public List<Integer>       toList()       {
        List<Integer> list = List.of();
        for (int i = lowerBound; i <= upperBound; i++) {
            list.add(i);
        }
        return list;
    }
    public int[]               toArray()      {
        var arr = new int[upperBound - lowerBound + 1];
        var fillCount = 0;
        for (int i = lowerBound; fillCount < count(); i++) {
            arr[fillCount] = i;
            fillCount++;
        }
        return arr;
    }


    // Iterator
    public class SwiftRangeIterator implements Iterator<Integer> {

        private int index;

        public SwiftRangeIterator(int lowerBound) {
            index = lowerBound;
        }

        @Override
        public boolean hasNext() {
            return index <= upperBound;
        }

        @Override
        public Integer next() {
            return index++;
        }
    }

    // Enumerated
    public final List<EnumeratedPair<Integer>> enumerated() {
        return IntStream.range(0, this.count())
                        .mapToObj(i -> EnumeratedPair.of(i, Integer.valueOf(this.lowerBound + i)))
                        .collect(Collectors.toList());
    }

    // Equality
    public final boolean equals(SwiftRange range) {
        return this.lowerBound == range.lowerBound && this.upperBound == range.upperBound;
    }



    // To String
    @Override
    public String toString() {
        var stringBuilder = new StringBuilder();
        for (int i = lowerBound; i <= upperBound; i++) {
            stringBuilder.append(i).append(", ");
        }
        return stringBuilder.delete(stringBuilder.length() - 2, stringBuilder.length()).toString();
    }
    public String toString(String withSeparator) {
        var stringBuilder = new StringBuilder();
        for (int i = lowerBound; i <= upperBound; i++) {
            stringBuilder.append(i).append(withSeparator);
        }
        return stringBuilder.delete(stringBuilder.length() - withSeparator.length(), stringBuilder.length()).toString();
    }

}