package problems.binarytree.medium;
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
 *   BFS adaptated to traverse in zigzag. 
 *   The trick is to have a boolean that indicates the order (left to right or right to left)
 *   and add / poll from the frontier accordingly. 
 * 
 *   if we are in the left to right situation (aka classic situation)
 *      - the current element to be polled from the frontier is the first element in the frontier
 *      - the elements yet to be visited are added in the frontier in a left to right manner
 *          - we add at the end of the frontier starting with the left child of the current node
 *   
 *   if we are in a right to left situation
 *      - the current element to be polled from the frontier is the last element of the frontier
 *      - the elements yet to be visited are added in the frontier still in a right to left manner 
 *          - we add at the head of the frontier starting with the right child of the current node
 * 
 *   notice that the frontier has "always the same order", no matter of the zig zag. we insert 
 *   differently only to accomodate how we poll from the frontier. 
 * 
 *   > the whole trick is how we poll from the frontier: if we want to print left to right we poll 
 *     the first elements otherwise we poll from the right
 * 
 */
public class BTZLOT {
    public static List<List<Integer>> solution(TreeNode root){
        List<List<Integer>> result = new ArrayList<>();
        boolean leftToRight = true;

        if(root == null)
            return result;

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
                
                // semantically the frontier will be always of the same order
                // but we insert in a different fashion based on leftToRight 
                // to accomodate how we poll the elements
                if(leftToRight == true){
                    if(current.left != null)
                        frontier.add(current.left);
                    if(current.right != null)
                        frontier.add(current.right);
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
