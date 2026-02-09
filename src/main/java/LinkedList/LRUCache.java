package LinkedList;

import java.util.HashMap;
import java.util.Map;

/**
 * LRU CACHE — Mind Map
 *
 * Pattern:
 * - Design problem using HashMap + Doubly Linked List
 * - Goal: support get() and put() in O(1) time.
 *
 * Core Idea:
 * - HashMap<Key, Node> → O(1) lookup of cache entries.
 * - Doubly Linked List → maintains usage order:
 *      Head → Most Recently Used (MRU)
 *      Tail → Least Recently Used (LRU)
 *
 * Why Doubly Linked List?
 * - Allows O(1) removal and insertion of nodes.
 * - Needed to quickly move accessed node to MRU position.
 *
 * Operations:
 *
 * get(key):
 * - If key not in map → return -1.
 * - If present:
 *      1. Move node to front (MRU).
 *      2. Return node.value.
 *
 * put(key, value):
 * - If key already exists:
 *      1. Update value.
 *      2. Move node to front (MRU).
 *
 * - If key does NOT exist:
 *      1. If capacity full:
 *             - Remove node before tail (LRU).
 *             - Delete it from map.
 *      2. Insert new node at front.
 *      3. Add to map.
 *
 * Helper DLL Operations:
 * - remove(node) → detach node in O(1).
 * - insertToFront(node) → place right after head (MRU).
 *
 * Edge Cases:
 * - Capacity = 1 → every new put evicts previous key.
 * - Repeated put on same key → update only, no eviction.
 * - get on missing key → return -1.
 *
 * Complexity:
 * - Time:
 *      get  → O(1)
 *      put  → O(1)
 * - Space:
 *      O(capacity) for map + DLL nodes.
 *
 * Interview One-liner:
 * "Use a HashMap for constant lookup and a doubly linked list to track
 * recency, evicting the tail when capacity is exceeded—achieving O(1)
 * get and put operations."
 */

class LRUCache {

    // Doubly Linked List Node
    private static class Node {
        int key, value;
        Node prev, next;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private final int capacity;
    private final Map<Integer, Node> map;

    // Dummy head and tail for easy operations
    private final Node head;
    private final Node tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();

        head = new Node(0, 0); // most recent side
        tail = new Node(0, 0); // least recent side

        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }

        Node node = map.get(key);

        // Move accessed node to front (most recent)
        remove(node);
        insertToFront(node);

        return node.value;
    }

    public void put(int key, int value) {

        if (map.containsKey(key)) {
            // Update value and move to front
            Node node = map.get(key);
            node.value = value;

            remove(node);
            insertToFront(node);
            return;
        }

        // If capacity full → remove LRU (node before tail)
        if (map.size() == capacity) {
            Node lru = tail.prev;
            remove(lru);
            map.remove(lru.key);
        }

        // Insert new node at front
        Node newNode = new Node(key, value);
        map.put(key, newNode);
        insertToFront(newNode);
    }

    /** Remove node from DLL */
    private void remove(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    /** Insert node right after head (most recent position) */
    private void insertToFront(Node node) {
        node.next = head.next;
        node.prev = head;

        head.next.prev = node;
        head.next = node;
    }
}

