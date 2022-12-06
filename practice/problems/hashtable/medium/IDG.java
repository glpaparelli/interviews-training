package problems.hashtable.medium;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
/*
 * > PROBLEM 380 (medium): Insert Delete GetRandom O(1)
 *   Implement the RandomizedSet class:
 *   - RandomizedSet(): Initializes the RandomizedSet object.
 *   - bool insert(int val): Inserts an item val into the set if not present. 
 *     Returns true if the item was not present, false otherwise.
 *   - bool remove(int val): Removes an item val from the set if present. 
 *     Returns true if the item was present, false otherwise.
 *   - int getRandom(): Returns a random element from the current set of elements 
 *     (it's guaranteed that at least one element exists when this method is called). 
 *     Each element must have the same probability of being returned.
 * 
 * > SOLUTION: 
 *   We use a combination of an ArrayList and a Map
 *   - ArrayList is a resizable array and allows for O(1) insert, delete and get
 *   - The map maps every element to the index in the array and this allow for 
 *     O(1) lookups
 *   
 *   The operations are implemented as follow
 *   - insert: check if the value is contained as key in the map, if so return false, 
 *     else insert the value as the last and put it in the map with its index
 *   - remove: check if the value is contained as key in the map, if not return false, 
 *     else we swap the element with the last element, then we remove the last
 *   - getRandom: simply extract a random number from 0 to the size of the list and 
 *     return that element
 */
public class IDG {
    private List<Integer> array;
    // element -> index in the array
    private Map<Integer,Integer> map; 
    private int last;

    public IDG(){
        this.array = new ArrayList<>();
        this.map = new HashMap<>();
        this.last = 0;
    }

    public boolean insert(int val) {
        if(this.map.containsKey(val))
            return false;
        
        this.map.put(val, last);
        this.array.add(last, val);
        this.last++;

        return true;
    }
    
    public boolean remove(int val) {
        if(!this.map.containsKey(val))
            return false;
        /*
         * - get the index of the value to remove
         * - we put the last element of the array in that index 
         *   - hence we eliminated the value from the array
         * - we update the the map with the new bind element - index
         * - we remove the value from the map
         * - we remove the last element from the array to delete the duplicate
         * - we decrease last
         */
        int valIndex = this.map.get(val);
        int lastElement = this.array.get(last-1);

        this.array.add(valIndex, lastElement);
        this.array.remove(last-1);
        this.last--;

        this.map.put(lastElement, valIndex);
        this.map.remove(val);
        
        return true;
    }
    
    public int getRandom() {
       int random = getRandomIndex();
       return this.array.get(random);
    }

    private int getRandomIndex() {
        Random rand = new Random(); 
        int upperbound = this.last;
        return rand.nextInt(upperbound); 
    }
}
