package linkedList;

import java.util.HashMap;
import java.util.Map;

class Node {
    int key;
    int value;

    Node prev;
    Node next;

    Node(int key, int value) {
        this.key = key;
        this.value = value;
    }
}


public class LRUCache {

    private Map<Integer, Node> cache;
    private final Integer CAPACITY;

    private Node left;
    private Node right;

    public LRUCache(int capacity) {
        CAPACITY = capacity;
        cache = new HashMap<>();

        left = new Node(0, 0); // next of left is LRU
        right = new Node(0, 0); // prev of right is most recently used

        left.next = right;
        right.prev = left;
    }

    // remove the next of left as it is least recent used
    private void remove(Node node) {
        // L -> 2 -> R  remove 2
        Node prev = node.prev;
        Node next = node.next;

        prev.next = next;
        next.prev = prev;
    }

    // insert before right -> so it becomes the most recent
    private void insert(Node node) {
        // L -> R insert the node at right
        Node prev = right.prev;

        prev.next = node;
        right.prev = node;

        node.prev = prev;
        node.next = right;
    }

    public int get(int key) {
        // check if key is there in the cache
        if (cache.containsKey(key)) {
            // move this to the most recent
            remove(cache.get(key));
            insert(cache.get(key));
            return cache.get(key).value;
        }
        return -1;
    }


    public void put(int key, int value) {
        // check if the key is there in the cache
        if (cache.containsKey(key)) {
            // remove it, because the value might me a new one so we need to update it
            remove(cache.get(key));
        }
        cache.put(key, new Node(key, value));
        insert(cache.get(key)); // insert it prev to right so it becomes the most recent

        // check if the cache size exceeds the capacity, is yes evict the least recent node
        if (cache.size() > CAPACITY) {
            Node lru = left.next;
            remove(lru);
            cache.remove(lru.key);
        }
    }

    public static void main(String[] args) {
        LRUCache cache1 = new LRUCache(2);
        cache1.put(1, 1);
        cache1.put(2, 2);
        System.out.println(cache1.get(1));
        cache1.put(3, 3);
        System.out.println(cache1.get(2));
        cache1.put(4, 4);
        System.out.println(cache1.get(1));
        System.out.println(cache1.get(3));
        System.out.println(cache1.get(4));
//        System.out.println( cache1.get(3));

        System.out.println(cache1.cache);
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */