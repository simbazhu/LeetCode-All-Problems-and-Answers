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
    public TreeNode findNearestRightNode(TreeNode root, TreeNode u) {
        if (root == null) return null;
        
        ArrayDeque<TreeNode> queue = new ArrayDeque(){{ offer(root); }};
        while (!queue.isEmpty()) {
            int levelLength = queue.size();

            for(int i = 0; i < levelLength; ++i) {
                TreeNode node = queue.poll();
                // if it's the given node
                if (node == u) {
                    return i != levelLength - 1 ? queue.poll() : null;    
                }

                // add child nodes in the queue
                if (node.left != null) {
                    queue.offer(node.left);    
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
        } 
        return null;
    }
}
