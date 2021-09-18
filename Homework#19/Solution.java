public class Solution {
    int result;

    public int sumRootToLeaf(TreeNode root) {
        result = 0;
        if (root == null) return 0;
        sum(root, 0);
        return result;
    }

    void sum(TreeNode root, int value) {
        if (root == null) return;
        int current = value * 2 + root.val;
        if (root.left == null && root.right == null) {
            result += current;
            return;
        }
        sum(root.right, current);
        sum(root.left, current);
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}