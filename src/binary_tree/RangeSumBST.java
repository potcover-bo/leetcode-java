package binary_tree;

public class RangeSumBST {
    int res = 0;
    public int rangeSumBST(TreeNode root, int low, int high) {
        rangeSum(root, low, high);
        return res;
    }

    private void rangeSum(TreeNode root, int low, int high) {
        if (root == null) {
            return;
        }
        if (root.val <= high && root.val >= low) {
            res += root.val;
        }
        rangeSum(root.left, low, high);
        rangeSum(root.right, low, high);
    }

    /**
     * 减去不必要的部分
     * @param root
     * @param low
     * @param high
     * @return
     */
    public int rangeSum2(TreeNode root, int low, int high) {
        if (root == null) {
            return 0;
        }
        if (root.val > high) {
            return rangeSum2(root.left, low, high);
        }

        if (root.val < low) {
            return rangeSum2(root.right, low, high);
        }

        return rangeSum2(root.left, low, high) + rangeSum2(root.right, low, high) + root.val;
    }
}
