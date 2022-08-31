public class LeetCode998 {
    public TreeNode insertIntoMaxTree(TreeNode root, int val) {
        if (root.val < val) {
            return new TreeNode(val, root, null);
        }
        dfs(root, val);
        return root;
    }

    public void dfs(TreeNode node, int val) {
        if (node.right == null) {
            node.right = new TreeNode(val);
        } else if (node.right.val < val) {
            node.right = new TreeNode(val, node.right, null);
        } else {
            dfs(node.right, val);
        }
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
