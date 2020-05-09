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
    int rootVal;
    
    public boolean isUnivalTree(TreeNode root) {
        rootVal = root.val;
        return dfs(root);
    }
    
    public boolean dfs(TreeNode node) {
        if (node != null) {
            if (node.val != rootVal)
                return false;
            return dfs(node.left) && dfs(node.right);
        }
        return true;
    }
}
