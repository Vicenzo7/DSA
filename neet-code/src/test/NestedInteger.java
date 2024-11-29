package test;

import java.util.List;

public interface NestedInteger {


    boolean isInteger(); // Returns true if it holds a single integer.
    Integer getInteger(); // Returns the single integer it holds, or null.
    void setInteger(int value); // Sets this NestedInteger to hold a single integer.
    void add(NestedInteger ni); // Adds a NestedInteger to the list.
    List<NestedInteger> getList(); // Returns the nested list or null.
}
