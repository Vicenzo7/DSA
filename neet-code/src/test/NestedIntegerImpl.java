package test;

import java.util.List;
import java.util.ArrayList;

public class NestedIntegerImpl implements NestedInteger {

    private Integer value;
    private List<NestedInteger> list;

    public NestedIntegerImpl() {
    }

    public NestedIntegerImpl(Integer value) {
        this.value = value;
    }

    public NestedIntegerImpl(List<NestedInteger> list) {
        this.list = list;
    }

    @Override
    public boolean isInteger() {
        return value != null;
    }

    @Override
    public Integer getInteger() {
        return value;
    }

    @Override
    public void setInteger(int value) {
        this.value = value;
    }

    @Override
    public void add(NestedInteger ni) {
        if (list == null) {
            list = new ArrayList<>();
        }

        list.add(ni);
    }

    @Override
    public List<NestedInteger> getList() {
        return list;
    }

    @Override
    public String toString() {
        return "NestedIntegerImpl{" +
                "value=" + value +
                ", list=" + list +
                '}';
    }
}