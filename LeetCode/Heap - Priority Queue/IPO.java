/**

Suppose LeetCode will start its IPO soon. In order to sell a good price of its shares to Venture Capital, LeetCode would like to work on some projects to increase
its capital before the IPO. Since it has limited resources, it can only finish at most k distinct projects before the IPO. Help LeetCode design the best way
to maximize its total capital after finishing at most k distinct projects.

You are given n projects where the ith project has a pure profit profits[i] and a minimum capital of capital[i] is needed to start it.

Initially, you have w capital. When you finish a project, you will obtain its pure profit and the profit will be added to your total capital.

Pick a list of at most k distinct projects from given projects to maximize your final capital, and return the final maximized capital.

The answer is guaranteed to fit in a 32-bit signed integer.
 

Example 1:

Input: k = 2, w = 0, profits = [1,2,3], capital = [0,1,1]
Output: 4
Explanation: Since your initial capital is 0, you can only start the project indexed 0.
After finishing it you will obtain profit 1 and your capital becomes 1.
With capital 1, you can either start the project indexed 1 or the project indexed 2.
Since you can choose at most 2 projects, you need to finish the project indexed 2 to get the maximum capital.
Therefore, output the final maximized capital, which is 0 + 1 + 3 = 4.


Example 2:

Input: k = 3, w = 0, profits = [1,2,3], capital = [0,1,2]
Output: 6

*/

class Solution {

    private static class Project {
        int capital;
        int profit;

        Project(int capital, int profit) {
            this.capital = capital;
            this.profit = profit;
        }
    }

    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        // Using 2 heaps

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
        PriorityQueue<Project> minHeap = new PriorityQueue<>((a, b) -> a.capital - b.capital);
        for (int i = 0; i < capital.length; i++) {
            minHeap.add(new Project(capital[i], profits[i]));
        }

        for (int i = 0; i < k; i++) {
            while (!minHeap.isEmpty() && minHeap.peek().capital <= w) {
                maxHeap.add(minHeap.poll().profit);
            }
            if (maxHeap.isEmpty()) {
                break;
            }
            w += maxHeap.poll();
        }
     
        return w;


        // Using max heap and sorting captial in ASC order.
        // int n = profits.length;
        // List<Project> projects = new ArrayList<>();

        // // Creating list of projects with capital and profits
        // for (int i = 0; i < n; i++) {
        //     projects.add(new Project(capital[i], profits[i]));
        // }

        // // Sorting projects by capital required
        // Collections.sort(projects, (a, b) -> a.capital - b.capital);

        // // Max-heap to store profits (using a min-heap with inverted values)
        // PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
        // int i = 0;

        // // Main loop to select up to k projects
        // for (int j = 0; j < k; j++) {
        //     // Add all profitable projects that we can afford
        //     while (i < n && projects.get(i).capital <= w) {
        //         maxHeap.add(projects.get(i).profit);
        //         i++;
        //     }

        //     // If no projects can be funded, break out of the loop
        //     if (maxHeap.isEmpty()) {
        //         break;
        //     }

        //     // Otherwise, take the project with the maximum profit
        //     w += maxHeap.poll();
        // }
        // return w;
    }
}
