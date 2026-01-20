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
    public int pathSum(TreeNode root, int targetSum) {

        if (root == null) return 0;
        
        // paths starting from current node
        int fromRoot = countPath(root, targetSum);
        

        // paths from left and right subtrees 
        int left = pathSum(root.left, targetSum);
        int right = pathSum(root.right, targetSum);

        return fromRoot + left + right;
        
    }

    private int countPath(TreeNode node,  long sum) {
        if(node == null) return 0;

        int count = 0;

        if (node.val == sum) {
            count++;

        }

        count += countPath(node.left, sum-node.val);
        count += countPath(node.right, sum-node.val);

        return count;
    }
}