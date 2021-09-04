/*
    Given a string s and a dictionary of strings wordDict, return true if s can be segmented into a space-separated sequence of
    one or more dictionary words.

    Note that the same word in the dictionary may be reused multiple times in the segmentation.

*/

class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int dp[] = new int[s.length()];
        solve(s, 0, wordDict, dp);
        return dp[0] == 1;
    }
    
    private boolean solve(String s, int index, List<String> dict, int[] dp) {
        if(index == s.length()) {
            return true;
        }
        
        if(dp[index] != 0) {
            return dp[index] == 1;
        }
        for(String word: dict) {
            if(s.indexOf(word, index) == index && solve(s, index + word.length(), dict, dp)) {
                dp[index] = 1;
                return true;
            }
        }
        dp[index] = -1;
        return false;
    } 
}