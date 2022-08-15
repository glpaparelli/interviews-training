package problems.array;
/*
 * > PRBLEM 11 (medium): Container with Most Water
 *   You are given an integer array "height" of length n. 
 *   There are n vertical lines drawn such taht the two 
 *   endpoints of the i-th line are (i, 0) and (i, height(i))
 * 
 *   Find two lines that together with the x-axis form a container 
 *   such that the container contains the most water. 
 * 
 *   Return the maximum amount of water a container can store. 
 *   Notice that you may not slant the container
 * 
 * > SOLUTION: 
 *   We can compute the maximum water in one pass using two pointers. 
 *   The water contained is computed as the area of a rectangle base*height.
 *   In this case the height is the shorter end of the container and the base 
 *   is the distance between the two vertical lines. 
 *   We compute the amount of water between the first (height[0]) and the last
 *   (height[n-1]) lines. If height[0] > height[n-1] means that if height[n-1] was 
 *   higher than we could contain more water, hence we move the right pointer left, 
 *   and check if the water contained is more. 
 *   This reasonig is applied iteratively until the left pointer is behind the right one.
 */
public class CwMW {
    public static void main(String[] args) {
        assert(solution(new int[]{1,8,6,2,5,4,8,3,7}) == 49);
        assert(solution(new int[]{1,1}) == 1);
    }

    public static int solution(int[] height){
        int left = 0; 
        int right = height.length - 1;
        int max = 0; 

        while(left < right){
            //compute the current max
            max = Math.max(max, Math.min(height[left], height[right])*(right-left));

            if(height[left] < height[right])
                left++;
            else 
                right--;
        }
        return max;
    }
}
