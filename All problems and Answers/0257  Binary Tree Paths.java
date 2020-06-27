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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        helper(res, new StringBuilder(), root);
        return res;
    }
    
    private void helper(List<String> res, StringBuilder sb, TreeNode root){
        if (root == null) return;
        if (root.left == null && root.right == null) {
            sb.append(root.val);
            res.add(sb.toString());
            return;
        }
        
        sb.append(root.val).append("->");
        int curLength = sb.length();
        
        helper(res, sb, root.left);
        sb.setLength(curLength);
        helper(res, sb, root.right);
        sb.setLength(curLength);
    }
    
}
