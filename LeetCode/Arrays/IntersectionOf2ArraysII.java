class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i: nums1) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        List<Integer> res = new ArrayList<>();
        for(int i: nums2) {
            if(map.containsKey(i)) {
                res.add(i);
                int cnt = map.get(i);
                if(cnt == 1) {
                    map.remove(i);
                } else {
                    map.put(i, cnt - 1);
                }
            }
        }
        int arr[] = new int[res.size()];
        int k = 0;
        for(int i: res) {
            arr[k++] = i;
        }
        return arr;
    }
}