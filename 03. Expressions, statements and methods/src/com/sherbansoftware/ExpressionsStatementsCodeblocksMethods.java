package com.sherbansoftware;

public class ExpressionsStatementsCodeblocksMethods {
    public static void main(String[] args) {
        boolean status = true; //or false
        doStuff(status);

        System.out.printf("%s", "\n");
        status = doStuff(false, true);
        System.out.printf("Status: %b\n", status);
        status = doStuff();
        System.out.printf("Status: %b\n", status);
    }

    //overloading methods with unique parameters
    public static boolean doStuff(boolean value, boolean status) {
        return value || status;
    }

    public static boolean doStuff() {
        return false;
    }

    //not overloading, same method name but return a different type
    public static void doStuff(boolean value) {
        if (value) {
            value = false;
            int number = 5; //statement
            int finalScore = 100;
            int bonus = 1000;

            if (bonus < 1500 && bonus >= 800) {
                finalScore *= bonus;
                System.out.println("The final score is: " + finalScore);
            } else if (bonus < 800 && bonus > 200) {
                finalScore -= bonus;
                System.out.println("The final score is: " + finalScore);
            } else {
                finalScore %= bonus;
                System.out.println("The final score is: " + finalScore);
            }

            if (number == 6)
                System.out.println("The number is 6");
            else {
                String status = "You lose!";
                System.out.println("The number is 5");
                System.out.println("Status: " + status + "\n" + "Value: " + value);
            }

            number = 10; //expression
            number++; //expression
            System.out.println("Mihai Serban"); //statement which includes "Mihai Serban" expression
            System.out.println("This " +
                    "is " +
                    "another expression"); //statement with expression on multiple lines

            if (number == 10)
                System.out.println("The number is 5");
            System.out.println("This is executed");
        } else {
            int finalScore = 100;
            int bonus = 5000;

            if (bonus < 13200 || bonus > 1600) {
                finalScore *= bonus;
                System.out.println("The final score is: " + finalScore);
            } else {
                finalScore -= bonus;
                System.out.println("The final score is: " + finalScore);
            }
        }
    }
}
