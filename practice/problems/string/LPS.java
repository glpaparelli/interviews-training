package problems.string;

/*
 * TODO
 * > problem: Longest Palindromic String
 */
public class LPS {
    
    public static void main(String[] args) {
        System.out.println(solution("babad"));
    }

    public static String solution(String s){
        if(s.isEmpty())
            return null;
        if(s.length() == 1)
            return s; 
        
        String longest = s.substring(0, 0);
        for(int i = 0; i < s.length(); i++){
            //get longest palindrome with center i (assume palindrome string has 
            // an odd length because X...X i X...X with X...X substring of even length)
            String oddPal = helper(s, i, i);
            //get longest palindrome with center i, i+1 (assume palindrome string has an 
            //even length: X...X i,i+1, X...X. In even long palindrome the center is of 2 chars)
            String evenPal = helper(s, i, i+1);
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

    private static String helper(String s, int leftC, int rightC){
        while(leftC >= 0 && rightC <= s.length() - 1 && s.charAt(leftC) == s.charAt(rightC)){
            leftC--; 
            rightC++;
        }
        return s.substring(leftC+1, rightC);
    }
    
}
