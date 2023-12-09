import java.util.ArrayList;
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

    public int deepestLeavesSum(TreeNode root) {
        Queue<TreeNode> que = new LinkedList<>();
        int res = 0;

        que.offer(root);

        while (!que.isEmpty()) {
            List<Integer> itemList = new ArrayList<Integer>();
            int size = que.size();
            res = 0;

            while (size > 0) {
                TreeNode tmpNode = que.poll();
                itemList.add(tmpNode.val);

                if (tmpNode.left != null)
                    que.offer(tmpNode.left);
                if (tmpNode.right != null)
                    que.offer(tmpNode.right);

                size--;
            }

            for (int item : itemList) {
                res += item;
            }
        }
        return res;
    }
}
