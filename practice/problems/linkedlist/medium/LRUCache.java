package problems.linkedlist.medium;
import java.util.LinkedHashMap;
import java.util.Map;
/*
 * > PROBLEM 146 (medium): LRU Cache
 *   Design a data structure that follows the constraints 
 *   of a Least Recently Used (LRU) cache.
 *   
 *   Implement the LRUCache class:
 *      - LRUCache(int capacity): Initialize the LRU cache with positive size capacity.
 *      - int get(int key): Return the value of the key if the key exists, 
 *        otherwise return -1.
 *      - void put(int key, int value): Update the value of the key if the key exists. 
 *        Otherwise, add the key-value pair to the cache. 
 *        If the number of keys exceeds the capacity from this operation, 
 *        evict the least recently used key.
 * 
 *   The functions get and put must each run in O(1) average time complexity.
 * 
 * > SOLUTION: 
 *   We can use the data structure LinkedHashMap: "This implementation differs from
 *   HashMap in that it maintains a doubly-linked list running through all of 
 *   its entries. This linked list defines the iteration ordering, which is normally
 *   the order in which keys were insererted into the map (insertion order). 
 *   Note that insertion order is not affected if a key is re-inserted into the map. 
 *   
 *   This implementation spares its clients from the unspecified, generally chaotic
 *   ordering provided by HashMap (and HashTable), without incurring the increased
 *   cost associated with TreeMap [...]
 * 
 *   A special constructor is provided to create a linked hash map whose order of 
 *   iteration is the order in which its entries were last accessed, from 
 *   least-recently accessed to most-recently accessed (access-order). 
 *   This kind of map is well-suited to building LRU caches. Invoking the put, 
 *   putIfAbsent, get, getOrDefault, ..., results in an access to the corresponding
 *   entry (assuming it exists after the invocation completes). The replace methods 
 *   only result in an access of the entry if the value is replaced. The putAll method
 *   generates one entry access for each mapping in the specified map, in the order
 *   that key-value mappings are provided by the specified map's entry iterator.
 *   No other methods generate entry access, in particular operations on 
 *   collection-views do not affect the order of iteration of the backing map."
 *      
 */
public class LRUCache {
    private LinkedHashMap<Integer, Integer> map; 
    private final int CAPACITY; 

    public LRUCache(int capacity){
        this.CAPACITY = capacity;
        this.map = new LinkedHashMap<>(capacity, 0.75f, true){
            // "returns true if this map should remove its eldest entry. This method
            // is invoked by put and putAll after inserting a new entry in the map. 
            // It provides the implementator with the opportunity to remove the 
            // eldest entry each time a new one is added."
            protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest){
                return size() > CAPACITY;
            }
        };
    }

    public int get(int key){
        return map.getOrDefault(key, -1);
    }

    public void set(int key, int value){
        map.put(key, value);
    }

    // this is if we do not want to override removeEldestEntry: 
    /*
        private LinkedHashMap<Integer, Integer> map;
        private int CAPACITY;

        public LRUCache(int capacity) {
            map = new LinkedHashMap<>();
            CAPACITY = capacity;
        }

        public int get(int key) {
            if(!map.containsKey(key))
                return -1 

            int value = map.remove(key);
            map.put(key, value);
            return value;            
        }

        public void put(int key, int value) {
            if(map.containsKey(key)) 
                map.remove(key);
            else if(map.size() + 1 > SIZE) 
                map.remove(map.keySet().iterator().next());
            
            map.put(key, value);
        }
    */
}
