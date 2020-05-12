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
    HashSet < String > trees = new HashSet < > ();
    public boolean isSubtree(TreeNode s, TreeNode t) {
        String tree1 = preorder(s);
        String tree2 = preorder(t);
        return tree1.indexOf(tree2) >= 0;
    }
    public String preorder(TreeNode t) {
        if (t == null) {
            return "null";
        }
        return "#" + t.val + " " + preorder(t.left) + " " + preorder(t.right);
    }
}
