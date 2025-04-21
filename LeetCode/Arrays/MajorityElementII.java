/**

Given an integer array of size n, find all elements that appear more than ⌊ n/3 ⌋ times.
 

Example 1:

Input: nums = [3,2,3]
Output: [3]


Example 2:

Input: nums = [1]
Output: [1]


Example 3:

Input: nums = [1,2]
Output: [1,2]

*/

class Solution {
    public List<Integer> majorityElement(int[] nums) {

        // Using HashMap
        Map<Integer, Integer> map = new HashMap();
        Map<Integer, Integer> newMap = new HashMap();
        List<Integer> res = new ArrayList<>();

        for (int i: nums) {
            map.put(i, map.getOrDefault(i, 0) + 1);
            if (map.size() > 2) {
                for (Map.Entry<Integer, Integer> entry: map.entrySet()) {
                    if (entry.getValue() > 1) {
                        newMap.put(entry.getKey(), entry.getValue() - 1);
                    }
                }
            }
        }

        for (Map.Entry<Integer, Integer> entry: map.entrySet()) {
            int count = 0;
            int key = entry.getKey();
            for (int i: nums) {
                if (i == key) {
                    count++;
                }
            }
            if (count > nums.length / 3) {
                res.add(key);
            }
        }

        return res;

        // Without hashmap, no difference in complexity.

        // int majority1 = 0;
        // int majority2 = 0;
        // int count1 = 0;
        // int count2 = 0;

        // for (int num : nums) {
        //     if (num == majority1) {
        //         count1++;
        //     } else if (num == majority2) {
        //         count2++;
        //     } else if (count1 == 0) {
        //         majority1 = num;
        //         count1++;
        //     } else if (count2 == 0) {
        //         majority2 = num;
        //         count2++;
        //     } else {
        //         count1--;
        //         count2--;
        //     }
        // }

        // count1 = 0;
        // count2 = 0;

        // for (int num : nums) {
        //     if (num == majority1) {
        //         count1++;
        //     } else if (num == majority2) {
        //         count2++;
        //     }
        // }

        // List<Integer> res = new ArrayList<>();
        // int n = nums.length;

        // if (count1 > n / 3) {
        //     res.add(majority1);
        // }
        // if (count2 > n / 3) {
        //     res.add(majority2);
        // }

        // return res;        
    }
}
