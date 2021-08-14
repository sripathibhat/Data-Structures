class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        solve(candidates, 0, target, new ArrayList<>(), res);
        return res;
    }
    
    private void solve(int[] cand, int index, int target, List<Integer> cur, List<List<Integer>> res) {
        if(target < 0 || index == cand.length) {
            return;
        }
        if(target == 0) {
            res.add(new ArrayList<>(cur));
            return;
        }
        if(cand[index] <= target) {
            cur.add(cand[index]);
            solve(cand, index, target - cand[index], cur, res);
            cur.remove(cur.size() - 1);
            solve(cand, index + 1, target, cur, res);
        }
        else {
            solve(cand, index + 1, target, cur, res);
        }
    }
}