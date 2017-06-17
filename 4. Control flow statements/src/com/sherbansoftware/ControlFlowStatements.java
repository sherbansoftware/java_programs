package com.sherbansoftware;

public class ControlFlowStatements {

    public static void main(String[] args) {

        int value = 3; //match the value for each switch case statement to check how the main method behaves

        /**
         * Switch statement executes one statement from multiple conditions. It is like if-else-if statement
         * Value can be a String in JDK 7
         * Instead of creating other case statements, we can use String methods to easily match cases
         */
        switch (value) {
            case 1:
                System.out.println("The value is 1");
                break;
            case 2:
                System.out.println("The value is 2");
                break;
            case 3:
                System.out.println("The value is 3");
                //break; intentionally comment
                //The output is listed until the next break occurs
            case 4:
                System.out.println("The value is 4");
                // value 3 and value 4
                break;
            case 5:
            case 6:
            case 7:
                System.out.println("The value 5 6 7");
                break;

            default:
                System.out.println("No option available");
                break;

        }

        /**
         * For loop statement it is used to iterate part of a program several times.
         * If the number of iterations is fixed it is recommended to use for loop.
         */
        System.out.println("\n" + " ***** Labeled For statement ****");
        rows:
        //label
        for (int i = 1; i <= 3; i++) {  //
            columns:
            for (int j = 1; j <= 3; j++) {
                if (i == 2 && j == 2) {
                    break columns;
                }
                System.out.printf("Row %d  - Column %d\n", i, j);
            }
        }

        System.out.println("\n" + " ***** For statement increment count ****");

        String str = "www.sherbansoftware.com";

        int maxim = str.length();
        int count = 0;

        // for - init ; termination ; incrementation
        for (int i = 0; i < maxim; i++) {
            if (str.charAt(i) != 's')
                continue;  //continue to next iteration
            count++;
        }

        System.out.println("Counting 's' : " + count);

        System.out.println("\n" + " ***** For statement decrement count ****");

        for (double d = 10.0; d >= 1.0; d -= 0.5) {
            System.out.println(String.format("%15f", d));  //formatting double with 15 spaces
            System.out.println(String.format("%.3f", d));  //formatting double with 3 decimals after point
        }

        /**
         * While loop statement it is used to iterate part of program but we do not know the number of iterations.
         * We continue the loop until a expression is true
         */
        count = 5;  //reassign value to count. This is *Init section* in the above for loop statement

        System.out.println("\n" + " ***** While statement ****");

        while (count != 10) {  // this is *Termination section* in the above for loop statement
            System.out.println("Count is: " + count);
            count++; //increment on each iteration and exit the while statement when count becomes 10
            // this is *Incrementation section* in the above for loop statement
        }

        /**
         * Do while loop statement it is used to iterate part of program but we do not know the number of iterations.
         * We continue the loop until a expression is true but must execute the loop at least once.
         */
        count = 100;  //reassign value to count.

        do {
            System.out.println("Count is: " + count);
            count -= 15;
        } while (count >= 10);  //do-while loop is executed at least once because condition is checked after loop body
    }
}
