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
    public int kthSmallest(TreeNode root, int k) {
        return inorder(root, new int[]{k})==null?0:inorder(root, new int[]{k});
    }
        private Integer inorder(TreeNode node, int[] k) {
        if (node == null) return null;

        Integer left = inorder(node.left, k);
        if (left != null) return left;

        if (--k[0] == 0)
            return node.val;

        return inorder(node.right, k);
}
}
