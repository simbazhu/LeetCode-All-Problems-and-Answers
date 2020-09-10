/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        if(original == target || original == null) {
            return cloned;
        }
        
        TreeNode oleft = original.left;
        TreeNode cleft = cloned.left;
        TreeNode left = getTargetCopy(oleft, cleft, target);
        if(left != null)   //Found the target node in left subtree.
            return left;
        
		//Target node is not in left subtree, then it must be in right subtree.
        TreeNode oright = original.right;
        TreeNode cright = cloned.right;
        TreeNode right = getTargetCopy(oright, cright, target);
        
        return right;
    }
}
