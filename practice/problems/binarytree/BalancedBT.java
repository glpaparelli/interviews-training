package problems.binarytree;
import datastructures.TreeNode;
/*
 * > PROBLEM 110 (easy): Balanced Binary Tree
 *   Given a binary tree, determine if it is height-balanced.
 *   For this problem, a height-balanced binary tree is defined as: 
 *   "a binary tree in which left and right subtrees of every node differ 
 *   in height by no more than 1"
 * 
 * > SOLUTION: 
 *   We basically we compute the depth of the tree but in the process we 
 *   check if the tree is balanced, if not we return -1. 
 *   
 *   Check the code. 
 * 
 *   Here a little simulation with the tree "input1"
 *                  3 
 *             9          20
 *                    15       7
 *   the tree is balanced. 
 * 
 *   root = 3
 *   > helper(3)
 *      > helper(9)
 *          > helper(null)
 *              - return 0
 *          > helper(null)
 *              - return 0
 *          - leftDepth, rightDepth = 0
 *          - return max(leftDepth, maxDepth) + 1 = 1
 *              // this is good since the left subtree of the root 3 has depth = 1
 *     > helper(20)
 *          > helper(15)
 *              > helper(null)
 *                  - return 0
 *              > helper(null)
 *                  - return 0
 *          - leftDepth, rightDepth = 0
 *          - return 1 // leftDepth at helper(20)
 *          > helper(7)
 *              ...
 *              - return 1 // rightDepth at helper(20)
 *          - return max(leftDepth, rightDepth) + 1 = 2 
 *              // this is good since the right subtree of the root 3 has depth 2
 *      - since 2 - 1 = 1 the tree is balanced
 */
public class BalancedBT {
    public static void main(String[] args) {
        TreeNode input1 = new TreeNode(3);
        input1.left = new TreeNode(9);
        input1.right = new TreeNode(20);
        input1.right.left = new TreeNode(15);
        input1.right.right = new TreeNode(7);

        assert(solution(input1));
    }

    public static boolean solution(TreeNode root){
        if(root == null)
            return true;

        return helper(root) != -1;
    }

    // function that return -1 if the tree is unbalanced, 
    // else it return its depth
    private static int helper(TreeNode root) {
        // base case
        if(root == null)
            return 0;

        // get the depth of the left and right subtrees
        int leftDepth = helper(root.left);
        int rightDepth = helper(root.right);

        // if the left or right subtree are unbalanced then
        // the whole tree is unbalanced
        if(leftDepth == -1 || rightDepth == -1)
            return -1;
            
        // if the depths (heights) differ by more than 1 the tree
        // is unbalanced
        if(Math.abs(leftDepth - rightDepth) > 1)
            return -1;
        
        return Math.max(leftDepth, rightDepth) + 1;
    }
}
