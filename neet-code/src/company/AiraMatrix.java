package company;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class AiraMatrix {


    static public void main(String[] args) {

        for (String arg : args) {
            System.out.println(arg);
        }
        String s = "Hello World, How are you";
        Map<Character, Long> collect = s.chars()
                .mapToObj(ch -> (char) ch)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        System.out.println(collect);


//        String s1 = """
//                Select * from employee e where n-1 =
//                (Select count(distinct salary) from employee e1 where e1.salary > e.salary)
//                """;



        /*
            Use Linked list to save memory instead of arrayList
            because arraylist size gets double and we mights not use that space

        */

    }
}
