package test;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
//        List<NestedInteger> nestedList = firstInput();
        List<NestedInteger> nestedList = secondInput();
        System.out.println(depthSumInverse(nestedList));

    }

    private static List<NestedInteger> secondInput() {
        List<NestedInteger> nestedList = new ArrayList<>();


        NestedInteger innerMostList = new NestedIntegerImpl();
        innerMostList.add(new NestedIntegerImpl(6));
        innerMostList.add(new NestedIntegerImpl(2));

        NestedInteger secondLevelList = new NestedIntegerImpl();
        secondLevelList.add(new NestedIntegerImpl(4));
        secondLevelList.add(innerMostList);

        NestedInteger topLevelList = new NestedIntegerImpl();
        topLevelList.add(new NestedIntegerImpl(1));
        topLevelList.add(secondLevelList);
        nestedList.add(topLevelList);
        return nestedList;
    }

    private static List<NestedInteger> firstInput() {
        List<NestedInteger> nestedList = new ArrayList<>();

        NestedInteger firstList = new NestedIntegerImpl();
        firstList.add(new NestedIntegerImpl(1));
        firstList.add(new NestedIntegerImpl(1));
        nestedList.add(firstList);

        nestedList.add(new NestedIntegerImpl(2));


        NestedInteger secondList = new NestedIntegerImpl();
        secondList.add(new NestedIntegerImpl(1));
        secondList.add(new NestedIntegerImpl(1));
        nestedList.add(secondList);
        return nestedList;
    }


    static
    public int depthSumInverse(List<NestedInteger> nestedList) {
        int total = 0;
        int prevSum = 0;
        Queue<NestedInteger> queue = new ArrayDeque<>(nestedList);

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                NestedInteger nestedInteger = queue.poll();
                if (nestedInteger.isInteger())
                    prevSum += nestedInteger.getInteger();
                else
                    queue.addAll(nestedInteger.getList());
            }
            total += prevSum;
        }

        return total;
    }
}
