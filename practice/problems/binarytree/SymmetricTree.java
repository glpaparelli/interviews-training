package problems.binarytree;
import datastructures.TreeNode;
/*
 * > PROBLEM 101 (easy): Symmetric Tree
 *   Given the root of a binary tree, check whether it is a 
 *   mirror of itself (i.e., symmetric around its center).
 * 
 * > SOLUTION 1: lazy solution
 *   Flip the right subtree of the root, then check if the left subtree 
 *   of the root is the same tree of the right subtree of the root
 * 
 * > SOLUTION 2: 
 *   read the code
 */
public class SymmetricTree {
    public static void main(String[] args) {
        TreeNode input1 = new TreeNode(1); 
        input1.left = new TreeNode(2, new TreeNode(3), new TreeNode(4)); 
        input1.right = new TreeNode(2, new TreeNode(4), new TreeNode(3));

        assert(smartSolution(input1));
    }

    public static boolean solution(TreeNode root){
        if(root == null)
            return true;

        invertTree(root.right);
        return sameTree(root.left, root.right);
    }

    public static boolean sameTree(TreeNode p, TreeNode q){
        if(p == null || q == null)
            return p == q;
        
        if(p.val != q.val)
            return false;

        return sameTree(p.left, q.left) && sameTree(p.right, q.right);
    }

    public static TreeNode invertTree(TreeNode root){
        if(root == null)
            return null; 

        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right); 

        root.left = right;
        root.right = left;

        return root;
    }

    public static boolean smartSolution(TreeNode root){
        if(root == null)
            return true;
        
        return helper(root.left, root.right);
    }

    private static boolean helper(TreeNode t1, TreeNode t2) {
        if(t1 == null || t2 == null)
            return t1 == t2; 

        if(t1.val != t2.val)
            return false;
        
        return helper(t1.left, t2.right) && helper(t1.right, t2.left);
    }
}
