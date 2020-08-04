package DSA.Design;
/**
 * https://leetcode.com/problems/lru-cache/
 * Time Complexity: for put and get is O(1)
 * Space Complexity: O(capacity of LRU)
 */
class LRUCache {
    class DLinkedList{
        DLinkedList next;
        DLinkedList prev;
        int data;
        int key;
        DLinkedList(int data,int key){
            this.data=data;
            this.key=key;
        }
    }
    int size;
    int capacity;
    Map<Integer,DLinkedList> map;
    DLinkedList head;
    DLinkedList tail;
    public LRUCache(int capacity) {
        this.capacity=capacity;
        this.map=new HashMap<Integer,DLinkedList>();
    }
    
    public int get(int key) {
        if(map.containsKey(key)){
            DLinkedList node=map.get(key);
            revisit(node);
            return node.data;
        }
        return -1;
    }
    
    public void put(int key, int value) {
         if(map.containsKey(key)){
            DLinkedList node=map.get(key);
            node.data=value;
            revisit(node);
            return;
        }else if(size==capacity){
            int evictedKey=removeFromTail();
            map.remove(evictedKey);
            size--;
        }
        DLinkedList newNode=new DLinkedList(value,key);
        insertToHead(newNode);
        map.put(key,newNode);
        size++;
    }
    public void revisit(DLinkedList node){
        if(head==node)
            return;
        if(tail==node){
            tail=tail.prev;
        }else{
           node.next.prev=node.prev;
           node.prev.next=node.next;
        }
           node.next=head;
           head.prev=node;
           head=node;
           node.prev=null;
    }
    public void insertToHead(DLinkedList node){
        if(head==null){
            head=node;
            tail=node;
        }else{
            node.next=head;
            head.prev=node;
            head=node;
        }
    }
    public int removeFromTail(){
        int evictKey=tail.key;
        if(head==tail){
            head=null;
            tail=null;
        }else{
            tail=tail.prev;
            tail.next=null;
        } 
        return evictKey;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */