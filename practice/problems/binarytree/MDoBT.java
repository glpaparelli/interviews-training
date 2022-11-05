package problems.binarytree;
import datastructures.TreeNode;
/*
 * > PROBLEM 104 (easy): Maximum Depth of Binary Tree
 *   Given the root of a binary tree, return its maximum depth
 *   
 *   A binary tree's maximum depth is the number of nodes along the
 *   longest path from the root node down to the farthest leaf node
 * 
 * > SOLUTION: 
 *   trivial
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
