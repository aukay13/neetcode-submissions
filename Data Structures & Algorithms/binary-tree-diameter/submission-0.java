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
    int dia = -1;

    public int diameterOfBinaryTree(TreeNode root) {
        
        getHeight(root);
        return dia;
        
    }

    public int getHeight(TreeNode node){

        if(node==null){
            return -1;
        }

        int leftHeight = getHeight(node.left)+1;
        int rightHeight = getHeight(node.right)+1;

        dia = Integer.max(dia, rightHeight+leftHeight);

        return Integer.max(leftHeight, rightHeight);
        
    }
}
