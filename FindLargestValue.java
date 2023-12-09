import java.util.LinkedList;
import java.util.List;
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

    public List<Integer> largestValues(TreeNode root) {

        List<Integer> res = new LinkedList<>();
        Queue<TreeNode> que = new LinkedList<>();

        if (root == null)
            return res;

        que.offer(root);

        while (!que.isEmpty()) {
            int size = que.size();
            int max = Integer.MIN_VALUE;

            while (size > 0) {
                TreeNode tmpNode = que.poll();
                max = Math.max(max, tmpNode.val);

                if (tmpNode.left != null)
                    que.add(tmpNode.left);
                if (tmpNode.right != null)
                    que.add(tmpNode.right);

                size--;
            }
            res.add(max);
        }
        return res;
    }
}