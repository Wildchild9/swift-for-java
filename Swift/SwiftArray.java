package Swift;

//
// SwiftArray.java
// Swift for Java
//
//
// Last modified on 27/11/18 11:13 AM.
//
// Copyright © 2018 Noah Wilder. All rights reserved.
// This file is subject to the terms and conditions defined in
// file 'LICENSE', which is part of this source code package.
//

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


@SuppressWarnings({"override", "unused"})
public class SwiftArray<Element> extends ArrayList<Element> {


//██▛▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▜█████████████████████████████████████████████████████████████████████████████
//██▌    Initialization     ▐█████████████████████████████████████████████████████████████████████████████
//██▙▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▟█████████████████████████████████████████████████████████████████████████████

    // Initializers (Constructors)
    public SwiftArray() { }
    public SwiftArray(Element... elements) {
        this.ensureCapacity(elements.length);
        this.addAll(List.of(elements));
    }
    public SwiftArray(ArrayList<Element> arrayList) {
        this.ensureCapacity(arrayList.size());
        this.addAll(arrayList);
    }
    public <T extends Iterable<Element>> SwiftArray(T iterableElements) {
        for (Element element : iterableElements) {
            this.add(element);
        }
    }


    // Static Initializers

    // Variations of dynamic initializers
    public static <T> SwiftArray<T> of(T... elements) {
        return new SwiftArray<T>(elements);
    }
    public static <T> SwiftArray<T> of(ArrayList<T> arrayList) {
        return new SwiftArray<T>(arrayList);
    }
    public static <T, U extends Iterable<T>> SwiftArray<T> of(U iterableElements) {
        return new SwiftArray<T>(iterableElements);
    }

    // Array from range
    public final static SwiftArray<Integer> fromRange(Integer lowerBound, Integer upperBound) {
        assert lowerBound <= upperBound:  "Can't form Range with upperBound < lowerBound";
        SwiftArray<Integer> swiftArray = new SwiftArray<Integer>();
        swiftArray.ensureCapacity(upperBound - lowerBound);
        for (Integer i = lowerBound; i < upperBound + 1; i++) {
            swiftArray.add(i);
        }
        return swiftArray;
    }
    public final static SwiftArray<Long> fromRange(Long lowerBound, Long upperBound) {
        assert lowerBound <= upperBound:  "Can't form Range with upperBound < lowerBound";

        SwiftArray<Long> swiftArray = new SwiftArray<Long>();
        if (upperBound - lowerBound > (long) Integer.MAX_VALUE) {
            swiftArray.ensureCapacity(Integer.MAX_VALUE);
        } else {
            swiftArray.ensureCapacity((int) (upperBound - lowerBound));
        }

        for (Long i = lowerBound; i < upperBound + 1; i++) {
            swiftArray.add(i);
        }
        return swiftArray;
    }

    // Array repeating element
    public final static <T> SwiftArray<T> repeating(T element, int count) {
        assert count >= 0 : "Cannot use a negative value as the count of a SwiftArray";
        var arr = new SwiftArray<T>();
        arr.ensureCapacity(count);
        for (int i = 0; i < count; i++) {
            arr.add(element);
        }
        return arr;
    }

    // Array repeating random element
    public final static SwiftArray<Integer> repeatingRandom(int    lowerBound, int    upperBound, int  count) {
        assert count >= 0 : "Cannot use a negative value as the count of a SwiftArray";
        assert lowerBound <= upperBound : "Can't form Range with upperBound < lowerBound";
        final var r = new Random();
        var swiftArray = new SwiftArray<Integer>();
        swiftArray.reserveCapacity(count);
        swiftArray.addAll(r.ints(count, lowerBound, upperBound).boxed().collect(Collectors.toList()));
        return swiftArray;

    }
    public final static SwiftArray<Double>  repeatingRandom(double lowerBound, double upperBound, long count) {
        assert count >= 0 : "Cannot use a negative value as the count of a SwiftArray";
        assert lowerBound <= upperBound : "Can't form Range with upperBound < lowerBound";
        final var r = new Random();
        return new SwiftArray<Double>(r.doubles(count, lowerBound, upperBound).boxed().collect(Collectors.toList())).map(i -> i);

    }
    public final static SwiftArray<Long>    repeatingRandom(long   lowerBound, long   upperBound, long count) {
        assert count >= 0 : "Cannot use a negative value as the count of a SwiftArray";
        assert lowerBound <= upperBound : "Can't form Range with upperBound < lowerBound";
        final var r = new Random();
        return new SwiftArray<Long>(r.longs(count, lowerBound, upperBound).boxed().collect(Collectors.toList()));

    }
    public final static SwiftArray<Double>  repeatingRandom(double lowerBound, double upperBound, int  decimalPlaces, long count) {
        assert count >= 0 : "Cannot use a negative value as the count of a SwiftArray";
        assert lowerBound <= upperBound : "Can't form Range with upperBound < lowerBound";
        assert decimalPlaces >= 0: "Cannot have a number with negative decimal places";

        final var r = new Random();
        return new SwiftArray<Double>(r.doubles(count, lowerBound, upperBound).boxed().collect(Collectors.toList())).map(i -> {
            long factor = (long) Math.pow(10, decimalPlaces);
            var value = i * factor;
            var tmp = Math.round(value);
            return (double) tmp / factor;
        });

    }

    // Stride
    public final static SwiftArray<Integer> strideTo(int    n, int    from, int    by) {
        assert from < n : "Cannot form range with upperBound < lowerBound";
        assert by > 0 : "Cannot stride by value less than or equal to zero";

        var arr = new SwiftArray<Integer>();
        for (var i = from; i < n; i += by) {
            arr.append(i);
        }

        return arr;
    }
    public final static SwiftArray<Float>   strideTo(float  n, float  from, float  by) {
        assert from < n : "Cannot form range with upperBound < lowerBound";
        assert by > 0 : "Cannot stride by value less than or equal to zero";
        var arr = new SwiftArray<Float>();
        for (var i = from; i < n; i += by) {
            arr.append(i);
        }

        return arr;
    }
    public final static SwiftArray<Double>  strideTo(double n, double from, double by) {
        assert from < n : "Cannot form range with upperBound < lowerBound";
        assert by > 0 : "Cannot stride by value less than or equal to zero";
        var arr = new SwiftArray<Double>();
        for (var i = from; i < n; i += by) {
            arr.append(i);
        }

        return arr;
    }
    public final static SwiftArray<Long>    strideTo(long   n, long   from, long   by) {
        assert from < n : "Cannot form range with upperBound < lowerBound";
        assert by > 0 : "Cannot stride by value less than or equal to zero";
        var arr = new SwiftArray<Long>();
        for (var i = from; i < n; i += by) {
            arr.append(i);
        }

        return arr;
    }

    public final static SwiftArray<Integer> strideThrough(int    n, int    from, int    by) {
        assert from <= n : "Cannot form range with upperBound < lowerBound";
        assert by > 0 : "Cannot stride by value less than or equal to zero";
        var arr = new SwiftArray<Integer>();
        for (var i = from; i <= n; i += by) {
            arr.append(i);
        }

        return arr;
    }
    public final static SwiftArray<Float>   strideThrough(float  n, float  from, float  by) {
        assert from <= n : "Cannot form range with upperBound < lowerBound";
        assert by > 0 : "Cannot stride by value less than or equal to zero";
        var arr = new SwiftArray<Float>();
        for (var i = from; i <= n; i += by) {
            arr.append(i);
        }

        return arr;
    }
    public final static SwiftArray<Double>  strideThrough(double n, double from, double by) {
        assert from <= n : "Cannot form range with upperBound < lowerBound";
        assert by > 0 : "Cannot stride by value less than or equal to zero";
        var arr = new SwiftArray<Double>();
        for (var i = from; i <= n; i += by) {
            arr.append(i);
        }

        return arr;
    }
    public final static SwiftArray<Long>    strideThrough(long   n, long   from, long   by) {
        assert from <= n : "Cannot form range with upperBound < lowerBound";
        assert by > 0 : "Cannot stride by value less than or equal to zero";
        var arr = new SwiftArray<Long>();
        for (var i = from; i <= n; i += by) {
            arr.append(i);
        }

        return arr;
    }




//██▛▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▜████████████████████████████████████████████████████████████████████████████████
//██▌     Conversion     ▐████████████████████████████████████████████████████████████████████████████████
//██▙▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▟████████████████████████████████████████████████████████████████████████████████


    // Array List
    public final ArrayList<Element> toArrayList() {
        return new ArrayList<Element>(this);
    }

    // List
    public final List<Element> toList() {
        return (List<Element>) this;
    }




//██▛▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▜█████████████████████████████████████████████████████████████████████████████████
//██▌      Outputs      ▐█████████████████████████████████████████████████████████████████████████████████
//██▙▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▟█████████████████████████████████████████████████████████████████████████████████

    // Print
    public final void print() {
        System.out.println(this);
    }
    public final SwiftArray<Element> printr() {
        System.out.println(this);
        return this;
    }

    // Print with separator
    public final void print(String separator) {
        System.out.println(this.stream().map(i -> String.valueOf(i)).collect(Collectors.joining(separator)));
    }
    public final SwiftArray<Element> printr(String separator) {
        System.out.println(this.stream().map(i -> String.valueOf(i)).collect(Collectors.joining(separator)));
        return this;
    }

    // Dump
    public final void dump() {
        if (size() <= 0) { System.out.println("- 0 elements"); }

        System.out.println("▿ " + size() + " elements");
        for (Element element : this) {
            System.out.println("  - " + element);
        }

    }



//██▛▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▜██████████████████████████████████████████████████████████████████████
//██▌   Element Adding Methods   ▐██████████████████████████████████████████████████████████████████████
//██▙▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▟██████████████████████████████████████████████████████████████████████

    // Append element to SwiftArray
    public final void append(Element item) {
        this.add(item);
    }

    // Variadic append to SwiftArray
    @SafeVarargs public final void append(Element... items) {
        Collections.addAll(this, items);
    }

    // Append contents
    public final <T extends Iterable<Element>> void append(T contentsOf) {
        for (Element element : contentsOf) {
            this.add(element);
        }
    }

    // Append contents of SwiftArray
    public final <T extends Collection<Element>> void append(T contentsOf) {
        this.addAll(contentsOf);
    }

    // Insert element at offset in SwiftArray
    public final void insert(Element element, int atIndex) {
        assert atIndex >= 0 && atIndex < size() : "SwiftArray offset for insertion is out of bounds";

        this.add(atIndex, element);

    }

    // Insert elements in collection at offset in SwiftArray
    public final <T extends Collection<Element>> void insert(T contentsOf, int atIndex) {
        assert atIndex >= 0 && atIndex < size() : "SwiftArray offset for insertion is out of bounds";

        for (Element element : contentsOf) {
            this.add(atIndex, element);
        }

    }

    // Insert elements in iterable type in SwiftArray
    public final <T extends Iterable<Element>> void insert(T contentsOf, int atIndex) {
        assert atIndex >= 0 && atIndex < size() : "SwiftArray offset for insertion is out of bounds";

        for (Element element : contentsOf) {
            this.add(atIndex, element);
        }

    }



//██▛▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▜███████████████████████████████████████████████████████████████████████████
//██▌     Removal Methods     ▐███████████████████████████████████████████████████████████████████████████
//██▙▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▟███████████████████████████████████████████████████████████████████████████


    // Remove at offset
    public final Element removeElement(int atIndex) {
        return this.remove(atIndex);
    }
    // Remove First/Last
    public final Element removeFirst() {
        return this.remove(0);
    }
    public final Element removeLast() {
        return this.remove(size() - 1);
    }

    // Remove First/Last n elements
    public final void removeFirst(int n) {
        this.removeRange(0, n - 1);
    }
    public final void removeLast(int n) {
        this.removeRange(n - 1, this.size() - 1);

    }

    // High-order removal
    public final void removeAllWhere(Predicate<Element> predicate) {
        this.removeIf(predicate);
    }


//██▛▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▜██████████████████████████████████████████████████████████████████████████
//██▌     Excluding Methods     ▐██████████████████████████████████████████████████████████████████████████
//██▙▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▟██████████████████████████████████████████████████████████████████████████

    // Drop First/Last
    public final SwiftArray<Element> dropFirst() {
        if (size() > 0) {
            return new SwiftArray<Element>(this.subList(1, size()));
        } else {
            return new SwiftArray<Element>();
        }
    }
    public final SwiftArray<Element> dropLast()  {
        if (size() > 0) {
            return new SwiftArray<Element>(this.subList(0, size() - 1));
        } else {
            return new SwiftArray<Element>();
        }
    }

    // Drop First/Last n elements
    public final SwiftArray<Element> dropFirst(int k) {
        assert k >= 0 : "Can't drop a negative number of elements from a collection";
        if (k >= size()) {
            return new SwiftArray<Element>(this);
        } else {
            return new SwiftArray<Element>(this.subList(size() - k, size()));
        }
    }
    public final SwiftArray<Element> dropLast(int k) {
        assert k >= 0 : "Can't drop a negative number of elements from a collection";
        if (k >= size()) {
            return new SwiftArray<Element>(this);
        } else {
            return new SwiftArray<Element>(this.subList(0, size() - k));
        }
    }

    // High-order dropping
    public final SwiftArray<Element> drop(Predicate<Element> predicate) {
        return new SwiftArray<Element>(this.stream().dropWhile(predicate).collect(Collectors.toList()));
    }


//██▛▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▜██████████████████████████████████████████████████████████████████████████
//██▌    Prefixes & Suffixes    ▐██████████████████████████████████████████████████████████████████████████
//██▙▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▟██████████████████████████████████████████████████████████████████████████

    // Prefix n elements
     public final SwiftArray<Element> prefix(final int n) {
        assert n >= 0: "Can't take a prefix of negative length from an array.";

        if (n <= this.size()) {
            return new SwiftArray<Element>(this.subList(0, n));
        } else {
            return new SwiftArray<Element>(this);
        }
    }

    // Prefix up to offset
     public final SwiftArray<Element> prefixUpTo(final int index) {
        assert index >= 0 : "Can't form Range with upperBound < lowerBound";
        assert index <= this.size() : "SwiftArray offset is out of range";

        return new SwiftArray<Element>(this.subList(0, index));
    }

    // Prefix through offset
     public final SwiftArray<Element> prefixThrough(final int index) {
        assert index + 1 >= 0 : "Can't form Range with upperBound < lowerBound";

        if (index + 1 > this.size() || index + 1 < 0) {
            throw new ArrayIndexOutOfBoundsException("SwiftArray offset is out of range");
        } else {
            return new SwiftArray<Element>(this.subList(0, index + 1));
        }
    }

    // High-order prefixation
     public final SwiftArray<Element> prefixWhile(Predicate<Element> predicate) {
        return new SwiftArray<>(this.stream().takeWhile(predicate).collect(Collectors.toList()));
    }

    // Suffix n elements
     public final SwiftArray<Element> suffix(final int n) {
        assert n >= 0: "Can't take a suffix of negative length from an array.";

        if (n <= this.size()) {
            return new SwiftArray<Element>(this.subList(this.size() - n, this.size()));
        } else {
            return new SwiftArray<Element>(this);
        }

    }

    // Suffix from offset
     public final SwiftArray<Element> suffixFrom(final int index) {
        assert index >= 0: "Negative SwiftArray offset is out of range";
        assert index <= this.size() : "Can't form Range with upperBound < lowerBound";

        return new SwiftArray<Element>(this.subList(index, this.size()));
    }

    // High-order suffixation
     public final SwiftArray<Element> suffixWhile(Predicate<Element> predicate) {
        final List<Element> list = this;
        Collections.reverse(list);
        return new SwiftArray<>(list.stream().takeWhile(predicate).collect(Collectors.toList()));
    }


//██▛▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▜█████████████████████████████████████████████████████████████████████████████
//██▌      First & Last      ▐█████████████████████████████████████████████████████████████████████████████
//██▙▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▟█████████████████████████████████████████████████████████████████████████████

    // First/Last Element
     public final Optional<Element> first() {

        return size() >= 1 ? Optional.of(this.get(0)) : Optional.empty();
     }
     public final Optional<Element> last () {
        return size() >= 1 ? Optional.of(this.get(size() - 1)) : Optional.empty();
     }

    // High-order First/Last element where predicate is met
     public final Optional<Element> firstWhere(Predicate<Element> predicate) {
        for (Element element : this) {
            if (predicate.test(element)) {
                return Optional.of(element);
            }
        }
        return Optional.empty();

     }
     public final Optional<Element> lastWhere (Predicate<Element> predicate) {
        for (int i = this.size() - 1; i >= 0; i--) {
            final Element element = this.get(i);
            if (predicate.test(element)) {
                return Optional.of(element);
            }
        }
        return Optional.empty();

     }

    // High-order First/Last offset where predicate is met
     public final Optional<Integer> firstIndexWhere(Predicate<Element> predicate) {
        for (int i = 0; i < this.size(); i++) {
            final Element element = this.get(i);
            if (predicate.test(element)) {
                return Optional.of(i);
            }
        }
        return Optional.empty();

     }
     public final Optional<Integer> lastIndexWhere (Predicate<Element> predicate) {
        for (int i = this.size() - 1; i >= 0; i--) {
            final Element element = this.get(i);
            if (predicate.test(element)) {
                return Optional.of(i);
            }
        }
        return Optional.empty();

     }


//██▛▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▜███████████████████████████████████████████████████████████████████████████
//██▌      Randomization      ▐███████████████████████████████████████████████████████████████████████████
//██▙▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▟███████████████████████████████████████████████████████████████████████████

    // Random element
    public final Element randomElement() {
        assert !this.isEmpty(): "Cannot return value from an empty array";

        int randomIdx = ThreadLocalRandom.current().nextInt(0, size());
        return this.get(randomIdx);
    }

    // Random offset
    public final int randomIndex() {
        assert !this.isEmpty(): "Cannot return value from an empty array";

        var randomIdx = ThreadLocalRandom.current().nextInt(0, size());
        return randomIdx;
    }

    // Mutating shuffle
    public final void shuffle()  {

        for (int idx = size() - 1; idx > 0; idx--) {
            int randomIdx = ThreadLocalRandom.current().nextInt(0, idx);
            final Element x = this.get(idx);
            final Element y = this.get(randomIdx);
            this.set(idx, y);
            this.set(randomIdx, x);
        }
    }

    // Non-mutating shuffle
    public final SwiftArray<Element> shuffled() {
        SwiftArray<Element> shuffledArray = new SwiftArray<Element>(this);
        for (int idx = size() - 1; idx > 0; idx--) {
            int randomIdx = ThreadLocalRandom.current().nextInt(0, idx);
            final Element x = shuffledArray.get(idx);
            final Element y = shuffledArray.get(randomIdx);
            shuffledArray.set(idx, y);
            shuffledArray.set(randomIdx, x);
        }

        return shuffledArray;
    }


//██▛▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▜█████████████████████████████████████████████████████████████████████████████
//██▌    Sorting Methods    ▐█████████████████████████████████████████████████████████████████████████████
//██▙▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▟█████████████████████████████████████████████████████████████████████████████

    // Default sorting
    public final SwiftArray<Element> sorted() {
        return new SwiftArray<Element>(this.stream().sorted().collect(Collectors.toList()));
    }

    public final void sort() {

        Collections.sort((List<Comparable>) this);
    }

    // High-order sorting by comparator
    public final SwiftArray<Element> sorted(Comparator<Element> comparator) {
        return new SwiftArray<Element>(this.stream().sorted(comparator).collect(Collectors.toList()));
    }


//██▛▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▜███████████████████████████████████████████████████████████████████████████
//██▌    Maximum & Minimum    ▐███████████████████████████████████████████████████████████████████████████
//██▙▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▟███████████████████████████████████████████████████████████████████████████

    // Maximum by comparator
    public final Optional<Element> max(Comparator<Element> comparator) {
        return this.stream().max(comparator);
    }

    // Minimum by comparator
    public final Optional<Element> min(Comparator<Element> comparator) {
        return this.stream().min(comparator);
    }


//██▛▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▜███████████████████████████████████████████████████████████████████████████
//██▌     Reverse Methods     ▐███████████████████████████████████████████████████████████████████████████
//██▙▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▟███████████████████████████████████████████████████████████████████████████

    // Mutating reverse
    public final void reverse() {
        Collections.reverse(this);
    }

    // Non-mutating reverse
    public final SwiftArray<Element> reversed() {
        SwiftArray<Element> swiftArray = new SwiftArray<Element>(this);
        Collections.reverse(swiftArray);
        return swiftArray;
    }


//██▛▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▜████████████████████████████████████████████████████████████████████████████
//██▌    Joining Methods     ▐████████████████████████████████████████████████████████████████████████████
//██▙▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▟████████████████████████████████████████████████████████████████████████████

    // Join elements into a string
    public final String joined() {
        return stream().map(i -> String.valueOf(i)).collect(Collectors.joining());
    }

    // Join elements with String separator
    public final String joined(String separator) {
        return stream().map(i -> String.valueOf(i)).collect(Collectors.joining(separator));
    }

    // Join elements with char separator
    public final String joined(char separator) {
        return stream().map(i -> String.valueOf(i)).collect(Collectors.joining(String.valueOf(separator)));
    }


//██▛▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▜████████████████████████████████████████████████████████████████████████████
//██▌    Advanced Methods    ▐████████████████████████████████████████████████████████████████████████████
//██▙▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▟████████████████████████████████████████████████████████████████████████████

    // Filter method
     public final SwiftArray<Element> filter(Predicate<Element> predicate) {
        return new SwiftArray<>(this.stream().filter(predicate).collect(Collectors.toList()));
    }

    // Mapping method
     public final <T> SwiftArray<T> map(Function<Element, T> transform) {
        return new SwiftArray<>(this.stream().map(transform).collect(Collectors.toList()));
    }

    // Reduce with binary operator
     public final Element reduce(BinaryOperator<Element> accumulator) {
        return this.stream().reduce(accumulator).get();
    }
     public final Element           reduce(Element initialValue, BinaryOperator<Element> accumulator) {
        return this.stream().reduce(initialValue, accumulator);
    }
     public final <T> T             reduce(T initialValue, BiFunction<T, ? super Element, T> accumulator, BinaryOperator<T> combiner) {
        return this.stream().reduce(initialValue, accumulator, combiner);
    }

    // Contains element that meets a predicate
     public final boolean contains(Predicate<Element> predicate) {
        for (Element element : this) {
            if (predicate.test(element)) {
                return true;
            }
        }
        return false;
    }

    // Count of element that meet a predicate
     public final int count(Predicate<Element> predicate) {
        int count = 0;
        for (Element element : this) {
            if (predicate.test(element)) {
                count++;
            }
        }
        return count;
    }


//██▛▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▜███████████████████████████████████████████████████████████████████████████████
//██▌    Slice Methods    ▐███████████████████████████████████████████████████████████████████████████████
//██▙▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▟███████████████████████████████████████████████████████████████████████████████

    // Checks if a given offset is valid in the context the SwiftArray
    public final boolean hasIndex(int idx) {
        return !this.isEmpty() && idx >= 0 && idx < size();
    }

    // Return slice of array between a particular offset
    public final SwiftArray<Element> toSlice(int lowerBound, int upperBound) {
        assert !this.isEmpty() : "Can't form slice from an empty array";
        assert lowerBound <= upperBound + 1 : "Can't form Range with upperBound < lowerBound";
        assert lowerBound >= 0 && lowerBound < size() &&
               upperBound >= 0 && upperBound < size()   : "SwiftArray offset is out of range";

        return new SwiftArray<Element>(this.subList(lowerBound, upperBound + 1));

    }


//██▛▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▜██████████████████████████████████████████████████████████████████████████████
//██▌   Matching Methods   ▐██████████████████████████████████████████████████████████████████████████████
//██▙▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▟██████████████████████████████████████████████████████████████████████████████

    // Returns true if all elements satisfy a predicate
    public final boolean allSatisfy(Predicate<Element> predicate) {
        for (Element element : this) {
            if (!predicate.test(element)) {
                return false;
            }
        }

        return true;
    }

    // Return true if no elements satisfy a predicate
    public final boolean noneSatisfy(Predicate<Element> predicate) {
        for (Element element : this) {
            if (predicate.test(element)) {
                return false;
            }
        }

        return true;

    }


//██▛▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▜██████████████████████████████████████████████████████████████████████████████
//██▌    Memory Methods    ▐██████████████████████████████████████████████████████████████████████████████
//██▙▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▟██████████████████████████████████████████████████████████████████████████████

    // Reserves a certain capacity in storage for an array
    public final void reserveCapacity(int capacity) {
        this.ensureCapacity(capacity);
    }


//██▛▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▜██████████████████████████████████████████████████████████████████████████████
//██▌    Random Numbers    ▐██████████████████████████████████████████████████████████████████████████████
//██▙▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▟██████████████████████████████████████████████████████████████████████████████

    // Int
    public static Integer randomInt() {
        return ThreadLocalRandom.current().nextInt();
    }
    public static Integer randomInt(int lo, int hi) {
        return ThreadLocalRandom.current().nextInt(lo, hi + 1);
    }

    // Double
    public static Double randomDouble() {
        return ThreadLocalRandom.current().nextDouble();
    }
    public static Double randomDouble(double lo, double hi) {
        return ThreadLocalRandom.current().nextDouble(lo, hi + 1);
    }

    // Long
    public static Long randomLong() {
        return ThreadLocalRandom.current().nextLong();
    }
    public static Long randomLong(long lo, long hi) {
        return ThreadLocalRandom.current().nextLong(lo, hi + 1);
    }


//██▛▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▜███████████████████████████████████████████████████████████████████████████████
//██▌    Other Methods    ▐███████████████████████████████████████████████████████████████████████████████
//██▙▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▟███████████████████████████████████████████████████████████████████████████████

    // Count
    public final int count() {
        return size();
    }

    // Indices
    public final SwiftRange indices() {
        return new SwiftRange(0, this.size() - 1);
    }

    // Start offset
    public final int startIndex() {
        return 0;
    }

    // End offset
    public final int endIndex() {
        return size() + 1;
    }

    // Swap at indices
    public void swapAt(int i, int j) {
        final Element x = this.get(i);
        final Element y = this.get(j);

        this.set(i, y);
        this.set(j, x);
    }

    // Enumerated
    public final List<EnumeratedPair<Element>> enumerated() {
        return IntStream.range(0, this.size())
                        .mapToObj(i -> EnumeratedPair.of(i, this.get(i)))
                        .collect(Collectors.toList());
    }



////▛▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀██████████████████████████████████████████████████████████████████████████████████████
} //▌ END OF CLASS  ██████████████████████████████████████████████████████████████████████████████████████
