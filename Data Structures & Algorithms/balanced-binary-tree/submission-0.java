/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    boolean isBalanced = true;

    public boolean isBalanced(TreeNode root) {

        geHeight(root);
        return isBalanced;
        
    }

    public int geHeight(TreeNode root){
        
        if(root==null){
            return -1;
        }

        int leftHeight = geHeight(root.left)+1;
        int rightHeight = geHeight(root.right)+1;

        if(Math.abs(leftHeight-rightHeight)>1){
            isBalanced = false;
        }

        return Integer.max(leftHeight, rightHeight);

    }

}
