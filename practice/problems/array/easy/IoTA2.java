package easy;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
/*
 * > PROBLEM 350 (easu): Intersection of Two Arrays II
 *   Given two integer arrays nums1 and nums2, return an array of their intersection. 
 *   Each element in the result must appear as many times as it shows in both arrays 
 *   and you may return the result in any order.
 * 
 * > SOLUTION:
 *   // TODO: to improve solution and to do other solutions, check leetcode
 * 
 */
public class IoTA2 {    
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new int[]{1,2,2,1}, new int[]{2,2})));
    }

    public static int[] solution(int[] nums1, int[] nums2){
        Map<Integer, Integer> map1 = new HashMap<>();
        Map<Integer, Integer> map2 = new HashMap<>(); 

        LinkedList<Integer> result = new LinkedList<>();

        for(int num : nums1)
            map1.put(num, map1.getOrDefault(num, 0)+1);

        for(int num : nums2)
            map2.put(num, map2.getOrDefault(num, 0)+1);

        for(int num : nums1)
            if(map2.containsKey(num) == false)
                continue;
            else{
                int occurrences = Math.min(map1.get(num), map2.get(num));
                for(int i = 0; i < occurrences; i++)
                    result.add(num);
                map2.remove(num);
            }
        
        return result.stream().mapToInt(i -> i).toArray(); 
    }
}
