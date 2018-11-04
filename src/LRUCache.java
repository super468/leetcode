import java.util.HashMap;
import java.util.Map;

/**
 * Creator : wangtaishan
 * Date : 2018/9/2
 * Title :
 * Description :
 *
 * Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following operations: get and put.
 *
 * get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
 * put(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity, it should invalidate the least recently used item before inserting a new item.
 *
 * Follow up:
 * Could you do both operations in O(1) time complexity?
 *
 * Example:
 *
 * LRUCache cache = new LRUCache( 2  );
*
*cache.put(1,1);
*cache.put(2,2);
*cache.get(1);       // returns 1
*cache.put(3,3);    // evicts key 2
*cache.get(2);       // returns -1 (not found)
*cache.put(4,4);    // evicts key 1
*cache.get(1);       // returns -1 (not found)
*cache.get(3);       // returns 3
*cache.get(4);       // returns 4
 *
 * Analysis :
 *      HashMap + DoubleLinkedlist
 */

public class LRUCache {
    DListNode head;
    DListNode tail;
    Map<Integer, DListNode> map; //instead store integer value, storing Node to can do O(1) time complexity in linkedlist
    int capacity;
    public LRUCache(int capacity) {

        this.map = new HashMap<Integer, DListNode>();
        this.capacity = capacity;

        this.head = new DListNode();
        this.tail = new DListNode();

        this.head.next = this.tail;
        this.tail.pre = this.head;

    }


    // the key step is
    public int get(int key) {
        if(!map.containsKey(key)) return -1;
        DListNode tmp = map.get(key);
        move(tmp);
        return tmp.val;
    }

    public void put(int key, int value) {
        if(map.containsKey(key)){
            DListNode tmp = map.get(key);
            tmp.val = value;
            move(tmp);
        }
        else{
            if(map.size() >= this.capacity){
                DListNode h = this.head.next;
                int headkey = h.key;
                remove();
                map.remove(headkey);
            }
            DListNode node = new DListNode(key, value);
            map.put(key, node);
            add(node);
        }


    }

    public void add(DListNode node){
        node.next = this.tail;
        node.pre = this.tail.pre;

        this.tail.pre.next = node;
        this.tail.pre = node;
    }

    public void remove(){
        if(this.head.next != null && this.head.next.next != null) {
            this.head.next = this.head.next.next;
        }
    }

    public void move(DListNode node){
        if(node != this.tail.pre){
            DListNode pre = node.pre;
            DListNode next = node.next;

            node.next = this.tail;
            node.pre = this.tail.pre;
            this.tail.pre.next = node;
            this.tail.pre = node;

            if(pre != null) pre.next = next;
            if(next != null) next.pre = pre;
        }
    }

     public static void main(String[] args){
         LRUCache obj = new LRUCache(3);
         obj.put(1,1);
         obj.put(2,2);
         obj.put(3,3);
         obj.put(4,4);
         obj.get(4);
         obj.get(3);
         obj.get(2);
         obj.get(1);
         obj.put(5,5);
         obj.get(1);
         obj.get(2);
         obj.get(3);
         obj.get(4);
         obj.get(5);
     }
}

class DListNode{
    int key;
    int val;
    DListNode pre;
    DListNode next;

    public DListNode(){

    }

    public DListNode(int key, int val){
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