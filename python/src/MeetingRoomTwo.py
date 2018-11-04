class Interval:
    def __init__(self, s=0, e=0):
        self.start = s
        self.end = e


class Solution:
    def minMeetingRooms(self, intervals):
        """
        the idea is that we sort the interval by their start times.
        then iterate the intervals, each interval will check the earliest room which is going to close.
        if that room's end time is before the interval's start time, then arrange the room for that interval.
        otherwise, open a new room to match that interval.

        this is a greedy solution.
        we need to maintain a min heap to find the earliest room to be closed on each iteration.
        that part of time complexity is O(nlogn)

        Also the sort at first is O(nlogn)
        So the final time complexity is O(nlogn)


        :type intervals: List[Interval]
        :rtype: int
        """
        intervals.sort(key=lambda interval: interval.start)
        heap = []
        for interval in intervals:
            if heap and interval.start >= heap[0]:
                heapq.heapreplace(heap, interval.end)
            else:
                heapq.heappush(heap, interval.end)
        return len(heap)

