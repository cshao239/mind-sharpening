package leetcode.design;

import java.util.HashMap;
import java.util.LinkedList;

public class LeaseRecentlyUsedCache<K, V> {

    private int capacity;
    private int numOfElements;
    private HashMap<K,V> map;
    //first is the mostly used
    //tail is the least used
    private LinkedList<V> linkedList;

    public LeaseRecentlyUsedCache(int capacity){
        map = new HashMap<>();
        linkedList=new LinkedList<>();
        this.capacity = capacity;
        numOfElements=0;
    }

    public void put(K key, V value){
        if(numOfElements==capacity) {
            deleteLRU();
        }
        map.put(key, value);
        linkedList.addFirst(value);
        numOfElements++;
    }

    public V get(K key) {
        if (map.containsKey(key)){
            V value = map.get(key);
            linkedList.remove();
            linkedList.addFirst(value);
            return value;
        }
        return null;
    }

    private void deleteLRU(){
        linkedList.removeLast();
    }



}
