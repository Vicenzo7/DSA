
**Solution 1**
1. Get frequency count of all the elements in the map.
2. Put that map.entry in the list and sort the list value wise
3. Extract the first k elements from the list and those will be the top K frequent elements

`TC = O(n) + O(n.log(n)) = O(n.log(n))`
`SC = O(n)`

**Solution 2**
1. Get frequency count of all the elements in the map.
2. Declare a priority que which custom comparator and add all the map.entry in that queue
3. Extract the first k elements from the list and those will be the top K frequent elements

`TC = O(n) + O(n.log(n)) = O(n.log(n))`
`SC = O(n)`

**Solution 3 : Bucket Sort**
`TC = O(n) 
`SC = O(n)

```
arr = [1,1,1,2,2,3,3,3,100]
k = 2
```

Count array = size of input array

| i(count) | 0  | 1  | 2 | 3 | 4| 5 |6|
| - | - | - | - | - |  - |- |- |
| Values   | 0| [100] |[2]|[1,3]|0|0|0|


100 appeared ones so its in 1's column 
2 appeared twice so it is in the 2th column
1 and 3 appear thrice so it is in the 3rd column


Now we need top k most frequent values so we start at the end of the count array 
and extract our answer

| i(count) | 0  | 1  | 2 | 3 | 4| 5 |6|
| - | - | - | - | - |  - |- |- |
| Values   | 0| [100] |[2]|[1,3]|X|X|X|

```
ans = [1,3]

Solution 
public static int[] topKFrequent(int[] nums, int k) {  
    // TC = O(n) SC = O(n)  
    Map<Integer, Integer> frequencyCount = new HashMap<>();  
    for (int num : nums) {  
        frequencyCount.put(num, frequencyCount.getOrDefault(num, 0) + 1);  
    }  
  
    List<List<Integer>> frequencyList = new ArrayList<>(nums.length + 1);  
    for (int i = 0; i <= nums.length; i++) {  
        frequencyList.add(new ArrayList<>());  
    }  
  
    for (Map.Entry<Integer, Integer> entry : frequencyCount.entrySet()) {  
        Integer value = entry.getValue();  
        Integer key = entry.getKey();  
        List<Integer> subList = frequencyList.get(value);  
        subList.add(key);  
    }  
  
    int[] result = new int[k];  
    int counter = 0;  
    for (int i = frequencyList.size() - 1; i >= 0; i--) {  
        List<Integer> subList = frequencyList.get(i);  
        if (subList.isEmpty()) continue;  
  
        for (Integer integer : subList) {  
            result[counter++] = integer;  
            k--;  
            if (k == 0) break;  
        }  
        if (k == 0) break;  
    }  
  
    return result;  
}


```