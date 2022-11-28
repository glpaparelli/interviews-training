package questions;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
/*
 * > PROBLEM: Iterate over HashMap  
 *   Write code for iterating over a HashMap in Java 7 and then in Java 8
 * 
 * > SOLUTION:
 *   Countless way to do it: 
 *      - for loop over entries of the map (java  7)
 *      - for loop over keys of the map (java 7)
 *      - forEach over the entry set (java 8)
 *      - entrySet.stream()... (java 11 (?))
 *      - ...
 */
public class IoHM {
    public static void main(String[] args) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(1, 2);
        map.put(3, 4);
        map.put(5, 6);

        iterateHMJava7(map);
        iterateHMJava8ForEach(map);
        iterateHMJava8Stream(map);
    }

    public static void iterateHMJava7(Map<Integer, Integer> map){
        System.out.println("iterateHMJava7");
        for(Entry<Integer, Integer> e : map.entrySet())
            System.out.printf("key = %d, value = %d\n", e.getKey(), e.getValue());
    }

    public static void iterateHMJava8ForEach(Map<Integer, Integer> map){
        System.out.println("iterateHMJava8ForEach");
        map.entrySet().forEach(e -> System.out.printf("key = %d, value = %d\n", e.getKey(), e.getValue()));
    }

    public static void iterateHMJava8Stream(Map<Integer, Integer> map){
        System.out.println("iterateHMJava8Stream");
        map.entrySet().stream().forEach(e -> System.out.printf("key = %d, value = %d\n", e.getKey(), e.getValue()));
    }
}
