class Solution {
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int i = 0; i < n; i++) {         
            List<Integer> emps = map.getOrDefault(manager[i], new ArrayList<>());
            emps.add(i);
            map.put(manager[i], emps);
        }
        
        Queue<Employee> q = new LinkedList<>();
        int time = 0;
        q.add(new Employee(headID, informTime[headID]));
        while(!q.isEmpty()) {
            int size = q.size();
            for(int i = 0; i < size; i++) {
                Employee e = q.poll();
                int empId = e.id;
                time = Math.max(time, e.time);
                if(map.containsKey(empId)) {
                    for(int id: map.get(empId)) {
                        q.add(new Employee(id, e.time + informTime[id]));
                    }
                }
            }
        }
        return time;
    }
    
    class Employee {
        int id;
        int time;
        Employee(int i, int t) {
            id = i;
            time = t;
        }
    }

}