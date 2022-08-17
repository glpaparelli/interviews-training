package problems.hashtable;
import java.util.HashMap;
import java.util.Map;
/*
 * > PROBLEM 383 (easy): Ransom Note
 *   Given two strings "ransomNote" and "magazine", return true if
 *   ransomNote can be constructed by using the letters from magazine
 *   and false otherwise.
 * 
 * > SOLUTION: 
 *   Simply use a map that match every letter in the magazine to how many
 *   times that letter appear in the magazine.
 *   Then for each letter c of the ransom note we check if there are enough 
 *   c occurrences in the magazine: if not we return false
 */
public class RansomNote {
    public static void main(String[] args) {
        assert(!solution("a", "b"));
        assert(!solution("aa", "ab"));
        assert(solution("aa", "aab"));
    }

    public static boolean solution(String ransomNote, String magazine){
        Map<Character, Integer> mDict = new HashMap<>();

        for(Character c : magazine.toCharArray())
            mDict.put(c, mDict.getOrDefault(c, 0)+1);

        for(Character c : ransomNote.toCharArray())
            if(mDict.getOrDefault(c, -1) > 0)
                mDict.put(c, mDict.get(c)-1);
            else
                return false;

        return true;
    }
}
