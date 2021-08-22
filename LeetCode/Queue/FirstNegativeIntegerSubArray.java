/*
Given an array A[] of size N and a positive integer K, find the first negative integer for each and every window(contiguous subarray) of size K.
*/

class Compute {
    
    public long[] printFirstNegativeInteger(long A[], int N, int K)
    {
        Deque<Integer> q = new LinkedList<Integer>();
        int i = 0;
        long res[] = new long[N - K + 1];
        for(; i < K; i++) {
            if(A[i] < 0) {
                q.addLast(i);
            }
        }
        int j = 0;
        for(; i < N; i++) {
            res[j++] = q.isEmpty() ? 0 : A[q.peek()];
            while(!q.isEmpty() && q.peek() <= i - K) {
                q.removeFirst();
            }
            if(A[i] < 0) {
                q.addLast(i);
            }
        }
        res[j] = q.isEmpty() ? 0 : A[q.peek()];
        return res;
    }
}