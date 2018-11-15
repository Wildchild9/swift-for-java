package Swift;

/*
 *
 * SwiftConversion.java
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

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


class SwiftConversion {

    // Int conversion methods
    public static int Int(int n) {
        return  n;
    }
    public static int Int(double n) {
        return (int) n;
    }
    public static int Int(float n) {
        return (int) n;
    }
    public static int Int(long n) {
        return (int) n;
    }
    public static int Int(short n) {
        return (int) n;
    }
    public static int Int(byte n) {
        return (int) n;
    }
    public static int Int(Integer n) {
        return n.intValue();
    }
    public static int Int(Double n) {
        return n.intValue();
    }
    public static int Int(Float n) {
        return n.intValue();
    }
    public static int Int(Long n) {
        return n.intValue();
    }
    public static int Int(Short n) {
        return n.intValue();
    }
    public static int Int(Byte n) {
        return n.intValue();
    }

    // Double conversion methods
    public static double Double(int n) {
        return (double) n;
    }
    public static double Double(double n) {
        return  n;
    }
    public static double Double(float n) {
        return (double) n;
    }
    public static double Double(long n) {
        return (double) n;
    }
    public static double Double(short n) {
        return (double) n;
    }
    public static double Double(byte n) {
        return (double) n;
    }
    public static double Double(Integer n) {
        return n.doubleValue();
    }
    public static double Double(Double n) {
        return n.doubleValue();
    }
    public static double Double(Float n) {
        return n.doubleValue();
    }
    public static double Double(Long n) {
        return n.doubleValue();
    }
    public static double Double(Short n) {
        return n.doubleValue();
    }
    public static double Double(Byte n) {
        return n.doubleValue();
    }

    // Float conversion methods
    public static float Float(int n) {
        return (float) n;
    }
    public static float Float(double n) {
        return (float) n;
    }
    public static float Float(float n) {
        return  n;
    }
    public static float Float(long n) {
        return (float) n;
    }
    public static float Float(short n) {
        return (float) n;
    }
    public static float Float(byte n) {
        return (float) n;
    }
    public static float Float(Integer n) {
        return n.floatValue();
    }
    public static float Float(Double n) {
        return n.floatValue();
    }
    public static float Float(Float n) {
        return n.floatValue();
    }
    public static float Float(Long n) {
        return n.floatValue();
    }
    public static float Float(Short n) {
        return n.floatValue();
    }
    public static float Float(Byte n) {
        return n.floatValue();
    }

    // Long conversion methods
    public static long Long(int n) {
        return (long) n;
    }
    public static long Long(double n) {
        return (long) n;
    }
    public static long Long(float n) {
        return (long) n;
    }
    public static long Long(long n) {
        return  n;
    }
    public static long Long(short n) {
        return (long) n;
    }
    public static long Long(byte n) {
        return (long) n;
    }
    public static long Long(Integer n) {
        return n.longValue();
    }
    public static long Long(Double n) {
        return n.longValue();
    }
    public static long Long(Float n) {
        return n.longValue();
    }
    public static long Long(Long n) {
        return n.longValue();
    }
    public static long Long(Short n) {
        return n.longValue();
    }
    public static long Long(Byte n) {
        return n.longValue();
    }

    // Short conversion methods
    public static short Short(int n) {
        return (short) n;
    }
    public static short Short(double n) {
        return (short) n;
    }
    public static short Short(float n) {
        return (short) n;
    }
    public static short Short(long n) {
        return (short) n;
    }
    public static short Short(short n) {
        return  n;
    }
    public static short Short(byte n) {
        return (short) n;
    }
    public static short Short(Integer n) {
        return n.shortValue();
    }
    public static short Short(Double n) {
        return n.shortValue();
    }
    public static short Short(Float n) {
        return n.shortValue();
    }
    public static short Short(Long n) {
        return n.shortValue();
    }
    public static short Short(Short n) {
        return n.shortValue();
    }
    public static short Short(Byte n) {
        return n.shortValue();
    }

    // Byte conversion methods
    public static byte Byte(int n) {
        return (byte) n;
    }
    public static byte Byte(double n) {
        return (byte) n;
    }
    public static byte Byte(float n) {
        return (byte) n;
    }
    public static byte Byte(long n) {
        return (byte) n;
    }
    public static byte Byte(short n) {
        return (byte) n;
    }
    public static byte Byte(byte n) {
        return  n;
    }
    public static byte Byte(Integer n) {
        return n.byteValue();
    }
    public static byte Byte(Double n) {
        return n.byteValue();
    }
    public static byte Byte(Float n) {
        return n.byteValue();
    }
    public static byte Byte(Long n) {
        return n.byteValue();
    }
    public static byte Byte(Short n) {
        return n.byteValue();
    }
    public static byte Byte(Byte n) {
        return n.byteValue();
    }

    // String conversion methods
    public static String String(int n) {
        return String.valueOf(n);
    }
    public static String String(double n) {
        return String.valueOf(n);
    }
    public static String String(float n) {
        return String.valueOf(n);
    }
    public static String String(long n) {
        return String.valueOf(n);
    }
    public static String String(short n) {
        return String.valueOf(n);
    }
    public static String String(byte n) {
        return String.valueOf(n);
    }
    public static String String(String n) {
        return n;
    }
    public static String String(Integer n) {
        return n.toString();
    }
    public static String String(Double n) {
        return n.toString();
    }
    public static String String(Float n) {
        return n.toString();
    }
    public static String String(Long n) {
        return n.toString();
    }
    public static String String(Short n) {
        return n.toString();
    }
    public static String String(Byte n) {
        return n.toString();
    }
    public static <T> String String(T s) {
        return s.toString();
    }

    // SwiftArray conversion and initializer methods
    public static <T> SwiftArray<T>   SwiftArray(Collection<T> collection) {
        return new SwiftArray<T>(collection);
    }
    public static <T> SwiftArray<T>   SwiftArray(ArrayList<T>  arrayList)  {
        return new SwiftArray<T>(arrayList);
    }
    public static <T> SwiftArray<T>   SwiftArray(Iterable<T>   elements)   {
        return new SwiftArray<T>(elements);
    }
    public static <T> SwiftArray<T>   SwiftArray(List<T>       list)       {
        return new SwiftArray<T>(list);
    }
    public static <T> SwiftArray<T>   SwiftArray(T...          array)      {
        return new SwiftArray<T>(array);
    }
    public static SwiftArray<Integer> SwiftArray(SwiftRange    range)      {
        return range.toSwiftArray();
    }

    public static SwiftArray SwiftArray() {
        return new SwiftArray();
    }

    // SwiftRange conversion and initializer methods
    public static SwiftRange SwiftRange(int     lowerBound, int     upperBound) {
        return new SwiftRange(lowerBound, upperBound);
    }
    public static SwiftRange SwiftRange(Integer lowerBound, Integer upperBound) {
        return new SwiftRange(lowerBound, upperBound);
    }
    public static SwiftRange SwiftRange(Integer lowerBound, int     upperBound) {
        return new SwiftRange(lowerBound, upperBound);
    }
    public static SwiftRange SwiftRange(int     lowerBound, Integer upperBound) {
        return new SwiftRange(lowerBound, upperBound);
    }


}
