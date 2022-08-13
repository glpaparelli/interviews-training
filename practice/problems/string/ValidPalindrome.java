package problems.string;

//TODO

public class ValidPalindrome {
    public static boolean solution(String s){
        s = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        int i = 0; 
        int j = s.length()-1;

        while(i < j)
            if(s.charAt(i++) != s.charAt(j--))
                return false;
            
        return true;
    }
}
