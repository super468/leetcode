#Definition for a binary tree node.
class TreeNode(object):
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

class Codec:

    def serialize(self, root):
        """Encodes a tree to a single string.
        pre-order tarvesral
        bfs
        :type root: TreeNode
        :rtype: str
        """
        def serialhelper(self, root):
            if root:
                value.append(str(root.val))
                serialhelper(root.left)
                serialhelper(root.right)
            else:
                value.append('#')
        value = []
        serialhelper(root)
        return " ".join(value)


    def deserialize(self, data):
        """Decodes your encoded data to tree.

        :type data: str
        :rtype: TreeNode
        """
        def deserialhelper(self):
            val = next(vals)
            if val == '#':
                return None
            else:
                node = TreeNode(int(val))
                node.left = deserialhelper()
                node.right = deserialhelper()
                return node

        vals = iter(data.split())
        return deserialhelper()


if __name__ == "__main__":

#Your Codec object will be instantiated and called as such:
    codec = Codec()
    #codec.deserialize(codec.serialize(root))