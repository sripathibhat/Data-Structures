class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList();
        solve(nums, new ArrayList<>(), res);
        return res;
    }
    
    private void solve(int ip[], List<Integer> op, List<List<Integer>> res) {
        if(ip.length == 0) {
            res.add(new ArrayList(op));
            return;
        }
        // Make 2 choices 
        // 1 - include nums[0]
        // 2 - do not include nums[0]
        List<Integer> op1 = clone(op);
        List<Integer> op2 = clone(op);
        op2.add(ip[0]);
        int newip[] = new int[ip.length - 1];
        for(int i = 0; i < newip.length; i++) {
            newip[i] = ip[i + 1];
        }
        solve(newip, op1, res);
        solve(newip, op2, res);
    }
    
    private List<Integer> clone(List<Integer> l) {
        List<Integer> list = new ArrayList<>();
        for(int i: l) {
            list.add(i);
        }
        return list;
    }
}