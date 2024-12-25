/**

Given an array of strings words and an integer k, return the k most frequent strings.

Return the answer sorted by the frequency from highest to lowest. Sort the words with the same frequency by their lexicographical order.

 

Example 1:

Input: words = ["i","love","leetcode","i","love","coding"], k = 2
Output: ["i","love"]
Explanation: "i" and "love" are the two most frequent words.
Note that "i" comes before "love" due to a lower alphabetical order.
Example 2:

Input: words = ["the","day","is","sunny","the","the","the","sunny","is","is"], k = 4
Output: ["the","is","sunny","day"]
Explanation: "the", "is", "sunny" and "day" are the four most frequent words, with the number of occurrence being 4, 3, 2 and 1 respectively.

*/

class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> frequencyMap = new HashMap<>();
        for (String word: words) {
            frequencyMap.put(word, frequencyMap.getOrDefault(word, 0) + 1);
        }
        PriorityQueue<WordFreq> pq = new PriorityQueue<WordFreq>((a, b) -> a.freq == b.freq ? b.word.compareTo(a.word) : a.freq - b.freq);
        for (Map.Entry<String, Integer> entry: frequencyMap.entrySet()) {
            WordFreq wordFreq = new WordFreq(entry.getKey(), entry.getValue());
            pq.add(wordFreq);
            if (pq.size() > k) {
                pq.poll();
            }
        }
        List<String> res = new ArrayList<>();
        while (!pq.isEmpty()) {
            res.add(pq.poll().word);
        }
        Collections.reverse(res);
        return res;
    }

    class WordFreq {
        String word;
        int freq;
        WordFreq(String w, int f) {
            word = w;
            freq = f;
        }
    }
}
