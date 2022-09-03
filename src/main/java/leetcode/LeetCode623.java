package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.stream.Stream;

public class LeetCode623 {
    public static void main(String[] args) {

    }

    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        if (depth == 1) {
            return new TreeNode(val, root, null);
        } else {

            ArrayList<TreeNode> list = new ArrayList<TreeNode>() {{
                add(root);
            }};

            Stream<TreeNode> nodeStream = list.stream();

            for (int i = 2; i < depth; i++) {
                nodeStream = nodeStream.flatMap(x -> {
                    LinkedList<TreeNode> nodes = new LinkedList<>();
                    if (x.left != null) {
                        nodes.add(x.left);
                    }
                    if (x.right != null) {
                        nodes.add(x.right);
                    }
                    return nodes.stream();
                });
            }
            nodeStream.forEach(x -> {
                x.left = new TreeNode(val, x.left, null);
                x.right = new TreeNode(val, null, x.right);
            });

            return root;
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
