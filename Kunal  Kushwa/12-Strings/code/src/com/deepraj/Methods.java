package com.deepraj;

import java.util.Arrays;

public class Methods {
    public static void main(String[] args) {
        String name = "Deepraj Majalikar Hello World";
        System.out.println(Arrays.toString(name.toCharArray()));
        //a new object is created in which name is converted to lower case because strings are immutable and then printed so the original object doesnt change
        System.out.println(name.toLowerCase());
        System.out.println(name);

        System.out.println(name.indexOf(" "));

        System.out.println("      Deepraj   ".trim());
        System.out.println(Arrays.toString(name.split(" ")));
    }
}
