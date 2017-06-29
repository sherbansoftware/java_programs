package com.sherbansoftware;

/**
 * The Java Regular Expression is an API to define pattern for searching or manipulating strings.
 * It is used to define constraint on strings. (passwords, emails, etc)
 * Java Regex API provides 1 interface and 3 classes in java.util.regex package.
 */
public class Main {

    public static void main(String[] args) {
        String myStringName = "My name is Mihai Serban";
        System.out.println("myString is: " + myStringName);

        //^ - carrot boundary matcher for the begin of string
        String yourStringName = new StringBuilder(myStringName.replaceAll("My", "Your").replaceAll("Mihai Serban", "John Misty")).toString();
        System.out.println("yourString is: " + yourStringName);

        String fatherName = new StringBuilder(myStringName.replaceAll("^My", "My father's").replaceAll("Mihai Serban", "Florica Serban")).toString();
        System.out.println("fatherName is: " + fatherName);

        boolean match = fatherName.matches("^My father's name is Florica Serban");
        System.out.println(match); // return true when matches all string

        //$ - dollar boundary matcher for the end of string
        String johnStringName = myStringName.replaceAll("Mihai Serban$", "John");
        System.out.println(johnStringName);

        //[] - boundary matcher for all the occurrences inside []
        String allOccurrences = myStringName.replaceAll("[aie]", "<replaced a letter here>");
        System.out.println(allOccurrences);

        //[][] - boundary matcher for all the occurrences in the first [] that is followed by all the occurrences in the second []
        allOccurrences = myStringName.replaceAll("[aie][rb]", "<REPLACED A LETTER HERE>");
        System.out.println(allOccurrences);

        //[]StringValue - boundary matcher for all the occurrences in the first [] that is followed by the string value
        allOccurrences = myStringName.replaceAll("[Mm]ihai", "MIHAI");
        System.out.println(allOccurrences);

        //[^StringValue] - - boundary matcher for all the occurrences except StringValue from []
        allOccurrences = myStringName.replaceAll("[^hai]", "X");
        System.out.println(allOccurrences);

        //[a-hA-M1-3] - - boundary matcher for all the occurrences from a to h, A to M and 1 to 3,inside []
        allOccurrences = new StringBuilder(myStringName).append(1234567).toString();
        allOccurrences = allOccurrences.replaceAll("[a-hA-M1-3]", "Y");
        System.out.println(allOccurrences);
    }
}
