package Swift;;

//
// IntMatrix.java
// Swift for Java
//
//
// Last modified on 27/11/18 11:13 AM.
//
// Copyright © 2018 Noah Wilder. All rights reserved.
// This file is subject to the terms and conditions defined in
// file 'LICENSE', which is part of this source code package.
//

import java.util.Collections;
import java.util.concurrent.ThreadLocalRandom;


public class IntMatrix extends Matrix<Integer> implements NumericMatrix<Integer, IntMatrix> {

    // Constructors
    public IntMatrix(int rows, int columns) {
        super(rows, columns, 0);
    }
    public IntMatrix(int rows, int columns, int initialValue) {
        super(rows, columns, initialValue);
    }
    public IntMatrix(Matrix<Integer> otherMatrix) {
        super(otherMatrix);
    }
    public IntMatrix(Integer[][] otherMatrix) {
        super(otherMatrix);
    }
    public IntMatrix(int[][] otherMatrix) {
        super(otherMatrix.length, otherMatrix[0].length);
        for (var i : otherMatrix) {
            for (var j : i) {
                this.matrix.append(j);
            }
        }
    }
    protected IntMatrix(int rows, int columns, SwiftArray<Integer> matrixArray) {
        super(rows, columns, matrixArray);
    }


    // Static Initializers
    public static IntMatrix ofRowStride(int from, int by, int rows, int columns) {

        var intMatrix = new IntMatrix(rows, columns);

        var n = from;
        for (var i = 0; i < intMatrix.matrix.count(); i++) {
            intMatrix.matrix.set(i, n);
            n += by;
        }

        return intMatrix;

    }
    public static IntMatrix ofColumnStride(int from, int by, int rows, int columns) {

        var intMatrix = new IntMatrix(rows, columns);

        var coordinate = new Coordinate(0,0);

        var n = from;
        for (var i = 0; i < rows; i++) {
            for (var j = 0; j < columns; j++) {
                intMatrix.set(n, coordinate);
                n += by;
                coordinate.y += 1;
            }
            coordinate.x += 1;
            coordinate.y = 0;
        }

        return intMatrix;
    }

    public static IntMatrix repeatingRandom(int rows, int columns) {
        var m = new IntMatrix(rows, columns);
        for (int i = 0; i < m.matrix.count(); i++) {
            m.matrix.set(i,ThreadLocalRandom.current().nextInt());
        }
        return m;
    }
    public static IntMatrix repeatingRandom(int lo, int hi, int rows, int columns) {
        var m = new IntMatrix(rows, columns);
        for (int i = 0; i < m.matrix.count(); i++) {
            m.matrix.set(i,ThreadLocalRandom.current().nextInt(lo, hi + 1));
        }
        return m;
    }
    public static IntMatrix repeatingRandom(SwiftRange range, int rows, int columns) {
        var m = new IntMatrix(rows, columns);
        for (int i = 0; i < m.matrix.count(); i++) {
            m.matrix.set(i,ThreadLocalRandom.current().nextInt(range.lowerBound(), range.upperBound() + 1));
        }
        return m;
    }

    // Implementations
    @Override public double average() {
        return matrix.stream().mapToDouble(i -> i.doubleValue()).average().getAsDouble();
    }

    @Override public Integer max() {
        return Collections.max(matrix);
    }
    @Override public Integer min() {
        return Collections.min(matrix);
    }


    // Operators
    @Override public IntMatrix added(IntMatrix n) {
        assert this.numberOfRows == n.numberOfRows &&
               this.numberOfColumns == n.numberOfColumns : "Cannot add matrices with different dimensions";

        var addedMatrix = new IntMatrix(numberOfRows, numberOfColumns);

        for (int i = 0; i < this.matrix.count(); i++) {
            addedMatrix.matrix.set(i, this.matrix.get(i) + n.matrix.get(i));
        }

        return addedMatrix;
    }
    @Override public void      add  (IntMatrix n) {
        assert this.numberOfRows == n.numberOfRows &&
               this.numberOfColumns == n.numberOfColumns : "Cannot add matrices with different dimensions";

        for (int i = 0; i < this.matrix.count(); i++) {
            this.matrix.set(i, this.matrix.get(i) + n.matrix.get(i));
        }
    }

    @Override public IntMatrix subtracted(IntMatrix by) {
        assert this.numberOfRows == by.numberOfRows &&
               this.numberOfColumns == by.numberOfColumns : "Cannot add matrices with different dimensions";

        var addedMatrix = new IntMatrix(numberOfRows, numberOfColumns);

        for (int i = 0; i < this.matrix.count(); i++) {
            addedMatrix.matrix.set(i, this.matrix.get(i) - by.matrix.get(i));
        }

        return addedMatrix;
    }
    @Override public void      subtract  (IntMatrix by) {
        assert this.numberOfRows == by.numberOfRows &&
               this.numberOfColumns == by.numberOfColumns : "Cannot add matrices with different dimensions";

        for (int i = 0; i < this.matrix.count(); i++) {
            this.matrix.set(i, this.matrix.get(i) - by.matrix.get(i));
        }
    }

    @Override public IntMatrix multiplied(Integer   by) {
        var multipliedMatrix = new IntMatrix(numberOfRows, numberOfColumns);
        for (int i = 0; i < this.matrix.count(); i++) {
            multipliedMatrix.matrix.set(i, this.matrix.get(i) * by);
        }

        return multipliedMatrix;
    }
    @Override public IntMatrix multiplied(IntMatrix by) {

        assert this.numberOfColumns == by.numberOfRows: "Invalid matrix dimensions for multiplication";

        var multipliedMatrix = new IntMatrix(this.numberOfRows, by.numberOfColumns);

        var point = new Coordinate(0, 0);
        for (var leftRow : this.rows) {
            for (var rightColumn : by.columns) {
                var runningSum = 0;
                for (var i = 0; i < leftRow.count(); i++) {
                    runningSum += leftRow.get(i) * rightColumn.get(i);
                }
                multipliedMatrix.set(runningSum, point);
                point.x += 1;
            }

            point.x = 0;
            point.y += 1;
        }

        return multipliedMatrix;
    }
    @Override public void      multiply  (IntMatrix by) {
        final var m = this.multiplied(by);
        this.numberOfRows = m.numberOfRows;
        this.numberOfColumns = m.numberOfColumns;
        this.matrix = m.matrix;
    }
    @Override public void      multiply  (Integer by) {
        for (var i : this.matrix.enumerated()) {
            this.matrix.set(i.offset, i.element * by);
        }
    }



    // Other Methods
    public SwiftRange rangeOfValues() {
        return new SwiftRange(this.min(), this.max());
    }

    public void fillRowWithRandom(                  int row) {
        assert row >= 0 && row < numberOfRows : "Index out of range";

        var startIdx = indexOf(row, 0);
        var endIdx =   indexOf(row, numberOfColumns - 1);
        for (var idx : new SwiftRange(startIdx, endIdx)) {
            matrix.set(idx, ThreadLocalRandom.current().nextInt());
        }
    }
    public void fillRowWithRandom(SwiftRange range, int row) {
        assert row >= 0 && row < numberOfRows : "Index out of range";

        var startIdx = indexOf(row, 0);
        var endIdx =   indexOf(row, numberOfColumns - 1);
        for (var idx : new SwiftRange(startIdx, endIdx)) {
            matrix.set(idx, ThreadLocalRandom.current().nextInt(range.lowerBound(), range.upperBound() + 1));
        }
    }
    public void fillRowWithRandom(int lo,  int hi,  int row) {
        assert row >= 0 && row < numberOfRows : "Index out of range";

        var startIdx = indexOf(row, 0);
        var endIdx =   indexOf(row, numberOfColumns - 1);
        for (var idx : new SwiftRange(startIdx, endIdx)) {
            matrix.set(idx, ThreadLocalRandom.current().nextInt(lo, hi + 1));
        }
    }

    public void fillColumnWithRandom(                  int col) {
        assert col >= 0 && col < numberOfColumns : "Index  out of range";

        var startIdx = indexOf(col, 0);
        var endIdx =   indexOf(col, numberOfColumns - 1);

        for (var idx : SwiftArray.strideThrough(col + numberOfRows * (numberOfColumns - 1), col, numberOfColumns)) {
            matrix.set(idx, ThreadLocalRandom.current().nextInt());
        }
    }
    public void fillColumnWithRandom(SwiftRange range, int col) {
        assert col >= 0 && col < numberOfColumns : "Index  out of range";

        var startIdx = indexOf(col, 0);
        var endIdx =   indexOf(col, numberOfColumns - 1);

        for (var idx : SwiftArray.strideThrough(col + numberOfRows * (numberOfColumns - 1), col, numberOfColumns)) {
            matrix.set(idx, ThreadLocalRandom.current().nextInt(range.lowerBound(), range.upperBound() + 1));
        }
    }
    public void fillColumnWithRandom(int lo,  int hi,  int col) {
        assert col >= 0 && col < numberOfColumns : "Index  out of range";

        var startIdx = indexOf(col, 0);
        var endIdx =   indexOf(col, numberOfColumns - 1);

        for (var idx : SwiftArray.strideThrough(col + numberOfRows * (numberOfColumns - 1), col, numberOfColumns)) {
            matrix.set(idx, ThreadLocalRandom.current().nextInt(lo, hi + 1));
        }
    }



}

