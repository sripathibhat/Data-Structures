class Solution {
    public int lengthOfLongestSubstring(String s) {
        int left = 0, right = 0;
        int max = 0;
        Map<Character, Integer> map = new HashMap<>();
        while (right < s.length()) {
            if (!map.containsKey(s.charAt(right))) {
                max = Math.max(max, right - left + 1);
            }
            else {
                int newLeft = map.get(s.charAt(right)) + 1;
                while (left < newLeft) {
                    map.remove(s.charAt(left++));
                }
                left = newLeft;
            }
            map.put(s.charAt(right), right);
            right++;
        }
        return max;
    }
}
