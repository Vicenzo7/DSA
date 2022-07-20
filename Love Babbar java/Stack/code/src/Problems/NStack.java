package Problems;

import java.util.Arrays;

public class NStack {
    
    int[] arr;
    int[] top;
    int[] next;
    
    int n,s;
    int freespot;
    
    // Initialize your data structure.
    public NStack(int N, int S) {
        n=N;
        s=S;
        arr = new int[s];
        top = new int[n];
        next = new int[s];
        
        //top initialize
        Arrays.fill(top,-1);
        
        //next initialise
        for(int i=0;i<s;i++){
            next[i] = i+1;
        }
        //update last index value to -1;
        next[s-1] =-1;
       
        // intiliase freespot
        freespot=0;
        
    }

    // Pushes 'X' into the Mth stack. Returns true if it gets pushed into the stack, and false otherwise.
    public boolean push(int x, int m) {
        //check for overflow
        if(freespot == -1)
            return false;
        
        //find index
        int index = freespot;
        
        //update freespot
        freespot = next[index];
        
        //insert element into array
        arr[index] = x;
      
        //update next  //m-1 because 0 based indexing 
        next[index] = top[m-1];
        
        //update top 
        top[m-1] = index;
        
        return true;
    }

    // Pops top element from Mth Stack. Returns -1 if the stack is empty, otherwise returns the popped element.
    public int pop(int m) {
        // check for underflow 
        if(top[m-1] ==-1)
            return -1;
        //pop is mirror reverse of push
        int index = top[m-1];
        
        top[m-1] = next[index];
        
        next[index] = freespot;
        
        freespot = index;
        
        return arr[index];
    }

    public static void main(String[] args) {
        int N =3,S=6;
        NStack obj = new NStack(N,S);

        obj.push(10,1);
        obj.push(20,1);
        obj.push(30,2);
        System.out.println(obj.pop(1));
        System.out.println(obj.pop(2));


    }
}