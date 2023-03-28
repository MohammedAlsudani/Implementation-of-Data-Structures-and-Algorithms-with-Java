package common;

public class MathFunctions {
    public static void main(String[] args) {
        // absolute value
        double absoluteValue = Math.abs(-5.7);
        System.out.println("The absolute value of -5.7 is " + absoluteValue);

        // maximum value
        int maxValue = Math.max(10, 20);
        System.out.println("The maximum value between 10 and 20 is " + maxValue);

        // minimum value
        int minValue = Math.min(30, 40);
        System.out.println("The minimum value between 30 and 40 is " + minValue);

        // random number generator
        double randomNumber = Math.random();
        System.out.println("A random number between 0.0 and 1.0 is " + randomNumber);

        // rounding
        double originalNumber = 5.67;
        double roundedNumber = Math.round(originalNumber);
        System.out.println("The rounded value of " + originalNumber + " is " + roundedNumber);

        // square root
        double squareRoot = Math.sqrt(25);
        System.out.println("The square root of 25 is " + squareRoot);

        // Cube root
        double cubeRoot = Math.cbrt(25.0);
        System.out.println("The cube root of 25 is: " + cubeRoot);

        // power function
        double base = 2.0;
        double exponent = 3.0;
        double result = Math.pow(base, exponent);
        System.out.println(base + " raised to the power of " + exponent + " is " + result);

        // trigonometric functions (in radians)
        double angleInRadians = Math.PI / 4.0;
        double sineValue = Math.sin(angleInRadians);
        double cosineValue = Math.cos(angleInRadians);
        double tangentValue = Math.tan(angleInRadians);
        System.out.println("sin(" + angleInRadians + ") = " + sineValue);
        System.out.println("cos(" + angleInRadians + ") = " + cosineValue);
        System.out.println("tan(" + angleInRadians + ") = " + tangentValue);

        // exponential function
        double exponentialResult = Math.exp(2.0);
        System.out.println("e raised to the power of 2 is " + exponentialResult);

        // natural logarithm function
        double naturalLogResult = Math.log(10.0);
        System.out.println("The natural logarithm of 10 is " + naturalLogResult);

        // base-10 logarithm function
        double base10LogResult = Math.log10(100.0);
        System.out.println("The base-10 logarithm of 100 is " + base10LogResult);

        // floor function (returns the largest integer less than or equal to a given number)
        double floorResult = Math.floor(3.7);
        System.out.println("The floor of 3.7 is " + floorResult);

        // ceil function (returns the smallest integer greater than or equal to a given number)
        double ceilResult = Math.ceil(3.2);
        System.out.println("The ceiling of 3.2 is " + ceilResult);

        // hypotenuse function (returns the length of the hypotenuse of a right triangle with given sides)
        double hypotenuseResult = Math.hypot(3.0, 4.0);
        System.out.println("The hypotenuse of a right triangle with sides 3 and 4 is " + hypotenuseResult);

        // signum function (returns the sign of a given number: -1 for negative, 0 for zero, 1 for positive)
        double signumResult1 = Math.signum(-5.6);
        double signumResult2 = Math.signum(0.0);
        double signumResult3 = Math.signum(7.9);
        System.out.println("The signum of -5.6 is " + signumResult1);
        System.out.println("The signum of 0.0 is " + signumResult2);
        System.out.println("The signum of 7.9 is " + signumResult3);


        // Inverse trigonometric functions
        double arcsineValue = Math.asin(1.0);
        System.out.println("Arcsine of 1 is: " + arcsineValue);

        double arccosineValue = Math.acos(0.0);
        System.out.println("Arccosine of 0 is: " + arccosineValue);

        double arctangentValue = Math.atan(1.0);
        System.out.println("Arctangent of 1 is: " + arctangentValue);

        // Rounding functions
        double roundingResult1 = Math.round(2.5);
        System.out.println("Rounding 2.5 is: " + roundingResult1);

        double roundingResult2 = Math.floor(2.8);
        System.out.println("Floor of 2.8 is: " + roundingResult2);

        double roundingResult3 = Math.ceil(2.2);
        System.out.println("Ceiling of 2.2 is: " + roundingResult3);

        // Logarithmic functions
        double naturalLogarithm = Math.log(10);
        System.out.println("Natural logarithm of 10 is: " + naturalLogarithm);

        double logarithmBase10 = Math.log10(100);
        System.out.println("Base-10 logarithm of 100 is: " + logarithmBase10);

        // Random number generation
        double randomValue = Math.random();
        System.out.println("Random number between 0 and 1 is: " + randomValue);
    }
}
