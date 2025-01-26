/*

A company is organizing a meeting and has a list of n employees, waiting to be invited. They have arranged for a large circular table, capable of seating any number of employees.

The employees are numbered from 0 to n - 1. Each employee has a favorite person and they will attend the meeting only if they can sit next to their favorite person at the table.
The favorite person of an employee is not themself.

Given a 0-indexed integer array favorite, where favorite[i] denotes the favorite person of the ith employee, return the maximum number of employees that can be invited to the meeting.

 

Example 1:


Input: favorite = [2,2,1,2]
Output: 3
Explanation:
The above figure shows how the company can invite employees 0, 1, and 2, and seat them at the round table.
All employees cannot be invited because employee 2 cannot sit beside employees 0, 1, and 3, simultaneously.
Note that the company can also invite employees 1, 2, and 3, and give them their desired seats.
The maximum number of employees that can be invited to the meeting is 3. 
Example 2:

Input: favorite = [1,2,0]
Output: 3
Explanation: 
Each employee is the favorite person of at least one other employee, and the only way the company can invite them is if they invite every employee.
The seating arrangement will be the same as that in the figure given in example 1:
- Employee 0 will sit between employees 2 and 1.
- Employee 1 will sit between employees 0 and 2.
- Employee 2 will sit between employees 1 and 0.
The maximum number of employees that can be invited to the meeting is 3.
Example 3:


Input: favorite = [3,0,1,4,1]
Output: 4
Explanation:
The above figure shows how the company will invite employees 0, 1, 3, and 4, and seat them at the round table.
Employee 2 cannot be invited because the two spots next to their favorite employee 1 are taken.
So the company leaves them out of the meeting.
The maximum number of employees that can be invited to the meeting is 4.

*/

class Solution {
    public int maximumInvitations(int[] favorite) {
        int n = favorite.length;
        List<List<Integer>> invertedGraph = new ArrayList<>(n);
        // Build the inverted graph where each node points to its admirers
        for (int i = 0; i < n; i++) {
            invertedGraph.add(new ArrayList<>());
        }
        for (int i = 0; i < n; i++) {
            invertedGraph.get(favorite[i]).add(i);
        }

        int longestCycle = 0;
        int twoCycleInvitations = 0;
        boolean visited[] = new boolean[n];

        // Final all cycles in the graph
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                // Track visited persons and their distances
                Map<Integer, Integer> visitedPersons = new HashMap<>();
                int cur = i;
                int dist = 0;
                while (true) {
                    if (visited[cur]) {
                        break;
                    }
                    visited[cur] = true;
                    visitedPersons.put(cur, dist++);
                    int next = favorite[cur];

                    // Cycle detected
                    if (visitedPersons.containsKey(next)) {
                        int cycleLen = dist - visitedPersons.get(next);
                        longestCycle = Math.max(longestCycle, cycleLen);
                        // Handle cycles of length 2
                        if (cycleLen == 2) {
                            Set<Integer> visitedNodes = new HashSet<>();
                            visitedNodes.add(cur);
                            visitedNodes.add(next);
                            twoCycleInvitations += 2 + bfs(next, visitedNodes, invertedGraph) + bfs(cur, visitedNodes, invertedGraph);
                        }
                        break;
                    }
                    cur = next;
                }
            }
        }
        return Math.max(longestCycle, twoCycleInvitations);
    }

    private int bfs(int s, Set<Integer> visitedNodes, List<List<Integer>> invertedGraph) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {s, 0});
        int maxDist = 0;
        while (!q.isEmpty()) {
            int cur[] = q.poll();
            int curNode = cur[0];
            int curDist = cur[1];
            for (int nei: invertedGraph.get(curNode)) {
                if (visitedNodes.contains(nei)) {
                    continue;
                }
                visitedNodes.add(nei);
                q.add(new int[] {nei, curDist + 1});
                maxDist = Math.max(maxDist, curDist + 1);
            }
        }
        return maxDist;
    }
}
