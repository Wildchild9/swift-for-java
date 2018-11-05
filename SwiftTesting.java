package com.noahwilder.Swift;

//
//  ComputerScience
//  SwiftTesting
//
//  Created by Noah Wilder on 2018-11-01.
//  Copyright © 2018 Noah Wilder. All rights reserved.
//

import com.noahwilder.Swift.*;

import java.util.ArrayList;


class SwiftTesting extends Swift {

    public static void main(String[] args) {
        var arr = SwiftArray.repeatingRandom(0, 100, 1000);
//        print(arr.reduce((x, y) -> x + y).orElseThrow() / arr.countInteger());
//        print(arr);
        var array = new SwiftArray(1, 2, 3, 4, 5, 6, 7);
        print(array.joined(", "));
        print(SwiftArray.repeatingRandom(-100, 100, 100));
        print(SwiftArray.repeatingRandom(100d, 200d, 100));
        print(primeFactors(5));
        print(gcf(6, 18, 60, 87));
        print("Is 2002 a palindrome:", isPalindromic(2002));
        print(reversed("abc"));
        print(concatenate(5, 10 ));
        SwiftArray.fromRange(10, 29).print();
        ArrayList<Integer> arrInt = new SwiftArray(1,2,3,4,5,6,7,8,9,10).toArrayList();
        var average = arr.stream().reduce((x, y) -> x + y).get() / arr.size();
        print(average);

        print("\u0300\u1ecd".equals("\u0323\u00F2"));
        Math.random();
    }
}
