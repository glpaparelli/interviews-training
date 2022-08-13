package problems.string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/*
 * > problem Palindrome Pairs 
 * 
 * . idea1: we use maps 
 *      > we do it in 3 pass for clarity, it is easly possible to do it in one pass
 * 
 * > idea: we could use the trie but we would need to modify my implementation
 *   in order to store the index of each word in words within the tree, hence we use 
 *   map solution
 * TODO
 */
public class PalindromePairs {
    
    public static List<List<Integer>> solution(String[] words){
        List<List<Integer>> result = new ArrayList<>();

        // map: string in words -> index of word in words
        Map<String, Integer> map = new HashMap<>();

        for(int i = 0; i < words.length; i++)
            map.put(words[i], i);

        //corner case: w1 = "", w2 = "...", w1 + w2 and w2 + w1 is 
        //palindrome only if w2 itself is already a palindrome
        for(String w1 : words){

            int w1Index = map.get(w1);
            int w2Index = -1;

            if(w1.equals("")){
                for(String w2 : words){
                    w2Index = map.get(w2);
                    if(w1Index != w2Index && isPalindrome(w2))
                        result.addAll(List.of
                            (List.of(w1Index, w2Index), 
                            List.of(w2Index, w1Index))
                        );
                }
                continue; 
            }

            //if the reversed string appear in the hashtable and it is not the revere
            //of the string itself than the concatenation surelly give a palindrome
            String revW1 = reverse(w1);
            int revW1Index = map.getOrDefault(revW1, -1);
            if(revW1Index != -1 && revW1Index != w1Index)
                result.add(List.of(w1Index, revW1Index));
            
            //the tricky case: given two strings w1 and w2
            //if the substring w1[0, n] is palindrome and w1[n+1, w1.length-1] = reverse(w2)
            //then w2 + w1 is a palindrome
                // eg: w1 = ABBABORK, w2 = KORB
                // w1[0, 3] = ABBA, is palindrome, w1[4, 7] = BORK = reverse(w2) = KORB
                // => w2 + w1 is palindrome = KORB + ABBABORK = KORBABBABORK
            //we have also the specular case: w1[n+1, w1.length-1] is palindrome and w1[0, n] = 
            //reverse(w2)
            for(int cut = 1; cut < w1.length(); cut++){
                int subWordIndex = -1;
                //tricky case 1
                if(isPalindrome(w1.substring(0, cut))){
                    subWordIndex = map.getOrDefault(reverse(w1.substring(cut)), -1);
                    if(subWordIndex != -1 && subWordIndex != w1Index)
                        result.add(List.of(subWordIndex, w1Index));
                }
                //tricky case 2
                if(isPalindrome(w1.substring(cut))){
                    subWordIndex = map.getOrDefault(reverse(w1.substring(0, cut)), -1);
                    if(subWordIndex != -1 && subWordIndex != w1Index)
                        result.add(List.of(w1Index, subWordIndex));
                }
            }   
        }
        return result; 
    }

    private static boolean isPalindrome(String s) {
        for(int i = 0, j = s.length()-1; i <= j; i++, j--)
            if(s.charAt(i) != s.charAt(j))
                return false;

        return true;
    }

    private static String reverse(String s){
        return new StringBuilder(s).reverse().toString();
    }

}
