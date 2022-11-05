package problems.binarytree;
import datastructures.TreeNode;
/*
 * > PROBLEM 100 (easy): Same Tree
 *   Given the roots of two binary trees p and q, write a function to check 
 *   if they are the same tree or not. 
 * 
 *   Two binary trees are considered the same if they are structurally identical
 *   and the nodes have the same value
 * 
 * > SOLUTION: 
 *   trivial
 */
public class SameTree {
    public static boolean solution(TreeNode p, TreeNode q){
        if(p == null || q == null)
            return p == q;
        
        if(p.val != q.val)
            return false;

        return solution(p.left, q.left) && solution(p.right, q.right);
    }
}
