package binarysearch;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TimeMap {

    public static void main(String[] args) {


        TimeMap obj = new TimeMap();
        obj.set("love", "high", 10);
        obj.set("love", "low", 20);
        System.out.println(obj.get("love", 5));
        System.out.println(obj.get("love", 10));
        System.out.println(obj.get("love", 15));
        System.out.println(obj.get("love", 20));
        System.out.println(obj.get("love", 25));
    }

    private final Map<String, List<Pair>> timeMap;

    public TimeMap() {
        timeMap = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        if (!timeMap.containsKey(key)) {
            timeMap.put(key, new ArrayList<>());
        }
        timeMap.get(key).add(new Pair(value, timestamp));
    }

    public String get(String key, int timestamp) {
        if (!timeMap.containsKey(key)) {
            return "x";
        }
        return search(key, timestamp);
    }

    private String search(String key, int timestamp) {
        List<Pair> pairs = timeMap.get(key);
        int start = 0, end = pairs.size() - 1;
        String value = "x";
        while (start <= end) {
            int mid = start + (end - start - 1) / 2;
            Pair pair = pairs.get(mid);
            if (pair.getValue() <= timestamp) {
                start = mid + 1;
                value = pair.getKey();
            } else {
                end = mid - 1;
            }
        }

        return value;


    }

    static class Pair {
        private String key;
        private int value;

        public Pair(String key, int value) {
            this.key = key;
            this.value = value;
        }

        public int getValue() {
            return value;
        }

        public String getKey() {
            return key;
        }
    }
}
