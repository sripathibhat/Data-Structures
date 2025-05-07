/**

Given a collection of numbers, nums, that might contain duplicates, return all possible unique permutations in any order. 

Example 1:

Input: nums = [1,1,2]
Output:
[[1,1,2],
 [1,2,1],
 [2,1,1]]


Example 2:

Input: nums = [1,2,3]
Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]

*/

class Solution {
    private Map<Integer, Integer> map;
    private List<List<Integer>> res;

    public List<List<Integer>> permuteUnique(int[] nums) {
        res = new ArrayList<>();
        map = new HashMap<>();
        for (int num: nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        List<Integer> perm = new ArrayList<>();
        dfs(nums, perm);
        return res;
    }

    private void dfs(int[] nums, List<Integer> perm) {
        if (perm.size() == nums.length) {
            res.add(new ArrayList<>(perm));
            return;
        }

        for (Map.Entry<Integer, Integer> entry: map.entrySet()) {
            if (entry.getValue() > 0) {
                map.put(entry.getKey(), entry.getValue() - 1);
                perm.add(entry.getKey());
                dfs(nums, perm);
                map.put(entry.getKey(), entry.getValue() + 1);
                perm.remove(perm.size() - 1);
            }
        }
    }
}
