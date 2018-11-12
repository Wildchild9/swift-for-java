package Swift;

/*
 *
 * Swift.java
 * ComputerScience
 *
 *
 * Last modified on 09/11/18 1:09 PM.
 *
 * Copyright © 2018 Noah Wilder. All rights reserved.
 * This file is subject to the terms and conditions defined in
 * file 'LICENSE', which is part of this source code package.
 *
 */


import java.util.*;
import java.util.stream.Collectors;

// Current top class
class SwiftBase extends SwiftMath { }

// Warning Suppression
@SuppressWarnings({"FinalStaticMethod", "unused", "RedundantExplicitVariableType", "SingleStatementInBlock", "VariableArgumentMethod", "MethodCanBeVariableArityMethod"})
public class Swift extends SwiftBase {

    // Allows SwiftFramework to be subclassed
    public Swift() { }


//████████████████████████████████████████████████████████████████████████████████████████████████████████
//██▛▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▜████████████████████████████████████████████████████████████████████████████████
//██▌       Tests        ▐████████████████████████████████████████████████████████████████████████████████
//██▙▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▟████████████████████████████████████████████████████████████████████████████████

//  ▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁
//  Method Testing Area
    public static void main(String[] args) { }

//████████████████████████████████████████████████████████████████████████████████████████████████████████
//██▛▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▜████████████████████████████████████████████████████████████████████████████████
//██▌  Printing Methods  ▐████████████████████████████████████████████████████████████████████████████████
//██▙▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▟████████████████████████████████████████████████████████████████████████████████

//  ▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁
//  Typed Methods
    public static final void print(int item) {
        System.out.println(item);
    }
    public static final void print(char item) {
        System.out.println(item);
    }
    public static final void print(long item) {
        System.out.println(item);
    }
    public static final void print(float item) {
        System.out.println(item);
    }
    public static final void print(char... item) {
        System.out.println(item);
    }
    public static final void print(double item) {
        System.out.println(item);
    }
    public static final void print(String item) {
        System.out.println(item);
    }
    public static final void print(boolean item) {
        System.out.println(item);
    }
    public static final void print() {
        System.out.println();
    }

//  ▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁
//  Generic Methods
    public static final <T> void print(T         item ) {
        System.out.println(item);
    }
    public static final     void print(Object... items) {
        print.withSeparator(" ", items);
    }
    public static final <T extends Collection> void print(Collection collection, String separator) {
        final String joinedCollection = collection.stream().map(i -> String.valueOf(i)).collect(Collectors.joining(separator)).toString();
        System.out.println(joinedCollection);
    }

//  ▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁
//  Separator Methods
    @SuppressWarnings("Convert2streamapi")
    public static final class print {
        private print() { }

        public static final void withSeparator(String separator, Object... items) {

            final String joinedItems = Arrays.stream(items).map(i -> String.valueOf(i)).collect(Collectors.joining(separator));

            System.out.println(joinedItems);
        }
        public static final void withSeparator(char   separator, Object... items) {
            print.withSeparator(String.valueOf(separator), items);
        }

        public static final <T> void withTerminator(String terminator, T item) {

            System.out.print(item.toString() + terminator);
        }
        public static final <T> void withTerminator(char   terminator, T item) {
            print.withTerminator(String.valueOf(terminator), item);
        }
    }

//  ▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁
//  Print & Return
    public static final <T> T printr(T item) {
    System.out.println(item);
    return item;
}



//█████████████████████████████████████████████████████████████████████████████████████████████████████████
//██▛▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▜████████████████████████████████████████████████████████████████████████████████
//██▌   Crashing Methods   ▐███████████████████████████████████████████████████████████████████████████████
//██▙▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▟████████████████████████████████████████████████████████████████████████████████


//  ▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁
//  Fatal Error

    public static void fatalError(String message) {
        System.out.println("\nFatal error: " + message);
        System.exit(10);
    }
    public static void fatalError() {
        System.out.println("\nFatal error");
        System.exit(10);
    }


//  ▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁
//  Precondition Failure

    public static void precondition(boolean condition, String message) {
        if (!condition) {
            throw new IllegalArgumentException(message);
        }
    }
    public static void precondition(boolean condition) {
        if (!condition) {
            throw new IllegalArgumentException("Fatal error");
        }
    }


    // Exit code for fatal error is "exit code 10"

//█████████████████████████████████████████████████████████████████████████████████████████████████████████
//██▛▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▜████████████████████████████████████████████████████████████████████████████████
//██▌   Scanner Methods   ▐████████████████████████████████████████████████████████████████████████████████
//██▙▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▟████████████████████████████████████████████████████████████████████████████████

    // Scanner object initializer
    public static swiftScanner swiftScanner(Scanner sc) {
        return new swiftScanner(sc);
    }

    // Scanner innerclass
    public static final class swiftScanner {

        // Scanner
        private Scanner sc;

        // Initializer
        private swiftScanner(Scanner scanner) {
            this.sc = scanner;
        }

    //  ▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁
    //  Prefix
        public final     boolean hasNextWithPrefix(String prefix) {
            String pattern = prefix + "(.*)";
            return sc.hasNext(pattern);
        }
        public final <T> boolean hasNextWithPrefix(T      prefix) {
        final String pattern = "(.*)" + String.valueOf(prefix);
        return this.sc.hasNext(pattern);
    }

    //  ▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁
    //  Suffix
        public final     boolean hasNextWithSuffix(String suffix) {
    String pattern = "(.*)" + suffix;
    return this.sc.hasNext(pattern);
}
        public final <T> boolean hasNextWithSuffix(T      suffix) {
        final String pattern = "(.*)" + String.valueOf(suffix);
        return this.sc.hasNext(pattern);
    }

    //  ▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁
    //  Contains
        public final     boolean hasNextContaining(String string) {

        long count = string.chars().count();

        // String is empty
        if (count == 0) { return true; }

        // String is a single character
        if (count == 1) {
            return hasNextContaining(string.charAt(0));
        }

        // String contains more than one character
        final String pattern = "(.*)" + string + "(.*)";
        return this.sc.hasNext(string);

    }
        public final <T> boolean hasNextContaining(T value)       {
            final String pattern = "(.*)" + String.valueOf(value) + "(.*)";
            return this.sc.hasNext(pattern);
        }

    //  ▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁
    //  Positive & Negative

        // Number types
        public enum NumberType {
            INT, DOUBLE, FLOAT, LONG, SHORT, BYTE, ANY
        }

        // Positive
        public final boolean hasNextPositive(NumberType numberType) {
            switch (numberType) {
                case INT:    return hasNextPositiveInt();
                case DOUBLE: return hasNextPositiveDouble();
                case FLOAT:  return hasNextPositiveFloat();
                case LONG:   return hasNextPositiveLong();
                case SHORT:  return hasNextPositiveShort();
                case BYTE:   return hasNextPositiveByte();
                case ANY:    return hasNextPositiveNumber();
                default:     return false;
            }
        }

        // Negative
        public final boolean hasNextNegative(NumberType numberType) {
            switch (numberType) {
                case INT:    return hasNextNegativeInt();
                case DOUBLE: return hasNextNegativeDouble();
                case FLOAT:  return hasNextNegativeFloat();
                case LONG:   return hasNextNegativeLong();
                case SHORT:  return hasNextNegativeShort();
                case BYTE:   return hasNextNegativeByte();
                case ANY:    return hasNextNegativeNumber();
                default:     return false;
            }
        }

        // Numeric
        public final boolean hasNextNumber() {

            return this.sc.hasNextInt()    ||
                    this.sc.hasNextLong()   ||
                    this.sc.hasNextDouble() ||
                    this.sc.hasNextFloat()  ||
                    this.sc.hasNextShort()  ||
                    this.sc.hasNextByte();
        } // +, -

        // Number +, -
        private final boolean hasNextPositiveNumber() {
            return !hasNextWithPrefix("-") && hasNextNumber();
        } // +
        private final boolean hasNextNegativeNumber() {
            return hasNextWithPrefix("-") && hasNextNumber();
        } // -

        // Integer +, -
        private final boolean hasNextPositiveInt() {
            return this.sc.hasNextInt() && !hasNextWithPrefix("-");
        } // +
        private final boolean hasNextNegativeInt() {
            return this.sc.hasNextInt() && hasNextWithPrefix("-");
        } // -

        // Double +, -
        private final boolean hasNextPositiveDouble() {
            return this.sc.hasNextDouble() && !hasNextWithPrefix("-");
        } // +
        private final boolean hasNextNegativeDouble() {
            return this.sc.hasNextDouble() && hasNextWithPrefix("-");
        } // -

        // Float
        private final boolean hasNextPositiveFloat() {
            return this.sc.hasNextFloat() && !hasNextWithPrefix("-");
        } // +
        private final boolean hasNextNegativeFloat() {
            return this.sc.hasNextFloat() && hasNextWithPrefix("-");
        } // -

        // Long
        private final boolean hasNextPositiveLong() {
            return this.sc.hasNextLong() && !hasNextWithPrefix("-");
        } // +
        private final boolean hasNextNegativeLong() {
            return this.sc.hasNextLong() && hasNextWithPrefix("-");
        } // -

        // Short
        private final boolean hasNextPositiveShort() {
            return this.sc.hasNextShort() && !hasNextWithPrefix("-");
        } // +
        private final boolean hasNextNegativeShort() {
            return this.sc.hasNextShort() && hasNextWithPrefix("-");
        } // -

        // Byte
        private final boolean hasNextPositiveByte() {
            return this.sc.hasNextByte() && !hasNextWithPrefix("-");
        } // +
        private final boolean hasNextNegativeByte() {
            return this.sc.hasNextByte() && hasNextWithPrefix("-");
        } // -

    //  ▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁
    //  Other Methods

        public final boolean hasNext(String s) {
            return this.sc.hasNext(s);
        }

    }


//█████████████████████████████████████████████████████████████████████████████████████████████████████████
//██▛▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▜████████████████████████████████████████████████████████████████████████████████
//██▌   Reverse Methods   ▐████████████████████████████████████████████████████████████████████████████████
//██▙▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▟████████████████████████████████████████████████████████████████████████████████

    public static final String reversed(String str) {
        return new StringBuilder(str).reverse().toString();
    }
    public static final <T> T[] reversed(T[] arr) {
        T[] reversedArr = arr;
        Collections.reverse(Arrays.asList(reversedArr));

        return reversedArr;

    }
    public static final <T extends List<T>> void reverse (T list) {
        Collections.reverse(list);
    }
    public static final <T extends List<T>> T reversed (T list) {
        var reversedList = list;
        Collections.reverse(reversedList);
        return list;
    }


////▛▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀██████████████████████████████████████████████████████████████████████████████████████
} //▌ END OF CLASS  ██████████████████████████████████████████████████████████████████████████████████████












//█████████████████████████████████████████████████████████████████████████████████████████████████████████
//██▛▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▜████████████████████████████████████████████████████████████████████████████████
//██▌     Old Methods     ▐████████████████████████████████████████████████████████████████████████████████
//██▙▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▟████████████████████████████████████████████████████████████████████████████████


//  ▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁
////  Reduce Enumeration
//    public enum Operation {
//
//        addition {
//            @Override public int     apply(int     x, int     y) { return x + y; }
//            @Override public double  apply(double  x, double  y) { return x + y; }
//            @Override public long    apply(long    x, long    y) { return x + y; }
//        },
//
//        subtraction {
//            @Override public int     apply(int     x, int     y) { return x - y; }
//            @Override public double  apply(double  x, double  y) { return x - y; }
//            @Override public long    apply(long    x, long    y) { return x - y; }
//        },
//
//        multiplication {
//            @Override public int     apply(int     x, int     y) { return x * y; }
//            @Override public double  apply(double  x, double  y) { return x * y; }
//            @Override public long    apply(long    x, long    y) { return x * y; }
//        },
//
//        division {
//            @Override public int     apply(int     x, int     y) { return x / y; }
//            @Override public double  apply(double  x, double  y) { return x / y; }
//            @Override public long    apply(long    x, long    y) { return x / y; }
//        };
//
//        protected abstract int apply(int x, int y);
//        protected abstract double apply(double x, double y);
//        protected abstract long apply(long x, long y);
//    }
//
////  ▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁
////  Reduce Array Lists
//    public static final int    reduce(ArrayList<Integer> list, Operation operation, int    initialValue) {
//        for (int element : list.) { initialValue = operation.apply(initialValue, element); }
//        return initialValue;
//    }
//    public static final double reduce(ArrayList<Double>  list, Operation operation, double initialValue) {
//        //noinspection SingleStatementInBlock
//        for (double element : list) { initialValue = operation.apply(initialValue, element); }
//        return initialValue;
//    }
//    public static final long   reduce(ArrayList<Long>    list, Operation operation, long   initialValue) {
//        //noinspection SingleStatementInBlock
//        for (long element : list) { initialValue = operation.apply(initialValue, element); }
//        return initialValue;
//    }
//
////  ▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁
////  Reduce Arrays
//    public static final int    reduce(int[]    arr, Operation operation, int    initialValue) {
//        for (int element : arr) { initialValue = operation.apply(initialValue, element); }
//        return initialValue;
//    }
//    public static final double reduce(double[] arr, Operation operation, double initialValue) {
//        for (double element : arr) { initialValue = operation.apply(initialValue, element); }
//        return initialValue;
//    }
//    public static final long   reduce(long[]   arr, Operation operation, long   initialValue) {
//        for (long element : arr) { initialValue = operation.apply(initialValue, element); }
//        return initialValue;
//    }
//
////  ▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁
////  Contains
//    @SuppressWarnings("Convert2streamapi")
//    public static final <T> boolean contains(ArrayList<T> arrayList, T value) {
//        for (T element : arrayList) {
//            if (value.equals(element)) { return true; }
//        }
//        return false;
//    }
//    public static final <T> boolean contains(T[] array, T value) {
//        for (T element : array) {
//            if (value.equals(element)) { return true; }
//        }
//        return false;
//    }