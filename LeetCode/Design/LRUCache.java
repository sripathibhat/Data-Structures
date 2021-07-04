class LRUCache {

    int cacheCapacity;
    HashMap<Integer, Node> map;
    Node head = new Node();
    Node tail = new Node();
    public LRUCache(int capacity) {
        map = new HashMap(capacity);
        cacheCapacity = capacity;
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        int res = -1;
        Node node = map.get(key);
        if(node != null) {
            res = node.val;
            removeNode(node);
            addNode(node);
        }
        return res;
    }
    
    public void put(int key, int value) {
        Node node = map.get(key);
        if(node != null) {
            // key exists, update its value
            removeNode(node);
            node.val = value;
            addNode(node);
        }
        else {
            // key does not exist, check for cache capacity and add it
            // System.out.println(map.size() + " " + cacheCapacity);
            if(map.size() == cacheCapacity) {
                map.remove(tail.prev.key);
                removeNode(tail.prev);
            }
            node = new Node();
            node.key = key;
            node.val = value;
            map.put(key, node);
            addNode(node);
        }
    }
    
    private void addNode(Node node) {
        Node next = head.next;
        node.next = next;
        node.prev = head;
        head.next = node;
        next.prev = node;
    }
    
    private void removeNode(Node node) {
        Node next = node.next;
        Node prev = node.prev;
        next.prev = prev;
        prev.next = next;
    }
}

class Node {
    int key;
    int val;
    Node prev;
    Node next;
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */