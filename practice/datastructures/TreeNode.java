package datastructures;
/*
 * simple definition of a binary tree, leetcode fluff
 */
public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode() {
    }

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    // dumb pre order lefty print
    public static void printTree(TreeNode root){
        if(root == null)
            return;

        System.out.println(root.val + "");
        printTree(root.left);
        printTree(root.right);
    }
}
