import java.util.ArrayList;
import java.util.List;

public class LeetCode655 {
    public List<List<String>> printTree(TreeNode root) {
        int height = getHeight(root);
        int m = height + 1;
        int n = (1 << (height + 1)) - 1;
        List<List<String>> res = new ArrayList<>();
        for (int i = 0; i < m; ++i) {
            List<String> row = new ArrayList<>();
            for (int j = 0; j < n; ++j) {
                row.add("");
            }
            res.add(row);
        }
        dfs(res, root, 0, (n - 1) / 2, height);
        return res;
    }


    public void dfs(List<List<String>> res, TreeNode root, int r, int c, int height) {
        res.get(r).set(c, Integer.toString(root.val));
        if (root.left != null) {
            dfs(res, root.left, r + 1, c - (1 << (height - r - 1)), height);
        }
        if (root.right != null) {
            dfs(res, root.right, r + 1, c + (1 << (height - r - 1)), height);
        }
    }


    public int getHeight(TreeNode root) {
        int height = 0;
        if (root.left != null) {
            height = Math.max(height, getHeight(root.left) + 1);
        }
        if (root.right != null) {
            height = Math.max(height, getHeight(root.right) + 1);
        }
        return height;
    }
}

class TreeNode {
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