package problems.binarytree.easy;
import datastructures.TreeNode;
/*
 * > PROBLEM 104 (easy): Maximum Depth of Binary Tree
 *   Given the root of a binary tree, return its maximum depth
 *   
 *   A binary tree's maximum depth is the number of nodes along the
 *   longest path from the root node down to the farthest leaf node
 * 
 * > SOLUTION: 
 *   Simple recursive algorithm, let's see the following example
 *             1 
 *            / \
 *           2   3
 *          /
 *         4
 * 
 *   > solution(1)
 *      - leftDepth = solution(2) = 2
 *          > solution(2) = 2
 *              - leftDepth = solution(4) = 1
 *                  > solution(4) = 1
 *                      - leftDepth = solution(null) = 0
 *                      - rightDepth = solution(null) = 0
 *                      - return max(0,0) + 1 = 1
 *                          - this value is returned to the invocation of solution(4)   
 *              - rightDepth = solution(null) = 0
 *              - return max(1, 0) + 1 = 2
 *                  - this value is returned to the invocation of solution(2)
 *      - rightDepth = solution(3) = 1
 *          > solution(3) = 1
 *              - leftDepth = solution(null) = 0
 *              - rightDepth = solution(null) = 0
 *              - return max(0,0) +1 = 1
 *                  - this value is returned to the invocation of solution(3)
 *      - return max(2,1) + 1 = 3
 *          - and in fact the max depth is given by the number of nodes 
 *            along the longest path: 1 -> 2 -> 4, 3 nodes. 
 */
public class MDoBT {
    public static int solution(TreeNode root){
        if(root == null)
            return 0; 

        int leftDepth = solution(root.left);
        int rigthDepth = solution(root.right);

        return Math.max(leftDepth, rigthDepth) + 1;
    }
}
