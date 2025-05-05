/**

You are given an integer array matchsticks where matchsticks[i] is the length of the ith matchstick. You want to use all the matchsticks to make one square.
You should not break any stick, but you can link them up, and each matchstick must be used exactly one time.

Return true if you can make this square and false otherwise.

Example 1:

Input: matchsticks = [1,1,2,2,2]
Output: true
Explanation: You can form a square with length 2, one side of the square came two sticks with length 1.

Example 2:

Input: matchsticks = [3,3,3,3,4]
Output: false
Explanation: You cannot find a way to form a square with all the matchsticks.

*/

class Solution {
    public boolean makesquare(int[] matchsticks) {
        int totalLength = Arrays.stream(matchsticks).sum();

        if (totalLength % 4 != 0) {
            return false;
        }
        
        int length = totalLength / 4;
        int[] sides = new int[4];
        Arrays.sort(matchsticks);
        reverse(matchsticks);
        
        return dfs(matchsticks, sides, 0, length);
    }
    
    private boolean dfs(int[] matchsticks, int[] sides, int index, int length) {
        if (index == matchsticks.length) {
            return true;
        }
        
        for (int i = 0; i < 4; i++) {
            if (sides[i] + matchsticks[index] <= length) {
                sides[i] += matchsticks[index];
                if (dfs(matchsticks, sides, index + 1, length)) {
                    return true;
                }
                sides[i] -= matchsticks[index];
            }
            
            if (sides[i] == 0) {
                break;
            }
        }
        
        return false;
    }
    
    private void reverse(int[] matchsticks) {
        for (int i = 0, j = matchsticks.length - 1; i < j; i++, j--) {
            int temp = matchsticks[i];
            matchsticks[i] = matchsticks[j];
            matchsticks[j] = temp;
        }
    }
}
