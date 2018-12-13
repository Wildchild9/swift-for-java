package Swift;;

//
// DoubleMatrix.java
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


public class DoubleMatrix extends Matrix<Double> implements NumericMatrix<Double, DoubleMatrix> {



    // Constructors
    public DoubleMatrix(int rows, int columns) {
        super(rows, columns, 0.0);
    }
    public DoubleMatrix(int rows, int columns, double initialValue) {
        super(rows, columns, initialValue);
    }
    public DoubleMatrix(Matrix<Double> otherMatrix) {
        super(otherMatrix);
    }
    public DoubleMatrix(Double[][] otherMatrix) {
        super(otherMatrix);
    }
    public DoubleMatrix(double[][] otherMatrix) {
        super(otherMatrix.length, otherMatrix[0].length);
        for (var i : otherMatrix) {
            for (var j : i) {
                this.matrix.append(j);
            }
        }
    }
    protected DoubleMatrix(int rows, int columns, SwiftArray<Double> matrixArray) {
        super(rows, columns, matrixArray);
    }

    // Static Initializers
    public static DoubleMatrix ofRowStride(double from, double by, int rows, int columns) {

        var doubleMatrix = new DoubleMatrix(rows, columns);

        var n = from;
        for (var i = 0; i < doubleMatrix.matrix.count(); i++) {
            doubleMatrix.matrix.set(i, n);
            n += by;
        }

        return doubleMatrix;

    }
    public static DoubleMatrix ofColumnStride(double from, double by, int rows, int columns) {

        var doubleMatrix = new DoubleMatrix(rows, columns);

        var coordinate = new Coordinate(0,0);

        var n = from;
        for (var i = 0; i < rows; i++) {
            for (var j = 0; i < columns; i++) {
                doubleMatrix.set(n, coordinate);
                n += by;
            }
        }

        return doubleMatrix;
    }

    public static DoubleMatrix repeatingRandom(int rows, int columns) {
        var m = new DoubleMatrix(rows, columns);
        for (int i = 0; i < m.matrix.count(); i++) {
            m.matrix.set(i, ThreadLocalRandom.current().nextDouble());
        }
        return m;
    }
    public static DoubleMatrix repeatingRandom(double lo, double hi, int rows, int columns) {
        var m = new DoubleMatrix(rows, columns);
        for (int i = 0; i < m.matrix.count(); i++) {
            m.matrix.set(i,ThreadLocalRandom.current().nextDouble(lo, hi + 1));
        }
        return m;
    }
    public static DoubleMatrix repeatingRandom(SwiftRange range, int rows, int columns) {
        var m = new DoubleMatrix(rows, columns);
        for (int i = 0; i < m.matrix.count(); i++) {
            m.matrix.set(i,ThreadLocalRandom.current().nextDouble((double) range.lowerBound(), (double) range.upperBound() + 1d));
        }
        return m;
    }

    // Implementations
    @Override public double average() {
        return matrix.stream().mapToDouble(i -> i.doubleValue()).average().getAsDouble();
    }

    @Override public Double max() {
        return Collections.max(matrix);
    }
    @Override public Double min() {
        return Collections.min(matrix);
    }


    // Operators
    @Override public DoubleMatrix added(DoubleMatrix n) {
        assert this.numberOfRows == n.numberOfRows &&
               this.numberOfColumns == n.numberOfColumns : "Cannot add matrices with different dimensions";

        var addedMatrix = new DoubleMatrix(numberOfRows, numberOfColumns);

        for (int i = 0; i < this.matrix.count(); i++) {
            addedMatrix.matrix.set(i, this.matrix.get(i) + n.matrix.get(i));
        }

        return addedMatrix;
    }
    @Override public void         add  (DoubleMatrix n) {
        assert this.numberOfRows == n.numberOfRows &&
               this.numberOfColumns == n.numberOfColumns : "Cannot add matrices with different dimensions";

        for (int i = 0; i < this.matrix.count(); i++) {
            this.matrix.set(i, this.matrix.get(i) + n.matrix.get(i));
        }
    }

    @Override public DoubleMatrix subtracted(DoubleMatrix by) {
        assert this.numberOfRows == by.numberOfRows &&
               this.numberOfColumns == by.numberOfColumns : "Cannot add matrices with different dimensions";

        var addedMatrix = new DoubleMatrix(numberOfRows, numberOfColumns);

        for (int i = 0; i < this.matrix.count(); i++) {
            addedMatrix.matrix.set(i, this.matrix.get(i) - by.matrix.get(i));
        }

        return addedMatrix;
    }
    @Override public void         subtract  (DoubleMatrix by) {
        assert this.numberOfRows == by.numberOfRows &&
               this.numberOfColumns == by.numberOfColumns : "Cannot add matrices with different dimensions";

        for (int i = 0; i < this.matrix.count(); i++) {
            this.matrix.set(i, this.matrix.get(i) - by.matrix.get(i));
        }
    }

    @Override public DoubleMatrix multiplied(Double       by) {
        var multipliedMatrix = new DoubleMatrix(numberOfRows, numberOfColumns);

        for (int i = 0; i < this.matrix.count(); i++) {
            multipliedMatrix.matrix.set(i, this.matrix.get(i) * by);
        }

        return multipliedMatrix;
    }
    @Override public DoubleMatrix multiplied(DoubleMatrix by) {

        assert this.numberOfColumns == by.numberOfRows: "Invalid matrix dimensions for multiplication";

        var multipliedMatrix = new DoubleMatrix(this.numberOfRows, by.numberOfColumns);

        var point = new Coordinate(0, 0);
        for (var leftRow : this.rows) {
            for (var rightColumn : by.columns) {
                var runningSum = 0d;
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
    @Override public void         multiply  (DoubleMatrix by) {
        final var m = this.multiplied(by);
        this.numberOfRows = m.numberOfRows;
        this.numberOfColumns = m.numberOfColumns;
        this.matrix = m.matrix;
    }
    @Override public void         multiply  (Double       by) {
        for (var i : this.matrix.enumerated()) {
            this.matrix.set(i.offset, i.element * by);
        }
    }

    // Other Methods
    public void fillRowWithRandom(                      int row) {
        assert row >= 0 && row < numberOfRows : "Index out of range";

        var startIdx = indexOf(row, 0);
        var endIdx =   indexOf(row, numberOfColumns - 1);
        for (var idx : new SwiftRange(startIdx, endIdx)) {
            matrix.set(idx, ThreadLocalRandom.current().nextDouble());
        }
    }
    public void fillRowWithRandom(SwiftRange range,     int row) {
        assert row >= 0 && row < numberOfRows : "Index out of range";

        var startIdx = indexOf(row, 0);
        var endIdx =   indexOf(row, numberOfColumns - 1);
        for (var idx : new SwiftRange(startIdx, endIdx)) {
            matrix.set(idx, ThreadLocalRandom.current().nextDouble((double) range.lowerBound(), (double) range.upperBound() + 1d));
        }
    }
    public void fillRowWithRandom(double lo, double hi, int row) {
        assert row >= 0 && row < numberOfRows : "Index out of range";

        var startIdx = indexOf(row, 0);
        var endIdx =   indexOf(row, numberOfColumns - 1);
        for (var idx : new SwiftRange(startIdx, endIdx)) {
            matrix.set(idx, ThreadLocalRandom.current().nextDouble(lo, hi + 1));
        }
    }

    public void fillColumnWithRandom(                      int col) {
        assert col >= 0 && col < numberOfColumns : "Index  out of range";

        var startIdx = indexOf(col, 0);
        var endIdx =   indexOf(col, numberOfColumns - 1);

        for (var idx : SwiftArray.strideThrough(col + numberOfRows * (numberOfColumns - 1), col, numberOfColumns)) {
            matrix.set(idx, ThreadLocalRandom.current().nextDouble());
        }
    }
    public void fillColumnWithRandom(SwiftRange range,     int col) {
        assert col >= 0 && col < numberOfColumns : "Index  out of range";

        var startIdx = indexOf(col, 0);
        var endIdx =   indexOf(col, numberOfColumns - 1);

        for (var idx : SwiftArray.strideThrough(col + numberOfRows * (numberOfColumns - 1), col, numberOfColumns)) {
            matrix.set(idx, ThreadLocalRandom.current().nextDouble((double) range.lowerBound(), (double) range.upperBound() + 1d));
        }
    }
    public void fillColumnWithRandom(double lo, double hi, int col) {
        assert col >= 0 && col < numberOfColumns : "Index  out of range";

        var startIdx = indexOf(col, 0);
        var endIdx =   indexOf(col, numberOfColumns - 1);

        for (var idx : SwiftArray.strideThrough(col + numberOfRows * (numberOfColumns - 1), col, numberOfColumns)) {
            matrix.set(idx, ThreadLocalRandom.current().nextDouble(lo, hi + 1));
        }
    }

}
