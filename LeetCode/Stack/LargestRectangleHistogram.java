class Solution {
    public int largestRectangleArea(int[] heights) {
        if(heights.length == 0) {
            return 0;
        }
        int area[] = new int[heights.length];
        int nsr[] = getnsr(heights);
        int nsl[] = getnsl(heights);
        int maxArea = Integer.MIN_VALUE;
        for(int i = 0; i < heights.length; i++) {
            area[i] = heights[i] * (nsr[i] - nsl[i] - 1);
            maxArea = Math.max(area[i], maxArea);
        }
        return maxArea;
    }
    
    // Find nearest smaller to right
    private int[] getnsr(int a[]) {
        int n = a.length;
        int nsr[] = new int[n];
        Stack<Integer> s = new Stack<Integer>();
        for(int i= n-1; i >= 0; i--) {
            if(s.size() == 0) {
                nsr[n-i-1] = n;
            }
            else if(a[s.peek()] < a[i]) {
                nsr[n-i-1] = s.peek();
            }
            else if(a[s.peek()] >= a[i]) {
                while(s.size() > 0 && a[s.peek()] >= a[i]) {
                    s.pop();
                }
                if(s.size() == 0) nsr[n-i-1] = n;
                else nsr[n-i-1] = s.peek();
            }
            s.push(i);
        }
        int rnsr[] = new int[n];
        for(int i = 0; i < n; i++) {
            rnsr[n-i-1] = nsr[i];
        }
        return rnsr;
    }
    
    // Find nearest smaller to left
    private int[] getnsl(int a[]) {
        int n = a.length;
        int nsl[] = new int[n];
        Stack<Integer> s = new Stack<Integer>();
        for(int i = 0; i < n; i++) {
            if(s.size() == 0) {
                nsl[i] = -1;
            }
            else if(a[s.peek()] < a[i]) {
                nsl[i] = s.peek();
            }
            else if(a[s.peek()] >= a[i]) {
                while(s.size() > 0 && a[s.peek()] >= a[i]) {
                    s.pop();
                }
                if(s.size() == 0) nsl[i] = -1;
                else nsl[i] = s.peek();
            }
            s.push(i);
        }
        return nsl;
    }


    // Monotonic stack
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack();
        int maxArea = 0;
        int i = 0;

        while (i < heights.length) {
            // If current bar is higher than stack top, push it
            if (stack.isEmpty() || heights[i] >= heights[stack.peek()]) {
                stack.push(i);
                i++;
            } else {
                // Pop the top and calculate area with popped bar as smallest
                int top = stack.pop();
                // Calculate area with heights[topOfStack] as the smallest bar
                // Width is determined by current index and the previous index in stack
                int width = stack.isEmpty() ? i : i - stack.peek() - 1;
                int area = heights[top] * width;
                maxArea = Math.max(maxArea, area);
            }
        }

        // Pop remaining bars from stack and calculate area
        while (!stack.isEmpty()) {
            int top = stack.pop();
            int width = stack.isEmpty() ? i : i - stack.peek() - 1;
            int area = heights[top] * width;
            maxArea = Math.max(maxArea, area);
        }

        return maxArea;
    }
}
