class Solution:
    def convert(self, s, numRows):
        """

        we maintain two stacks to track the sequence of substrs.
        First, on each character, we append it to a new substr if iteration time is less than row number and put this substr to           the first stack A
        Second, once len of A is equal to row, as long as iteration goes on, pop A and push it to stack B except the first time.
        onece B reachs length of row, to the same thing as A.

        If iteration is over, join substr in the order as they were initialized.

        revision 1: No need to use stack, the built-in function reverse() of list is just fine.
        revision 2: Don't use reverse method. use the index trick

        :type s: str
        :type numRows: int
        :rtype: str
        """
        if len(s) <= numRows or numRows < 2:
            return s
        index, step = 0, 1
        list = [''] * numRows
        for char in s:
            list[index] += char
            if index == 0:
                step = 1
            elif index == numRows - 1:
                step = -1
            index += step
        return ('').join(list)