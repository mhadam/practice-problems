# Definition for a binary tree node.
import collections
import itertools
import json
import math
from typing import Optional, Generator, Iterator


class TreeNode(object):
    def __init__(self, x, left=None, right=None):
        self.val = x
        self.left = left
        self.right = right


class Codec:
    def serialize(self, root):
        """Encodes a tree to a single string.

        :type root: TreeNode
        :rtype: str
        """
        h = []
        c = itertools.count()
        t = [root]
        while len(t) > 0:
            el = t.pop(0)
            try:
                h.append(el.val)
            except AttributeError:
                h.append(el)
                continue
            if el.left:
                t.append(el.left)
            else:
                t.append(None)
            if el.right:
                t.append(el.right)
            else:
                t.append(None)
        try:
            while h[-1] is None:
                h.pop()
        except IndexError:
            pass
        return json.dumps(h)

    def deserialize(self, data):
        """Decodes your encoded data to tree.

        :type data: str
        :rtype: TreeNode
        """
        a = json.loads(data)
        try:
            head = TreeNode(a.pop(0))
        except IndexError:
            return
        l = 2
        total = 2
        while total < len(a):
            l *= 2
            total += l
        if total != len(a):
            leftover = total - len(a)
            a.extend([None] * leftover)
        prev = [head]
        l = 2
        while l <= len(a):
            layer = a[:l]
            next_prev = []
            for i, el in enumerate(layer):
                if el is None:
                    el = 'null'
                if i % 2 == 0:
                    prev[i // 2].left = TreeNode(el)
                    next_prev.append(prev[i // 2].left)
                else:
                    prev[i // 2].right = TreeNode(el)
                    next_prev.append(prev[i // 2].right)
            del a[:l]
            prev = next_prev
            l *= 2
        return head


class RecursiveCodec:
    def serialize(self, root: 'TreeNode') -> str:
        """Encodes a tree to a single string."""
        s = []

        def preorder(root: 'TreeNode') -> None:
            if not root:
                s.append('n')
                return

            s.append(str(root.val))
            preorder(root.left)
            preorder(root.right)

        preorder(root)
        return ' '.join(s)

    def deserialize(self, data: str) -> 'TreeNode':
        """Decodes your encoded data to tree."""
        q = collections.deque(data.split())

        def preorder() -> 'TreeNode':
            s = q.popleft()
            if s == 'n':
                return None

            root = TreeNode(s)
            root.left = preorder()
            root.right = preorder()
            return root

        return preorder()


# Your Codec object will be instantiated and called as such:
# de = Codec().deserialize('[1,2,3,null,null,4,5]')
# result = Codec().serialize(de)
#
# de = Codec().deserialize('[1,2]')
# result = Codec().serialize(de)

de = RecursiveCodec().deserialize('1 2 n n 3 n 4 n n')
result = RecursiveCodec().serialize(de)

pass
