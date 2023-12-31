
**Important formula to find how many blocks of water can be stored at index i**

$$
minimum(maxLeftHeight,maxRightHeight) - height[i]
$$

**Solution 1:**
`TC O(n)`
`SC O(n)`

| input (Array)               | 0   | 1  | 0  | 2   | 1  | 0  | 1  | 3  | 2  | 1  | 2  | 1  |
| -                           | -   | -  | -  | -   | -  | -  | -  | -  | -  | -  | -  | -  |
| Max Left Height             | 0   | 0  | 1  | 1   | 2  | 2  | 2  | 2  | 3  | 3  | 3  | 3  |
| Max Right Height            | 3   | 3  | 3  | 3   | 3  | 3  | 3  | 2  | 2  | 2  | 1  | 0  |
| Min(leftHeight,rightHeight) | 0   | 0  | 1  | 1   | 2  | 2  | 2  | 2  | 2  | 2  | 1  | 0  |
| -                           | -   | -  | -  | -   | -  | -  | -  | -  | -  | -  | -  | -  |
| After applying Formula      | 0   | -1 | 1  | -1  | 1  | 2  | 1  | -1 | 0  | 1  | -1  |-1 |

1. Iterate through the array and calculate max left height for each index and store it in an array
2. Iterate though back of the array and calculate max right height for each index and store it in an array
3. Now Iterate and calculate the total water trapped using the formula


**Solution 2: Two pointer approach** 
`TC = O(n)`
`SC = O(1)`

Here in this solution we will not use extra array to store max left height and  max right height

1. Take two pointer left and right and also two variables maxLeft and maxRight
2. Initial maxLeft = height[0]  maxRight = height[height.length-1]
3. Iterate till left < right, but which pointer to move, move the pointer which has less value min(maxLeft,maxRight) ,because we need min(maxLeft,maxRight)