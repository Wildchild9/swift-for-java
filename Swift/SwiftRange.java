package SwiftFramework.Swift;

/*
 *
 * SwiftRange.java
 * ComputerScience
 *
 *
 * Last modified on 05/11/18 10:51 PM.
 *
 * Copyright © 2018 Noah Wilder. All rights reserved.
 * This file is subject to the terms and conditions defined in
 * file 'LICENSE.txt', which is part of this source code package.
 *
 */


public class SwiftRange {



    private long upperBound;
    private long lowerBound;

    public SwiftRange(int lowerBound, int upperBound) {

        assert lowerBound <= upperBound: "Cannot form range with upperBound > lowerBound";

        this.lowerBound = (long) lowerBound;
        this.upperBound = (long) upperBound;
    }

    public SwiftRange(long lowerBound, long upperBound) {
        assert lowerBound <= upperBound: "Cannot form range with upperBound > lowerBound";

        this.lowerBound = lowerBound;
        this.upperBound = upperBound;
    }


}