public class LRUCache {
    HashMap<Integer, Node> map;
    int capacity;
    DoubleLinkedList cache;
    public LRUCache(int capacity) {
        map = new HashMap<>();
        //don't miss this
        this.capacity = capacity;
        cache = new DoubleLinkedList();
    }
    
    //get() means it is recently used
    public int get(int key) {
        if(!map.containsKey(key)){
            return -1;
        }
        int value = map.get(key).val;
        //put again
        put(key, value);
        return value;
    }
    
    public void put(int key, int val){
        Node newNode = new Node(key, val);
        
        if(map.containsKey(key)){
            cache.delete(map.get(key));
            cache.addFirst(newNode);
            map.put(key, newNode);
        }else{
            if(map.size() == capacity){
                int k = cache.deleteLast();
                map.remove(k);
            }
            cache.addFirst(newNode);
            map.put(key, newNode);
            
        }
    }
}

class DoubleLinkedList{
    Node head;
    Node tail;
    public DoubleLinkedList(){
        head = new Node(0, 0);
        tail = new Node(0, 0);
        head.next = tail;
        tail.prev = head;
    }

    public void addFirst(Node node){
        node.next = head.next;
        node.prev = head;
        head.next.prev = node;
        head.next = node;
    }

    public int delete(Node n){
        int key = n.key;
        n.next.prev = n.prev;
        n.prev.next = n.next;
        
        return key;
    }

    public int deleteLast(){
        if(head.next == tail)   return -1;

        return delete(tail.prev);
    }
}

class Node{
    public int key;
    public int val;
    public Node prev;
    public Node next;
    public Node(int key, int val){
        this.key = key;
        this.val = val;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
