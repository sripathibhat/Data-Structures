/**

There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1. You are given an array prerequisites where prerequisites[i] = [ai, bi]
indicates that you must take course ai first if you want to take course bi.

For example, the pair [0, 1] indicates that you have to take course 0 before you can take course 1.
Prerequisites can also be indirect. If course a is a prerequisite of course b, and course b is a prerequisite of course c, then course a is a prerequisite of course c.

You are also given an array queries where queries[j] = [uj, vj]. For the jth query, you should answer whether course uj is a prerequisite of course vj or not.

Return a boolean array answer, where answer[j] is the answer to the jth query.

 

Example 1:


Input: numCourses = 2, prerequisites = [[1,0]], queries = [[0,1],[1,0]]
Output: [false,true]
Explanation: The pair [1, 0] indicates that you have to take course 1 before you can take course 0.
Course 0 is not a prerequisite of course 1, but the opposite is true.
Example 2:

Input: numCourses = 2, prerequisites = [], queries = [[1,0],[0,1]]
Output: [false,false]
Explanation: There are no prerequisites, and each course is independent.
Example 3:


Input: numCourses = 3, prerequisites = [[1,2],[1,0],[2,0]], queries = [[1,0],[1,2]]
Output: [true,true]

*/

class Solution {
    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            adjList.add(new ArrayList<>());
        }
        for (int i = 0; i < prerequisites.length; i++) {
            adjList.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }
        Map<Integer, Set<Integer>> preReqMap = new HashMap<>();
        for (int i = 0; i < numCourses; i++) {
            dfs(i, preReqMap, adjList);
        }
        List<Boolean> res = new ArrayList<>();
        for (int i = 0; i < queries.length; i++) {
            res.add(preReqMap.getOrDefault(queries[i][1], new HashSet<>()).contains(queries[i][0]));
        }
        return res;
    }

    private Set<Integer> dfs(int i, Map<Integer, Set<Integer>> preReqMap, List<List<Integer>> adjList) {
        if (!preReqMap.containsKey(i)) {
            preReqMap.put(i, new HashSet<>());
            for (int preReq: adjList.get(i)) {
                preReqMap.get(i).addAll(dfs(preReq, preReqMap, adjList));
            }
            preReqMap.get(i).add(i);
        }
        return preReqMap.get(i);
    }
}
