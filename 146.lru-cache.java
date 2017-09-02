public class LRUCache {
    class DLinkedNode {
        int key;
        int value;
        DLinkedNode pre;
        DLinkedNode post;
    }

    /**
     * Always add the new node right after head;
     */
    private void addNode(DLinkedNode node){
        node.pre = this.head;
        node.post = this.head.post;

        this.head.post.pre = node;
        this.head.post = node;
    }

    /**
     * Remove an existing node from the linked list.
     */
    private void removeNode(DLinkedNode node){
        node.pre.post = node.post;
        node.post.pre = node.pre;
    }

    /**
     * Move certain node in between to the head.
     */
    private void moveToHead(DLinkedNode node){
        this.removeNode(node);
        this.addNode(node);
    }

    // pop the current tail.
    private DLinkedNode popTail(){
        DLinkedNode result = tail.pre;
        this.removeNode(result);
        return result;
    }

    private HashMap<Integer,DLinkedNode> cache = new HashMap<>();
    private int count;
    private int capacity;
    private DLinkedNode head,tail;

    public LRUCache(int capacity) {
        this.count=0;
        this.capacity=capacity;

        this.head = new DLinkedNode();
        this.head.pre = null;

        this.tail = new DLinkedNode();
        this.tail.post = null;

        this.head.post = tail;
        this.tail.pre = head;
    }
    
    public int get(int key) {
        if (cache.containsKey(key)){
            this.moveToHead(this.cache.get(key));
            return this.cache.get(key).value;
        }else {
            return -1;
        }
    }
    
    public void put(int key, int value) {
        if (this.cache.containsKey(key)){
            DLinkedNode removeone = this.cache.get(key);
            this.removeNode(removeone);
            DLinkedNode node = new DLinkedNode();
            node.value = value;
            node.key = key;
            this.cache.put(key,node);
            this.addNode(node);
        }else {
            if (this.count==this.capacity){
                DLinkedNode removeone = this.popTail();
                this.cache.remove(removeone.key);
            }else {
                this.count++;
            }
            DLinkedNode node = new DLinkedNode();
            node.value = value;
            node.key = key;
            this.cache.put(key,node);
            this.addNode(node);
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */