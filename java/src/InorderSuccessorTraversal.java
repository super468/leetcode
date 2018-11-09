public class InorderSuccessorTraversal {
    class Solution1 {
        /**
         * The inorder traversal of a BST is the nodes in ascending order.
         * To find a successor, you just need to find the smallest one that is larger than the given value since there are no duplicate values in a BST.
         * It just like the binary search in a sorted list.
         * The time complexity should be O(h) where h is the depth of the result node. succ is a pointer that keeps the possible successor.
         * Whenever you go left the current root is the new possible successor, otherwise the it remains the same.
         */
        public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
            TreeNode succ = null;
            while(root != null){
                if(root.val > p.val){
                    succ = root;
                    root = root.left;
                }
                else{
                    root = root.right;
                }
            }
            return succ;
        }
    }
    class Solution2{
        /**
         * the idea is the same. We just need to find the smallest element which is greater than the given node.
         * if given node is greater than the cur node, the target should be on the right side of the cur node.
         * if give node is smaller than the cur node, the cur node could be a potential successor unless you find a smaller one on its left side.
         * @param root
         * @param p
         * @return
         */
        public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
            if(root == null) return null;
            if(root.val <= p.val){
                return inorderSuccessor(root.right, p);
            }
            else{
                TreeNode left = inorderSuccessor(root.left, p);
                return (left != null) ? left:root;
            }
        }
    }
}
