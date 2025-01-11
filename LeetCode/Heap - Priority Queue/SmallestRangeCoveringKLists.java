/**

You have k lists of sorted integers in non-decreasing order. Find the smallest range that includes at least one number from each of the k lists.

We define the range [a, b] is smaller than range [c, d] if b - a < d - c or a < c if b - a == d - c.

Example 1:

Input: nums = [[4,10,15,24,26],[0,9,12,20],[5,18,22,30]]
Output: [20,24]
Explanation: 
List 1: [4, 10, 15, 24,26], 24 is in range [20,24].
List 2: [0, 9, 12, 20], 20 is in range [20,24].
List 3: [5, 18, 22, 30], 22 is in range [20,24].
Example 2:

Input: nums = [[1,2,3],[1,2,3],[1,2,3]]
Output: [1,1]

*/

class Solution {
    public int[] smallestRange(List<List<Integer>> nums) {
        // Min heap: stores (value, list index, element index)
        PriorityQueue<ValListElement> pq = new PriorityQueue<>((a, b) -> a.val - b.val);
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < nums.size(); i++) {
            List<Integer> list = nums.get(i);
            ValListElement vle = new ValListElement(list.get(0), i, 0);
            pq.add(vle);
            max = Math.max(max, list.get(0));
            min = Math.min(min, list.get(0));
        }
        int res[] = new int[] {min, max};
        while (true) {
            ValListElement vle = pq.poll();
            min = vle.val;
            int listIndex = vle.listIndex;
            int elementIndex = vle.elementIndex;
            if (res[1] - res[0] > max - min) {
                res[1] = max;
                res[0] = min;
            }
            // Move to the next element in the same list
            if (elementIndex == nums.get(listIndex).size() - 1) {
                break;
            }
            int nextVal = nums.get(listIndex).get(elementIndex + 1);
            ValListElement nextVle = new ValListElement(nextVal, listIndex, elementIndex + 1);
            pq.add(nextVle);
            max = Math.max(max, nextVal);
        }
        return res;
    }

    class ValListElement {
        int val;
        int listIndex;
        int elementIndex;

        ValListElement(int v, int listI, int eleI) {
            val = v;
            listIndex = listI;
            elementIndex = eleI;
        }
    }
}

