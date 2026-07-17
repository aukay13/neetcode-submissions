class LRUCache {

    DoubleLL head;
    DoubleLL tail;
    HashMap<Integer,DoubleLL> hMap;
    int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.head = new DoubleLL(-1,-1);
        this.tail = new DoubleLL(-1,-1);
        head.next = tail;
        tail.prev = head;
        hMap = new HashMap<>();
    }
    
    public int get(int key) {
        if(!hMap.containsKey(key)){
            return -1;
        }
        DoubleLL node = hMap.get(key);
        deleteNode(node);
        hMap.put(key,insertAtEnd(key, node.val));
        return node.val;
    }
    
    public void put(int key, int value) {
        if(hMap.containsKey(key)){
            deleteNode(hMap.get(key));
            DoubleLL newNode = insertAtEnd(key, value);
            hMap.put(key, newNode);
        }
        else{
            if(hMap.size() == this.capacity){
                hMap.remove(head.next.key);
                deleteNode(head.next);
                DoubleLL newNode = insertAtEnd(key, value);
                hMap.put(key, newNode);
            }
            else{
                insertAtEnd(key,value);
            }
        }

    }

    private DoubleLL insertAtEnd(int key, int value){
        DoubleLL newNode = new DoubleLL(key, value);
        tail.prev.next = newNode;
        newNode.prev = tail.prev;
        newNode.next = tail;
        tail.prev = newNode;
        hMap.put(key, newNode);
        return newNode;
    }

    private void deleteNode(DoubleLL node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
}

public class DoubleLL {
    int key;
    int val;
    DoubleLL next;
    DoubleLL prev;
    DoubleLL(){
    }

    DoubleLL(int key,int val){
        this.key = key;
        this.val = val;
    }
}

