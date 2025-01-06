/*

You are given an array routes representing bus routes where routes[i] is a bus route that the ith bus repeats forever.

For example, if routes[0] = [1, 5, 7], this means that the 0th bus travels in the sequence 1 -> 5 -> 7 -> 1 -> 5 -> 7 -> 1 -> ... forever.
You will start at the bus stop source (You are not on any bus initially), and you want to go to the bus stop target. You can travel between bus stops by buses only.

Return the least number of buses you must take to travel from source to target. Return -1 if it is not possible.

Example 1:

Input: routes = [[1,2,7],[3,6,7]], source = 1, target = 6
Output: 2
Explanation: The best strategy is take the first bus to the bus stop 7, then take the second bus to the bus stop 6.
Example 2:

Input: routes = [[7,12],[4,5,15],[6],[15,19],[9,12,13]], source = 15, target = 12
Output: -1

*/

class Solution {
    public int numBusesToDestination(int[][] routes, int source, int target) {

        if (source == target) {
            return 0;
        }
        int n = routes.length;
        Map<Integer, List<Integer>> routeToBusMap = new HashMap();
        for (int i = 0; i < routes.length; i++) {
            for (int j = 0; j < routes[i].length; j++) {
                List<Integer> cur = routeToBusMap.getOrDefault(routes[i][j], new LinkedList());
                cur.add(i);
                routeToBusMap.put(routes[i][j], cur);
            }
        }
        if (!routeToBusMap.containsKey(source) || !routeToBusMap.containsKey(target)) {
            return -1;
        }

        Set<Integer> visitedBuses = new HashSet();
        Set<Integer> visitedStops = new HashSet();
        Queue<Integer> q = new LinkedList();
        q.add(source);
        int moves = 0;

        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int stop = q.poll();
                if (stop == target) {
                    return moves;
                }
                for (int bus: routeToBusMap.get(stop)) {
                    if (!visitedBuses.contains(bus)) {
                        visitedBuses.add(bus);
                        for (int route: routes[bus]) {
                            if (!visitedStops.contains(route)) {
                                visitedStops.add(route);
                                q.add(route);
                            }
                        }
                    }
                }
            }
            moves++;
        }
        
        return -1;
    }
}
