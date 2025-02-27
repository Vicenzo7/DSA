package company.ukg;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class UKGTest {

    // Constructor can be final
    // Where does it store null keys in HAshMAp

    public static void main(String[] args) {
        // Write a function to find first non-repeating character

        // aabaac

        String s = "aabaac";

        Map<Character, Long> collect = s.chars().mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(Function.identity(),
                        LinkedHashMap::new, Collectors.counting()));

//         collect.entrySet().stream()
//                .filter(e -> e.getValue() == 0)
//                .findFirst().get();

        for (Map.Entry<Character, Long> characterLongEntry : collect.entrySet()) {
            if (characterLongEntry.getValue() == 1) {
                System.out.println(characterLongEntry.getKey());
                break;
            }
        }

        /*
            select e1.salary from employee e1 where n - 1 >
            (Select distinct(salary) from employee e2 where e2.salary > e1.salary)
        */
    }

    @FunctionalInterface
    interface TestFunctionalInterface {
        int accept(int a, int b);
    }


}
