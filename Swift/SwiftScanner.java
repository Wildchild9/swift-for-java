package Swift;;//
//
// SwiftScanner.java
// Swift for Java
//
//
// Last modified on 07/12/18 10:32 AM.
//
// Copyright © 2018 Noah Wilder. All rights reserved.
// This file is subject to the terms and conditions defined in
// file 'LICENSE', which is part of this source code package.
//

import java.io.*;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.nio.channels.ReadableByteChannel;
import java.nio.charset.Charset;
import java.nio.file.Path;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Locale;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.regex.MatchResult;
import java.util.regex.Pattern;
import java.util.stream.Stream;


@SuppressWarnings({"SingleStatementInBlock", "unused", "WeakerAccess"})
public class SwiftScanner implements Iterator<String>, Closeable {

    public LazyScanner lazy = new LazyScanner();
    private Scanner sc;

    // Constructors
    public SwiftScanner(Readable source) {
        this.sc = new Scanner(source);
        this.sc.useDelimiter("\n");
    }

    public SwiftScanner(InputStream source) {
        this.sc = new Scanner(source);
        this.sc.useDelimiter("\n");
    }

    public SwiftScanner(InputStream source, String charsetName) {
        this.sc = new Scanner(source, charsetName);
        this.sc.useDelimiter("\n");
    }

    public SwiftScanner(InputStream source, Charset charset) {
        this.sc = new Scanner(source, charset);
        this.sc.useDelimiter("\n");
    }

    public SwiftScanner(File source) throws FileNotFoundException {
        this.sc = new Scanner(source);
        this.sc.useDelimiter("\n");
    }

    public SwiftScanner(File source, String charsetName) throws FileNotFoundException {
        this.sc = new Scanner(source, charsetName);
        this.sc.useDelimiter("\n");
    }

    public SwiftScanner(File source, Charset charset) throws IOException {
        this.sc = new Scanner(source, charset);
        this.sc.useDelimiter("\n");
    }

    public SwiftScanner(Path source) throws IOException {
        this.sc = new Scanner(source);
        this.sc.useDelimiter("\n");
    }

    public SwiftScanner(Path source, String charsetName) throws IOException {
        this.sc = new Scanner(source, charsetName);
        this.sc.useDelimiter("\n");
    }

    public SwiftScanner(Path source, Charset charset) throws IOException {
        this.sc = new Scanner(source, charset);
        this.sc.useDelimiter("\n");
    }

    public SwiftScanner(String source) {
        this.sc = new Scanner(source);
        this.sc.useDelimiter("\n");
    }

    public SwiftScanner(ReadableByteChannel source) {
        this.sc = new Scanner(source);
        this.sc.useDelimiter("\n");
    }

    public SwiftScanner(ReadableByteChannel source, String charsetName) {
        this.sc = new Scanner(source, charsetName);
        this.sc.useDelimiter("\n");
    }

    public SwiftScanner(ReadableByteChannel source, Charset charset) {
        this.sc = new Scanner(source, charset);
        this.sc.useDelimiter("\n");
    }

    @Override
    public void close() {
        sc.close();
    }

    @Override
    public boolean hasNext() {
        return sc.hasNext();
    }

    @Override
    public String next() {
        return sc.next();
    }

    @Override
    public void remove() {
        sc.remove();
    }

    @Override
    public void forEachRemaining(Consumer<? super String> action) {
        sc.forEachRemaining(action);
    }

    public IOException ioException() {
        return sc.ioException();
    }

    public Pattern delimiter() {
        return sc.delimiter();
    }

    public Scanner useDelimiter(Pattern pattern) {
        return sc.useDelimiter(pattern);
    }

    public Scanner useDelimiter(String pattern) {
        return sc.useDelimiter(pattern);
    }

    public Locale locale() {
        return sc.locale();
    }

    public Scanner useLocale(Locale locale) {
        return sc.useLocale(locale);
    }

    public int radix() {
        return sc.radix();
    }

    public Scanner useRadix(int radix) {
        return sc.useRadix(radix);
    }

    public MatchResult match() {
        return sc.match();
    }

    public boolean hasNext(String pattern) {
        return sc.hasNext(pattern);
    }

    public String next(String pattern) {
        return sc.next(pattern);
    }

    public boolean hasNext(Pattern pattern) {
        return sc.hasNext(pattern);
    }

    public String next(Pattern pattern) {
        return sc.next(pattern);
    }

    public boolean hasNextLine() {
        return sc.hasNextLine();
    }

    public String nextLine() {
        return sc.nextLine();
    }

    public String findInLine(String pattern) {
        return sc.findInLine(pattern);
    }

    public String findInLine(Pattern pattern) {
        return sc.findInLine(pattern);
    }

    public String findWithinHorizon(String pattern, int horizon) {
        return sc.findWithinHorizon(pattern, horizon);
    }

    public String findWithinHorizon(Pattern pattern, int horizon) {
        return sc.findWithinHorizon(pattern, horizon);
    }

    public Scanner skip(Pattern pattern) {
        return sc.skip(pattern);
    }

    public Scanner skip(String pattern) {
        return sc.skip(pattern);
    }

    public boolean hasNextBoolean() {
        return sc.hasNextBoolean();
    }

    public boolean nextBoolean() {
        return sc.nextBoolean();
    }

    public boolean hasNextByte() {
        return sc.hasNextByte();
    }

    public boolean hasNextByte(int radix) {
        return sc.hasNextByte(radix);
    }

    public byte nextByte() {
        return sc.nextByte();
    }

    public byte nextByte(int radix) {
        return sc.nextByte(radix);
    }

    public boolean hasNextShort() {
        return sc.hasNextShort();
    }

    public boolean hasNextShort(int radix) {
        return sc.hasNextShort(radix);
    }

    public short nextShort() {
        return sc.nextShort();
    }

    public short nextShort(int radix) {
        return sc.nextShort(radix);
    }

    public boolean hasNextInt() {
        return sc.hasNextInt();
    }

    public boolean hasNextInt(int radix) {
        return sc.hasNextInt(radix);
    }

    public int nextInt() {
        return sc.nextInt();
    }

    public int nextInt(int radix) {
        return sc.nextInt(radix);
    }

    public boolean hasNextLong() {
        return sc.hasNextLong();
    }

    public boolean hasNextLong(int radix) {
        return sc.hasNextLong(radix);
    }

    public long nextLong() {
        return sc.nextLong();
    }

    public long nextLong(int radix) {
        return sc.nextLong(radix);
    }

    public boolean hasNextFloat() {
        return sc.hasNextFloat();
    }

    public float nextFloat() {
        return sc.nextFloat();
    }

    public boolean hasNextDouble() {
        return sc.hasNextDouble();
    }

    public double nextDouble() {
        return sc.nextDouble();
    }

    public boolean hasNextBigInteger() {
        return sc.hasNextBigInteger();
    }

    public boolean hasNextBigInteger(int radix) {
        return sc.hasNextBigInteger(radix);
    }

    public BigInteger nextBigInteger() {
        return sc.nextBigInteger();
    }

    public BigInteger nextBigInteger(int radix) {
        return sc.nextBigInteger(radix);
    }

    public boolean hasNextBigDecimal() {
        return sc.hasNextBigDecimal();
    }

    public BigDecimal nextBigDecimal() {
        return sc.nextBigDecimal();
    }

    public Scanner reset() {
        return sc.reset();
    }

    public Stream<String> tokens() {
        return sc.tokens();
    }

    public Stream<MatchResult> findAll(Pattern pattern) {
        return sc.findAll(pattern);
    }

    public Stream<MatchResult> findAll(String patString) {
        return sc.findAll(patString);
    }

    // Next methods with predicates
    public String next(Predicate<String> predicate) {
        var satisfiesPredicate = false;
        var s = "";
        while (!satisfiesPredicate) {
            if (this.sc.hasNext()) {
                var sc2 = new Scanner(System.in);
                var x = this.sc.next();

                if (predicate.test(x)) {
                    s = x;
                    satisfiesPredicate = true;
                } else {
                    System.out.println("Invalid input, please try again");
                    this.sc.nextLine();
                }

            } else {
                System.out.println("Invalid input, please try again");
                this.sc.nextLine();
            }
        }

        return s;
    }

    public String next(Predicate<String> predicate, String invalidInputMessage) {
        var useInputInMessage = Pattern.compile("(\\*input\\*)").matcher(invalidInputMessage).groupCount() > 0;
        var satisfiesPredicate = false;
        var s = "";
        while (!satisfiesPredicate) {
            String message;
            if (useInputInMessage) {
                Pattern p = Pattern.compile("\\*input\\*", Pattern.DOTALL | Pattern.CASE_INSENSITIVE);
                message = p.matcher(invalidInputMessage).replaceAll(this.lazy.nextLine());
            } else {
                message = invalidInputMessage;
            }

            if (this.sc.hasNext()) {
                var sc2 = new Scanner(System.in);
                var x = this.sc.next();

                if (predicate.test(x)) {
                    s = x;
                    satisfiesPredicate = true;
                } else {
                    System.out.println(message);
                    this.sc.nextLine();
                }

            } else {
                System.out.println(message);
                this.sc.nextLine();
            }
        }

        return s;
    }

    public String nextLine(Predicate<String> predicate) {
        var satisfiesPredicate = false;
        var s = "";
        while (!satisfiesPredicate) {
            if (this.sc.hasNext()) {
                var sc2 = new Scanner(System.in);
                var x = this.sc.nextLine();

                if (predicate.test(x)) {
                    s = x;
                    satisfiesPredicate = true;
                } else {
                    System.out.println("Invalid input, please try again");
                    this.sc.nextLine();
                }

            } else {
                System.out.println("Invalid input, please try again");
                this.sc.nextLine();
            }
        }

        return s;
    }

    public String nextLine(Predicate<String> predicate, String invalidInputMessage) {
        var useInputInMessage = Pattern.compile("(\\*input\\*)").matcher(invalidInputMessage).groupCount() > 0;

        var satisfiesPredicate = false;

        var s = "";
        while (!satisfiesPredicate) {
            String message;
            if (useInputInMessage) {
                Pattern p = Pattern.compile("\\*input\\*", Pattern.DOTALL | Pattern.CASE_INSENSITIVE);
                message = p.matcher(invalidInputMessage).replaceAll(this.lazy.nextLine());
            } else {
                message = invalidInputMessage;
            }

            if (this.sc.hasNext()) {
                var sc2 = new Scanner(System.in);
                var x = this.sc.nextLine();

                if (predicate.test(x)) {
                    s = x;
                    satisfiesPredicate = true;
                } else {
                    System.out.println(message);
                    this.sc.nextLine();
                }

            } else {
                System.out.println(message);
                this.sc.nextLine();
            }
        }

        return s;
    }

    public int nextInt(Predicate<Integer> predicate) {
        var satisfiesPredicate = false;
        var n = 0;
        while (!satisfiesPredicate) {
            if (this.sc.hasNextInt()) {
                var sc2 = new Scanner(System.in);
                var x = this.sc.nextInt();

                if (predicate.test(x)) {
                    n = x;
                    satisfiesPredicate = true;
                } else {
                    System.out.println("Invalid input, please try again");
                    this.sc.nextLine();
                }

            } else {
                System.out.println("Invalid input, please try again");
                this.sc.nextLine();
            }
        }

        return n;
    }

    public int nextInt(Predicate<Integer> predicate, String invalidInputMessage) {

        var useInputInMessage = Pattern.compile("(\\*input\\*)").matcher(invalidInputMessage).groupCount() > 0;

        var satisfiesPredicate = false;
        var n = 0;
        while (!satisfiesPredicate) {
            String message;
            if (useInputInMessage) {
                Pattern p = Pattern.compile("\\*input\\*", Pattern.DOTALL | Pattern.CASE_INSENSITIVE);
                message = p.matcher(invalidInputMessage).replaceAll(this.lazy.nextLine());
            } else {
                message = invalidInputMessage;
            }

            if (this.sc.hasNextInt()) {
                var sc2 = new Scanner(System.in);
                var x = this.sc.nextInt();

                if (predicate.test(x)) {
                    n = x;
                    satisfiesPredicate = true;
                } else {
                    System.out.println(message);
                    this.sc.nextLine();
                }

            } else {
                System.out.println(message);
                this.sc.nextLine();
            }
            message = null;
        }

        return n;
    }

    public double nextDouble(Predicate<Double> predicate) {
        var satisfiesPredicate = false;
        double n = 0;
        while (!satisfiesPredicate) {
            if (this.sc.hasNextDouble()) {
                var sc2 = new Scanner(System.in);
                var x = this.sc.nextDouble();

                if (predicate.test(x)) {
                    n = x;
                    satisfiesPredicate = true;
                } else {
                    System.out.println("Invalid input, please try again");
                    this.sc.nextLine();
                }

            } else {
                System.out.println("Invalid input, please try again");
                this.sc.nextLine();
            }
        }

        return n;
    }

    public double nextDouble(Predicate<Double> predicate, String invalidInputMessage) {

        var useInputInMessage = Pattern.compile("(\\*input\\*)").matcher(invalidInputMessage).groupCount() > 0;

        var satisfiesPredicate = false;
        double n = 0;
        while (!satisfiesPredicate) {
            String message;
            if (useInputInMessage) {
                Pattern p = Pattern.compile("\\*input\\*", Pattern.DOTALL | Pattern.CASE_INSENSITIVE);
                message = p.matcher(invalidInputMessage).replaceAll(this.lazy.nextLine());
            } else {
                message = invalidInputMessage;
            }

            if (this.sc.hasNextDouble()) {
                var sc2 = new Scanner(System.in);
                var x = this.sc.nextDouble();

                if (predicate.test(x)) {
                    n = x;
                    satisfiesPredicate = true;
                } else {
                    System.out.println(message);
                    this.sc.nextLine();
                }

            } else {
                System.out.println(message);
                this.sc.nextLine();
            }
            message = null;
        }

        return n;
    }

    public float nextFloat(Predicate<Float> predicate) {
        var satisfiesPredicate = false;
        float n = 0;
        while (!satisfiesPredicate) {
            if (this.sc.hasNextFloat()) {
                var sc2 = new Scanner(System.in);
                var x = this.sc.nextFloat();

                if (predicate.test(x)) {
                    n = x;
                    satisfiesPredicate = true;
                } else {
                    System.out.println("Invalid input, please try again");
                    this.sc.nextLine();
                }

            } else {
                System.out.println("Invalid input, please try again");
                this.sc.nextLine();
            }
        }

        return n;
    }

    public float nextFloat(Predicate<Float> predicate, String invalidInputMessage) {

        var useInputInMessage = Pattern.compile("(\\*input\\*)").matcher(invalidInputMessage).groupCount() > 0;

        var satisfiesPredicate = false;
        float n = 0;
        while (!satisfiesPredicate) {
            String message;
            if (useInputInMessage) {
                Pattern p = Pattern.compile("\\*input\\*", Pattern.DOTALL | Pattern.CASE_INSENSITIVE);
                message = p.matcher(invalidInputMessage).replaceAll(this.lazy.nextLine());
            } else {
                message = invalidInputMessage;
            }

            if (this.sc.hasNextFloat()) {
                var sc2 = new Scanner(System.in);
                var x = this.sc.nextFloat();

                if (predicate.test(x)) {
                    n = x;
                    satisfiesPredicate = true;
                } else {
                    System.out.println(message);
                    this.sc.nextLine();
                }

            } else {
                System.out.println(message);
                this.sc.nextLine();
            }
            message = null;
        }

        return n;
    }

    public long nextLong(Predicate<Long> predicate) {
        var satisfiesPredicate = false;
        long n = 0;
        while (!satisfiesPredicate) {
            if (this.sc.hasNextLong()) {
                var sc2 = new Scanner(System.in);
                var x = this.sc.nextLong();

                if (predicate.test(x)) {
                    n = x;
                    satisfiesPredicate = true;
                } else {
                    System.out.println("Invalid input, please try again");
                    this.sc.nextLine();
                }

            } else {
                System.out.println("Invalid input, please try again");
                this.sc.nextLine();
            }
        }

        return n;
    }

    public long nextLong(Predicate<Long> predicate, String invalidInputMessage) {

        var useInputInMessage = Pattern.compile("(\\*input\\*)").matcher(invalidInputMessage).groupCount() > 0;

        var satisfiesPredicate = false;
        long n = 0;
        while (!satisfiesPredicate) {
            String message;
            if (useInputInMessage) {
                Pattern p = Pattern.compile("\\*input\\*", Pattern.DOTALL | Pattern.CASE_INSENSITIVE);
                message = p.matcher(invalidInputMessage).replaceAll(this.lazy.nextLine());
            } else {
                message = invalidInputMessage;
            }

            if (this.sc.hasNextLong()) {
                var sc2 = new Scanner(System.in);
                var x = this.sc.nextLong();

                if (predicate.test(x)) {
                    n = x;
                    satisfiesPredicate = true;
                } else {
                    System.out.println(message);
                    this.sc.nextLine();
                }

            } else {
                System.out.println(message);
                this.sc.nextLine();
            }
            message = null;
        }

        return n;
    }

    public short nextShort(Predicate<Short> predicate) {
        var satisfiesPredicate = false;
        short n = 0;
        while (!satisfiesPredicate) {
            if (this.sc.hasNextShort()) {
                var sc2 = new Scanner(System.in);
                var x = this.sc.nextShort();

                if (predicate.test(x)) {
                    n = x;
                    satisfiesPredicate = true;
                } else {
                    System.out.println("Invalid input, please try again");
                    this.sc.nextLine();
                }

            } else {
                System.out.println("Invalid input, please try again");
                this.sc.nextLine();
            }
        }

        return n;
    }

    public short nextShort(Predicate<Short> predicate, String invalidInputMessage) {

        var useInputInMessage = Pattern.compile("(\\*input\\*)").matcher(invalidInputMessage).groupCount() > 0;

        var satisfiesPredicate = false;
        short n = 0;
        while (!satisfiesPredicate) {
            String message;
            if (useInputInMessage) {
                Pattern p = Pattern.compile("\\*input\\*", Pattern.DOTALL | Pattern.CASE_INSENSITIVE);
                message = p.matcher(invalidInputMessage).replaceAll(this.lazy.nextLine());
            } else {
                message = invalidInputMessage;
            }

            if (this.sc.hasNextShort()) {
                var sc2 = new Scanner(System.in);
                var x = this.sc.nextShort();

                if (predicate.test(x)) {
                    n = x;
                    satisfiesPredicate = true;
                } else {
                    System.out.println(message);
                    this.sc.nextLine();
                }

            } else {
                System.out.println(message);
                this.sc.nextLine();
            }
            message = null;
        }

        return n;
    }

    public byte nextByte(Predicate<Byte> predicate) {
        var satisfiesPredicate = false;
        byte n = 0;
        while (!satisfiesPredicate) {
            if (this.sc.hasNextByte()) {
                var sc2 = new Scanner(System.in);
                var x = this.sc.nextByte();

                if (predicate.test(x)) {
                    n = x;
                    satisfiesPredicate = true;
                } else {
                    System.out.println("Invalid input, please try again");
                    this.sc.nextLine();
                }

            } else {
                System.out.println("Invalid input, please try again");
                this.sc.nextLine();
            }
        }

        return n;
    }

    public byte nextByte(Predicate<Byte> predicate, String invalidInputMessage) {

        var useInputInMessage = Pattern.compile("(\\*input\\*)").matcher(invalidInputMessage).groupCount() > 0;

        var satisfiesPredicate = false;
        byte n = 0;
        while (!satisfiesPredicate) {
            String message;
            if (useInputInMessage) {
                Pattern p = Pattern.compile("\\*input\\*", Pattern.DOTALL | Pattern.CASE_INSENSITIVE);
                message = p.matcher(invalidInputMessage).replaceAll(this.lazy.nextLine());
            } else {
                message = invalidInputMessage;
            }

            if (this.sc.hasNextByte()) {
                var sc2 = new Scanner(System.in);
                var x = this.sc.nextByte();

                if (predicate.test(x)) {
                    n = x;
                    satisfiesPredicate = true;
                } else {
                    System.out.println(message);
                    this.sc.nextLine();
                }

            } else {
                System.out.println(message);
                this.sc.nextLine();
            }
            message = null;
        }

        return n;
    }

    public BigInteger nextBigInteger(Predicate<BigInteger> predicate) {
        var satisfiesPredicate = false;
        var n = BigInteger.ZERO;
        while (!satisfiesPredicate) {
            if (this.sc.hasNextBigInteger()) {
                var sc2 = new Scanner(System.in);
                var x = this.sc.nextBigInteger();

                if (predicate.test(x)) {
                    n = x;
                    satisfiesPredicate = true;
                } else {
                    System.out.println("Invalid input, please try again");
                    this.sc.nextLine();
                }

            } else {
                System.out.println("Invalid input, please try again");
                this.sc.nextLine();
            }
        }

        return n;
    }

    public BigInteger nextBigInteger(Predicate<BigInteger> predicate, String invalidInputMessage) {

        var useInputInMessage = Pattern.compile("(\\*input\\*)").matcher(invalidInputMessage).groupCount() > 0;

        var satisfiesPredicate = false;
        var n = BigInteger.ZERO;
        while (!satisfiesPredicate) {
            String message;
            if (useInputInMessage) {
                Pattern p = Pattern.compile("\\*input\\*", Pattern.DOTALL | Pattern.CASE_INSENSITIVE);
                message = p.matcher(invalidInputMessage).replaceAll(this.lazy.nextLine());
            } else {
                message = invalidInputMessage;
            }

            if (this.sc.hasNextBigInteger()) {
                var sc2 = new Scanner(System.in);
                var x = this.sc.nextBigInteger();

                if (predicate.test(x)) {
                    n = x;
                    satisfiesPredicate = true;
                } else {
                    System.out.println(message);
                    this.sc.nextLine();
                }

            } else {
                System.out.println(message);
                this.sc.nextLine();
            }
            message = null;
        }

        return n;
    }

    public BigDecimal nextBigDecimal(Predicate<BigDecimal> predicate) {
        var satisfiesPredicate = false;
        var n = BigDecimal.ZERO;
        while (!satisfiesPredicate) {
            if (this.sc.hasNextBigDecimal()) {
                var sc2 = new Scanner(System.in);
                var x = this.sc.nextBigDecimal();

                if (predicate.test(x)) {
                    n = x;
                    satisfiesPredicate = true;
                } else {
                    System.out.println("Invalid input, please try again");
                    this.sc.nextLine();
                }

            } else {
                System.out.println("Invalid input, please try again");
                this.sc.nextLine();
            }
        }

        return n;
    }

    public BigDecimal nextBigDecimal(Predicate<BigDecimal> predicate, String invalidInputMessage) {

        var useInputInMessage = Pattern.compile("(\\*input\\*)").matcher(invalidInputMessage).groupCount() > 0;

        var satisfiesPredicate = false;
        var n = BigDecimal.ZERO;
        while (!satisfiesPredicate) {
            String message;
            if (useInputInMessage) {
                Pattern p = Pattern.compile("\\*input\\*", Pattern.DOTALL | Pattern.CASE_INSENSITIVE);
                message = p.matcher(invalidInputMessage).replaceAll(this.lazy.nextLine());
            } else {
                message = invalidInputMessage;
            }

            if (this.sc.hasNextBigDecimal()) {
                var sc2 = new Scanner(System.in);
                var x = this.sc.nextBigDecimal();

                if (predicate.test(x)) {
                    n = x;
                    satisfiesPredicate = true;
                } else {
                    System.out.println(message);
                    this.sc.nextLine();
                }

            } else {
                System.out.println(message);
                this.sc.nextLine();
            }
            message = null;
        }

        return n;
    }

    public boolean nextBoolean(boolean value) {
        var satisfiesPredicate = false;
        var n = false;
        while (!satisfiesPredicate) {
            if (this.sc.hasNextBoolean()) {
                var sc2 = new Scanner(System.in);
                var x = this.sc.nextBoolean();

                if (x == value) {
                    n = x;
                    satisfiesPredicate = true;
                } else {
                    System.out.println("Invalid input, please try again");
                    this.sc.nextLine();
                }

            } else {
                System.out.println("Invalid input, please try again");
                this.sc.nextLine();
            }
        }

        return n;
    }

    public boolean nextBoolean(boolean value, String invalidInputMessage) {
        var useInputInMessage = false;
        var pattern = Pattern.compile("(\\*input\\*)");
        var match = pattern.matcher(invalidInputMessage);
        String[] strArray;
        if (match.groupCount() > 0) {
            useInputInMessage = true;
            strArray = invalidInputMessage.split("\\*input\\*");
        } else {
            strArray = null;
        }


        var satisfiesPredicate = false;
        var n = false;
        while (!satisfiesPredicate) {
            String message;
            if (useInputInMessage) {
                message = String.join(this.lazy.nextLine(), strArray);
            } else {
                message = invalidInputMessage;
            }

            if (this.sc.hasNextBoolean()) {
                var sc2 = new Scanner(System.in);
                var x = this.sc.nextBoolean();

                if (x == value) {
                    n = x;
                    satisfiesPredicate = true;
                } else {
                    System.out.println(message);
                    this.sc.nextLine();
                }

            } else {
                System.out.println(message);
                this.sc.nextLine();
            }
        }

        return n;
    }

    // Next valid input methods
    public String nextValid(String invalidInputMessage) {
        var useInputInMessage = Pattern.compile("(\\*input\\*)").matcher(invalidInputMessage).groupCount() > 0;
        while (!sc.hasNext()) {
            String message;
            if (useInputInMessage) {
                Pattern p = Pattern.compile("\\*input\\*", Pattern.DOTALL | Pattern.CASE_INSENSITIVE);
                message = p.matcher(invalidInputMessage).replaceAll(this.lazy.nextLine());
            } else {
                message = invalidInputMessage;
            }

            System.out.println(message);
            sc.nextLine();
        }
        return sc.next();
    }
    public String nextValid() {
        while (!sc.hasNext()) {
            System.out.println("Invalid input, please try again");
            sc.nextLine();
        }
        return sc.next();
    }

    public String nextValidLine(String invalidInputMessage) {
        var useInputInMessage = Pattern.compile("(\\*input\\*)").matcher(invalidInputMessage).groupCount() > 0;
        while (!sc.hasNextLine()) {
            String message;
            if (useInputInMessage) {
                Pattern p = Pattern.compile("\\*input\\*", Pattern.DOTALL | Pattern.CASE_INSENSITIVE);
                message = p.matcher(invalidInputMessage).replaceAll(this.lazy.nextLine());
            } else {
                message = invalidInputMessage;
            }

            System.out.println(message);
            sc.nextLine();
        }
        return sc.nextLine();
    }
    public String nextValidLine() {
        while (!sc.hasNextLine()) {
            System.out.println("Invalid input, please try again");
            sc.nextLine();
        }
        return sc.nextLine();
    }

    public int nextValidInt(String invalidInputMessage) {
        var useInputInMessage = Pattern.compile("(\\*input\\*)").matcher(invalidInputMessage).groupCount() > 0;
        while (!sc.hasNextInt()) {
            String message;
            if (useInputInMessage) {
                Pattern p = Pattern.compile("\\*input\\*", Pattern.DOTALL | Pattern.CASE_INSENSITIVE);
                message = p.matcher(invalidInputMessage).replaceAll(this.lazy.nextLine());
            } else {
                message = invalidInputMessage;
            }

            System.out.println(message);
            sc.nextLine();
        }
        return sc.nextInt();
    }
    public int nextValidInt() {
        while (!sc.hasNextInt()) {
            System.out.println("Invalid input, please try again");
            sc.nextLine();
        }
        return sc.nextInt();
    }

    public double nextValidDouble(String invalidInputMessage) {
        var useInputInMessage = Pattern.compile("(\\*input\\*)").matcher(invalidInputMessage).groupCount() > 0;
        while (!sc.hasNextDouble()) {
            String message;
            if (useInputInMessage) {
                Pattern p = Pattern.compile("\\*input\\*", Pattern.DOTALL | Pattern.CASE_INSENSITIVE);
                message = p.matcher(invalidInputMessage).replaceAll(this.lazy.nextLine());
            } else {
                message = invalidInputMessage;
            }

            System.out.println(message);
            sc.nextLine();
        }
        return sc.nextDouble();
    }
    public double nextValidDouble() {
        while (!sc.hasNextDouble()) {
            System.out.println("Invalid input, please try again");
            sc.nextLine();
        }
        return sc.nextDouble();
    }

    public long nextValidLong(String invalidInputMessage) {
        var useInputInMessage = Pattern.compile("(\\*input\\*)").matcher(invalidInputMessage).groupCount() > 0;
        while (!sc.hasNextLong()) {
            String message;
            if (useInputInMessage) {
                Pattern p = Pattern.compile("\\*input\\*", Pattern.DOTALL | Pattern.CASE_INSENSITIVE);
                message = p.matcher(invalidInputMessage).replaceAll(this.lazy.nextLine());
            } else {
                message = invalidInputMessage;
            }

            System.out.println(message);
            sc.nextLine();
        }
        return sc.nextLong();
    }
    public long nextValidLong() {
        while (!sc.hasNextLong()) {
            System.out.println("Invalid input, please try again");
            sc.nextLine();
        }
        return sc.nextLong();
    }

    public short nextValidShort(String invalidInputMessage) {
        var useInputInMessage = Pattern.compile("(\\*input\\*)").matcher(invalidInputMessage).groupCount() > 0;
        while (!sc.hasNextShort()) {
            String message;
            if (useInputInMessage) {
                Pattern p = Pattern.compile("\\*input\\*", Pattern.DOTALL | Pattern.CASE_INSENSITIVE);
                message = p.matcher(invalidInputMessage).replaceAll(this.lazy.nextLine());
            } else {
                message = invalidInputMessage;
            }

            System.out.println(message);
            sc.nextLine();
        }
        return sc.nextShort();
    }
    public short nextValidShort() {
        while (!sc.hasNextShort()) {
            System.out.println("Invalid input, please try again");
            sc.nextLine();
        }
        return sc.nextShort();
    }

    public BigInteger nextValidBigInteger(String invalidInputMessage) {
        var useInputInMessage = Pattern.compile("(\\*input\\*)").matcher(invalidInputMessage).groupCount() > 0;
        while (!sc.hasNextBigInteger()) {
            String message;
            if (useInputInMessage) {
                Pattern p = Pattern.compile("\\*input\\*", Pattern.DOTALL | Pattern.CASE_INSENSITIVE);
                message = p.matcher(invalidInputMessage).replaceAll(this.lazy.nextLine());
            } else {
                message = invalidInputMessage;
            }

            System.out.println(message);
            sc.nextLine();
        }
        return sc.nextBigInteger();
    }
    public BigInteger nextValidBigInteger() {
        while (!sc.hasNextBigInteger()) {
            System.out.println("Invalid input, please try again");
            sc.nextLine();
        }
        return sc.nextBigInteger();
    }

    public BigDecimal nextValidBigDecimal(String invalidInputMessage) {
        var useInputInMessage = Pattern.compile("(\\*input\\*)").matcher(invalidInputMessage).groupCount() > 0;
        while (!sc.hasNextBigDecimal()) {
            String message;
            if (useInputInMessage) {
                Pattern p = Pattern.compile("\\*input\\*", Pattern.DOTALL | Pattern.CASE_INSENSITIVE);
                message = p.matcher(invalidInputMessage).replaceAll(this.lazy.nextLine());
            } else {
                message = invalidInputMessage;
            }

            System.out.println(message);
            sc.nextLine();
        }
        return sc.nextBigDecimal();
    }
    public BigDecimal nextValidBigDecimal() {
        while (!sc.hasNextBigDecimal()) {
            System.out.println("Invalid input, please try again");
            sc.nextLine();
        }
        return sc.nextBigDecimal();
    }

    public boolean nextValidBoolean(String invalidInputMessage) {
        var useInputInMessage = Pattern.compile("(\\*input\\*)").matcher(invalidInputMessage).groupCount() > 0;
        while (!sc.hasNextBoolean()) {
            String message;
            if (useInputInMessage) {
                Pattern p = Pattern.compile("\\*input\\*", Pattern.DOTALL | Pattern.CASE_INSENSITIVE);
                message = p.matcher(invalidInputMessage).replaceAll(this.lazy.nextLine());
            } else {
                message = invalidInputMessage;
            }

            System.out.println(message);
            sc.nextLine();
        }
        return sc.nextBoolean();
    }
    public boolean nextValidBoolean() {
        while (!sc.hasNextBoolean()) {
            System.out.println("Invalid input, please try again");
            sc.nextLine();
        }
        return sc.nextBoolean();
    }

    public byte nextValidByte(String invalidInputMessage) {
        var useInputInMessage = Pattern.compile("(\\*input\\*)").matcher(invalidInputMessage).groupCount() > 0;
        while (!sc.hasNextByte()) {
            String message;
            if (useInputInMessage) {
                Pattern p = Pattern.compile("\\*input\\*", Pattern.DOTALL | Pattern.CASE_INSENSITIVE);
                message = p.matcher(invalidInputMessage).replaceAll(this.lazy.nextLine());
            } else {
                message = invalidInputMessage;
            }

            System.out.println(message);
            sc.nextLine();
        } return sc.nextByte();
    }
    public byte nextValidByte() {
        while (!sc.hasNextByte()) {
            System.out.println("Invalid input, please try again");
            sc.nextLine();
        }
        return sc.nextByte();
    }

    public float nextValidFloat(String invalidInputMessage) {
        var useInputInMessage = Pattern.compile("(\\*input\\*)").matcher(invalidInputMessage).groupCount() > 0;
        while (!sc.hasNextFloat()) {
            String message;
            if (useInputInMessage) {
                Pattern p = Pattern.compile("\\*input\\*", Pattern.DOTALL | Pattern.CASE_INSENSITIVE);
                message = p.matcher(invalidInputMessage).replaceAll(this.lazy.nextLine());
            } else {
                message = invalidInputMessage;
            }

            System.out.println(message);
            sc.nextLine();
        }
        return sc.nextFloat();
    }
    public float nextValidFloat() {
        while (!sc.hasNextFloat()) {
            System.out.println("Invalid input, please try again");
            sc.nextLine();
        }
        return sc.nextFloat();
    }


    // Has next methods that check if a predicate is also satisfied
    public boolean hasNext(Predicate<String> predicate) {
        return this.hasNext() && predicate.test(this.lazy.next());
    }


    // Note:
    //   - Occurrences of "*input*" in invalidInputMessage
    //     will be replaced with the value of the invalid input.
    //

    public boolean hasNextLine(Predicate<String> predicate) {
        return this.hasNextLine() && predicate.test(this.lazy.nextLine());
    }

    public boolean hasNextBoolean(Predicate<Boolean> predicate) {
        return this.hasNextBoolean() && predicate.test(this.lazy.nextBoolean());
    }

    public boolean hasNextByte(Predicate<Byte> predicate) {
        return this.hasNextByte() && predicate.test(this.lazy.nextByte());
    }

    public boolean hasNextShort(Predicate<Short> predicate) {
        return this.hasNextShort() && predicate.test(this.lazy.nextShort());
    }

    public boolean hasNextInt(Predicate<Integer> predicate) {
        return this.hasNextInt() && predicate.test(this.lazy.nextInt());
    }

    public boolean hasNextLong(Predicate<Long> predicate) {
        return this.hasNextLong() && predicate.test(this.lazy.nextLong());
    }

    public boolean hasNextFloat(Predicate<Float> predicate) {
        return this.hasNextFloat() && predicate.test(this.lazy.nextFloat());
    }

    public boolean hasNextDouble(Predicate<Double> predicate) {
        return this.hasNextDouble() && predicate.test(this.lazy.nextDouble());
    }

    public boolean hasNextBigInteger(Predicate<BigInteger> predicate) {
        return this.hasNextBigInteger() && predicate.test(this.lazy.nextBigInteger());
    }

    public boolean hasNextBigDecimal(Predicate<BigDecimal> predicate) {
        return this.hasNextBigDecimal() && predicate.test(this.lazy.nextBigDecimal());
    }

    public class LazyScanner {

        private LazyScanner() { }

        public String next() {
            sc.hasNext("(.*)");
            return sc.match().group(0);
        }

        public String nextLine() {
            sc.hasNext("(.*)");
            return sc.match().group(0);
        }

        public int nextInt() {
            sc.hasNext("(.*)");

            try {
                return Integer.parseInt(sc.match().group(0));
            }
            catch (NumberFormatException e) {
                throw new InputMismatchException();
            }

        }

        public long nextLong() {
            sc.hasNext("(.*)");
            try {
                return Long.parseLong(sc.match().group(0));
            }
            catch (NumberFormatException e) {
                throw new InputMismatchException();
            }
        }

        public double nextDouble() {
            sc.hasNext("(.*)");
            try {
                return Double.parseDouble(sc.match().group(0));
            }
            catch (NumberFormatException e) {
                throw new InputMismatchException();
            }
        }

        public short nextShort() {
            sc.hasNext("(.*)");
            try {
                return Short.parseShort(sc.match().group(0));
            }
            catch (NumberFormatException e) {
                throw new InputMismatchException();
            }
        }

        public byte nextByte() {
            sc.hasNext("(.*)");
            try {
                return Byte.parseByte(sc.match().group(0));
            }
            catch (NumberFormatException e) {
                throw new InputMismatchException();
            }
        }

        public float nextFloat() {
            sc.hasNext("(.*)");
            try {
                return Float.parseFloat(sc.match().group(0));
            }
            catch (NumberFormatException e) {
                throw new InputMismatchException();
            }
        }

        public boolean nextBoolean() {
            sc.hasNext("(.*)");
            try {
                return Boolean.parseBoolean(sc.match().group(0));
            }
            catch (NumberFormatException e) {
                throw new InputMismatchException();
            }

        }

        public BigInteger nextBigInteger() {
            sc.hasNext("(.*)");
            try {
                return new BigInteger(sc.match().group(0));
            }
            catch (NumberFormatException e) {
                throw new InputMismatchException();
            }
        }

        public BigDecimal nextBigDecimal() {
            sc.hasNext("(.*)");
            try {
                return new BigDecimal(sc.match().group(0));
            }
            catch (NumberFormatException e) {
                throw new InputMismatchException();
            }
        }

    }
}


/*
public String next(Predicate<String> predicate) {
        var satisfiesPredicate = false;
        var s = "";
        while (!satisfiesPredicate) {
            if (this.sc.hasNext()) {
                var sc2 = new Scanner(System.in);
                var x = this.sc.next();

                if (predicate.test(x)) {
                    s = x;
                    satisfiesPredicate = true;
                } else {
                    System.out.println("Invalid input, please try again");
                    this.sc.nextLine();
                }

            } else {
                System.out.println("Invalid input, please try again");
                this.sc.nextLine();
            }
        }

        return s;
    }
    public String next(Predicate<String> predicate, String invalidInputMessage) {
        var useInputInMessage = false;
        if (invalidInputMessage.contains("*input*")) useInputInMessage = true;

        var satisfiesPredicate = false;
        var s = "";
        while (!satisfiesPredicate) {


            if (this.sc.hasNext()) {
                var sc2 = new Scanner(System.in);
                var x = this.sc.next();

                if (predicate.test(x)) {
                    s = x;
                    satisfiesPredicate = true;
                } else {
                     if (useInputInMessage) {
                        System.out.println(invalidInputMessage.replaceAll("\\*input\\*", this.lazy.nextLine()));
                    } else {
                        System.out.println(invalidInputMessage);
                    }
                    this.sc.nextLine();
                }

            } else {
                 if (useInputInMessage) {
                        System.out.println(invalidInputMessage.replaceAll("\\*input\\*", this.lazy.nextLine()));
                    } else {
                        System.out.println(invalidInputMessage);
                    }
                this.sc.nextLine();
            }
        }

        return s;
    }

    public String nextLine(Predicate<String> predicate) {
        var satisfiesPredicate = false;
        var s = "";
        while (!satisfiesPredicate) {
            if (this.sc.hasNext()) {
                var sc2 = new Scanner(System.in);
                var x = this.sc.nextLine();

                if (predicate.test(x)) {
                    s = x;
                    satisfiesPredicate = true;
                } else {
                    System.out.println("Invalid input, please try again");
                    this.sc.nextLine();
                }

            } else {
                System.out.println("Invalid input, please try again");
                this.sc.nextLine();
            }
        }

        return s;
    }
    public String nextLine(Predicate<String> predicate, String invalidInputMessage) {
        var useInputInMessage = false;
        var pattern = Pattern.compile("(\\*input\\*)");
        var match = pattern.matcher(invalidInputMessage);
        String[] strArray;
        if (match.groupCount() > 0) {
            useInputInMessage = true;
            strArray = invalidInputMessage.split("\\*input\\*");
        } else {
            strArray = null;
        }


        var satisfiesPredicate = false;
        var s = "";
        while (!satisfiesPredicate) {


            if (this.sc.hasNext()) {
                var sc2 = new Scanner(System.in);
                var x = this.sc.nextLine();

                if (predicate.test(x)) {
                    s = x;
                    satisfiesPredicate = true;
                } else {
                    if (useInputInMessage) {
                        System.out.println(invalidInputMessage.replaceAll("\\*input\\*", this.lazy.nextLine()));
                    } else {
                        System.out.println(invalidInputMessage);
                    }
                    this.sc.nextLine();
                }

            } else {
                if (useInputInMessage) {
                        System.out.println(invalidInputMessage.replaceAll("\\*input\\*", this.lazy.nextLine()));
                    } else {
                        System.out.println(invalidInputMessage);
                    }
                this.sc.nextLine();
            }
        }

        return s;
    }

    public int nextInt(Predicate<Integer> predicate) {
        var satisfiesPredicate = false;
        var n = 0;
        while (!satisfiesPredicate) {
            if (this.sc.hasNextInt()) {
                var sc2 = new Scanner(System.in);
                var x = this.sc.nextInt();

                if (predicate.test(x)) {
                    n = x;
                    satisfiesPredicate = true;
                } else {
                    System.out.println("Invalid input, please try again");
                    this.sc.nextLine();
                }

            } else {
                System.out.println("Invalid input, please try again");
                this.sc.nextLine();
            }
        }

        return n;
    }
    public int nextInt(Predicate<Integer> predicate, String invalidInputMessage) {

        var useInputInMessage = false;
        if (invalidInputMessage.contains("*input*")) useInputInMessage = true;


        var satisfiesPredicate = false;
        var n = 0 ;
        while (!satisfiesPredicate) {

            if (this.sc.hasNextInt()) {
                var sc2 = new Scanner(System.in);
                var x = this.sc.nextInt();

                if (predicate.test(x)) {
                    n = x;
                    satisfiesPredicate = true;
                } else {
                    if (useInputInMessage) {
                        System.out.println(invalidInputMessage.replaceAll("\\*input\\*", this.lazy.nextLine()));
                    } else {
                        System.out.println(invalidInputMessage);
                    }
                    this.sc.nextLine();
                }

            } else {
                if (useInputInMessage) {
                    System.out.println(invalidInputMessage.replaceAll("\\*input\\*", this.lazy.nextLine()));
                } else {
                    System.out.println(invalidInputMessage);
                }
                this.sc.nextLine();
            }
        }

        return n;
    }

    public double nextDouble(Predicate<Double> predicate) {
        var satisfiesPredicate = false;
        double n = 0;
        while (!satisfiesPredicate) {
            if (this.sc.hasNextDouble()) {
                var sc2 = new Scanner(System.in);
                var x = this.sc.nextDouble();

                if (predicate.test(x)) {
                    n = x;
                    satisfiesPredicate = true;
                } else {
                    System.out.println("Invalid input, please try again");
                    this.sc.nextLine();
                }

            } else {
                System.out.println("Invalid input, please try again");
                this.sc.nextLine();
            }
        }

        return n;
    }
    public double nextDouble(Predicate<Double> predicate, String invalidInputMessage) {
        var useInputInMessage = false;
        if (invalidInputMessage.contains("*input*")) useInputInMessage = true;


        var satisfiesPredicate = false;
        double n = 0;
        while (!satisfiesPredicate) {


            if (this.sc.hasNextDouble()) {
                var sc2 = new Scanner(System.in);
                var x = this.sc.nextDouble();

                if (predicate.test(x)) {
                    n = x;
                    satisfiesPredicate = true;
                } else {
                    if (useInputInMessage) {
                        System.out.println(invalidInputMessage.replaceAll("\\*input\\*", this.lazy.nextLine()));
                    } else {
                        System.out.println(invalidInputMessage);
                    }
                    this.sc.nextLine();
                }

            } else {
                if (useInputInMessage) {
                        System.out.println(invalidInputMessage.replaceAll("\\*input\\*", this.lazy.nextLine()));
                    } else {
                        System.out.println(invalidInputMessage);
                    }
                this.sc.nextLine();
            }
        }

        return n;
    }

    public float nextFloat(Predicate<Float> predicate) {
        var satisfiesPredicate = false;
        float n = 0;
        while (!satisfiesPredicate) {
            if (this.sc.hasNextFloat()) {
                var sc2 = new Scanner(System.in);
                var x = this.sc.nextFloat();

                if (predicate.test(x)) {
                    n = x;
                    satisfiesPredicate = true;
                } else {
                    System.out.println("Invalid input, please try again");
                    this.sc.nextLine();
                }

            } else {
                System.out.println("Invalid input, please try again");
                this.sc.nextLine();
            }
        }

        return n;
    }
    public float nextFloat(Predicate<Float> predicate, String invalidInputMessage) {
        var useInputInMessage = false;
        if (invalidInputMessage.contains("*input*")) useInputInMessage = true;


        var satisfiesPredicate = false;
        float n = 0;
        while (!satisfiesPredicate) {


            if (this.sc.hasNextFloat()) {
                var sc2 = new Scanner(System.in);
                var x = this.sc.nextFloat();

                if (predicate.test(x)) {
                    n = x;
                    satisfiesPredicate = true;
                } else {
                    if (useInputInMessage) {
                        System.out.println(invalidInputMessage.replaceAll("\\*input\\*", this.lazy.nextLine()));
                    } else {
                        System.out.println(invalidInputMessage);
                    }
                    this.sc.nextLine();
                }

            } else {
                if (useInputInMessage) {
                        System.out.println(invalidInputMessage.replaceAll("\\*input\\*", this.lazy.nextLine()));
                    } else {
                        System.out.println(invalidInputMessage);
                    }
                this.sc.nextLine();
            }
        }

        return n;
    }

    public long nextLong(Predicate<Long> predicate) {
        var satisfiesPredicate = false;
        long n = 0;
        while (!satisfiesPredicate) {
            if (this.sc.hasNextLong()) {
                var sc2 = new Scanner(System.in);
                var x = this.sc.nextLong();

                if (predicate.test(x)) {
                    n = x;
                    satisfiesPredicate = true;
                } else {
                    System.out.println("Invalid input, please try again");
                    this.sc.nextLine();
                }

            } else {
                System.out.println("Invalid input, please try again");
                this.sc.nextLine();
            }
        }

        return n;
    }
    public long nextLong(Predicate<Long> predicate, String invalidInputMessage) {
        var useInputInMessage = false;
        if (invalidInputMessage.contains("*input*")) useInputInMessage = true;


        var satisfiesPredicate = false;
        long n = 0;
        while (!satisfiesPredicate) {


            if (this.sc.hasNextLong()) {
                var sc2 = new Scanner(System.in);
                var x = this.sc.nextLong();

                if (predicate.test(x)) {
                    n = x;
                    satisfiesPredicate = true;
                } else {
                    if (useInputInMessage) {
                        System.out.println(invalidInputMessage.replaceAll("\\*input\\*", this.lazy.nextLine()));
                    } else {
                        System.out.println(invalidInputMessage);
                    }
                    this.sc.nextLine();
                }

            } else {
                if (useInputInMessage) {
                        System.out.println(invalidInputMessage.replaceAll("\\*input\\*", this.lazy.nextLine()));
                    } else {
                        System.out.println(invalidInputMessage);
                    }
                this.sc.nextLine();
            }
        }

        return n;
    }

    public short nextShort(Predicate<Short> predicate) {
        var satisfiesPredicate = false;
        short n = 0;
        while (!satisfiesPredicate) {
            if (this.sc.hasNextShort()) {
                var sc2 = new Scanner(System.in);
                var x = this.sc.nextShort();

                if (predicate.test(x)) {
                    n = x;
                    satisfiesPredicate = true;
                } else {
                    System.out.println("Invalid input, please try again");
                    this.sc.nextLine();
                }

            } else {
                System.out.println("Invalid input, please try again");
                this.sc.nextLine();
            }
        }

        return n;
    }
    public short nextShort(Predicate<Short> predicate, String invalidInputMessage) {
        var useInputInMessage = false;
        if (invalidInputMessage.contains("*input*")) useInputInMessage = true;


        var satisfiesPredicate = false;
        short n = 0;
        while (!satisfiesPredicate) {


            if (this.sc.hasNextShort()) {
                var sc2 = new Scanner(System.in);
                var x = this.sc.nextShort();

                if (predicate.test(x)) {
                    n = x;
                    satisfiesPredicate = true;
                } else {
                    if (useInputInMessage) {
                        System.out.println(invalidInputMessage.replaceAll("\\*input\\*", this.lazy.nextLine()));
                    } else {
                        System.out.println(invalidInputMessage);
                    }
                    this.sc.nextLine();
                }

            } else {
                if (useInputInMessage) {
                        System.out.println(invalidInputMessage.replaceAll("\\*input\\*", this.lazy.nextLine()));
                    } else {
                        System.out.println(invalidInputMessage);
                    }
                this.sc.nextLine();
            }
        }

        return n;
    }

    public byte nextByte(Predicate<Byte> predicate) {
        var satisfiesPredicate = false;
        byte n = 0;
        while (!satisfiesPredicate) {
            if (this.sc.hasNextByte()) {
                var sc2 = new Scanner(System.in);
                var x = this.sc.nextByte();

                if (predicate.test(x)) {
                    n = x;
                    satisfiesPredicate = true;
                } else {
                    System.out.println("Invalid input, please try again");
                    this.sc.nextLine();
                }

            } else {
                System.out.println("Invalid input, please try again");
                this.sc.nextLine();
            }
        }

        return n;
    }
    public byte nextByte(Predicate<Byte> predicate, String invalidInputMessage) {
        var useInputInMessage = false;
        if (invalidInputMessage.contains("*input*")) useInputInMessage = true;


        var satisfiesPredicate = false;
        byte n = 0;
        while (!satisfiesPredicate) {


            if (this.sc.hasNextByte()) {
                var sc2 = new Scanner(System.in);
                var x = this.sc.nextByte();

                if (predicate.test(x)) {
                    n = x;
                    satisfiesPredicate = true;
                } else {
                    if (useInputInMessage) {
                        System.out.println(invalidInputMessage.replaceAll("\\*input\\*", this.lazy.nextLine()));
                    } else {
                        System.out.println(invalidInputMessage);
                    }
                    this.sc.nextLine();
                }

            } else {
                if (useInputInMessage) {
                        System.out.println(invalidInputMessage.replaceAll("\\*input\\*", this.lazy.nextLine()));
                    } else {
                        System.out.println(invalidInputMessage);
                    }
                this.sc.nextLine();
            }
        }

        return n;
    }

    public BigInteger nextBigInteger(Predicate<BigInteger> predicate) {
        var satisfiesPredicate = false;
        var n = BigInteger.ZERO;
        while (!satisfiesPredicate) {
            if (this.sc.hasNextBigInteger()) {
                var sc2 = new Scanner(System.in);
                var x = this.sc.nextBigInteger();

                if (predicate.test(x)) {
                    n = x;
                    satisfiesPredicate = true;
                } else {
                    System.out.println("Invalid input, please try again");
                    this.sc.nextLine();
                }

            } else {
                System.out.println("Invalid input, please try again");
                this.sc.nextLine();
            }
        }

        return n;
    }
    public BigInteger nextBigInteger(Predicate<BigInteger> predicate, String invalidInputMessage) {
        var useInputInMessage = false;
        if (invalidInputMessage.contains("*input*")) useInputInMessage = true;


        var satisfiesPredicate = false;
        var n = BigInteger.ZERO;
        while (!satisfiesPredicate) {


            if (this.sc.hasNextBigInteger()) {
                var sc2 = new Scanner(System.in);
                var x = this.sc.nextBigInteger();

                if (predicate.test(x)) {
                    n = x;
                    satisfiesPredicate = true;
                } else {
                    if (useInputInMessage) {
                        System.out.println(invalidInputMessage.replaceAll("\\*input\\*", this.lazy.nextLine()));
                    } else {
                        System.out.println(invalidInputMessage);
                    }
                    this.sc.nextLine();
                }

            } else {
                if (useInputInMessage) {
                        System.out.println(invalidInputMessage.replaceAll("\\*input\\*", this.lazy.nextLine()));
                    } else {
                        System.out.println(invalidInputMessage);
                    }
                this.sc.nextLine();
            }
        }

        return n;
    }

    public BigDecimal nextBigDecimal(Predicate<BigDecimal> predicate) {
        var satisfiesPredicate = false;
        var n = BigDecimal.ZERO;
        while (!satisfiesPredicate) {
            if (this.sc.hasNextBigDecimal()) {
                var sc2 = new Scanner(System.in);
                var x = this.sc.nextBigDecimal();

                if (predicate.test(x)) {
                    n = x;
                    satisfiesPredicate = true;
                } else {
                    System.out.println("Invalid input, please try again");
                    this.sc.nextLine();
                }

            } else {
                System.out.println("Invalid input, please try again");
                this.sc.nextLine();
            }
        }

        return n;
    }
    public BigDecimal nextBigDecimal(Predicate<BigDecimal> predicate, String invalidInputMessage) {
        var useInputInMessage = false;
        if (invalidInputMessage.contains("*input*")) useInputInMessage = true;


        var satisfiesPredicate = false;
        var n = BigDecimal.ZERO;
        while (!satisfiesPredicate) {


            if (this.sc.hasNextBigDecimal()) {
                var sc2 = new Scanner(System.in);
                var x = this.sc.nextBigDecimal();

                if (predicate.test(x)) {
                    n = x;
                    satisfiesPredicate = true;
                } else {
                    if (useInputInMessage) {
                        System.out.println(invalidInputMessage.replaceAll("\\*input\\*", this.lazy.nextLine()));
                    } else {
                        System.out.println(invalidInputMessage);
                    }
                    this.sc.nextLine();
                }

            } else {
                if (useInputInMessage) {
                        System.out.println(invalidInputMessage.replaceAll("\\*input\\*", this.lazy.nextLine()));
                    } else {
                        System.out.println(invalidInputMessage);
                    }
                this.sc.nextLine();
            }
        }

        return n;
    }

    public boolean nextBoolean(boolean value) {
        var satisfiesPredicate = false;
        var n = false;
        while (!satisfiesPredicate) {
            if (this.sc.hasNextBoolean()) {
                var sc2 = new Scanner(System.in);
                var x = this.sc.nextBoolean();

                if (x == value) {
                    n = x;
                    satisfiesPredicate = true;
                } else {
                    System.out.println("Invalid input, please try again");
                    this.sc.nextLine();
                }

            } else {
                System.out.println("Invalid input, please try again");
                this.sc.nextLine();
            }
        }

        return n;
    }
    public boolean nextBoolean(boolean value, String invalidInputMessage) {
        var useInputInMessage = false;
        if (invalidInputMessage.contains("*input*")) useInputInMessage = true;


        var satisfiesPredicate = false;
        var n = false;
        while (!satisfiesPredicate) {


            if (this.sc.hasNextBoolean()) {
                var sc2 = new Scanner(System.in);
                var x = this.sc.nextBoolean();

                if (x == value) {
                    n = x;
                    satisfiesPredicate = true;
                } else {
                    if (useInputInMessage) {
                        System.out.println(invalidInputMessage.replaceAll("\\*input\\*", this.lazy.nextLine()));
                    } else {
                        System.out.println(invalidInputMessage);
                    }
                    this.sc.nextLine();
                }

            } else {
                if (useInputInMessage) {
                        System.out.println(invalidInputMessage.replaceAll("\\*input\\*", this.lazy.nextLine()));
                    } else {
                        System.out.println(invalidInputMessage);
                    }
                this.sc.nextLine();
            }
        }

        return n;
    }

 */



/* Scanner methods

    public static int nextIntThatSatisfies(Predicate<Integer> predicate, Scanner sc) {
        var satisfiesPredicate = false;
        int n = 0;
        while (!satisfiesPredicate) {
            if (sc.hasNextInt()) {
                var sc2 = new Scanner(System.in);
                var x = sc.nextInt();

                if (predicate.test(x)) {
                    n = x;
                    satisfiesPredicate = true;
                } else {
                    System.out.println("Invalid input, please try again");
                    sc.nextLine();
                }

            } else {
                System.out.println("Invalid input, please try again");
                sc.nextLine();
            }
        }

        return n;
    }
    public static long nextLongThatSatisfies(Predicate<Long> predicate, Scanner sc) {
        var satisfiesPredicate = false;
        long n = 0;
        while (!satisfiesPredicate) {
            if (sc.hasNextLong()) {
                var sc2 = new Scanner(System.in);
                var x = sc.nextLong();

                if (predicate.test(x)) {
                    n = x;
                    satisfiesPredicate = true;
                } else {
                    System.out.println("Invalid input, please try again");
                    sc.nextLine();
                }

            } else {
                System.out.println("Invalid input, please try again");
                sc.nextLine();
            }
        }

        return n;
    }
    public static double nextDoubleThatSatisfies(Predicate<Double> predicate, Scanner sc) {
        var satisfiesPredicate = false;
        double n = 0;
        while (!satisfiesPredicate) {
            if (sc.hasNextDouble()) {
                var sc2 = new Scanner(System.in);
                var x = sc.nextDouble();

                if (predicate.test(x)) {
                    n = x;
                    satisfiesPredicate = true;
                } else {
                    System.out.println("Invalid input, please try again");
                    sc.nextLine();
                }

            } else {
                System.out.println("Invalid input, please try again");
                sc.nextLine();
            }
        }

        return n;
    }
    public static short nextShortThatSatisfies(Predicate<Short> predicate, Scanner sc) {
        var satisfiesPredicate = false;
        short n = 0;
        while (!satisfiesPredicate) {
            if (sc.hasNextShort()) {
                var sc2 = new Scanner(System.in);
                var x = sc.nextShort();

                if (predicate.test(x)) {
                    n = x;
                    satisfiesPredicate = true;
                } else {
                    System.out.println("Invalid input, please try again");
                    sc.nextLine();
                }

            } else {
                System.out.println("Invalid input, please try again");
                sc.nextLine();
            }
        }

        return n;
    }
    public static byte nextByteThatSatisfies(Predicate<Byte> predicate, Scanner sc) {
        var satisfiesPredicate = false;
        byte n = 0;
        while (!satisfiesPredicate) {
            if (sc.hasNextByte()) {
                var sc2 = new Scanner(System.in);
                var x = sc.nextByte();

                if (predicate.test(x)) {
                    n = x;
                    satisfiesPredicate = true;
                } else {
                    System.out.println("Invalid input, please try again");
                    sc.nextLine();
                }

            } else {
                System.out.println("Invalid input, please try again");
                sc.nextLine();
            }
        }

        return n;
    }
    public static float nextFloatThatSatisfies(Predicate<Float> predicate, Scanner sc) {
        var satisfiesPredicate = false;
        float n = 0;
        while (!satisfiesPredicate) {
            if (sc.hasNextFloat()) {
                var sc2 = new Scanner(System.in);
                var x = sc.nextFloat();

                if (predicate.test(x)) {
                    n = x;
                    satisfiesPredicate = true;
                } else {
                    System.out.println("Invalid input, please try again");
                    sc.nextLine();
                }

            } else {
                System.out.println("Invalid input, please try again");
                sc.nextLine();
            }
        }

        return n;
    }
    public static String nextThatSatisfies(Predicate<String> predicate, Scanner sc) {
        var satisfiesPredicate = false;
        String s = "";
        while (!satisfiesPredicate) {
            if (sc.hasNext()) {
                var sc2 = new Scanner(System.in);
                var x = sc.nextLine();

                if (predicate.test(x)) {
                    s = x;
                    satisfiesPredicate = true;
                } else {
                    System.out.println("Invalid input, please try again");
                    sc.nextLine();
                }

            } else {
                System.out.println("Invalid input, please try again");
                sc.nextLine();
            }
        }

        return s;
    }

    public static String nextLazy(Scanner sc) {
        sc.hasNext("(.*)");
        return sc.match().group(0);
    }
    public static int nextLazyInt(Scanner sc) {
        sc.hasNext("(.*)");

        try {
            return Integer.parseInt(sc.match().group(0));
        } catch (NumberFormatException e) {
            throw new InputMismatchException();
        }

    }
    public static long nextLazyLong(Scanner sc) {
        sc.hasNext("(.*)");
        try {
            return Long.parseLong(sc.match().group(0));
        } catch (NumberFormatException e) {
            throw new InputMismatchException();
        }
    }
    public static double nextLazyDouble(Scanner sc) {
        sc.hasNext("(.*)");
        try {
            return Double.parseDouble(sc.match().group(0));
        } catch (NumberFormatException e) {
            throw new InputMismatchException();
        }
    }
    public static short nextLazyShort(Scanner sc) {
        sc.hasNext("(.*)");
        try {
            return Short.parseShort(sc.match().group(0));
        } catch (NumberFormatException e) {
            throw new InputMismatchException();
        }
    }
    public static byte nextLazyByte(Scanner sc) {
        sc.hasNext("(.*)");
        try {
            return Byte.parseByte(sc.match().group(0));
        } catch (NumberFormatException e) {
            throw new InputMismatchException();
        }
    }
    public static float nextLazyFloat(Scanner sc) {
        sc.hasNext("(.*)");
        try {
            return Float.parseFloat(sc.match().group(0));
        } catch (NumberFormatException e) {
            throw new InputMismatchException();
        }
    }
    public static boolean nextLazyBoolean(Scanner sc) {
        sc.hasNext("(.*)");
        try {
            return Boolean.parseBoolean(sc.match().group(0));
        } catch (NumberFormatException e) {
            throw new InputMismatchException();
        }
    }
 */

/* Scanner methods

    public static int nextIntThatSatisfies(Predicate<Integer> predicate, Scanner sc) {
        var satisfiesPredicate = false;
        int n = 0;
        while (!satisfiesPredicate) {
            if (sc.hasNextInt()) {
                var sc2 = new Scanner(System.in);
                var x = sc.nextInt();

                if (predicate.test(x)) {
                    n = x;
                    satisfiesPredicate = true;
                } else {
                    System.out.println("Invalid input, please try again");
                    sc.nextLine();
                }

            } else {
                System.out.println("Invalid input, please try again");
                sc.nextLine();
            }
        }

        return n;
    }
    public static long nextLongThatSatisfies(Predicate<Long> predicate, Scanner sc) {
        var satisfiesPredicate = false;
        long n = 0;
        while (!satisfiesPredicate) {
            if (sc.hasNextLong()) {
                var sc2 = new Scanner(System.in);
                var x = sc.nextLong();

                if (predicate.test(x)) {
                    n = x;
                    satisfiesPredicate = true;
                } else {
                    System.out.println("Invalid input, please try again");
                    sc.nextLine();
                }

            } else {
                System.out.println("Invalid input, please try again");
                sc.nextLine();
            }
        }

        return n;
    }
    public static double nextDoubleThatSatisfies(Predicate<Double> predicate, Scanner sc) {
        var satisfiesPredicate = false;
        double n = 0;
        while (!satisfiesPredicate) {
            if (sc.hasNextDouble()) {
                var sc2 = new Scanner(System.in);
                var x = sc.nextDouble();

                if (predicate.test(x)) {
                    n = x;
                    satisfiesPredicate = true;
                } else {
                    System.out.println("Invalid input, please try again");
                    sc.nextLine();
                }

            } else {
                System.out.println("Invalid input, please try again");
                sc.nextLine();
            }
        }

        return n;
    }
    public static short nextShortThatSatisfies(Predicate<Short> predicate, Scanner sc) {
        var satisfiesPredicate = false;
        short n = 0;
        while (!satisfiesPredicate) {
            if (sc.hasNextShort()) {
                var sc2 = new Scanner(System.in);
                var x = sc.nextShort();

                if (predicate.test(x)) {
                    n = x;
                    satisfiesPredicate = true;
                } else {
                    System.out.println("Invalid input, please try again");
                    sc.nextLine();
                }

            } else {
                System.out.println("Invalid input, please try again");
                sc.nextLine();
            }
        }

        return n;
    }
    public static byte nextByteThatSatisfies(Predicate<Byte> predicate, Scanner sc) {
        var satisfiesPredicate = false;
        byte n = 0;
        while (!satisfiesPredicate) {
            if (sc.hasNextByte()) {
                var sc2 = new Scanner(System.in);
                var x = sc.nextByte();

                if (predicate.test(x)) {
                    n = x;
                    satisfiesPredicate = true;
                } else {
                    System.out.println("Invalid input, please try again");
                    sc.nextLine();
                }

            } else {
                System.out.println("Invalid input, please try again");
                sc.nextLine();
            }
        }

        return n;
    }
    public static float nextFloatThatSatisfies(Predicate<Float> predicate, Scanner sc) {
        var satisfiesPredicate = false;
        float n = 0;
        while (!satisfiesPredicate) {
            if (sc.hasNextFloat()) {
                var sc2 = new Scanner(System.in);
                var x = sc.nextFloat();

                if (predicate.test(x)) {
                    n = x;
                    satisfiesPredicate = true;
                } else {
                    System.out.println("Invalid input, please try again");
                    sc.nextLine();
                }

            } else {
                System.out.println("Invalid input, please try again");
                sc.nextLine();
            }
        }

        return n;
    }
    public static String nextThatSatisfies(Predicate<String> predicate, Scanner sc) {
        var satisfiesPredicate = false;
        String s = "";
        while (!satisfiesPredicate) {
            if (sc.hasNext()) {
                var sc2 = new Scanner(System.in);
                var x = sc.nextLine();

                if (predicate.test(x)) {
                    s = x;
                    satisfiesPredicate = true;
                } else {
                    System.out.println("Invalid input, please try again");
                    sc.nextLine();
                }

            } else {
                System.out.println("Invalid input, please try again");
                sc.nextLine();
            }
        }

        return s;
    }

    public static String nextLazy(Scanner sc) {
        sc.hasNext("(.*)");
        return sc.match().group(0);
    }
    public static int nextLazyInt(Scanner sc) {
        sc.hasNext("(.*)");

        try {
            return Integer.parseInt(sc.match().group(0));
        } catch (NumberFormatException e) {
            throw new InputMismatchException();
        }

    }
    public static long nextLazyLong(Scanner sc) {
        sc.hasNext("(.*)");
        try {
            return Long.parseLong(sc.match().group(0));
        } catch (NumberFormatException e) {
            throw new InputMismatchException();
        }
    }
    public static double nextLazyDouble(Scanner sc) {
        sc.hasNext("(.*)");
        try {
            return Double.parseDouble(sc.match().group(0));
        } catch (NumberFormatException e) {
            throw new InputMismatchException();
        }
    }
    public static short nextLazyShort(Scanner sc) {
        sc.hasNext("(.*)");
        try {
            return Short.parseShort(sc.match().group(0));
        } catch (NumberFormatException e) {
            throw new InputMismatchException();
        }
    }
    public static byte nextLazyByte(Scanner sc) {
        sc.hasNext("(.*)");
        try {
            return Byte.parseByte(sc.match().group(0));
        } catch (NumberFormatException e) {
            throw new InputMismatchException();
        }
    }
    public static float nextLazyFloat(Scanner sc) {
        sc.hasNext("(.*)");
        try {
            return Float.parseFloat(sc.match().group(0));
        } catch (NumberFormatException e) {
            throw new InputMismatchException();
        }
    }
    public static boolean nextLazyBoolean(Scanner sc) {
        sc.hasNext("(.*)");
        try {
            return Boolean.parseBoolean(sc.match().group(0));
        } catch (NumberFormatException e) {
            throw new InputMismatchException();
        }
    }
 */