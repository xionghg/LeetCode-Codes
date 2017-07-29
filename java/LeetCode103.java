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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root==null) {
            return result;
        }
        boolean ltr = true;
        List<TreeNode> current = new ArrayList<>();
        current.add(root);

        while (current.size() != 0) {
            ltr = !ltr;
            List<Integer> r = new ArrayList<>();
            final List<TreeNode> temp = new ArrayList<>(current);
            for (TreeNode tn: temp) {
                r.add(tn.val);
            }
            current.clear();

            for (int i = temp.size()-1; i >=0 ; i--) {
                TreeNode ltn = temp.get(i).left;
                TreeNode rtn = temp.get(i).right;
                if (ltr) {
                    if (ltn != null) current.add(ltn);
                    if (rtn != null) current.add(rtn);
                } else {
                    if (rtn != null) current.add(rtn);
                    if (ltn != null) current.add(ltn);
                }
            }
            result.add(r);
        }
        return result;
    }
}
