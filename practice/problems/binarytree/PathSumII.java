package problems.binarytree;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import datastructures.TreeNode;
/*
 * > PROBLEM 113 (medium): Path Sum II
 *   Given the root of a binary tree and an integer targetSum, return all root-to-leaf paths 
 *   where the sum of the node values in the path equals targetSum. 
 *   Each path should be returned as a list of the node values, not node references.
 *   
 *   A root-to-leaf path is a path starting from the root and ending at any leaf node. 
 *   A leaf is a node with no children.
 * 
 * > SOLUTION:
 *   > We basically use a dfs
 *   Let's simulate on the following tree: 
 *          1 
 *        2   3
 *   with targetSum = 4: the only path will be 1 -> 3
 * 
 *   - current = 1
 *   - targetSum = 4
 *   - result = []
 *   - path = [] 
 *   > path.add(1)
 *   > current is not a leaf
 *   > current.left != null
 *      > - current = 2
 *      > - targetSum = 3
 *      > - result = []
 *      > - path = [1]
 *      > path.add(2)
 *      > current is a leaf
 *      > targetSum - current.leaf != 0 since 3 - 2 = 1 != 0
 *      > return
 *  > now path is [1,2] because of the previous recursive call
 *  > path.removeLast() => path = [1]
 *  > current.right != null
 *      > - current = 3
 *      > - targetSum = 3
 *      > - result = []
 *      > - path = [1]
 *      > path.add(3), path = [1,3]
 *      > current is a leaf
 *      > targetSum - current = 0
 *      > result.add(new ArrayList<>(path)) => result = [[1,3]]
 *      > path.removeLast()
 *      > return
 *   > return
 */
public class PathSumII {
    public static void main(String[] args) {
        TreeNode input1 = new TreeNode(5);
        input1.left = new TreeNode(4);
        input1.left.left = new TreeNode(11);
        input1.left.left.left = new TreeNode(7);
        input1.left.left.right = new TreeNode(2);

        input1.right = new TreeNode(8);
        input1.right.left = new TreeNode(13);
        input1.right.right = new TreeNode(4);
        input1.right.right.left = new TreeNode(5);
        input1.right.right.right = new TreeNode(1);

        List<List<Integer>> output1 = new ArrayList<>();
        output1.add(List.of(5, 4, 11, 2));
        output1.add(List.of(5, 8, 4, 5));

        assert(output1.equals(solution(input1, 22)));
    }

    public static List<List<Integer>> solution(TreeNode root, int targetSum){
        List<List<Integer>> result = new ArrayList<>();
        LinkedList<Integer> path = new LinkedList<>();
        if(root == null)
            return result; 
        
        helper(root, targetSum, result, path);

        return result;
    }

    private static void helper(
        TreeNode current, 
        int targetSum, 
        List<List<Integer>> result, 
        LinkedList<Integer> path
    ){
        path.add(current.val);

        // if the current node is a leaf and targetSum - current.val == 0 we won
        if(current.left == null && current.right == null){
            if(targetSum - current.val == 0)
                result.add(new ArrayList<>(path));
            // if targetSum - currentVal != 0 the path is useless
            return;
        }
        
        if(current.left != null){
            helper(current.left, targetSum - current.val, result, path);
            path.removeLast();
        }
        if(current.right != null){
            helper(current.right, targetSum - current.val, result, path);
            path.removeLast();
        }
        
        return;
    }
}
