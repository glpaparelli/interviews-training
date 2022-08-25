package problems.searching;
/*
 * > PROBLEM 278 (easy): First Bad Version
 * // TODO
 */
public class FBV {
    public static int solution(int n){
        int start = 1; 
        int end = n;
        int mid = 0; 

        while(start < end){
            // start + end / 2 may overflow the integer value!
            mid = start + ( end - start ) / 2;
            if(!isBadVersion(mid))
                start = mid+1;
            else
                end = mid;
        }
        return start; 
    }
    
    //dummy method, leetcode fluff
    private static boolean isBadVersion(int mid) {
        return false;
    }
}
