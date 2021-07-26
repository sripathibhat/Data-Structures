class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        // NGR
        Stack<Integer> stack = new Stack<>();
        List<Integer> res = new ArrayList<>();
        int n = temperatures.length;
        for(int i = n - 1; i >= 0; i--) {
            if(stack.isEmpty()) {
                res.add(0);
            }
            else if(temperatures[stack.peek()] > temperatures[i]) {
                res.add(stack.peek() - i);
            }
            else {
                while(!stack.isEmpty() && temperatures[stack.peek()] <= temperatures[i]) {
                    stack.pop();
                }
                if(stack.isEmpty()) {
                    res.add(0);
                }
                else {
                    res.add(stack.peek() - i);
                }
            }
            stack.push(i);
        }
        int ans[] = new int[res.size()];
        for(int i = 0; i < ans.length; i++) {
            ans[n - i - 1] = res.get(i);
        }
        return ans;
    }
}