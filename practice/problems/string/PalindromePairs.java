package problems.string;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/*
 * > PROBLEM 336 (hard): Palindrome Pairs 
 *   Given a list of unique words, return all the pairs of distinct indices (i, j)
 *   in the given list, so that the concatenation of two words word[i] + word[j] is
 *   palindrome
 * 
 * > SOLUTION: 
 *   Use hashtable to find rapidly strings that are palindrome or strings that could 
 *   be palindrome. 
 *   The steps are the following: 
 *      - put each word in the list of word in a map: word -> index of word in words
 *      - loop for every word in the list of words
 *          - the word is ""
 *              - this word concatenated with another word is palindrome only if 
 *                the other word is already palindrome. Add to the result every pair
 *                (index of "", index of a palindrome)
 *          - we reverse the word: if the reverse is in the map then the concatenation of 
 *            those two is a palindrome
 *          - tricky case: read the code
 * 
 * > IDEA: we could also use a Trie, but since there is no implementation in Java (and mine 
 *   would need a slight customization) we use maps
 */
public class PalindromePairs {
    public static void main(String[] args) {
        List<List<Integer>> input1 = solution(new String[]{"abcd","dcba","lls","s","sssll"});
        List<List<Integer>> output1 = new ArrayList<>(); 
        output1.addAll(List.of(
            List.of(0,1), 
            List.of(1, 0), 
            List.of(3, 2), 
            List.of(2, 4)
        ));
        assert(input1.equals(output1));

        List<List<Integer>> input2 = solution(new String[]{"bat", "tab", "cat"});
        List<List<Integer>> output2 = new ArrayList<>(); 
        output2.addAll(List.of(
            List.of(0,1), 
            List.of(1, 0)
        ));
        assert(input2.equals(output2));

        List<List<Integer>> input3 = solution(new String[]{"a", ""});
        List<List<Integer>> output3 = new ArrayList<>(); 
        output3.addAll(List.of(
            List.of(0,1), 
            List.of(1, 0)
        ));
        assert(input3.equals(output3));
    }


    public static List<List<Integer>> solution(String[] words){
        if(words.length == 0 || words == null)
            return new ArrayList<>();

        List<List<Integer>> result = new ArrayList<>();

        // map: string in words -> index of word in words
        Map<String, Integer> map = new HashMap<>();

        for(int i = 0; i < words.length; i++)
            map.put(words[i], i);

        // corner case: w1 = "", w2 = "...", w1 + w2 and w2 + w1 is 
        // palindrome only if w2 itself is already a palindrome
        for(String w1 : words){
            int w1Index = map.get(w1); 
            int w2Index = -1;       

            if(w1.length() == 0){
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

            // if the reversed string appear in the hashtable and it is not the reverse
            // of the string w1 itself than the concatenation surely give a palindrome
            String revW1 = reverse(w1);
            int revW1Index = map.getOrDefault(revW1, -1);
            if(revW1Index != -1 && revW1Index != w1Index)
                result.add(List.of(w1Index, revW1Index));
            
            /* 
                the tricky cases: 
                1) given two strings w1 and w2 if the substring w1[0, n] is palindrome 
                   and w1[n+1, w1.length-1] = reverse(w2) then w2 + w1 is a palindrome
                    > eg: w1 = ABBABORK, w2 = KORB:
                        - w1[0, 3] = ABBA, is palindrome
                        - w1[4, 7] = BORK = reverse(w2) = KORB
                        => w2 + w1 is palindrome: KORB + ABBABORK = KORBABBABORK
                2) specular case: w1[n+1, w1.length-1] palindrome and w1[0, n] = reverse(w2) 
            */
            for(int cut = 1; cut < w1.length(); cut++){
                int subWordIndex = -1;
                // tricky case 1
                if(isPalindrome(w1.substring(0, cut))){
                    subWordIndex = map.getOrDefault(reverse(w1.substring(cut)), -1);
                    if(subWordIndex != -1 && subWordIndex != w1Index)
                        result.add(List.of(subWordIndex, w1Index));
                }
                // tricky case 2
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
