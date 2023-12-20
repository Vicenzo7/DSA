
Let us first **redefine the problem**.
```
So permutation of a string basically means just the reordering of the letters of the string. That means all the permutations of a string are just the anagrams of the string, with all the letters included, just in another way. And we have to find if such a substring exists in s2 which is a permutation of s1, which means we have to find a substring in s2 such that the frequency of the characters in that substring is same as the frequency of the characters in s1.
```

So we will be using **SLIDING WINDOW APPROACH** to find such a window in s2 in which the freq of characters is same as s1.

#### Algorithm:

1. The first step is to find the freq of all characters of s1. 
2. Then we will be starting with a window of size 1 initially in s2. That means start=0, end=0. 
3. Along with this, we will also be maintaining the frequency of the characters in the current window. 
4. We will be continuing the below steps until we reach a situation where the end of the window reaches the end of s2. That means we will be doing the steps while end<length of s2. 
	1. Increase the frequency of the character which is just now newly included inside the window. That means increase the frequency of s2[end]. 
	2. Now check if the frequency of the characters in the current window, is same as the frequency of characters int s1. But this is only possible if the length of current substring(window) is same as the length of s1. If this is true, then we can directly return true from here. 
	3. If the frequency doesn't match, we have to change the window:- 
		1. If the length of window in less than the length of s1, then we should increase the length of the the window by increasing the end. So end+=1.
		2. If not, that means length of window is greater than or equal to the length of s1, so we will need to move to a new window. For that we will have to move start to the next character but before that we will have to decrease the frequency of start character from the current window frequency. That means -
			- Decrease the frequency of s2[start]. -
			- Move start to the next element. -
			- Move end to the next element. 
5. If the algorithm did not return true for any window, then we will reach here(out of the loop). This will mean that we did not find any such substring in s2. So return false.

`TC = O(26.n) = O(s2.length())`
`SC = O(26) = O(1)`

```
public static boolean checkInclusion(String s1, String s2) {  
    // if s2 < s1 return false  
    if (s2.length() < s1.length()) {  
        return false;  
    }  
  
    // calculate frequency of s1 characters  
    int[] s1Frequency = new int[26];  
    for (char ch : s1.toCharArray()) {  
        s1Frequency[ch - 'a']++;  
    }  
  
    int left = 0, right = 0;  
    int[] s2Frequency = new int[26];  
    while (right < s2.length()) {  
        s2Frequency[s2.charAt(right) - 'a']++;  
  
        // check if window size is proper and if proper window size check if frequency match  
        int windowSize = right - left + 1;  
        if (windowSize == s1.length()) {  
            if (frequencyMatch(s1Frequency, s2Frequency)) {  
                return true;  
            }  
        }  
        // windowSize is >= s1 length but answer is not in this window  
        if (windowSize >= s1.length()) {  
            s2Frequency[s2.charAt(left) - 'a']--;  
            left++;  
        }  
        right++;  
    }  
    return false;  
}  
  
public static boolean frequencyMatch(int[] s1Frequency, int[] s2Frequency) {  
    for (int i = 0; i < 26; i++) {  
        if (s1Frequency[i] != s2Frequency[i]) {  
            return false;  
        }  
    }  
    return true;  
}
```



**Solution 2**: Optimized slightly

The difference between the above and the below code is 
Above code TC = (26.n) and here the TC = O(n)

Instead of checking the both frequency arrays are equal again and again its better to keep a track, how many index of those both are match

If the **match is 26** then permutation exist.


```
// TC = O(n)  
public static boolean checkInclusionOptimised(String s1, String s2) {  
    // if s2 < s1 return false  
    if (s2.length() < s1.length()) {  
        return false;  
    }  
  
    int[] s1Freq = new int[26];  
    int[] s2Freq = new int[26];  
  
    for (int i = 0; i < s1.length(); i++) {  
        s1Freq[s1.charAt(i) - 'a']++;  
        s2Freq[s2.charAt(i) - 'a']++;  
    }  
  
    int matches = 0; // note if matches == 26 means frequency matches  
    for (int i = 0; i < 26; i++) {  
        matches += s1Freq[i] == s2Freq[i] ? 1 : 0;  
    }  
  
    // starting from s1.length because we have created a window  
    int left = 0;  
    for (int right = s1.length(); right < s2.length(); right++) {  
        // note if matches == 26 means frequency count matches  
        if (matches == 26) {  
            return true;  
        }  
  
        // if no match then increase the window  
        int index = s2.charAt(right) - 'a';  
        s2Freq[index]++;  
        // by increasing the frequency in s2Freq,caused the character frequency in both array to be same then increase the match  
        if (s1Freq[index] == s2Freq[index]) {  
            matches += 1;  
        } else if (s1Freq[index] + 1 == s2Freq[index]) { // by increasing the frequency in s2Freq,caused the character frequency in s1Freq array to be less than s2Freq  
            // decrease the match            matches -= 1;  
        }  
  
        // by decreasing the frequency in s2Freq,caused the character frequency in both array to be same then increase the match  
        index = s2.charAt(left) - 'a';  
        s2Freq[index]--;  
        if (s1Freq[index] == s2Freq[index]) {  
            matches += 1;  
        } else if (s1Freq[index] - 1 == s2Freq[index]) { // by decreasing the frequency in s2Freq,caused the character frequency in s1Freq array to be more than s2Freq  
            // decrease the match            matches -= 1;  
        }  
        left += 1;  
    }  
  
    return matches == 26;  
}
```