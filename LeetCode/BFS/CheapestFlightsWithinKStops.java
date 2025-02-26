/*

There are n cities connected by some number of flights. You are given an array flights where flights[i] = [fromi, toi, pricei] indicates that there is a flight from city fromi to city toi with cost pricei.

You are also given three integers src, dst, and k, return the cheapest price from src to dst with at most k stops. If there is no such route, return -1.

Example 1:


Input: n = 4, flights = [[0,1,100],[1,2,100],[2,0,100],[1,3,600],[2,3,200]], src = 0, dst = 3, k = 1
Output: 700
Explanation:
The graph is shown above.
The optimal path with at most 1 stop from city 0 to 3 is marked in red and has cost 100 + 600 = 700.
Note that the path through cities [0,1,2,3] is cheaper but is invalid because it uses 2 stops.
Example 2:


Input: n = 3, flights = [[0,1,100],[1,2,100],[0,2,500]], src = 0, dst = 2, k = 1
Output: 200
Explanation:
The graph is shown above.
The optimal path with at most 1 stop from city 0 to 2 is marked in red and has cost 100 + 100 = 200.
Example 3:


Input: n = 3, flights = [[0,1,100],[1,2,100],[0,2,500]], src = 0, dst = 2, k = 0
Output: 500
Explanation:
The graph is shown above.
The optimal path with no stops from city 0 to 2 is marked in red and has cost 500.

*/

class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        Map<Integer, Set<Flight>> map = buildGraph(flights);
        int distance[] = new int[n];
        Queue<Flight> q = new LinkedList<>();
        q.add(new Flight(src, 0));
        int level = k + 1;
        int res = Integer.MAX_VALUE;

        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                Flight flight = q.poll();
                if (flight.target == dst) {
                    res = Math.min(res, flight.price);
                    continue;
                }
                int cur = flight.target;
                if (map.containsKey(cur)) {
                    for (Flight neighbour: map.get(cur)) {
                        if (distance[neighbour.target] != 0 && neighbour.price + flight.price > distance[neighbour.target]) {
                            continue;
                        }
                        distance[neighbour.target] = neighbour.price + flight.price;
                        q.add(new Flight(neighbour.target, distance[neighbour.target]));
                    }
                }
            }
            if (level == 0) {
                break;
            }
            level--;
        }

        return res == Integer.MAX_VALUE ? -1 : res;
    }

    private Map<Integer, Set<Flight>> buildGraph(int flights[][]) {
        Map<Integer, Set<Flight>> map = new HashMap<>();
        for (int flight[]: flights) {
            map.putIfAbsent(flight[0], new HashSet<>());
            map.get(flight[0]).add(new Flight(flight[1], flight[2]));
        }
        return map;
    }

    class Flight {
        int target;
        int price;
        Flight(int target, int price) {
            this.target = target;
            this.price = price;
        }
    }
}
