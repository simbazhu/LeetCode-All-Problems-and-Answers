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
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        return deep(root).getValue();
    }

    public Pair<Integer, TreeNode> deep(TreeNode root) {
        if (root == null) return new Pair(0, null);
        Pair<Integer, TreeNode> l = deep(root.left), r = deep(root.right);

        int d1 = l.getKey(), d2 = r.getKey();
        return new Pair(Math.max(d1, d2) + 1, d1 == d2 ? root : d1 > d2 ? l.getValue() : r.getValue());
    }
}
