import java.util.LinkedList;
import java.util.Queue;

class Solution {
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

    public int minDepth(TreeNode root) {

        if (root == null)
            return 0;

        Queue<TreeNode> que = new LinkedList<>();

        que.offer(root);
        int depth = 0;

        while (!que.isEmpty()) {
            int size = que.size();
            depth++; // current depth

            while (size > 0) {
                TreeNode tmpNode = que.poll();

                if (tmpNode.left == null && tmpNode.right == null)
                    return depth;

                if (tmpNode.left != null)
                    que.add(tmpNode.left);
                if (tmpNode.right != null)
                    que.add(tmpNode.right);

                size--;
            }
        }
        return depth;

    }
}