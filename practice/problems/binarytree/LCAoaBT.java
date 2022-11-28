package problems.binarytree;
import java.util.LinkedList;
import datastructures.TreeNode;
/*
 * > PROBLEM 236 (medium): Lowest Common Ancestor of a Binary Tree
 *   Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.
 *   “The lowest common ancestor is defined between two nodes p and q as the lowest node in T 
 *   that has both p and q as descendants (where we allow a node to be a descendant of itself).”
 * 
 * > SOLUTION:
 *   read the code, trivial (get the two paths and check)
 * 
 *   > not tested: trivial
 */
public class LCAoaBT {
    public static TreeNode solution(TreeNode root, TreeNode p, TreeNode q){
        LinkedList<TreeNode> pathToQ = new LinkedList<>();
        LinkedList<TreeNode> pathToP = new LinkedList<>();

        getPath(root, q, pathToQ);
        getPath(root, p, pathToP);

        while(pathToP.isEmpty() == false){
            TreeNode current = pathToP.pollLast();
            // we could make pathToQ an HashSet and contains would be O(1)
            // and the whole loop complexity would become O(n) instead of O(n^2)
            if(pathToQ.contains(current) == true)
                return current;
        }

        return null;
    }

    /**
     * @param root the current root of the tree
     * @param target the node of which we are searching the path to
     * @param path the list to store the path
     * @return true if there is a path to target, false otherwise
     */
    private static boolean getPath(
        TreeNode root, 
        TreeNode target, 
        LinkedList<TreeNode> path
    ){
        // if root (the current starting point) is null there is no path
        if(root == null)
            return false;

        // push the current node in the path
        path.add(root);

        // if the current node is the target node then we return true
        if(root.val == target.val)
            return true;
        
        // otherwise we check whether the required node lies 
        if(getPath(root.left, target, path) || getPath(root.right, target, path))
            return true;
        
        // the required node does not lie either in the left or right
        // subtre of the current node, hence we remove the last element 
        // and return false
        path.remove(path.size() -1);
        return false;
    }
}
