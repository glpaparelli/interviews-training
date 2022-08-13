package problems.string;
/*
    > problem: Longest Common Prefix
 */
public class LCP {

    //TODO

    public static String solution(String[] strs){
        int minLength = Integer.MAX_VALUE;
        String shortestString = null; 
        for(String s : strs){
            if(s.length() < minLength)
                minLength = s.length(); 
                shortestString = s;
        }
        
        int prefixLength = 0;
        for(int i = 0; i < minLength; i++){
            for(int j = 0; j < strs.length; j++)
                if(shortestString.charAt(i) != strs[j].charAt(i))
                    return shortestString.substring(0, prefixLength);

            prefixLength++;
        }

        return shortestString.substring(0, prefixLength);
    }
}