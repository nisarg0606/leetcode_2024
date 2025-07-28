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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        rightRideViewRec(root, result, 0);
        return result;
    }

    public void rightRideViewRec(TreeNode current, List<Integer> result, int currDepth){
        if(current == null) return;
        if(currDepth == result.size()){
            result.add(current.val);
        }
        rightRideViewRec(current.right, result, currDepth + 1);
        rightRideViewRec(current.left, result, currDepth + 1);
    }
}