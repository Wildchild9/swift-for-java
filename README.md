# Swift for Java
Introduction of similar Swift types, functions, and methods in Java.

![swift java logo](https://user-images.githubusercontent.com/35314567/48043647-b7632d00-e155-11e8-9db9-cdd25d43bb2e.png)

## Installation

1. Download *swift-for-java* as a .zip file.

2. Open folder in Finder.

3. In another Finder window, navigate to the source folder of the desired IntelliJ project.

4. Drag the folder *Swift* into the source folder.

## Setup

### Compiler Flags
Please enable assertions in your compiler settings using the flag `-ea`.

To enable assertions, go to **File > Preferences > Build, Execution, Deployment > Compiler** and type `-ea` in the field labeled "Shared build process VM options".

### Setup
Please ensure that both your version of IntelliJ IDEA and version of Java are updated to the most recent versions. Also, please ensure that your project language level is set to the highest number (not including *X - Experimental Features*).

- [Java version 11.0.1](https://www.oracle.com/technetwork/java/javase/downloads/jdk11-downloads-5066655.html)
- [IntelliJ IDEA 2018.2.5 (Community Edition)](https://download.jetbrains.com/idea/ideaIC-2018.2.5.dmg)
- Project language level *11 - Local variable syntax for lambda parameters*

#### Set the project language version in IntelliJ IDEA
In IntelliJ IDEA, navigate to **File > Project Structure > Project** and select *11 - Local variable syntax for lambda parameters* in the field under *Project language level*.


## Usage

In the desired class, `Foo`, add the following:

    public class Foo extends Swift { ... }

If you would like to use the `SwiftArray` class, add the following line to your imports:

    import Swift.SwiftArray;

## Swift Methods

### Print
- `print()` - prints an empty line

- `print(item:)` - prints `item`

- `print(items:)` - prints the specified `items` separated by spaces (`items` is a variadic argument)

- `print(collection:separator:)` - prints the items in `collection` separated by a `separator`

- `print.withSeparator(separator:items:)` - prints the specified `items` separated by a `separator` (`items` is a variadic argument)

- `print.withTerminator(terminator:items:)` - prints the specified `items` followed by a `terminator` (`items` is a variadic argument)

- `printr(item:)` - prints `item` and returns `item`

    ---

### Fatal Error
- `fatalError()` - crashes program (exit code 10)

- `fatalError(message:)` - crashes program with `message` (exit code 10)

    ---

### Precondition
- `precondition(condition:)` - throws an `IllegalArgumentException` if `condition` evaluates to false

- `precondition(condition:message:)` - throws an `IllegalArgumentException` with a `message` if `condition` evaluates to false

    ---

### Scanner

- `swiftScanner(sc:)` - exposes `Scanner` to scanner methods

	- 	`hasNextWithPrefix(prefix:)` - returns a `boolean` value indicating the presence of `prefix` at the beginning of the scanner object's next input

	- 	`hasNextWithSuffix(suffix:)` - returns a `boolean` value indicating the presence of `suffix` at the end of the scanner object's next input

	-  	`hasNextContaining(value:)` - returns a `boolean` value indicating the presence of `value` contained within the scanner object's next input

	-  `hasNextPositive(numberType:)` - returns a `boolean` value indicating a positive input of the specified `numberType` for the scanner object

	-   `hasNextNegative(numberType:)` - returns a `boolean` value indicating a negative input of the specified `numberType` for the scanner object

	-   `hasNextNumber()` - returns a `boolean` value indicating whether the scanner object's next input is a number of any type

	-   `hasNext(s:)` - returns a `boolean` value indicating whether the scanner object's next input is the specified string, `s` (supports regex inputs)

	---

### Reverse

- **Non-mutating**
	- `reversed(str:)` - returns a copy of the inputted string `str` reversed

	- `reversed(list:)` - returns a copy of the inputted `list` reversed

- **Mutating**
 	- `reverse(str:)` - reverses `str`

	- `reverse(list:)` - reverses `lists`


## Swift-styled Conversion

Ditch Java's weird conversion syntax of `(targetType) value` for Swift's beautiful and clear type conversions.

#### Examples:

	// Conversion from double to int
	int integerN = Int(3.1415926d);

	// Conversion from int to double
	double doubleN = Double(2);

	// Conversion from int to long
	long longN = Long(592);

	// Conversion from double to String
	String string = String(12345.6789);


**Types with support for _Swift-styled conversion_:**

* `(int) value` → `Int(value)`
* `(double) value` → `Double(value)`
* `(float) value` → `Float(value)`
* `(long) value` → `Long(value)`
* `(short) value` → `Short(value)`
* `(byte) value` → `Byte(value)`
* `new String(value)` → `String(value)`



## Swift Math

Swift Math contains all of the same methods included within `java.util.Math` along with an array of additional functions to make your life easier.

- `lcm(x:y:)` - returns the lowest common multiplier of `x` and `y`

- `factors(of:)` - returns a `SwiftArray` containing the factors of an integral value

- `primeFactors(of:)` - returns a `SwiftArray` containing the prime factors of an integral value

- `primality(of:)` - returns a `boolean` value indicating whether an integral value is prime.

- `isPalindromic(n:)` - returns a `boolean` value indicating whether a value is a palindrome

- `concatenate(x:y:)` - returns the value of `x` and `y` concatenated

- `factorial(n:)` - returns the value of `n!`

- `average(collection:)` - returns a `double` value indicating the average of a `collection` with numeric elements

-  `average(numbers:)` - returns a `double` value indicating the average of a variadic list of `numbers`

-  `median(collection:)` - returns a `double` value indicating the median of a `collection` with numeric elements

-  `median(numbers:)` - returns a `double` value indicating the median of a variadic list of `numbers`

- `mode(collection:)` - returns the first mode of a `collection`

- `mode(elements:)` - returns the first mode of a variadic list of `elements`

- `modes(collection:)` - returns a `SwiftArray` containing the modes of a `collection`

- `modes(elements:)` - returns the a `SwiftArray` containing the modes of a variadic list of `elements`

- `sum(collection:)` - returns the sum of all values in a `collection` containing numeric elements

- `sum(numbers:)` - returns the sum of a variadic list of `numbers`



## Swift Array
`SwiftArray` is an array class that contains all of the functions found in Swift's `Collection` protocol and many more. `SwiftArray` is incredibly versatile and brings many of Java's high order functions buried under `Stream` to the surface with an ease of use.

### Initializers (Constructors)

#### Standard Initializers

- `SwiftArray()`, `new SwiftArray()` - an empty array

- `new SwiftArray(iterableElements:)` - an array containing the contents any type that is iterable (implements `Iterable`) including `ArrayList`, `Stack`, `LinkedList`, etc.

    ---


#### Static Initializers

- `SwiftArray.fromRange(lowerBound:upperBound:)` - an array containing all the numbers in an inclusive range bounded by `lowerBound` and `upperBound`

- `SwiftArray.repeating(element:count:)` - an array containing `element` repeated `count` times

- `SwiftArray.repeatingRandom(lowerBound:upperBound:count:)` - an array containing `count` random numbers within an inclusive range bounded by `lowerBound` and `upperBound`

- `SwiftArray.repeatingRandom(lowerBound:upperBound:decimalPlaces:count:)` - an array containing `count` random `double` values rounded to `decimalPlaces` decimal places within an inclusive range bounded by `lowerBound` and `upperBound`

- `SwiftArray.strideTo(n:from:by:)` - an array from a starting value to, but not including, an end value, stepping by the specified amount

- `SwiftArray.strideThrough(n:from:by:)` - an array from a starting value toward, and possibly including, an end value, stepping by the specified amount


**Note:** the word *"array"* in this context refers to a new object of `SwiftArray`.

----

### Outputting Methods

- `print()` - prints the array

- `printr()` - prints and returns the array

- `print(separator:)` - prints the array with its elements separated by a `separator`

- `printr(separator:)` - prints and returns the array with its elements separated by a `separator`

- `dump()` - dumps the array

    ---

### Element Adding Methods

- `append(item:)` - adds a new element at the end of the array

- `append(items:)` - adds the new elements in a variadic list to the end of the array

- `append(contentsOf:)` - adds the elements of a sequence to the end of the array.

- `insert(element:atIndex:)` - inserts a new element at the specified position

- `insert(contentsOf:atIndex:)` - inserts the elements of a sequence into the array at the specified position

    ---

### Count Methods

- `count()` - the number of elements in the array

- `count(predicate:)` - returns a count of the elements in the array that satisfy a given predicate

  ---

### Index Methods

- `hasIndex(idx:)` - returns boolean value indicating the validity of the given offset in the array

- `indices()` - an array containing the integral indices of an array

- `startIndex()` - the position of the first element in a nonempty array

- `endIndex()` - the array’s “past the end” position—that is, the position one greater than the last valid offset

- `swapAt(i:j:)` - exchanges the values at the specified indices of the array

    ---

### Removal Methods

- `removeElement(atIndex:)` - removes and returns the element at the specified position

- `removeFirst()` - removes and returns the element at the specified position

- `removeFirst(n:)` - removes the specified number of elements from the beginning of the array

- `removeLast()` - removes and returns the last element of the array

- `removeLast(n:)` - Removes the specified number of elements from the end of the array

- `removeAllWhere(predicate:)` - removes all the elements that satisfy the given predicate.

    ---

### Excluding Methods

- `dropFirst()` - returns an array containing all but the first element of the initial array

- `dropFirst(n:)` - returns an array containing all but the given number of initial elements

- `dropLast()` - returns an array containing all but the last element of the initial array

- `dropLast(n:)` - returns an array containing all but the specified number of final elements

- `drop(predicate:)` - returns an array by skipping elements while `predicate` returns `true` and returning the remaining elements

    ---

### Prefix & Suffix Methods

#### Prefix Methods

- `prefix(n:)` - returns an array, up to the specified maximum length, containing the initial elements of the array

- `prefixThrough(offset:)`- returns an array from the start of the initial array through the specified position

- `prefixUpTo(offset:)` - returns an array from the start of the initial array up to, but not including, the specified position

- `prefixWhile(predicate:)` - returns an array containing the initial elements until `predicate` returns `false` and skipping the remaining elements

#### Suffix Methods

- `suffix(n:)` - returns an array, up to the given maximum length, containing the final elements of the initial array

- `suffixFrom(offset:)` - returns an array from the specified position to the end of the initial array

- `suffixWhile(predicate:)` - returns an array containing the final elements until `predicate` returns `false` and skipping the remaining elements

    ---

### First & Last Methods

- `first()` - the first element of the array

- `firstWhere(predicate:)` - returns the first element of the array that satisfies the given predicate

- `firstIndexWhere(predicate:)` - returns the first offset in which an element of the array satisfies the given predicate

- `last()` - the last element of the array

- `lastWhere(predicate:)` - returns the last element of the array that satisfies the given predicate

- `lastIndexWhere(predicate:)` - returns the offset of the last element in the array that matches the given predicate

    ---

### Randomized Methods

- `randomElement()` - returns a random element of the array

- `randomIndex()` - returns a random offset of the array

- `shuffle()` - shuffles the array in place

- `shuffled()` - returns the elements of the array, shuffled

    ---

### Sorting Methods

- `sort()` - sorts the array in places

- `sort(c:)` - sorts the array in place, using the given predicate as the comparison between elements

- `sorted()` - returns the elements of the array, sorted

- `sorted(comparator:)` - returns the elements of the array, sorted using the given predicate as the comparison between elements

    ---

### Maximum & Minimum

- `max(comparator:)` - returns the maximum element in the array, using the given predicate as the comparison between elements

- `min(comparator:)` - returns the minimum element in the array, using the given predicate as the comparison between elements

    ---

### Reverse methods

- `reverse()` - reverses the elements of the array in place

- `reversed()` - returns the elements of the array, reversed

     ---

### Joining Methods

- `joined()` - returns a new string by concatenating the elements of the array

- `joined(separator:)` - returns a new string by concatenating the elements of the array, adding the given separator between each element

    ---

### Transformation Methods

- `map(transform:)` - returns an array containing the results of mapping the given transformation over the array’s elements

- `filter(predicate:)` - returns a new array containing, in order, the elements of the array that satisfy the given predicate

- `reduce(accumulator:)` - returns the result of combining the elements of the array using the given accumulator

    ---

### Element Matching Methods


- `contains(predicate:)` - returns a boolean value indicating whether the array contains an element that satisfies the given predicate

- `allSatisfy(predicate:)` - returns a boolean value indicating whether every element of an array satisfies a given predicate

- `noneSatisfy(predicate:)` - returns a boolean value indicating whether no elements of an array satisfies a given predicate

  ---

### Other Methods

- `reserveCapacity(n:)` - reserves enough space to store the specified number of elements
- `toSlice(lowerBound:upperBound:)` - returns a new array containing the elements from the lowerBound to the upperBound (inclusive)


## Dusk Color Theme

This IntelliJ color theme a near replica of Xcode's beautiful dusk color theme for Java.

### Installation

1. Then, inside IntelliJ, navigate to **File > IntelliJ Idea > Prefereces > Editor > Color Scheme > General**.

2. From there, select the gear icon to the right of the "Scheme" field. Continue to select **Import Scheme > IntelliJ IDEA color scheme (.icls) or settings (.jar)**.

3. Inside the popup window of Finder, navigate to the downloaded project folder and select the file Dusk.icls and click "open".

4. Now hit "Apply", then "OK" in the bottom right of the IntelliJ preferences pane.

5. Finally your IntelliJ color scheme should be reminiscent of the Xcode's beautiful Dusk color scheme. Enjoy!



## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details
