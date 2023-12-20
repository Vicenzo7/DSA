
**Solution 1: Brute force**

**Intuition**
Find all substrings and check if the those substrings have duplicate, if they have duplicate do not consider them.
Mean while also keep track of maxLength of valid sub-strings.

`TC : O(n^2)`
`SC : O(n)` -> using set to check duplicates

```
public static int lengthOfLongestSubstring(String s) {  
    if (s.isEmpty()) {  
        return 0;  
    }  
  
    if (s.isBlank() || s.length() == 1) {  
        return 1;  
    }  
  
    int maxLength = Integer.MIN_VALUE;  
    for (int i = 0; i < s.length() - 1; i++) {  
        Set<Character> set = new HashSet<>();  
        set.add(s.charAt(i));  
        maxLength = Math.max(maxLength, set.size());  
        for (int j = i + 1; j < s.length(); j++) {  
            if (!set.contains(s.charAt(j))) {  
                set.add(s.charAt(j));  
                maxLength = Math.max(maxLength, j - i + 1);  
            } else {  
                break;  
            }  
        }  
    }  
  
    return maxLength;  
}
```

**Solution 2: Using sliding window technique**

Need two pointers left and right using which we care going to calculate length.
Also need Set to keep check duplicates.

1. Iterate over the string using right pointer
2. Check if that character is in the set, while it is in the set remove the left most character from the set until the duplicates exist. This ensures us to start a substring with no duplicates
3. Add the current character to the set.
4. calculate the maxLength

`TC : O(n)`
`SC : O(n)`

```
public static int lengthOfLongestSubstringOptimised(String s) {  
    if (s.isEmpty()) {  
        return 0;  
    }  
  
    int maxLength = Integer.MIN_VALUE;  
    int left = 0;  
    Set<Character> window = new HashSet<>();  
    for (int right = 0; right < s.length(); right++) {  
        while (window.contains(s.charAt(right))) {  
            window.remove(s.charAt(left));  
            left += 1;  
        }  
        window.add(s.charAt(right));  
        maxLength = Math.max(maxLength, right - left + 1);  
    }  
    return maxLength;  
}
```