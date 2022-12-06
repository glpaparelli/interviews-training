package problems.string.medium;
/*
 * > PROBLEM 5 (medium): Longest Palindromic Substring
 *   Given a string "s" return the longest palindromic substring
 * 
 * > SOLUTION: 
 *   Every palindrome has a center. In palindromic strings of odd length 
 *   the center is of one letter, in the other case the length is equal two
 *      - eg: 
 *          - AAABAAA, length = 7, the center is B
 *          - ABABBABA, length = 8, the center is BB
 *   To find the longest palindromic substring we simply try every letter
 *   as center and check, increasing the "radius" as we go on
 */
public class LPS {
    public static void main(String[] args) {
        assert(solution("babad").equals("bab"));
        assert(solution("cbbd").equals("bb"));
    }

    public static String solution(String s){
        if(s.isEmpty())
            return null;
        if(s.length() == 1)
            return s; 
        
        String longest = s.substring(0, 0);

        for(int i = 0; i < s.length(); i++){
            // get palindrome with center i (assume palindrome string has an odd
            // length: because X...X i X...X with X...X substring of even length)
            String oddPal = helper(s, i, i);

            // get palindrome with center i, i+1 (assume palindrome string has an even
            // length: because X...X i,i+1, X...X, with X...X substring of even length
            String evenPal = helper(s, i, i+1);

            // update the longest palindromic substring
            longest = getLongest(longest, oddPal, evenPal);
        }
        return longest;
    }
    
    private static String getLongest(String s1, String s2, String s3){
        String longest = s1;
        if(s2.length() > longest.length())
            longest = s2;
        if(s3.length() > longest.length())
            longest = s3;
        
        return longest;
    }

    /**
     * @param s string of which we want the palindrome substring of center leftC, rightC
     * @param leftC the left center
     * @param rightC the right center
     * @return the palindrome substring s[leftC+1, rightC]
     */
    private static String helper(String s, int leftC, int rightC){
        while(leftC >= 0 && rightC <= s.length() - 1 && s.charAt(leftC) == s.charAt(rightC)){
            leftC--; 
            rightC++;
        }
        return s.substring(leftC+1, rightC);
    }
}
