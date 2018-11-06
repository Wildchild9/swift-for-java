# Swift for Java
Introduction of similar Swift types, functions, and methods in Java.

## Installation

    

## Compiler Flags
Please enable assertions in your compiler settings using the flag `-ea`.

To enable assertions, go to **Run > Edit Configurations > Swift** and type `-ea` in the field labeled "VM Options".



## Swift Methods

### Print
- `print()` - prints an empty line
- `print(item:)` - prints `item`
- `print(items:)` - prints the speciefied `items` separated by spaces (`items` is a variadic argument)
- `print(collection:separator:)` - prints the items in `collection` separated by a `separator`
- `print.withSeparator(separator:items:)` - prints the specified `items` separated by a `separator` (`items` is a variadic argument)
- `print.withTerminator(terminator:items:)` - prints the specified `items` followed by a `termiator` (`items` is a variadic argument)
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

---
### Swift-styled Conversion

Ditch Java's wierd conversion syntax of `(targetType) value` for Swift's beautifully clear type conversions.

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
		
				    
	
    
    


## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details

---