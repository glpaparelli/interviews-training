package problems.binarytree;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import datastructures.TreeNode;
/*
 * > PROBLEM 199 (medium): Binary Tree Level Order Traversal
 *   Given the root of a binary tree, return the level order traversal 
 *   of its nodes' values. (i.e., from left to right, level by level).
 * 
 * > SOLUTION:
 *   We use a simple DFS to save all the levels. 
 * 
 *   1) we put the root in the frontier
 *   2) while the frontier != empty
 *      2.1) frontierSize = 1 // only the root in the frontier
 *      2.2) for i = 0, i < 1, i++
 *          2.2.1) current = root
 *          2.2.2) level.add(root)
 *          2.2.3) add root.right and root.left in frontier
 *      2.3) add level (only the root) in result
 *      2.4) frontierSize = 2 // the left and right sons of root
 *      2.5) for i = 0, i < 2, i++
 *          2.5.1) current = left son of root
 *          2.5.2) level.add(current)
 *          2.5.3) add current.left and current.right to level
 *          2.5.4) current = right son of root
 *          2.5.5) level.add(current)
 *          2.5.6) add current.left and current.right to level
 *     2.6) add level (the two sons of root) in result
 *     2.7) frontier = 4 // the four grandchildren of root 
 *     ...
 *     
 *     > not tested, trivial
 */
public class BTLOT {    
    public static List<List<Integer>> solution(TreeNode root){
        List<List<Integer>> result = new ArrayList<>();

        if(root == null)
            return result;

        // frontier: list of nodes yet to visit
        LinkedList<TreeNode> frontier = new LinkedList<>();
        frontier.add(root);

        while(frontier.isEmpty() == false){
            int frontierSize = frontier.size();
            List<Integer> level = new ArrayList<>();
            
            // add to level all the nodes at a certain depth
            for(int i = 0; i < frontierSize; i++){
                TreeNode current = frontier.poll();
                level.add(current.val);
                
                if(current.left != null)
                    frontier.add(current.left);
                if(current.right != null)
                    frontier.add(current.right);
            }
            result.add(level);
        }
        return result;
    }
}