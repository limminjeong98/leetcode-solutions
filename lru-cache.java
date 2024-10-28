import java.util.*;

// https://leetcode.com/problems/lru-cache

class LRUCache {

    int size;
	  LinkedHashMap<Integer, Integer> cache; // 순서 보장

    public LRUCache(int capacity) {
        size = capacity;
        cache = new LinkedHashMap();
    }
    
    public int get(int key) {
        if (!cache.containsKey(key)) return -1;
    	int value = cache.get(key);
    	cache.remove(key);
    	cache.put(key, value);
    	return value;
    }
    
    public void put(int key, int value) {
        if (cache.containsKey(key)) {
    		cache.remove(key);
    	}
    	cache.put(key, value);
    	if (cache.size() > size) {
    		int lru = cache.keySet().iterator().next();
    		cache.remove(lru);
    	}
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
