/**

There is a foreign language which uses the latin alphabet, but the order among letters is not "a", "b", "c" ... "z" as in English.

You receive a list of non-empty strings words from the dictionary, where the words are sorted lexicographically based on the rules of this new language.

Derive the order of letters in this language. If the order is invalid, return an empty string. If there are multiple valid order of letters, return any of them.

A string a is lexicographically smaller than a string b if either of the following is true:

The first letter where they differ is smaller in a than in b.
There is no index i such that a[i] != b[i] and a.length < b.length.
Example 1:

Input: ["z","o"]

Output: "zo"
Explanation:
From "z" and "o", we know 'z' < 'o', so return "zo".

Example 2:

Input: ["hrn","hrf","er","enn","rfnn"]

Output: "hernf"
Explanation:

from "hrn" and "hrf", we know 'n' < 'f'
from "hrf" and "er", we know 'h' < 'e'
from "er" and "enn", we know get 'r' < 'n'
from "enn" and "rfnn" we know 'e'<'r'
so one possibile solution is "hernf"

*/

class Solution {
    public String foreignDictionary(String[] words) {
      
      Map<Character, Set<Character>> adj = new HashMap();
      Map<Character, Boolean> visited = new HashMap();
      List<Character> res = new ArrayList();

      for (String word: words) {
        for (char c: word.toCharArray()) {
            adj.putIfAbsent(c, new HashSet<>());
        }
      }

      for (int i = 0; i < words.length - 1; i++) {
        String w1 = words[i], w2 = words[i + 1];
        int min = Math.min(w1.length(), w2.length());

        if (w1.length() > w2.length() && 
            w1.substring(0, min).equals(w2.substring(0, min))) {
              return "";
        }

        for (int j = 0; j < min; j++) {
            if (w1.charAt(j) != w2.charAt(j)) {
                adj.get(w1.charAt(j)).add(w2.charAt(j));
                break;
            }
        }
      }

      for (char c: adj.keySet()) {
        // dfs to return true if cycle found, indicates solution not possible
        if (dfs(c, adj, visited, res)) {
          return "";
        }
      }

      Collections.reverse(res);
      StringBuilder sb = new StringBuilder();
      for (char c: res) {
        sb.append(c);
      }
      return sb.toString();
    }

    private boolean dfs(char ch, Map<Character, Set<Character>> adj, Map<Character, Boolean> visited,
      List<Character> res) {
        
        if (visited.containsKey(ch)) {
          return visited.get(ch);
        }

        visited.put(ch, true);

        for (char nei: adj.get(ch)) {
          if (dfs(nei, adj, visited, res)) {
            return true;
          }
        }

        visited.put(ch, false);
        res.add(ch);

        // no cycle
        return false;
    }
}
