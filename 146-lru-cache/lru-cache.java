import java.util.HashMap;

public class LRUCache {
    private class Node {
        int key, val;
        Node prev, next;
        Node(int k, int v) { key = k; val = v; }
    }

    private int capacity;
    private HashMap<Integer, Node> map;
    private Node head, tail; // dummy head & tail

    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        head = new Node(0, 0); // dummy
        tail = new Node(0, 0); // dummy
        head.next = tail;
        tail.prev = head;
    }

    // Add node right after head (mark as most recently used)
    private void addToHead(Node node) {
        node.prev = head;
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
    }

    // Remove node from wherever it is
    private void removeNode(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    // Move an existing node to head (used on get & update)
    private void moveToHead(Node node) {
        removeNode(node);
        addToHead(node);
    }

    // Pop the least recently used node (node before dummy tail)
    private Node popTail() {
        Node res = tail.prev;
        removeNode(res);
        return res;
    }

    public int get(int key) {
        Node node = map.get(key);
        if (node == null) return -1;
        moveToHead(node); // accessed → becomes MRU
        return node.val;
    }

    public void put(int key, int value) {
        Node node = map.get(key);
        if (node != null) {
            // update value and mark as recently used
            node.val = value;
            moveToHead(node);
        } else {
            Node newNode = new Node(key, value);
            map.put(key, newNode);
            addToHead(newNode);

            if (map.size() > capacity) {
                Node tailNode = popTail();
                map.remove(tailNode.key);
            }
        }
    }
}
