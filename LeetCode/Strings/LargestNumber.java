/*

Given a list of non-negative integers nums, arrange them such that they form the largest number and return it.

Since the result may be very large, so you need to return a string instead of an integer.

Example 1:

Input: nums = [10,2]
Output: "210"
Example 2:

Input: nums = [3,30,34,5,9]
Output: "9534330"

*/

class Solution {
    public String largestNumber(int[] nums) {
        List<String> str = new ArrayList<>();
        boolean onlyZeroes = true;
        for (int x: nums) {
            String s = String.valueOf(x);
            if (!s.equals("0")) {
                onlyZeroes = false;
            }
            str.add(s);
        }
        if (onlyZeroes) {
            return "0";
        }
        Collections.sort(str, (a, b) -> {
            return (b + a).compareTo(a + b);
        });
        StringBuilder sb = new StringBuilder();
        for (String s: str) {
            sb.append(s);
        }
        return sb.toString();
    }
}
