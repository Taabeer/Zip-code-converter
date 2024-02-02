# Zip-code-converter
This project consists of two Java classes, Zipcode and ZipTest, which provide functionality for converting between ZIP codes and barcodes.

### Zipcode Class
The Zipcode class provides methods to convert ZIP codes to barcodes and vice versa. It contains the following methods:

Zipcode(int z): Constructor that initializes a Zipcode object with an integer ZIP code.
Zipcode(String b): Constructor that initializes a Zipcode object with a barcode string.
getZIPcode(): Converts the barcode to a ZIP code string.
getBarcode(): Converts the ZIP code to a barcode string.
createCheckDigit(): Calculates the check digit for the ZIP code.
arrayToString(String[] barCode): Converts a string array representing a barcode to a single string.
arrayToString(int[] zipCode): Converts an integer array representing a ZIP code to a single string.
isValidCheckDigit(String barcode): Checks if the check digit of the barcode is valid.

### ZipTest Class
The ZipTest class serves as a tester program for the functionality provided by the Zipcode class. It allows users to interactively test the conversion between ZIP codes and barcodes.

### Usage
To use the ZipTest program:

Compile the program.
Run the compiled program.
Follow the prompts to enter either a ZIP code or a barcode.
The program will display the corresponding barcode or ZIP code based on the input provided
