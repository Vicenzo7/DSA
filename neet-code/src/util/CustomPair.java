package util;

public class CustomPair<T, U> {
    private T key;
    private U value;

    public CustomPair() {
    }

    public CustomPair(T key, U value) {
        this.key = key;
        this.value = value;
    }

    public T getKey() {
        return key;
    }

    public void setKey(T key) {
        this.key = key;
    }

    public U getValue() {
        return value;
    }

    public void setValue(U value) {
        this.value = value;
    }
}
