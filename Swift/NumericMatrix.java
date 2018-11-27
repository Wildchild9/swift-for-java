package Swift;

/*
 *
 * NumericMatrix.java
 * Swift for Java
 *
 *
 * Last modified on 27/11/18 10:56 AM.
 *
 * Copyright © 2018 Noah Wilder. All rights reserved.
 * This file is subject to the terms and conditions defined in
 * file 'LICENSE', which is part of this source code package.
 *
 */

public interface NumericMatrix<Numeric extends Comparable, T extends Matrix<Numeric>> {

    // Statistics
    double average();
    Numeric max();
    Numeric min();

    // Non-mutating operators
    T added(T n);

    T subtracted(T by);

    T multiplied(Numeric by);
    T multiplied(T by);

    // Mutating operators
    void add(T n);
    void subtract(T by);
    void multiply(Numeric by);
    void multiply(T by);


}
