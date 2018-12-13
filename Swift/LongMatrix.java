package Swift;;

//
// LongMatrix.java
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


public class LongMatrix extends Matrix<Long> implements NumericMatrix<Long, LongMatrix> {



    // Constructors
    public LongMatrix(int rows, int columns) {
        super(rows, columns, 0L);
    }
    public LongMatrix(int rows, int columns, long initialValue) {
        super(rows, columns, initialValue);
    }
    public LongMatrix(Matrix<Long> otherMatrix) {
        super(otherMatrix);
    }
    public LongMatrix(Long[][] otherMatrix) {
        super(otherMatrix);
    }
    public LongMatrix(long[][] otherMatrix) {
        super(otherMatrix.length, otherMatrix[0].length);
        for (var i : otherMatrix) {
            for (var j : i) {
                this.matrix.append(j);
            }
        }
    }
    protected LongMatrix(int rows, int columns, SwiftArray<Long> matrixArray) {
        super(rows, columns, matrixArray);
    }

    // Static Initializers
    public static LongMatrix ofRowStride(long from, long by, int rows, int columns) {

        var longMatrix = new LongMatrix(rows, columns);

        var n = from;
        for (var i = 0; i < longMatrix.matrix.count(); i++) {
            longMatrix.matrix.set(i, n);
            n += by;
        }

        return longMatrix;

    }
    public static LongMatrix ofColumnStride(long from, long by, int rows, int columns) {

        var longMatrix = new LongMatrix(rows, columns);

        var coordinate = new Coordinate(0,0);

        var n = from;
        for (var i = 0; i < rows; i++) {
            for (var j = 0; i < columns; i++) {
                longMatrix.set(n, coordinate);
                n += by;
            }
        }

        return longMatrix;
    }

    public static LongMatrix repeatingRandom(int rows, int columns) {
        var m = new LongMatrix(rows, columns);
        for (int i = 0; i < m.matrix.count(); i++) {
            m.matrix.set(i, ThreadLocalRandom.current().nextLong());
        }
        return m;
    }
    public static LongMatrix repeatingRandom(long lo, long hi, int rows, int columns) {
        var m = new LongMatrix(rows, columns);
        for (int i = 0; i < m.matrix.count(); i++) {
            m.matrix.set(i, ThreadLocalRandom.current().nextLong(lo, hi + 1));
        }
        return m;
    }
    public static LongMatrix repeatingRandom(SwiftRange range, int rows, int columns) {
        var m = new LongMatrix(rows, columns);
        for (int i = 0; i < m.matrix.count(); i++) {
            m.matrix.set(i,ThreadLocalRandom.current().nextLong((long) range.lowerBound(), (long) range.upperBound() + 1L));
        }
        return m;
    }


    // Implementations
    @Override public double average() {
        return matrix.stream().mapToDouble(i -> i.doubleValue()).average().getAsDouble();
    }

    @Override public Long max() {
        return Collections.max(matrix);
    }
    @Override public Long min() {
        return Collections.min(matrix);
    }


    // Operators
    @Override public LongMatrix added(LongMatrix n) {
        assert this.numberOfRows == n.numberOfRows &&
               this.numberOfColumns == n.numberOfColumns : "Cannot add matrices with different dimensions";

        var addedMatrix = new LongMatrix(numberOfRows, numberOfColumns);

        for (int i = 0; i < this.matrix.count(); i++) {
            addedMatrix.matrix.set(i, this.matrix.get(i) + n.matrix.get(i));
        }

        return addedMatrix;
    }
    @Override public void       add  (LongMatrix n) {
        assert this.numberOfRows == n.numberOfRows &&
               this.numberOfColumns == n.numberOfColumns : "Cannot add matrices with different dimensions";

        for (int i = 0; i < this.matrix.count(); i++) {
            this.matrix.set(i, this.matrix.get(i) + n.matrix.get(i));
        }
    }

    @Override public LongMatrix subtracted(LongMatrix by) {
        assert this.numberOfRows == by.numberOfRows &&
               this.numberOfColumns == by.numberOfColumns : "Cannot add matrices with different dimensions";

        var addedMatrix = new LongMatrix(numberOfRows, numberOfColumns);

        for (int i = 0; i < this.matrix.count(); i++) {
            addedMatrix.matrix.set(i, this.matrix.get(i) - by.matrix.get(i));
        }

        return addedMatrix;
    }
    @Override public void       subtract  (LongMatrix by) {
        assert this.numberOfRows == by.numberOfRows &&
               this.numberOfColumns == by.numberOfColumns : "Cannot add matrices with different dimensions";

        for (int i = 0; i < this.matrix.count(); i++) {
            this.matrix.set(i, this.matrix.get(i) - by.matrix.get(i));
        }
    }

    @Override public LongMatrix multiplied(Long       by) {
        var multipliedMatrix = new LongMatrix(numberOfRows, numberOfColumns);

        for (int i = 0; i < this.matrix.count(); i++) {
            multipliedMatrix.matrix.set(i, this.matrix.get(i) * by);
        }

        return multipliedMatrix;
    }
    @Override public LongMatrix multiplied(LongMatrix by) {

        assert this.numberOfColumns == by.numberOfRows: "Invalid matrix dimensions for multiplication";

        var multipliedMatrix = new LongMatrix(this.numberOfRows, by.numberOfColumns);

        var point = new Coordinate(0, 0);
        for (var leftRow : this.rows) {
            for (var rightColumn : by.columns) {
                var runningSum = 0L;
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
    @Override public void       multiply  (LongMatrix by) {
        final var m = this.multiplied(by);
        this.numberOfRows = m.numberOfRows;
        this.numberOfColumns = m.numberOfColumns;
        this.matrix = m.matrix;
    }
    @Override public void       multiply  (Long       by) {
        for (var i : this.matrix.enumerated()) {
            this.matrix.set(i.offset, i.element * by);
        }
    }

    
    // Other Methods
    public void fillRowWithRandom(                  int row) {
        assert row >= 0 && row < numberOfRows : "Index out of range";

        var startIdx = indexOf(row, 0);
        var endIdx =   indexOf(row, numberOfColumns - 1);
        for (var idx : new SwiftRange(startIdx, endIdx)) {
            matrix.set(idx, ThreadLocalRandom.current().nextLong());
        }
    }
    public void fillRowWithRandom(SwiftRange range, int row) {
        assert row >= 0 && row < numberOfRows : "Index out of range";

        var startIdx = indexOf(row, 0);
        var endIdx =   indexOf(row, numberOfColumns - 1);
        for (var idx : new SwiftRange(startIdx, endIdx)) {
            matrix.set(idx, ThreadLocalRandom.current().nextLong((long) range.lowerBound(), (long) range.upperBound() + 1L));
        }
    }
    public void fillRowWithRandom(long lo, long hi, int row) {
        assert row >= 0 && row < numberOfRows : "Index out of range";

        var startIdx = indexOf(row, 0);
        var endIdx =   indexOf(row, numberOfColumns - 1);
        for (var idx : new SwiftRange(startIdx, endIdx)) {
            matrix.set(idx, ThreadLocalRandom.current().nextLong(lo, hi + 1));
        }
    }

    public void fillColumnWithRandom(                  int col) {
        assert col >= 0 && col < numberOfColumns : "Index  out of range";

        var startIdx = indexOf(col, 0);
        var endIdx =   indexOf(col, numberOfColumns - 1);

        for (var idx : SwiftArray.strideThrough(col + numberOfRows * (numberOfColumns - 1), col, numberOfColumns)) {
            matrix.set(idx, ThreadLocalRandom.current().nextLong());
        }
    }
    public void fillColumnWithRandom(SwiftRange range, int col) {
        assert col >= 0 && col < numberOfColumns : "Index  out of range";

        var startIdx = indexOf(col, 0);
        var endIdx =   indexOf(col, numberOfColumns - 1);

        for (var idx : SwiftArray.strideThrough(col + numberOfRows * (numberOfColumns - 1), col, numberOfColumns)) {
            matrix.set(idx, ThreadLocalRandom.current().nextLong((long) range.lowerBound(), (long) range.upperBound() + 1L));
        }
    }
    public void fillColumnWithRandom(long lo, long hi, int col) {
        assert col >= 0 && col < numberOfColumns : "Index  out of range";

        var startIdx = indexOf(col, 0);
        var endIdx =   indexOf(col, numberOfColumns - 1);

        for (var idx : SwiftArray.strideThrough(col + numberOfRows * (numberOfColumns - 1), col, numberOfColumns)) {
            matrix.set(idx, ThreadLocalRandom.current().nextLong(lo, hi + 1));
        }
    }
}
