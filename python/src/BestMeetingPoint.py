class Solution:
    def minTotalDistance(self, grid):
        """
        the point is that median can minimize the total distance of different points.
        the math explanation is https://leetcode.com/problems/best-meeting-point/discuss/74217/The-theory-behind-(why-the-median-works)
        the more human language version is that there are two groups of people, it will decrease the distance if you put the point
        closer to the group with more people. At end of the day, the two sides will be equal.
        :type grid: List[List[int]]
        :rtype: int
        """
        list_y = []
        list_x = []
        for row in range(0, len(grid)):
            for col in range(0, len(grid[row])):
                if grid[row][col] == 1:
                    list_y.append(row)
                    list_x.append(col)
        list_y.sort()
        list_x.sort()
        median_y = list_y[int(len(list_y) / 2)]
        median_x = list_x[int(len(list_x) / 2)]
        sum_y = 0
        for y in list_y:
            sum_y += median_y - y if median_y > y else y - median_y
        sum_x = 0
        for x in list_x:
            sum_x += median_x - x if median_x > x else x - median_x
        return sum_x + sum_y
