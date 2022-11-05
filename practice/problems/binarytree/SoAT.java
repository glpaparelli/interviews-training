package problems.binarytree;
import datastructures.TreeNode;
/*
 * > PROBLEM 572 (easy): Subtree of Another Tree
 *   Given the roots of two binary trees root and subRoot, return true if there 
 *   is a subtree of root with the same structure and node values of subRoot 
 *   and false otherwise. 
 *   A subtree of a binary tree tree is a tree that consists of a node in tree 
 *   and all of this node's descendants. 
 *   The tree tree could also be considered as a subtree of itself.
 * 
 * > SOLUTION: 
 *   trivial
 */
public class SoAT {
    public static void main(String[] args) {        
        TreeNode root = new TreeNode(3, 
            new TreeNode(4, new TreeNode(1), new TreeNode(2)), 
            new TreeNode(5)
        );

        TreeNode subRoot = new TreeNode(4, new TreeNode(1), new TreeNode(2));
        assert(solution(root, subRoot));
    }

    public static boolean solution(TreeNode root, TreeNode subRoot){
        if(subRoot == null)
            return true;

        if(root == null)
            return false;

        if(helper(root, subRoot))
            return true;

        return solution(root.left, subRoot) || solution(root.right, subRoot);
    }

    private static boolean helper(TreeNode p, TreeNode q){
        if (p == null || q == null)
            return p == q;
        
        return p.val == q.val && 
               helper(p.left, q.left) && 
               helper(p.right, q.right);
    }
}