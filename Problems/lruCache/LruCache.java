package Problems.lruCache;

import java.util.*;

public class LruCache <K, V> {
    private int capacity;
    private Map<K, Node<K, V>> cache;
    private Node<K, V> head;
    private Node <K, V> tail;

    LruCache(int cap){
        this.capacity = cap;

        this.cache = new HashMap<>(capacity);

        this.head = new Node(null, null);
        this.tail = new Node(null, null);
        this.head.next = this.tail;
        this.tail.prev = this.head;
    }

    public synchronized V get(K key){
        
        Node<K, V> node = cache.get(key);
        if(node == null){
//            System.out.println("Key not found");
            return null;
        }

        moveToHead(node);

        return node.value;
    }


    public synchronized void put(K key, V value){
        Node node = cache.get(key);
        if(node != null){
            node.value = value;
            moveToHead(node);
        }else{

            Node newNode = new Node(key, value);
            addToHead(newNode);
            cache.put(key, newNode);

            if(cache.size() > capacity){
                Node<K, V> removedNode = removeTail();
                cache.remove(removedNode.key);
            }

        }
        
    }

    private void addToHead(Node<K, V> node){
        node.prev = head;
        node.next = head.next;
        node.next.prev = node;
        head.next = node;
    }


    private void removeNode(Node<K, V> node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }


    private void moveToHead(Node<K,V> node){
        removeNode(node);
        addToHead(node);
    }

    private Node<K, V> removeTail(){
        Node pre = tail.prev;
        removeNode(pre);
        return pre;
    }

}
