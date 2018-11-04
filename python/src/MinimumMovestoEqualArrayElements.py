class Solution:
    def minMoves(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """

        """
        the idea is that since the goal we are going to achieve is to increase elements to make the array same.
        
        but if we decrease the element and make them same, the final value is the minimum value at first.
        
        the movements would be the sum of the each element's movements through the process.
        
        sum(array) - n * mim
        """

        return sum(nums) - min(nums) * len(nums)
