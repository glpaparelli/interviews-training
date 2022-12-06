package problems.binarytree.medium;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import datastructures.TreeNode;
/*
 * > PROBLEM 102 (medium): Binary Tree Right Side View
 *   Given the root of a binary tree, imagine yourself standing on the right side of it, 
 *   return the values of the nodes you can see ordered from top to bottom.
 * 
 * > SOLUTION: 
 *   we do a BFS and store the rightest node of every level. 
 *   The list of all the rightest nodes in the tree gives the right side view of a tree
 * 
 *   > non tested, trivial
 */
public class BTRSV {
    public static List<Integer> solution(TreeNode root){
        List<Integer> result = new ArrayList<>();

        if(root == null)
            return result;

        // frontier: list of nodes yet to visit
        LinkedList<TreeNode> frontier = new LinkedList<>();
        frontier.add(root);

        while(frontier.isEmpty() == false){
            int frontierSize = frontier.size();
            LinkedList<Integer> level = new LinkedList<>();
            
            // add to level all the nodes at a certain depth
            for(int i = 0; i < frontierSize; i++){
                TreeNode current = frontier.poll();
                level.add(current.val);
                
                if(current.left != null)
                    frontier.add(current.left);
                if(current.right != null)
                    frontier.add(current.right);
            }
            // of a level we get the rightest node
            result.add(level.getLast());
            
        }
        return result;
    }
}
