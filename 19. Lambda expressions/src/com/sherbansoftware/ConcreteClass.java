package com.sherbansoftware;

/**
 * Created by Mihai Serban on 7/13/2017.
 * <p>
 * syntax
 * arg_list -> body
 * The arrow separates the arg list from the body, maps it's arguments to a value
 * If there is a single argument, the arg list may not be parenthesised; but it may be.
 */
public class ConcreteClass {

    public void doStuff() {
        //the fibonacci of a given number recursive
        FInterface fibonacci = (int number) -> {
            if (number == 0)
                return 0;
            else if (number == 1)
                return 1;
            else
                return (number - 1) + (number - 2);
        };

        // the sum of first 'n' numbers recursive
        // the parameters for arg list are not typed. The compiler figures out. Without braces when is a single line
        FInterface summarize = (number) -> number * (number + 1) / 2;

        // the collatz of a number recursive
        FInterface collatz = (number) -> {
            if (number == 1) return 1;
            if (number % 2 == 0) return (number / 2);
            else return (3 * number + 1);
        };

        int sum = summarize.compute(10);
        System.out.println("Summarize of 10 is: " + sum);

        int fib = fibonacci.compute(50);
        System.out.println("Fibonacci of 50 is: " + fib);

        int col = collatz.compute(100);
        System.out.println("Collatz of 100 is: " + col);

    }

}
