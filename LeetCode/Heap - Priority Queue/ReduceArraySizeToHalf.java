class Solution {
    public int minSetSize(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i: arr) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[1] - a[1]);
        int len = arr.length / 2;
        for(Map.Entry<Integer, Integer> entry: map.entrySet()) {
            pq.add(new int[] { entry.getKey(), entry.getValue() });
        }
        int cnt = 0;
        int res = 0;
        while(cnt < len && !pq.isEmpty()) {
            cnt += pq.poll()[1];
            res++;
        }
        return res;
    }
}