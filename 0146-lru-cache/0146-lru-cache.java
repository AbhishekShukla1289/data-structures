class LRUCache {

    class Node{
        Node prev;
        Node next;
        int val;
        int key;
        public Node(int key, int val){
            this.key = key;
            this.val = val;
        }       
    }
    
    private void addToHead(Node node){
        node.next = head.next;
        node.prev = head;
        head.next.prev = node;        
        head.next = node;
    }
    
    private void removeNode(Node node){
        node.next.prev = node.prev;
        node.prev.next = node.next;
    }
    
    Node head;
    Node tail;
    int capacity;
    HashMap<Integer, Node> map;
    
    
    public LRUCache(int capacity) {    
        map = new HashMap<>();
        this.capacity = capacity;
        head = new Node(-1,-1);
        tail = new Node(-1,-1);
        head.next = tail;
        tail.prev = head;        
    }
    
    public int get(int key) {
        if(!map.containsKey(key)) return -1;
        Node node = map.get(key);
        removeNode(node);
        addToHead(node);
        return node.val;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)){
            Node node = map.get(key);
            node.val = value;
            removeNode(node);
            addToHead(node);
        }
        else{
            Node node = new Node(key, value);
            if(map.size() == capacity){
                Node prevNode = tail.prev;
                removeNode(prevNode);
                map.remove(prevNode.key);
            }
            addToHead(node);
            map.put(key,node);
        }
        return;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */