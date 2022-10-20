package problems.binarysearch;
/*
 * > PROBLEM 278 (easy): First Bad Version
 *   You are a product manager and currently leading a team to develop a new product. 
 *   Unfortunately, the latest version of your product fails the quality check. 
 *   Since each version is developed based on the previous version, all the versions 
 *   after a bad version are also bad.
 *   
 *   Suppose you have n versions [1, 2, ..., n] and you want to find out the first 
 *   bad one, which causes all the following ones to be bad.
 *   
 *   You are given an API bool isBadVersion(version) which returns whether version is bad.
 *   Implement a function to find the first bad version. 
 *   You should minimize the number of calls to the API.
 * 
 * > SOLUTION: 
 *   Adaptation of binary search
 */
public class FBV {
    public static int solution(int n){
        int start = 1; 
        int end = n;
        int mid = 0; 

        while(start < end){
            // best practice: ((start + end) / 2) may overflow the integer value
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
