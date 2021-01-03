// 84
class Solution {
    public int largestRectangleArea(int[] heights) {
        if(heights.length == 0) {
            return 0;
        }
        int area[] = new int[heights.length];
        int nsr[] = getnsr(heights);
        int nsl[] = getnsl(heights);
        int maxArea = Integer.MIN_VALUE;
        for(int i=0;i<heights.length;i++) {
            area[i] = heights[i] * (nsr[i] - nsl[i] - 1);
            // System.out.println(area[i] + " " + nsl[i] + " " + nsr[i]);
            maxArea = Math.max(area[i], maxArea);
        }
        return maxArea;
    }
    
    // Find nearest smaller to right
    private int[] getnsr(int a[]) {
        int n = a.length;
        int nsr[] = new int[n];
        Stack<Integer> s = new Stack<Integer>();
        for(int i=n-1; i>=0; i--) {
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
        for(int i=0;i<n;i++) {
            rnsr[n-i-1] = nsr[i];
        }
        return rnsr;
    }
    
    // Find nearest smaller to left
    private int[] getnsl(int a[]) {
        int n = a.length;
        int nsl[] = new int[n];
        Stack<Integer> s = new Stack<Integer>();
        for(int i=0; i<n; i++) {
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
}