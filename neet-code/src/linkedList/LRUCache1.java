package linkedList;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCache1 {


    /*
        Several points to mention:

        In the constructor, the third boolean parameter specifies the ordering mode.
        If we set it to true, it will be in access order.
        (https://docs.oracle.com/javase/8/docs/api/java/util/LinkedHashMap.html#LinkedHashMap-int-float-boolean-)

        By overriding removeEldestEntry in this way, we do not need to take care of it ourselves.
        It will automatically remove the least recent one when the size of map exceeds the specified capacity.
        (https://docs.oracle.com/javase/8/docs/api/java/util/LinkedHashMap.html#removeEldestEntry-java.util.Map.Entry-)

    */

    private Map<Integer, Integer> cache;

    private final Integer CAPACITY;


    public LRUCache1(int capacity) {
        this.CAPACITY = capacity;
        cache = new LinkedHashMap<>(CAPACITY, 0.75f, true) {
            @Override
            protected boolean removeEldestEntry(Map.Entry eldest) {
                return size() > CAPACITY;
            }
        };
    }

    public int get(int key) {
        return cache.getOrDefault(key, -1);
    }

    public void put(int key, int value) {
        cache.put(key, value);
    }


    public static void main(String[] args) {
        LRUCache1 cache1 = new LRUCache1(2);
        cache1.put(1,1);
        cache1.put(2,2);
        System.out.println(cache1.get(1));
        cache1.put(3,3);
        System.out.println( cache1.get(2));
        cache1.put(4,4);
        System.out.println( cache1.get(1));
        System.out.println( cache1.get(3));
        System.out.println( cache1.get(4));
//        System.out.println( cache1.get(3));

        System.out.println(cache1.cache);

    }
}
