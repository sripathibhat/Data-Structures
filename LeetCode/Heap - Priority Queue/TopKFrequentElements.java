/*

    Given an integer array nums and an integer k, return the k most frequent elements. You may return the answer in any order.

*/

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        PriorityQueue<Pair> pq = new PriorityQueue<>(new Comparator<Pair>() {
            public int compare(Pair x, Pair y) {
                return x.getFirst() - y.getFirst();
            }
        });
        int res[] = new int[k];
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        for(Map.Entry<Integer,Integer> entry: map.entrySet()) {
            Pair pair = new Pair();
            pair.setFirst(entry.getValue());
            pair.setSecond(entry.getKey());
            pq.add(pair);
            if(pq.size() > k) {
                pq.remove();
            }
        }
        int i=0;
        while(pq.size() > 0) {
            Pair pair = pq.poll();
            res[i++] = pair.getSecond();
        }
        return res;
    }
}

public class Pair {
    private int first,second;
    
    int getFirst() {
        return first;
    }
    int getSecond() {
        return second;
    }
    void setFirst(int x) {
        first = x;
    }
    void setSecond(int y) {
        second = y;
    }
}