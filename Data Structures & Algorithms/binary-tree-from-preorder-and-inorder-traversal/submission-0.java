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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return build(preorder, inorder, 0, preorder.length-1, 0, inorder.length-1);
    }

    private TreeNode build(int[] preorder, int[] inorder, int pres, int pree, int inos, int inoe){

        if(pres>pree || inos>inoe){
            return null;
        }

        TreeNode root = new TreeNode(preorder[pres]);
        int index = find(inorder, preorder[pres]);
        root.left = build(preorder, inorder, pres+1, pres+index-inos, inos, index-1);
        root.right = build(preorder, inorder, pres+index-inos+1, pree, index+1, inoe);

        return root;
    }

    private int find(int[] inorder,int val){
        for(int i =0;i<inorder.length;i++){
            if(val==inorder[i]){
                return i;
            }
        }
        return -1;
    }
}
