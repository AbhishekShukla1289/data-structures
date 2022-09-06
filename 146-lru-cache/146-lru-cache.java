class LRUCache {
    Node head;
    Node tail;
    int capacity;
    
    class Node {
        Node next;
        Node prev;
        int key;
        int value;
        
        Node(int k, int v){ key = k; value = v; }
    }
    
    HashMap<Integer, Node> lhm = new HashMap<>();
    
    
    public LRUCache(int capacity) {
        head = new Node(-1,-1);
        tail = new Node(-1,-1);
        head.next = tail;
        tail.prev = head;
        this.capacity = capacity;
    }
    
    public int get(int key) {
        if(!lhm.containsKey(key))
            return -1;
        
        Node ref = lhm.get(key);
        int val = ref.value;
        
        ref.prev.next = ref.next;
        ref.next.prev = ref.prev;     
        ref.next = head.next;
        ref.prev = head;
        head.next = ref;
        ref.next.prev = ref;
        
        return val;
    }
    
    public void put(int key, int value) {
        if(lhm.containsKey(key)){
            Node ref = lhm.get(key);
            ref.value = value;
            lhm.put(key, ref);
            
            ref.prev.next = ref.next;
            ref.next.prev = ref.prev;     
            ref.next = head.next;
            ref.prev = head;
            head.next = ref;
            ref.next.prev = ref;
            
        }
        else{
            Node nn = new Node(key,value);
            
            if(lhm.size() == capacity){
                Node temp = tail.prev;
                tail.prev = temp.prev;
                temp.prev.next = temp.next;
                
                lhm.remove(temp.key);
            }
            
            nn.next = head.next;
            nn.prev = head;
            head.next = nn;
            nn.next.prev = nn;
            
            lhm.put(nn.key, nn);
            
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */