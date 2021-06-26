""" 1649 """
from sortedcontainers import SortedList
class Solution(object):
    def createSortedArray(self, instructions):
        """
        :type instructions: List[int]
        :rtype: int
        """
        arr = SortedList()
        total = 0
        mod = 10**9 + 7
        for x in instructions:
            left = arr.bisect_left(x)
            right = len(arr) - arr.bisect_right(x)
            total += min(left, right)
            total = total % mod
            arr.add(x)
        return total
        