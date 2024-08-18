package linkedList;


import java.util.HashMap;

public class LRU {
    class Node{
        int key , val ;
        Node prev , next;
        Node(int key , int val){
            this.key = key;
            this.val = val;
        }
    }

    private int capacity;
    private HashMap<Integer, Node> cache;
    private Node head;
    private Node tail;

    public LRU(int capacity) {
        this.capacity = capacity;
        this.cache = new HashMap<>(capacity);

        // Initialize the head and tail nodes
        this.head = new Node(-1, -1);
        this.tail = new Node(-1, -1);

        // Link head and tail
        head.next = tail;
        tail.prev = head;
    }
    public int get(int key){
        if(!cache.containsKey(key)){
            return -1;
        }
        Node node = cache.get(key);
        removeNode(node);
        addToHead(node);
        return node.val;
    }
    public void put(int key , int val){
        if(cache.containsKey(key)){
            // If the key exists, update the value and move it to the head
            Node node = cache.get(key);
            node.val = val;
            removeNode(node);
            addToHead(node);
        }
        else{
            if(cache.size() >= capacity){
                Node lruNode = tail.prev;
                cache.remove(lruNode.key);
                removeNode(lruNode);
            }
            Node newNode = new Node(key , val);
            cache.put(key , newNode);
            addToHead(newNode);
        }
    }
    public void addToHead(Node node){
        Node nextNode = head.next;

        head.next = node;
        node.prev = head;

        node.next = nextNode;
        nextNode.prev = node;
    }

    public void removeNode(Node node){
        Node nextNode = node.next;
        Node prevNode = node.prev;

        prevNode.next = nextNode;
        nextNode.prev = prevNode;
    }

    public static void main(String[] args) {
        LRU lRUCache = new LRU(2);
        lRUCache.put(1, 1); // cache is {1=1}
        lRUCache.put(2, 2); // cache is {1=1, 2=2}
        System.out.println(lRUCache.get(1));    // return 1
        lRUCache.put(3, 3); // LRU key was 2, evicts key 2, cache is {1=1, 3=3}
        System.out.println(lRUCache.get(2));   // returns -1 (not found)
        lRUCache.put(4, 4); // LRU key was 1, evicts key 1, cache is {4=4, 3=3}
        lRUCache.get(1);    // return -1 (not found)
        lRUCache.get(3);    // return 3
        lRUCache.get(4);    // return 4
    }
}
