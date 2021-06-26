// 126
class Solution {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> res = new ArrayList();
        Set<String> s = new HashSet();
        for(String word: wordList) {
            s.add(word);
        }
        
        if(!s.contains(endWord)) {
            return res;
        }
        
        // BFS 
        Queue<String> q = new LinkedList();
        Map<String, List<String>> adj = new HashMap();
        Map<String, Integer> visited = new HashMap();
        q.add(beginWord);
        visited.put(beginWord, 0);
        
        while(!q.isEmpty()) {
            int size = q.size();
            for(int i=0; i<size; i++) {
                String word = q.poll();
                char wordChar[] = word.toCharArray();
                for(int j=0; j<word.length(); j++) {
                    char ch = word.charAt(j);
                    for(char c='a'; c<='z'; c++) {
                        if(ch == c) {
                            continue;
                        }
                        wordChar[j] = c;
                        String newWord = String.valueOf(wordChar);
                        if(s.contains(newWord)) {
                            if(!visited.containsKey(newWord)) {
                                q.add(newWord);
                                visited.put(newWord, visited.get(word) + 1);
                                List<String> l = adj.get(word);
                                if(l==null || l.size()==0) {
                                    adj.put(word, new ArrayList(Arrays.asList(newWord)));
                                }
                                else {
                                    l.add(newWord);
                                    adj.put(word, l);
                                }
                            }
                            else {
                                if(visited.get(newWord) == visited.get(word) + 1) {
                                    // make newWord as adjacent of word
                                    List<String> l = adj.get(word);
                                    if(l == null || l.size() == 0) {
                                        adj.put(word, new ArrayList(Arrays.asList(newWord)));
                                    }
                                    else {
                                        l.add(newWord);
                                        adj.put(word, l);
                                    }
                                }
                            }
                        }
                    }
                    wordChar[j] = ch;
                }
            }
        }
        
        // Debug, print adj and visited
//         System.out.println("-------Adjacency List-----------");
//         for(Map.Entry<String, List<String>> entry: adj.entrySet()) {
//             System.out.print(entry.getKey() + "->");
//             for(String x: entry.getValue()) {
//                 System.out.print(x + " ");
//             }
//             System.out.println();
//         }
        
//         System.out.println("------------Visited---------------");
//         for(Map.Entry<String, Integer> entry: visited.entrySet()) {
//             System.out.print(entry.getKey() + "-" + entry.getValue() + "\n");
//         }
        DFS(beginWord, endWord, res, new ArrayList(), adj);
        return res;
    }
    
    private void DFS(String start, String end, List<List<String>> res, List<String> path, Map<String, List<String>> adj) {
        path.add(start);
        if(start.equals(end)) {
            res.add(new ArrayList(path));
            path.remove(path.size()-1);
            return;
        }
        if(adj.containsKey(start)) {
            for(String x: adj.get(start)) {
                DFS(x, end, res, path, adj);
            }
        }
        
        path.remove(path.size()-1);
    }
}