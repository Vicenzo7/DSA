
**Solution 1**

1. Iterate the array and calculate the whole product
2. Iterate the result array and store in it  ```product/nums[i]```

`TC = O(n)`
`SC = O(n)`

**But the constraint is : You must write an algorithm that runs in `O(n)` time and without using the division operation.**

**Solution 2**
`TC = O(n)`
`SC = O(1) => output array is not considered


|  1 | 2  | 3 | 4|
| - | - | - | - |

Prefix 

|  1 | 2  | 6 | 24|
| - | - | - | - |

Postfix

|  24 | 24  | 12 | 4|
| - | - | - | - |

Output

|  24 | 12  | 8 | 6|
| - | - | - | - |

No need to use two arrays called prefix and postfix
1. Traverse the array and store the prefix in the output array
2. Traverse the array from back and compute the postfix and multiply and store the answer in the output.
