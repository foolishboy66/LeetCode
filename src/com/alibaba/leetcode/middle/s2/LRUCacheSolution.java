package com.alibaba.leetcode.middle.s2;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * 146. LRU Cache
 * 
 * 146. LRU缓存机制
 * 
 * Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following
 * operations: get and put.
 * 
 * get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
 * put(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity, it
 * should invalidate the least recently used item before inserting a new item.
 * 
 * The cache is initialized with a positive capacity.
 * 
 * Follow up:
 * 
 * Could you do both operations in O(1) time complexity?
 * 
 * Example:
 * 
 * LRUCache cache = new LRUCache(2);
 * 
 * cache.put(1, 1); cache.put(2, 2); cache.get(1); // returns 1 cache.put(3, 3); // evicts key 2 cache.get(2); //
 * returns -1 (not found) cache.put(4, 4); // evicts key 1 cache.get(1); // returns -1 (not found) cache.get(3); //
 * returns 3 cache.get(4); // returns 4
 * 
 * 
 * @author wang
 * @date 2019/08/05
 */
public class LRUCacheSolution {

    /**
     * 解法二：使用linkedHashMap
     * 
     * @author wang
     * @date 2019/08/05
     */
    class LRUCache {

        private Map<Integer, Integer> map;

        public LRUCache(int capacity) {
            map = new LinkedHashMap<Integer, Integer>(16, 0.75f, true) {

                private static final long serialVersionUID = 5424366694552924091L;

                @Override
                protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
                    return size() > capacity;
                }
            };
        }

        public int get(int key) {

            return map.getOrDefault(key, -1);
        }

        public void put(int key, int value) {

            map.put(key, value);
        }
    }

    /**
     * 解法一：使用hashMap+linkedList
     * 
     * @author wang
     * @date 2019/08/05
     */
    class LRUCache2 {

        private LinkedList<Integer> keys;
        private Map<Integer, Integer> map;
        private int capacity;

        public LRUCache2(int capacity) {
            this.keys = new LinkedList<>();
            this.map = new HashMap<>(capacity);
            this.capacity = capacity;
        }

        public int get(int key) {

            if (map.containsKey(key)) {
                keys.remove((Integer)key);
                keys.add(key);
                return map.get(key);
            }

            return -1;
        }

        public void put(int key, int value) {

            if (map.containsKey(key)) {
                keys.remove((Integer)key);
                keys.add(key);
                map.put(key, value);
                return;
            }

            if (capacity == keys.size()) {
                Integer first = keys.removeFirst();
                map.remove(first);
            }
            map.put(key, value);
            keys.add(key);
        }
    }
}
