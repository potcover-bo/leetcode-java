package binary_tree;

/**
 * 给定一个有序整数数组，元素各不相同且按升序排列，编写一个算法，创建一棵高度最小的二叉搜索树。
 */
public class SortedArrayToBST {
    public TreeNode sortedArrayToBST(int[] nums) {
        return sortedArrayToBST(nums, 0, nums.length - 1);
    }

    private TreeNode sortedArrayToBST(int[] nums, int l, int r) {
        // important
        if (l > r) {
            return null;
        }else {
            int mid = l + (r - l) / 2;
            TreeNode node = new TreeNode(nums[mid]);
            node.left = sortedArrayToBST(nums, l, mid - 1);
            node.right = sortedArrayToBST(nums, mid + 1, r);
            return node;
        }
    }
}
