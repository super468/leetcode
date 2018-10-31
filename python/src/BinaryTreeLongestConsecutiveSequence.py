#Definition for a binary tree node.
class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


class Solution:
    def longestConsecutive(self, root):
        """
        the idea is to use dfs find the max length of sequence of each node, and see if the cur node can append in this
        sequence and make the length plus one. during the dfs process, we use the global variable max to store the longest length.

        revision: no use gloable variable using the count

        :type root: TreeNode
        :rtype: int
        """
        if root:
            return self.traversal(root, 0, root.val)
        else:
            return 0
    def traversal(self, root, count, val):
        if root is None:
            return count
        count = count + 1 if root.val - val == 1 else 1
        left = self.traversal(root.left, count, root.val)
        right = self.traversal(root.right, count, root.val)
        return max(left, right, count)
