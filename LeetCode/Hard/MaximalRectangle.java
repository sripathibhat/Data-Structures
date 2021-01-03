// 85
class Solution {
    public int maximalRectangle(char[][] matrix) {
        int max = 0;
        if(matrix.length == 0) {
            return 0;
        }
        int arr[] = new int[matrix[0].length];
        for(int j=0; j<matrix[0].length; j++) {
            arr[j] = matrix[0][j] - '0';
        }
        max = mah(arr);
        for(int i=1; i<matrix.length; i++) {
            for(int j=0; j<matrix[0].length; j++) {
                arr[j] = matrix[i][j]-'0' == 0 ? 0 : arr[j] + matrix[i][j]-'0';
            }
            max = Math.max(max, mah(arr));
        }
        return max;
    }
    
    private int mah(int[] heights) {
        if(heights.length == 0) {
            return 0;
        }
        int area[] = new int[heights.length];
        int nsr[] = nsr(heights);
        int nsl[] = nsl(heights);
        int maxArea = Integer.MIN_VALUE;
        for(int i=0;i<heights.length;i++) {
            area[i] = heights[i] * (nsr[i]-nsl[i]-1);
            maxArea = Math.max(area[i], maxArea);
        }
        return maxArea;
    }
    
    private int[] nsr(int a[]) {
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
    
    private int[] nsl(int a[]) {
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
