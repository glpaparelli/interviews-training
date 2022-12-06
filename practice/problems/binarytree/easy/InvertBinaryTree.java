package problems.binarytree.easy;
import java.util.LinkedList;
import java.util.Queue;
import datastructures.TreeNode;
/*
 * > PROBLEM 226 (easy): Invert Binary Tree
 *   Given the root of a binary tree, invert the tree, and return its root
 * 
 * > SOLUTION 1: Recursive Approach 
 *   This is a classic tree problem that is best suited for a recursive approach: 
 *   - the inverse of an empty tree is the empty tree
 *   - the inverse of a tree with a root r and subtrees left and right is a tree with
 *     root r, whose rigth subtree is the inverse of left and whose left subtree is the
 *     inverse of rigth.  
 * 
 *   Complexity Analysis: 
 *   Since each node in the tree is visited only once, the time complexity is O(n), 
 *   where n is the number of nodes in the tree. We cannot do better than that, since 
 *   at the very least we have to visit each node to invert it. 
 *  
 *   Because of the recursion, O(h) function calls will be placed on the stack in the
 *   worst case, where h is the height of the tree. 
 *   Since h is in O(n), the space complexity is O(n)
 * 
 * > SOLUTION 2: Iterative Approach
 *   Alternatively we can solve the problem iteratively, in a manner similar to BFS. 
 *   
 *   The idea is that we need to swap the left and rigth child of all nodes in the tree.
 *   So we create a queue to store nodes whose left and rigth child have not been swapped
 *   yet. Initially, only the root is in the queue. As long as the queue is not 
 *   empty, remove the next node from the queue, swap its children and add the childer 
 *   to the queue. Null nodes are not added to the queue. 
 *   Eventually the queue will be empty and all the children swapped, and we return the
 *   original root. 
 * 
 *   Complexity Analysis:
 *   Since each node in the tree is visited/added to the queue only once, the time 
 *   complexity is O(n), where n is the number of nodes in the tree.
 * 
 *   Space Complexity is O(n), since in the worst case the queue will contain all 
 *   nodes in one level of the binary tree. 
 *   For a full binary tree, the leaf level has n/2 = O(n) leaves. 
 */
public class InvertBinaryTree {
    public static void main(String[] args) {
        TreeNode input1 = new TreeNode(4);

        input1.left = new TreeNode(2);
        input1.left.left = new TreeNode(1);
        input1.left.right = new TreeNode(3);

        input1.right = new TreeNode(7);
        input1.right.left = new TreeNode(6);
        input1.right.right = new TreeNode(9);
        
        TreeNode.printTree(input1);
        recSolution(input1);
        TreeNode.printTree(input1);
    }

    public static TreeNode recSolution(TreeNode root){
        if(root == null)
            return null; 

        TreeNode left = recSolution(root.left);
        TreeNode right = recSolution(root.right); 

        root.left = right;
        root.right = left;

        return root;
    }

    public static TreeNode itSolution(TreeNode root){
        if(root == null)
            return null; 

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()){
            TreeNode current = queue.poll();
            
            TreeNode tmp = current.left;
            current.left = current.right;
            current.right = tmp; 

            if(current.left != null)
                queue.add(current.left);
            if(current.right != null)
                queue.add(current.right);
        }
        return root;
    }
}