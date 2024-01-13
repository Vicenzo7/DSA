## Subset Pattern

Q. Give a list of distinct numbers, return all possible distinct subset

eg [ 1, 2, 3]
Answer would be \[1],   \[2], \[3],  \[1,2],  \[1,3], \[2,3] or \[empty choosing nothing]

The pattern so subset is either **include or exclude**
```
// Q. Given a list of distinct numbers, return all possible distinct subset  
public static void main(String[] args) {  
    int[] nums = {1, 2, 3};  
    List<List<Integer>> subSets = new ArrayList<>();  
    List<Integer> currentSet = new ArrayList<>();  
    // Q. Given a list of distinct numbers, return all possible distinct subset  
    getSubsets(nums, 0, currentSet, subSets);  
    System.out.println(subSets);  
  
    // Q. Given a list of numbers that are not necessarily distinct, return all possible distinct subset  
    int[] nums2 = {1, 2, 3, 2};  
    subsetsWithDuplicates(nums2);  
}  
  
  
// TC = O(n*2^n)  SC=O(n)  
private static void getSubsets(int[] nums, int index, List<Integer> currentSet, List<List<Integer>> subSets) {  
    if (index == nums.length) {  
        subSets.add(new ArrayList<>(currentSet));  
        return;  
    }  
    // include  
    currentSet.add(nums[index]);  
    getSubsets(nums, index + 1, currentSet, subSets);  
  
    // exclude  
    currentSet.remove(currentSet.size() - 1);  
    getSubsets(nums, index + 1, currentSet, subSets);  
}  
  
// Q. Given a list of numbers that are not necessarily distinct, return all possible distinct subset  
private static void subsetsWithDuplicates(int[] nums) {  
    List<List<Integer>> subsets = new ArrayList<>();  
    List<Integer> currentSet = new ArrayList<>();  
    Arrays.sort(nums); // makes it easier  
    helper2(0, nums, currentSet, subsets);  
    System.out.println(subsets);  
}  
  
private static void helper2(int index, int[] nums, List<Integer> currentSet, List<List<Integer>> subsets) {  
    if (index == nums.length) {  
        subsets.add(new ArrayList<>(currentSet));  
        return;  
    }  
  
    // Decision to include nums[index]  
    currentSet.add(nums[index]);  
    helper2(index + 1, nums, currentSet, subsets);  
  
    // skipping the duplicates to avoid adding duplicates subsets  
    while (index + 1 < nums.length && nums[index] == nums[index + 1]) {  
        index += 1;  
    }  
  
    // Decision to exclude nums[index]  
    currentSet.remove(currentSet.size() - 1);  
    helper2(index + 1, nums, currentSet, subsets);  
}

```

## Combinations (Similar to subsets pattern)

**Q. Given two nums n and k, return all possible combination of size k choosing from values between 1 and n**

```
n = 5 ,k = 2

ans = [1,2],[1,3],[1,4],[1,5],[2,3],[2,4],[2,5],[3,4],[3,5][4,5]
```

```
// Given n numbers (1 - n), return all possible combinations  
// of size k. (n choose k math problem).  
// Time: O(k * 2^n)  
public static List<List<Integer>> combinations(int n, int k) {  
    List<List<Integer>> combs = new ArrayList<>();  
    helper(1, new ArrayList<>(), combs, n, k);  
    return combs;  
}  
  
public static void helper(int i, List<Integer> curComb, List<List<Integer>> combs, int n, int k) {  
    if (curComb.size() == k) {  
        combs.add(new ArrayList<>(curComb));  
        return;  
    }  
    if (i > n) {  
        return;  
    }  
    // decision to include i  
    curComb.add(i);  
    helper(i + 1, curComb, combs, n, k);  
    curComb.remove(curComb.size() - 1);  
  
    // decision to NOT include i  
    helper(i + 1, curComb, combs, n, k);  
}
```

 TC = `O(k.2^n)` can we reduce it?
  **Yes -> If we have 5 numbers and we can choose only 2, how many combination exists  
 $$
C(n, k) = \frac{n!}{k! \cdot (n-k)!}
$$

$$
C(n, k) = C(5, 2) = \frac{5!}{2! \cdot (5-2)!}
$$

Expanding the factorials:

$$
= \frac{5 \cdot 4 \cdot 3 \cdot 2 \cdot 1}{2 \cdot 1 \cdot (5-2) \cdot 1}
$$

Simplifying:

$$
= \frac{120}{2 \cdot 1 \cdot 6} = \frac{120}{12} = 10
$$

So, \( C(5, 2) = 10 \).

Instead of doing this 
![[combination_pattern_recurssion_tree.png]]

Do this 
![[combination_pattern_recurssion_tree2.png]]

Now `TC = O(k. C(n,k))`

```
// Time: O(k * C(n, k))  
public static List<List<Integer>> combinations2(int n, int k) {  
    List<List<Integer>> combs = new ArrayList<>();  
    helper2(1, new ArrayList<>(), combs, n, k);  
    return combs;  
}  
  
public static void helper2(int i, List<Integer> curComb, List<List<Integer>> combs, int n, int k) {  
    if (curComb.size() == k) {  
        combs.add(new ArrayList<>(curComb));  
        return;  
    }  
    if (i > n) {  
        return;  
    }  
    for (int j = i; j < n + 1; j++) {  
        curComb.add(j);  
        helper2(j + 1, curComb, combs, n, k);  
        curComb.remove(curComb.size() -1);  
    }  
}
```

## Permutation

**Q. Given a list of numbers, return all possible distinct permutations of numbers**

Subset or combination is to add or exclude some, where permutation is to add every single one of these numbers, but the order will be rearranged

example we have \[1,2,3] 
Permutation of above is 
\[1,2,3] ->\[1,3,2] -> \[2,3,1] -> \[2,1,3] -> \[3,2,1] -> \[3,1,2] 

for n elements number of permutation is n!
eg 3 = 3! = 3*2 = 6

```
public static List<List<Integer>> permute(int[] nums) {  
    return generatePermutation(0, nums);  
}  
  
public static List<List<Integer>> generatePermutation(int index, int[] nums) {  
    if (index == nums.length) {  
        List<List<Integer>> result = new ArrayList<>();  
        result.add(new ArrayList<>());  
        return result;  
    }  
  
    List<List<Integer>> allPermutation = new ArrayList<>();  
    List<List<Integer>> permutations = generatePermutation(index + 1, nums);  
  
    for (List<Integer> permutation : permutations) {  
        for (int i = 0; i < permutation.size() + 1; i++) {  
            List<Integer> premCopy = new ArrayList<>(permutation);  
            premCopy.add(i, nums[index]);  
            allPermutation.add(premCopy);  
        }  
    }  
    return allPermutation;  
}
```