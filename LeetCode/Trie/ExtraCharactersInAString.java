/**
You are given a 0-indexed string s and a dictionary of words dictionary. You have to break s into one or more non-overlapping substrings such that
each substring is present in dictionary. There may be some extra characters in s which are not present in any of the substrings.

Return the minimum number of extra characters left over if you break up s optimally.
 

Example 1:

Input: s = "leetscode", dictionary = ["leet","code","leetcode"]
Output: 1
Explanation: We can break s in two substrings: "leet" from index 0 to 3 and "code" from index 5 to 8. There is only 1 unused character (at index 4), so we return 1.

Example 2:

Input: s = "sayhelloworld", dictionary = ["hello","world"]
Output: 3
Explanation: We can break s in two substrings: "hello" from index 3 to 7 and "world" from index 8 to 12. The characters at indices 0, 1, 2 are not used
in any substring and thus are considered as extra characters. Hence, we return 3.

*/

class TrieNode {
    TrieNode children[];
    boolean isWord;

    TrieNode() {
        children = new TrieNode[26];
        isWord = false;
    }
}

class Trie {
    TrieNode root;

    Trie() {
        root = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode cur = root;
        for (char c: word.toCharArray()) {
            if (cur.children[c - 'a'] == null) {
                cur.children[c - 'a'] = new TrieNode();
            }
            cur = cur.children[c - 'a'];
        }
        cur.isWord = true;
    }
}

class Solution {
    public int minExtraChar(String s, String[] dictionary) {
        int n = s.length();
        Trie trie = new Trie();
        int dp[] = new int[n + 1];

        for (String word: dictionary) {
            trie.addWord(word);
        }

        for (int i = n - 1; i >= 0; i--) {
            dp[i] = dp[i + 1] + 1;
            TrieNode node = trie.root;
            for (int j = i; j < n; j++) {
                if (node.children[s.charAt(j) - 'a'] == null) {
                    break;
                }
                node = node.children[s.charAt(j) - 'a'];
                if (node.isWord) {
                    dp[i] = Math.min(dp[i], dp[j + 1]);
                }
            }
        }

        return dp[0];
    }

    private TrieNode buildTrie(String[] dictionary) {
        TrieNode root = new TrieNode();
        for (String word : dictionary) {
            TrieNode node = root;
            for (char c : word.toCharArray()) {
                if (node.children[c - 'a'] == null) {
                    node.children[c - 'a'] = new TrieNode();
                }
                node = node.children[c];
            }
            node.isWord = true;
        }
        return root;
    }
}
