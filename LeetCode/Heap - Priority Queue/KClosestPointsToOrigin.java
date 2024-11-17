class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<Point> pq = new PriorityQueue<>((a, b) -> b.dist - a.dist); // max heap
        for (int p[]: points) {
            int dist = p[0] * p[0] + p[1] * p[1];
            pq.add(new Point(dist, p[0], p[1]));
            if (pq.size() > k) {
                pq.poll();
            }
        }
        int closest[][] = new int[k][2];
        int i = 0;
        while (!pq.isEmpty()) {
            Point p = pq.poll();
            closest[i++] = new int[] {p.x, p.y};
        }
        return closest;
    }

    class Point {
        int dist;
        int x;
        int y;
        Point(int dist, int x, int y) {
            this.dist = dist;
            this.x = x;
            this.y = y;
        }
    }
}
