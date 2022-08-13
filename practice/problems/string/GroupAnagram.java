package problems.string;
//TODO
/*
    > problem: Group Anagram
*/

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

public class GroupAnagram {
    

    public static void main(String[] args) {
    }

    //TODO
    public static List<List<String>> solution(String[] strs){
        if (strs == null || strs.length == 0) 
            return new ArrayList<>();

        Map<String, List<String>> map = new HashMap<>();

        for (String s : strs) {
            char[] ca = new char[26];

            for (char c : s.toCharArray()) 
                ca[c - 'a']++;

            String keyStr = String.valueOf(ca);

            if (!map.containsKey(keyStr)) 
                map.put(keyStr, new ArrayList<>());
            
            map.get(keyStr).add(s);
        }
        return new ArrayList<>(map.values());
    }

    //TODO: this is dumb, no matter what you overflow
    public static List<List<String>> primeNumSolution(String[] strs){
        Integer[] primes = firstNPrimes(26);
        List<List<String>> result = new ArrayList<>();
        Map<Long, List<String>> map = new HashMap<>();

        for(String s : strs){
            long sP = 1;
            
            for(Character c : s.toCharArray())
                sP = Long.parseUnsignedLong(new String(""+sP * primes[c - 'a']));
            
            if(map.containsKey(sP))
                map.put(sP, map.get(sP)).add(s);
            else{
                List<String> value = new ArrayList<>();
                value.add(s);
                map.put(sP, value);
            } 
        }

        for(List<String> list : map.values())
            result.add(list);

        return result; 
    }

    public static Integer[] firstNPrimes(int n) {
        List<Integer> primes = new ArrayList<>();
        int i = 2; 
        while(n > 0){
            if(isPrime(i)){
                primes.add(i);
                n--;
            }
            i++;
        }
        return primes.toArray(new Integer[26]);
    }

    private static boolean isPrime(int x) {
        return IntStream.rangeClosed(2, (int) (Math.sqrt(x)))
          .allMatch(n -> x % n != 0);
    }
}
