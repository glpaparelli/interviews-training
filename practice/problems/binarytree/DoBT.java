package problems.binarytree;
import datastructures.TreeNode;
/*
 * > PROBLEM 543 (easy): Diameter of Binary Tree
 *   Given the root of a binary tree, return the length of the diameter 
 *   of the tree. 
 * 
 *   The diameter of a binary tree is the length of the longest path between
 *   any two nodes in a tree. This path may or may not pass through the root.
 *   
 *   The length of a path between two nodes is represented by the number of 
 *   edges between them. 
 * 
 * > SOLUTION: 
 *   - insight: if it pass through the root the diameter is basically the heigth 
 *     of the deepest node in the left subtree + height of deepest node in right 
 *     subtree
 * 
 *   just check the code
 */
public class DoBT {
    public static void main(String[] args) {
        TreeNode input1 = new TreeNode(1);
        input1.left = new TreeNode(2);
        input1.left.left = new TreeNode(4);
        input1.left.right = new TreeNode(5);
        input1.right = new TreeNode(3);

        assert(smartSolution(input1) == 3);
    }

    public static int solution(TreeNode root) {
        // base case
        if(root ==  null)
            return 0; 

        // the insight is used here
        int rootUsed = getDepth(root.left) + getDepth(root.right); 

        // what if the max diameter is in a subtree without the root? 
        int left = solution(root.left);
        int right = solution(root.right);

        return max(rootUsed, left, right);
    }

    private static int getDepth(TreeNode root){
        if(root == null)
            return 0;  

        return Math.max(getDepth(root.left), getDepth(root.right)) + 1;
    }

    // dumb method, just for clarity and my ocd
    private static int max(int a, int b, int c){
        return Math.max(a, Math.max(b, c));
    }

    // NOW THE SMART SOLUTION
    public static int smartSolution(TreeNode root){
        int[] diameter = new int[1]; 
        helper(root, diameter);
        return diameter[0];
    }

    private static int helper(TreeNode root, int[] diameter) {
        if(root == null)
            return 0; 

        int leftDepth = helper(root.left, diameter);
        int rigthDepth = helper(root.right, diameter); 

        diameter[0] = Math.max(diameter[0], leftDepth + rigthDepth);
        return Math.max(leftDepth, rigthDepth) + 1;
    }
}