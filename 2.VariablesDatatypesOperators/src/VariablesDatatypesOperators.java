/**
 * Created by Mihai Serban on 5/31/2017.
 */
public class VariablesDatatypesOperators {
    public static void main(String[] args) {
        System.out.println("Variables Data types and Operators");
        //Data types
        // byte - width of 8, 1 bytes (-128 -> 127)
        // short - width of 16, 2 bytes (-32768 -> -32767)
        // int - width of 32, 4 bytes
        // long - width of 64, 8 bytes
        // float  - width of 32, 4 bytes
        // double - width of 64, 8 bytes
        // char - width of 16, 2 bytes (0 -> 65535)
        // boolean - true or false

        //Operators
        //-, +, *, /, %, %=, ==, >=, != , <= , >, <, |, $, ^, ~, ||, >>, <<<, !, ternary, instanceof etc

        //Literals
        boolean status;
        boolean status2;
        status2 = status = false;

        boolean isBooleanPrimitive = true;
        isBooleanPrimitive = false; //change the primitive value
        boolean wasBooleanPrimitve = isBooleanPrimitive ? true : false;

        char capitalC = 'C';
        char charNumber = 63;
        char charUnicode = '\u00AE';

        byte b = 100;
        short s = 10000;
        short myNewShortPrimitiveValue = (short) (s / 10);

        //Integer literals
        // The number 26, in decimal
        int decValue = 26;
        //  The number 26, in hexadecimal
        int hexValue = 0x1a;
        // The number 26, in binary
        int binValue = 0b11010;
        int i = 'I';
        int integerValue = 12;
        float floatValue = 12F;
        double doubleValye = 12D;

        //Floating-Point Literals
        double d1 = 163.1;
        d1 %= 12.7;

        // same value as d1, but in scientific notation
        double doublePrimitive = 1.631e2 + d1;
        float floatPrimitive = 123.4f / 2f;
        float pi = 3.14_15F + floatPrimitive;

        //Numeric literals
        byte bytePrimitive = 127;
        byte bytePrimitive2 = 0b0010_0101;
        short shortPrimitive = 32767;
        short totalValue = (short) (--bytePrimitive + ++bytePrimitive2);

        int intPrimitive = (Double.valueOf(Math.pow(2, 31) - 1).intValue()) / 2;
        int minValue = -2_147_483_648 % 5;  //Java 7 feature
        int maxValue = 2_147_483_647;  //Java 7 feature

        long longPrimitive = Double.valueOf(Math.pow(2, 63) - 1).longValue();
        long creditCardNumber = 1234_5678_9012_3456L;
        long socialSecurityNumber = 999_99_9999L - creditCardNumber;
        long longMinValue = -9_223_372_036_854_775_808L;
        long longMaxValue = 9_223_372_036_854_775_807L;
        long longTotalValue = 200L + (longMaxValue / 2) * longMaxValue;
        long hexBytes = 0xFF_EC_DE_5E;
        long hexWords = 0xCAFE_BABE;
        long maxLong = 0x7fff_ffff_ffff_ffffL;
        long bytes = 0b11010010_01101001_10010100_10010010;

        String myStringObject = new StringBuilder("sherbansoftware").append(" \u00A9 2017").toString();

        /*
        System out directive:
            - println
            - print
            - printf
        You can list the contents of primitive variables above as shown:
         */
        System.out.println("charUnicode value is: " + charUnicode);
        System.out.println("myNewShortPrimitiveValue is: " + myNewShortPrimitiveValue);
        System.out.println("myStringObject value is: " + myStringObject);
        System.out.print("intPrimitive value is: " + intPrimitive + "\n");
        System.out.printf("%b\n", bytePrimitive != shortPrimitive);
        System.out.println(new Long(longPrimitive).equals(new Long(socialSecurityNumber)));
        if(isBooleanPrimitive == true)
            System.out.println("Yes, isBooleanPrimitive!");
        if((maxLong > minValue) && (maxLong > 100))
            System.out.printf("%s", "Both conditions are actually true");
    }
}
