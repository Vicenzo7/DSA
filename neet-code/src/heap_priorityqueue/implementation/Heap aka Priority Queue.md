	
## Heap Type
1. Min Heap
2. Max Heap


## Heap Properties

- To create a heap need to satisfy the below two properties.

-  **Structure Property**
	- A binary heap is essentially a binary tree which is considered a **complete binary tree**.
	- A **Complete Binary Tree** is a binary tree where its every level will be completely full, expect the last level. The last level might have hole but every other level wont have holes
		![[heap_property.png]]
	
	- Nodes will be added from left to right

- **Order Property**
	- Suppose we are doing min heap, the the root node must be smaller than every other node so we can access the min value in `O(1)` and this is a recursive property. This is the same for max heap, the root node must be greater than every other node.
	- In this binary tree we can have duplicates.
	- Though this is a binary tree, under the hood it is implemented using arrays
	- We don't store at 0'th index 
		![[heap_property_2.png]]
	
	- These property hold only for complete binary tree

## Insertion and Removal in heap while maintaining the property

- Insertion 17 in min heap
	![[insert_17_in_min_heap.png]]

- Removal means we remove the root
	 - Remove the root 
	 - At root add the last element 
	 - Now **percolate down** so satisfy the order property, percolate only when there is at-least one child
	- There are three cases
		 - A root has no child
		 - A root has one child (mean it will only have a left child)
		 - A root has two children
	- While there is a left child
		- Check if there is a **right child** and **right child is smaller then left child** and **right child is smaller then parent** == true, 
			- then swap right child with the parent and move towards right to percolate.
		- If above condition is false, it means it only has left child so check if left right is smaller then it's parent == true.
			- then swap left child with the parent and move towards left to percolate
		- If the above condition is means the order property is satisfying and we need to break 


```
Code for Min heap
// leftChild = heap[2 * i]
// rightChild = heap[(2 * i) + 1] 
// parent = heap[i // 2]

public class Heap {
    
    List<Integer> heap;

    public Heap() {
        heap = new ArrayList<Integer>();
        heap.add(0);
    }

    // TC = O(log(n)) = O(height of the tree)
    public void push(int val) {
        heap.add(val);
        int i = heap.size() - 1;

        // Percolate up
        while (i > 1 && heap.get(i) < heap.get(i / 2)) {
            int tmp = heap.get(i);
            heap.set(i, heap.get(i / 2));
            heap.set(i / 2, tmp);
            i = i / 2;
        }
    }

	// TC = O(log(n)) = O(height of the tree)
    public int pop() {
        if (heap.size() == 1) {
            return -1;
        }
        if (heap.size() == 2) {
            return heap.remove(heap.size() - 1); // equivalent to heap.remove(1)
        }

        int res = heap.get(1);
        // Move last value to root
        heap.set(1, heap.remove(heap.size() - 1)) ;
        int i = 1;
        // Percolate down
        while(2 * i < heap.size()) {
            if (2*i + 1 < heap.size() &&
            heap.get(2 * i + 1) < heap.get(2 * i) &&
            heap.get(i) > heap.get(2 * i + 1)) {
                // Swap right child
                int tmp = heap.get(i);
                heap.set(i, heap.get(2 * i + 1));
                heap.set(2 * i + 1, tmp);
                i = 2 * i + 1;
            } else if (heap.get(i) > heap.get(2 * i)) {
                // Swap left child
                int tmp = heap.get(i);
                heap.set(i, heap.get(2 * i));
                heap.set(2 * i, tmp);
                i = 2 * i;
            } else {
                break;
            }
        }
        return res;
    }
}

```

## Heapify Algorithm

**Advantage of heap over binary search tree, we can get min or max in O(1). In binary tree it's O(log(n))**

To  build a binary tree of n elements take `O(n * log(n))`  time
Looking up a node in a binary tree is O(log(n)) because the tree has log(n) levels (each level holds twice as much as the level above it). Therefore to create/insert n elements into a binary tree it's `O(nlog(n))` .

Given a set or a list of elements we can construct heap in `O(n)` using heapify algo

Algo 
- Structure property easily satisfied by putting the 0'th element at last
![[heapify_1.png]]
- Now to satisfy the order property we could start from the end i.e.  60 and check if its children are greater. Same we could do for 90,20,70,10 but notice these doesn't have children. We could runt the algo and still heapify but we can also skip them how. Length = 9 , 9/2 = 4, at index 4 we got 30


Disadvantage of heap is we cannot search a element in `O(log(n)` time like in BST

```
Heapify code  
// Tc =  O(n)  
public void heapify(List<Integer> list) {  
    // correct the structure  
    list.add(list.get(0));  
  
    this.heap = list;  
  
    // start from the node which has children  
    int curr = (heap.size() - 1) / 2;  
  
    while (curr > 0) {  
        int i = curr;  
        percolateDown(i);  
        curr -= 1;  
    }  
}

private void percolateDown(int i) {  
    while (2 * i < heap.size()) {  
        /*  
            now we know left child is present, check if right child is present and            right child is smaller than left child and also smaller than parent            swap right child with parent and percolate right        */        if (2 * i + 1 < heap.size() &&  
                heap.get(2 * i + 1) < heap.get(2 * i) &&  
                heap.get(i) > heap.get(2 * i + 1)) {  
            // Swap right child  
            int tmp = heap.get(i);  
            heap.set(i, heap.get(2 * i + 1));  
            heap.set(2 * i + 1, tmp);  
            i = 2 * i + 1;  
        } else if (heap.get(i) > heap.get(2 * i)) { // means left child > parent  
            // Swap left child            int tmp = heap.get(i);  
            heap.set(i, heap.get(2 * i));  
            heap.set(2 * i, tmp);  
            i = 2 * i;  
        } else { // satisfies order property  
            break;  
        }  
    }  
}  
  
```

# **Problem Pattern : Two Heap** 

Sometime we require two heap to solve heap problem, such as median problems

need to continue


# **Problem Pattern: Kth** largest

If we are told to find kth largest we can do it using both minHeap and maxHeap, but using minHeap is more efficient, as TC will be O(n.log(k)) because we will store only k large elements

### Finding kth Largest Element using minHeap

Suppose we have an array `[3, 1, 4, 2, 5]` and we want to find the 3rd largest element.

```java
// Initializing minHeap
minHeap = [3]

// Iteration 2
minHeap = [1, 3]

// Iteration 3 
minHeap = [1, 3, 4]

// Iteration 4 (discard 1 as it's smaller)
minHeap = [2, 3, 4]

// Iteration 5 (discard 2 as it's smaller)
minHeap = [3, 4, 5]

```


# **Problem Pattern: Kth** smallest

If we are told to find kth largest we can do it using both minHeap and maxHeap, but using maxHeap is more efficient, as TC will be O(n.log(k)) because we will store only k small elements

### Finding kth Smallest Element using maxHeap

Suppose we have an array `[3, 1, 4, 2, 5]` and we want to find the 3rd smallest element.

```java
// Initializing maxHeap
maxHeap = [3]

// Iteration 2
maxHeap = [1, 3]

// Iteration 3 
maxHeap = [1, 3, 4]

// Iteration 4 (discard 4 as it's smaller)
maxHeap = [1, 2, 3, 4]
maxHeap = [1, 2, 3]

// Iteration 5 (discard 2 as it's smaller)
maxHeap = [1, 2, 3, 5]
maxHeap = [1, 2, 3]

