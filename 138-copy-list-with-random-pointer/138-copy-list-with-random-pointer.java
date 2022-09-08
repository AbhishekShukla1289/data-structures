/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        Map <Node , Node> map = new HashMap<>();
        Node oh = head;
        Node vh = new Node(-1);
        Node result = vh;
        
        while(oh!=null){
            Node nextNode = new Node(oh.val);
            vh.next = nextNode;
            vh = nextNode;
            map.put(oh , vh);
            oh = oh.next;
        }
        vh = result.next;
        oh = head;
        while(vh != null){
             if(oh.random!=null){
                  vh.random = map.get(oh.random);
             }
            vh = vh.next;
            oh = oh.next;
        }
        
        
        return result.next;
    }
}