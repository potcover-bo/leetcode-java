package binary_tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 103
 *给你二叉树的根节点 root ，返回其节点值的 锯齿形层序遍历 。（
 * 即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
 */
public class ZigzagLevelOrder {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        boolean flag = true;
        while (!queue.isEmpty()) {
            ArrayList<Integer> temp = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                if (flag) {
                    TreeNode cur = queue.remove();
                    temp.add(cur.val);
                    if (cur.left != null) {
                        queue.add(cur.left);
                    }
                    if (cur.right != null) {
                        queue.add(cur.right);
                    }
                }else {
                    TreeNode cur = queue.removeLast();
                    temp.add(cur.val);

                    if (cur.right != null) {
                        queue.addFirst(cur.right);
                    }
                    if (cur.left != null) {
                        queue.addFirst(cur.left);
                    }
                }
            }

            res.add(temp);
            flag = !flag;
        }

        return res;

    }
}
