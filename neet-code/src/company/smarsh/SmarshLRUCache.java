package company.smarsh;

import java.util.HashMap;
import java.util.Map;

public class SmarshLRUCache {

    private Map<Integer, Node1> cache;
    private int capacity;
    private Node1 left;
    private Node1 right;

    public SmarshLRUCache(int size) {
        this.cache = new HashMap<>();
        this.capacity = size;
        this.left = new Node1(0, 0);
        this.right = new Node1(0, 0);
        left.next = right;
        right.prev = left;
    }


    public void put(Integer key, Integer value) {
        if (cache.containsKey(key)) {
            remove(cache.get(key));
        }

        cache.put(key, new Node1(key, value));
        Node1 node1 = cache.get(key);
        insert(node1);
        if (cache.size() > capacity) {
            Node1 lru = left.next;
            remove(lru);
            cache.remove(lru.key);
        }
    }

    public Integer get(Integer key) {
        if (!cache.containsKey(key)) {
            return null;
        }

        remove(cache.get(key));
        insert(cache.get(key));
        return cache.get(key).value;
    }

    private void insert(Node1 node1) {
        Node1 prev = right.prev;

        prev.next = node1;
        right.prev = node1;

        node1.prev = prev;
        node1.next = right;
    }

    private void remove(Node1 node1) {
        Node1 prev = node1.prev;
        Node1 next = node1.next;

        prev.next = next;
        next.prev = prev;

        node1.next = null;
        node1.prev = null;
    }


    static class Node1 {
        Integer key;
        Integer value;
        Node1 prev;
        Node1 next;

        public Node1(Integer key, Integer value) {
            this.key = key;
            this.value = value;
        }
    }

    public static void main(String[] args) {
        SmarshLRUCache lruCache = new SmarshLRUCache(3);
        lruCache.put(5, 5);
        lruCache.put(3, 3);
        Integer value = lruCache.get(3);
        System.out.println(value);
        lruCache.put(4, 4);
        lruCache.put(2, 2);
        value = lruCache.get(5);
        System.out.println(value);
        value = lruCache.get(3);
        System.out.println(value);
        lruCache.put(1, 1);
        value = lruCache.get(4);
        System.out.println(value);
    }

//    5 -> 3 -> 4
//    3 -> 4-> 2
    // 4 -> 3 -> 2
//    3 -> 2 -> 1

}
