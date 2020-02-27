package com.lr.map;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;

/**
 * @author liurui
 * @date 2020/2/27 9:33
 */
public class LRUCache extends LinkedHashMap<Integer, Integer> {
    private int k;

    public LRUCache(int maxSize) {
        super(maxSize, 0.75f, true);
        this.k = maxSize;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
        return size()>k;
    }

    public void set(Integer k, Integer v) {
        put(k, v);
    }


}

class LRUCache1 {
    Map<Integer, Integer> valMap;
    LinkedHashSet<Integer> list;
    int cap;
    int size;

    public LRUCache1(int cap) {
        valMap = new HashMap<>();
        list = new LinkedHashSet<>();
        this.cap = cap;
    }

    public void set(int key, int val) {
        if (!valMap.containsKey(key)) {
            if (size == cap) {
                int head = list.iterator().next();
                list.remove(head);
                valMap.remove(head);
                size--;
            }
        }
        valMap.put(key, val);
        list.add(key);
        size++;
    }

    public int get(int key) {
        if (!valMap.containsKey(key)) {
            return -1;
        }
        int val = valMap.get(key);
        list.remove(key);
        list.add(key);
        return val;
    }
}

class Main{
    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(3);
        lruCache.set(1, 1);
        lruCache.set(2, 2);
        lruCache.set(3, 3);
        lruCache.set(4, 4);
        lruCache.set(5, 5);

        System.out.println(lruCache.size());
        System.out.println(lruCache.get(4));
        lruCache.forEach((k,v)->{
            System.out.println("k:" + k + ",v:" + v);
        });




    }

}
