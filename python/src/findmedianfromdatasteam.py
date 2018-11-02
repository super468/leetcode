import heapq
class MedianFinder:
    """
    we have 3 solutions to find the median of the data stream
    1. max-min heap
    2. bst
    3. insert sort
    """

    class Solution1:
        """
        we maintain two heap, one max heap stores the larger half of the data, one min heap stores the smaller half of the data.
        when data is coming, we just need to maintain the difference of numbers between those two heaps is at most 1.
        Note we can make the insertion number negative to maintain a min heap.
        """

        def __init__(self):
            """
            initialize your data structure here.
            """
            self.heaps = [], []

        def addNum(self, num):
            """
            :type num: int
            :rtype: void
            """
            small, large = self.heaps
            heapq.heappush(small, -heapq.heappushpop(large, num))
            if len(small) > len(large):
                heapq.heappush(large, -heapq.heappop(small))

        def findMedian(self):
            """
            :rtype: float
            """
            small, large = self.heaps
            if len(large) > len(small):
                return float(large[0])
            return (large[0] - small[0]) / 2.0
