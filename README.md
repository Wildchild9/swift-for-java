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

To enable assertions, go to **Run > Edit Configurations > Swift** and type `-ea` in the field labeled "VM Options".

### Setup
Please ensure that both your version of IntelliJ (and version of Java is updated to the most recent versions. Also, please ensure that your project language level is set to the highest number (not including *X - Experimental Features*).

- [Java version 11.0.1](http://download.oracle.com/otn-pub/java/jdk/11.0.1+13/90cf5d8f270a4347a95050320eef3fb7/jdk-11.0.1_osx-x64_bin.dmg)
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

- `SwiftArray()`, `new SwiftArray()` - an empty array

- `new SwiftArray(iterableElements:)` - an array containing the contents any type that is iterable (implements `Iterable`) including `ArrayList`, `Stack`, `LinkedList`, etc.

#### Static Initializers

- `SwiftArray.fromRange(lowerBound:upperBound:)` - an array containing all the numbers in a range inclusively bounded by `lowerBound` and `upperBound`

- `SwiftArray.repeating(element:count:)` - an array containing `element` repeated `count` times




**Note:** the word *array* in this context refers to a new object of `SwiftArray`.

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
