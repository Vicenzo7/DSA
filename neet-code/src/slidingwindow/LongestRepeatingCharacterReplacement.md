
**Hint** : No need to change characters

**Solution**

`TC : O(n)`
`SC : O(26) = O(1)`

**Intuition**
	

1. Create a window, left = 0, right = 0, also need an array to track of character frequency 
2.  While iterating store the frequency of every character
3. Also compute maxCharacterCount till now `maxCharCount = max(maxCharCount , array[s.charAt(right) -'A']++)`. Max char count can also be calculated by running a for loop around the frequency array as its size is fixed and will be always constant.
4. Now check if window is of proper size `right - left + 1` = window size
	1. `windowSize - maxCharacterCount > k` = mean not a proper window, means this substring requires more then k replacement which we cannot have
	2.  So to have a proper window, increment the left pointer and before incrementing reduce the frequency count of the character which is at the left pointer.
5. Keep track of maxLength, `maxLength = max(maxLength, right-left +1)`

```
public static int characterReplacement(String s, int k) {  
    int[] array = new int[26]; // to keep character frequency  
    int left = 0;  
    int maxLength = 0;  
    int maxCharacterCount = 0; // to keep track of max character count till now  
    for (int right = 0; right < s.length(); right++) {  
        char ch = s.charAt(right);  
        int index = ch - 'A';  
        array[index]++;  
        maxCharacterCount = Math.max(maxCharacterCount, array[index]);  
        // means window is not of proper size, also it means to make this longest repeating   
        // we have to do more than k replacement which does not permit, so we reduce the window size   
        // and also the frequency of the character which was at left   
if ((right - left + 1) - maxCharacterCount > k) {  
            array[s.charAt(left) - 'A']--;  
            left += 1;  
        }  
        maxLength = Math.max(maxLength, (right - left + 1));  
    }  
    return maxLength;  
}
```


