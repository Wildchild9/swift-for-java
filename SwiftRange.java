package com.noahwilder.Swift;

//
//  ComputerScience
//  SwiftRange
//
//  Created by Noah Wilder on 2018-11-02.
//  Copyright © 2018 Noah Wilder. All rights reserved.
//


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