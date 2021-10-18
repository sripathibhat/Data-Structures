/*

    Given an integer numRows, return the first numRows of Pascal's triangle.

    In Pascal's triangle, each number is the sum of the two numbers directly above it as shown:

*/

class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        for(int i = 0; i < numRows; i++) {
            List<Integer> curRow = new ArrayList<>();
            curRow.add(1);
            if(i != 0) {
                List<Integer> prevRow = res.get(i - 1);
                for(int j = 1; j < i; j++) {
                    curRow.add(prevRow.get(j - 1) + prevRow.get(j));
                }
                curRow.add(1);
            }
            res.add(curRow);
        }
        return res;
    }
}