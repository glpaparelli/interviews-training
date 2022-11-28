package problems.binarytree;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import datastructures.TreeNode;
/*
 * > PROBLEM 103 (medium): Binary Tree Zigzag Order Traversal
 *   Given the root of a binary tree, return the zigzag level order traversal 
 *   of its nodes' values. 
 *   (i.e., from left to right, then right to left for the next level and alternate between).
 * 
 * > SOLUTION: 
 *   TODO 
 */

public class BTZLOT {
   
    public static List<List<Integer>> solution(TreeNode root){
        List<List<Integer>> result = new ArrayList<>();

        if(root == null)
            return result;

        boolean leftToRight = true;

        LinkedList<TreeNode> frontier = new LinkedList<>();
        frontier.add(root);

        while(frontier.isEmpty() == false){
            int frontierSize = frontier.size();
            List<Integer> level = new ArrayList<>();
            
            for(int i = 0; i < frontierSize; i++){
                TreeNode current = null;
                if(leftToRight == true)
                    current = frontier.pollFirst();
                else
                    current = frontier.pollLast();
                
                level.add(current.val);
                
                if(leftToRight == true){
                    if(current.left != null)
                        frontier.addLast(current.left);
                    if(current.right != null)
                        frontier.addLast(current.right);
                }else{
                    if(current.right != null)
                        frontier.addFirst(current.right);
                    if(current.left != null)
                        frontier.addFirst(current.left);
                }
            }
            result.add(level);
            leftToRight = !leftToRight;
        }

        return result;
    }
}
