class Solution {
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int i = 0; i < n; i++) {         
            List<Integer> emps = map.getOrDefault(manager[i], new ArrayList<>());
            emps.add(i);
            map.put(manager[i], emps);
        }
        
        return dfs(headID, informTime, map);
    }
    
    private int dfs(int head, int[] informTime, Map<Integer, List<Integer>> map) {
        int maxTimeOfSubordinate = 0;
        if(map.containsKey(head)) {
            for(int nei: map.get(head)) {
                maxTimeOfSubordinate = Math.max(maxTimeOfSubordinate, dfs(nei, informTime, map));
            }
            return maxTimeOfSubordinate + informTime[head];
        }
        return 0;
    }
}