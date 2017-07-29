/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    static String interval = "->";
    
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        travelNode(root, result, "");
        return result;
    }

    private void travelNode(TreeNode node, List<String> result, String base) {
        String now = base + node.val;
        if (node.left == null && node.right == null) {
            result.add(now);
        }
        if (node.left != null) {
            travelNode(node.left, result, now + interval);
        }
        if (node.right != null) {
            travelNode(node.right, result, now + interval);
        }
    }
}
