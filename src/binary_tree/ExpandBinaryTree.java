package binary_tree;

/**
 * 67题
 * 力扣嘉年华上的 DIY 手工展位准备了一棵缩小版的 二叉 装饰树 root 和灯饰，你需要将灯饰逐一插入装饰树中，要求如下：
 *
 * 完成装饰的二叉树根结点与 root 的根结点值相同
 * 若一个节点拥有父节点，则在该节点和他的父节点之间插入一个灯饰（即插入一个值为 -1 的节点）。具体地：
 * 在一个 父节点 x 与其左子节点 y 之间添加 -1 节点， 节点 -1、节点 y 为各自父节点的左子节点，
 * 在一个 父节点 x 与其右子节点 y 之间添加 -1 节点， 节点 -1、节点 y 为各自父节点的右子节点，
 * 现给定二叉树的根节点 root ，请返回完成装饰后的树的根节点。
 * 示例 1：
 *
 * 输入：
 * root = [7,5,6]
 *
 * 输出：[7,-1,-1,5,null,null,6]
 *
 */
public class ExpandBinaryTree {
    public TreeNode expandBinaryTree(TreeNode root) {
        if (root == null) {
            return null;
        }

        if (root.left != null) {
            TreeNode leftInsertNode = new TreeNode(-1);
            TreeNode leftNode = root.left;
            root.left = leftInsertNode;
            leftInsertNode.left = expandBinaryTree(leftNode);
        }

        if (root.right != null) {
            TreeNode rightInsertNode = new TreeNode(-1);
            TreeNode rightNode = root.right;
            root.right = rightInsertNode;
            rightInsertNode.right = expandBinaryTree(rightNode);
        }

        return root;
    }
}
