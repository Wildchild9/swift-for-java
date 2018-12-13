package Swift;;

//
// Matrix.java
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
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Predicate;


public class Matrix<Element> {

    // Stored values
    protected SwiftArray<Element> matrix;
    protected int numberOfRows;
    protected int numberOfColumns;

    // Constructors
    public    Matrix(int rows, int columns) {
        this.numberOfRows = rows;
        this.numberOfColumns = columns;
        matrix = new SwiftArray<Element>();
        matrix.ensureCapacity(rows * columns);
    }
    public    Matrix(int rows, int columns, Element initialValue) {
        this.numberOfRows = rows;
        this.numberOfColumns = columns;
        matrix = new SwiftArray<Element>();
        matrix.ensureCapacity(rows * columns);
        matrix.addAll(Collections.nCopies(rows * columns, initialValue));
    }
    public    Matrix(Matrix<Element> otherMatrix) {
        this.matrix = otherMatrix.matrix;
        this.numberOfRows = otherMatrix.numberOfRows;
        this.numberOfColumns = otherMatrix.numberOfColumns;
        this.rows = otherMatrix.rows;
        this.columns = otherMatrix.columns; // you can access
    }
    public    Matrix(Element[][] otherMatrix) {
        assert otherMatrix[0].length > 0: "Cannot form a matrix from an empty two dimensional array";
        this.numberOfRows = otherMatrix.length;
        this.numberOfColumns = otherMatrix[0].length;
        this.matrix = new SwiftArray<Element>();
        this.matrix.ensureCapacity(this.numberOfRows * this.numberOfRows);
        for (var i : otherMatrix) {
            for (var j : i) {
                this.matrix.append(j);
            }
        }
    }
    protected Matrix(int rows, int columns, SwiftArray<Element> matrixArray) {
        this.numberOfRows = rows;
        this.numberOfColumns = columns;
        matrix.ensureCapacity(rows * columns);
        matrix.addAll(matrixArray);
    }


    // Getters
    public Element get(int row, int column)   {
        assert indexIsValid(row, column): "Index out of range";
        return matrix.get((row * numberOfColumns) + column);
    }
    public Element get(Coordinate coordinate) {
        return this.get(coordinate.x, coordinate.y);
    }
    public SwiftArray<Element> row   (int n)  {
        assert n >= 0 && n < numberOfRows : "Index out of range";

        var startIdx = indexOf(n, 0);
        var endIdx =   indexOf(n, numberOfColumns - 1);

        return new SwiftArray<Element>(matrix.subList(startIdx, endIdx + 1));
    }
    public SwiftArray<Element> column(int n)  {
        assert n >= 0 && n < numberOfColumns : "Index out of range";

        var column = new SwiftArray<Element>();
        for (var idx : SwiftArray.strideThrough(n + 1 + numberOfRows * (numberOfColumns - 1), n, numberOfColumns)) {
            column.append(matrix.get(idx));
        }
        return column;
    }

    // Setters
    public Element set(int row, int column, Element value) {
        assert indexIsValid(row, column): "Index out of range";

        return matrix.set((row * numberOfColumns) + column, value);
    }
    public void set(Element value, Coordinate... toCoordinates) {
        for (var coordinate : toCoordinates) {
            assert indexIsValid(coordinate.y, coordinate.x): "Index out of range";
            set(coordinate.y, coordinate.x, value);
        }
    }
    public void set(Coordinate coordinate, Element value) {
        assert indexIsValid(coordinate.x, coordinate.y): "Index out of range";

        set(coordinate.y, coordinate.x, value);

    }


    // Iterators
    public Rows    rows    = new Rows();
    public Columns columns = new Columns();

    public class Rows    implements Iterable<SwiftArray<Element>> {

        public ReversedRows reversed = new ReversedRows();

        @Override
        public Iterator<SwiftArray<Element>> iterator() {
            return new RowIterator();
        }

        public class RowIterator implements Iterator<SwiftArray<Element>> {

            private int currentRow = 0;

            public RowIterator() { }

            @Override
            public boolean hasNext() {
                return currentRow < numberOfRows;
            }

            @Override
            public SwiftArray<Element> next() {
                return row(currentRow++);
            }

        }

        public class ReversedRows implements Iterable<SwiftArray<Element>> {

            @Override
            public Iterator<SwiftArray<Element>> iterator() {
                return new ReversedRowIterator();
            }

            public class ReversedRowIterator implements Iterator<SwiftArray<Element>> {

                private int currentRow = numberOfRows - 1;

                public ReversedRowIterator() { }

                @Override
                public boolean hasNext() {
                    return currentRow >= 0;
                }

                @Override
                public SwiftArray<Element> next() {
                    return row(currentRow--);
                }

            }

        }
    }
    public class Columns implements Iterable<SwiftArray<Element>> {

        public ReversedColumns reversed = new ReversedColumns();

        @Override
        public Iterator<SwiftArray<Element>> iterator() {
            return new ColumnIterator();
        }

        public class ColumnIterator implements Iterator<SwiftArray<Element>> {

            private int currentColumn = 0;

            public ColumnIterator() { }

            @Override
            public boolean hasNext() {
                return currentColumn < numberOfColumns;
            }

            @Override
            public SwiftArray<Element> next() {
                return column(currentColumn++);
            }

        }

        public class ReversedColumns implements Iterable<SwiftArray<Element>> {

            @Override
            public Iterator<SwiftArray<Element>> iterator() {
                return new ReversedColumnIterator();
            }

            public class ReversedColumnIterator implements Iterator<SwiftArray<Element>> {

                private int currentColumn = numberOfColumns - 1;

                public ReversedColumnIterator() { }

                @Override
                public boolean hasNext() {
                    return currentColumn >= 0;
                }

                @Override
                public SwiftArray<Element> next() {
                    return column(currentColumn--);
                }

            }

        }

    }

    // Sizes
    public final int numberOfRows() {
        return numberOfRows;
    }
    public final int numberOfColumns() {
        return numberOfColumns;
    }
    public final int numberOfElements() {
        return numberOfColumns * numberOfRows;
    }


    // Index validation
    public boolean indexIsValid(int row, int column) {
        return row >= 0 && row < numberOfRows && column >= 0 && column < numberOfColumns;
    }

    // Fill
    public void fill(Element element) {
        matrix.clear();
        matrix.addAll(Collections.nCopies(numberOfRows * numberOfColumns, element));
    }
    public void fillRow(int n, Element with) {
        assert n >= 0 && n < numberOfRows : "Index out of range";

        var startIdx = indexOf(n, 0);
        var endIdx =   indexOf(n, numberOfColumns - 1);
        for (var idx : new SwiftRange(startIdx, endIdx)) {
            matrix.set(idx, with);
        }
    }
    public void fillColumn(int n, Element with) {
        assert n >= 0 && n < numberOfColumns : "Index  out of range";

        var startIdx = indexOf(n, 0);
        var endIdx =   indexOf(n, numberOfColumns - 1);

        for (var idx : SwiftArray.strideThrough(n + numberOfRows * (numberOfColumns - 1), n, numberOfColumns)) {
            matrix.set(idx, with);
        }
    }

    //////////////////
    // Algorithms

    // Map
    public <T> Matrix<T> map(Function<Element, T> transform) {
        var copy = new Matrix<T>(numberOfRows, numberOfColumns);
        copy.matrix = matrix.map(transform);
        return copy;
    }

    // Count
    public int count(Predicate<Element> predicate) {
        return matrix.count(predicate);
    }

    // Satisfy
    public boolean allSatisfy(Predicate<Element> predicate) {
        return matrix.allSatisfy(predicate);
    }
    public boolean noneSatisfy(Predicate<Element> predicate) {
        return matrix.noneSatisfy(predicate);
    }

    // Reduce
    public Element reduceByRow(BinaryOperator<Element> accumulator) {
        return matrix.reduce(accumulator);
    }
    public Element reduceByColumns(BinaryOperator<Element> accumulator) {
        var columns = new SwiftArray<Element>();
        for (var column : this.columns) {
            columns.addAll(column);
        }
        return columns.reduce(accumulator);
    }

    // Max and min
    public final Optional<Element> max(Comparator<Element> comparator) {
        return matrix.max(comparator);
    }
    public final Optional<Element> min(Comparator<Element> comparator) {
        return matrix.min(comparator);
    }

    // Contains
    public boolean contains(Predicate<Element> predicate) {
        return matrix.contains(predicate);
    }
    public boolean contains(Object object) {
        return matrix.contains(object);
    }

    // Transformations
    // Non-mutating
    public Matrix<Element> rotatedLeft()  {
        var rotatedMatrix = new Matrix<Element>(numberOfColumns, numberOfRows);
        for (var column : this.columns.reversed) {
            rotatedMatrix.matrix.addAll(column);
        }
        return rotatedMatrix;
    }
    public Matrix<Element> rotatedRight() {
        var rotatedMatrix = new Matrix<Element>(numberOfColumns, numberOfRows);
        for (var column : this.columns) {
            rotatedMatrix.matrix.addAll(column);
        }
        return rotatedMatrix;
    }
    public Matrix<Element> flippedX() {
        var rotatedMatrix = new Matrix<Element>(numberOfRows, numberOfColumns);
        for (var row : this.rows.reversed) {
            rotatedMatrix.matrix.addAll(row);
        }
        return rotatedMatrix;
    }
    public Matrix<Element> flippedY() {
        var rotatedMatrix = new Matrix<Element>(numberOfRows, numberOfColumns);
        for (var row : this.rows) {
            rotatedMatrix.matrix.addAll(row.reversed());
        }
        return rotatedMatrix;
    }

    // Mutating
    public void rotateLeft()  {
        var rotated = this.rotatedLeft();
        this.numberOfColumns = rotated.numberOfColumns;
        this.numberOfRows = rotated.numberOfRows;
        this.matrix = rotated.matrix;
    }
    public void rotateRight() {
        var rotated = this.rotatedRight();
        this.numberOfColumns = rotated.numberOfColumns;
        this.numberOfRows = rotated.numberOfRows;
        this.matrix = rotated.matrix;
    }
    public void flipX() {
        var rotated = this.flippedX();
        this.numberOfColumns = rotated.numberOfColumns;
        this.numberOfRows = rotated.numberOfRows;
        this.matrix = rotated.matrix;
    }
    public void flipY() {
        var rotated = this.flippedY();
        this.numberOfColumns = rotated.numberOfColumns;
        this.numberOfRows = rotated.numberOfRows;
        this.matrix = rotated.matrix;
    }

    // Modes
    public SwiftArray<Element> modes() {
        var dict = new HashMap<Element, Integer>();

        for (var n : matrix) {
            if (dict.containsKey(n)) {
                dict.replace(n, dict.get(n) + 1);
            } else {
                dict.put(n, 1);
            }
        }
        var maxOccurencesCount = 0;
        var modes = new SwiftArray<Element>();
        for (var pair : dict.entrySet()) {
            if (pair.getValue() > maxOccurencesCount) {
                modes.clear();
                modes.append(pair.getKey());
                maxOccurencesCount = pair.getValue();
            } else if (pair.getValue() == maxOccurencesCount) {
                modes.append(pair.getKey());
            }
        }
        return modes;
    }

    // Swap
    public void swapAt(int ax, int ay, int bx, int by) {
        assert indexIsValid(ax, ay) && indexIsValid(bx, by):
                "Index out of range";
        matrix.swapAt(indexOf(ax, ay), indexOf(bx, by));
    }


    //////////////////
    // Other Methods

    // Private methods
    protected int indexOf(int row, int column) {
        return (row * numberOfColumns) + column;
    }

    // Copy
    public Matrix<Element> copy() {
        return new Matrix<Element>(this);
    }

    // Equals
    public boolean equals(Matrix<Element> m) {
        if (this.numberOfRows != m.numberOfRows || this.numberOfColumns != m.numberOfColumns) {
            return false;
        }
        for (int i = 0; i < matrix.count(); i++) {
            if (!this.matrix.get(i).equals(m.matrix.get(i))) {
                return false;
            }

        }
        return true;
    }

    // Print
    public void print() {
        System.out.println(this.toString());
    }

    // To String
    @Override public String toString() {
        var str = new StringBuilder();
        for (var pair : matrix.enumerated()) {

            str.append(pair.getRight() + " ");

            if ((pair.getLeft() + 1) % numberOfColumns == 0) {
                str.replace(str.length() - 1, str.length(), "\n");
            }
        }
        return str.toString();
    }

    private static String String(String repeating, int count) {
        if (count <= 0) { return ""; }
        var str = new StringBuilder();
        for (int i = 0; i < count; i++) {
            str.append(repeating);
        }
        return str.toString();
    }
    private static String String(char   repeating, int count) {
        if (count <= 0) { return ""; }
        var str = new StringBuilder();
        for (int i = 0; i < count; i++) {
            str.append(repeating);
        }
        return str.toString();
    }

    public String formatted() {
        var maxLength = 0;
        for (var element : this.matrix) {
            final var l = element.toString().length();
            if (l > maxLength) maxLength = l;
        }

        var str = new StringBuilder();

        str.append("┌");

        for (int i = 0; i < numberOfColumns - 1; i++) {
            str.append(String("─", maxLength + 2)).append('┬');
        }

        str.append(String("─", maxLength + 2)).append('┐');
        str.append("\n");

        for (var row : this.rows) {
            for (var element : row) {
                str.append("│ ");
                var s = element.toString();
                if (s.length() < maxLength) {
                    str.append(String(' ', maxLength - s.length()));
                }
                str.append(element);
                str.append(' ');
            }
            str.append("│\n");

            str.append('├');
            for (int i = 0; i < numberOfColumns - 1; i++) {
                str.append(String("─", maxLength + 2)).append('┼');
            }
            str.append(String("─", maxLength + 2));
            str.append("┤\n");

        }



        str.delete(str.length() - numberOfColumns - 3 - ((maxLength + 2) * numberOfColumns), str.length() - 1);
        str.append('└');
        for (int i = 0; i < numberOfColumns - 1; i++) {
            str.append(String("─", maxLength + 2)).append('┴');
        }
        str.append(String("─", maxLength + 2));
        str.append('┘');


        return str.toString();

    }

    public void printFormatted() {
        System.out.println(this.formatted());
    }


//       ╭────┬────╮
//       │  7 │  8 │
//       ├────┼────┤
//       │  9 │ 10 │
//       ├────┼────┤
//       │ 11 │ 12 │
//       ╰────┴────╯
//


}
