package dynamic_programming;

// The Longest Increasing Subsequence (LIS) problem is to find the length of the longest subsequence
// of a given sequence such that all elements of the subsequence are sorted in increasing order.
// For example, the length of LIS for {10, 22, 9, 33, 21, 50, 41, 60, 80} is 6 and LIS is {10, 22, 33, 50, 60, 80}.

// 1. If A[i] is smallest among all end candidates of active lists, we will start new active list of length 1.
// 2. If A[i] is largest among all end candidates of active lists, we will clone the largest active list, and extend it by A[i].
// 3. If A[i] is in between, we will find a list with largest end element that is smaller than A[i].
//    Clone and extend this list by A[i]. We will discard all other lists of same length as that of this modified list.
// Java program to find length of longest increasing subsequence
// in O(n Log n) time

//Complexity:
//The loop runs for N elements. In the worst case (what is worst case input?), we may end up querying ceil value using binary search (log i) for many A[i].
//Therefore, T(n) < O( log N! )  = O(N log N). Analyse to ensure that the upper and lower bounds are also O( N log N ). The complexity is THETA (N log N).
//Auxiliary Space: O(N)

// Useful links:
// https://www.geeksforgeeks.org/longest-monotonically-increasing-subsequence-size-n-log-n/
// https://www.geeksforgeeks.org/construction-of-longest-monotonically-increasing-subsequence-n-log-n/
// https://stackoverflow.com/questions/2631726/how-to-determine-the-longest-increasing-subsequence-using-dynamic-programming
// https://en.wikipedia.org/wiki/Longest_increasing_subsequence#Efficient_algorithms
class LIS {
    // Binary search (note boundaries in the caller)
    // A[] is ceilIndex in the caller
    static int CeilIndex(int[] A, int l, int r, int key) {
        while (r - l > 1) {
            int m = l + (r - l) / 2;
            if (A[m] >= key)
                r = m;
            else
                l = m;
        }
        return r;
    }

    static int LongestIncreasingSubsequenceLength(int[] A, int size) {
        // Add boundary case, when array size is one
        int[] tailTable = new int[size];
        int len; // always points empty slot

        tailTable[0] = A[0];
        len = 1;
        for (int i = 1; i < size; i++) {
            if (A[i] < tailTable[0])
                // new smallest value
                tailTable[0] = A[i];
            else if (A[i] > tailTable[len - 1])
                // A[i] wants to extend largest subsequence
                tailTable[len++] = A[i];
            else
                // A[i] wants to be current end candidate of an existing
                // subsequence. It will replace ceil value in tailTable
                tailTable[CeilIndex(tailTable, -1, len - 1, A[i])] = A[i];
        }

        return len;
    }

    // Driver program to test above function
    public static void main(String[] args) {
        int[] A = {2, 5, 3, 7, 11, 8, 10, 13, 6};
        int n = A.length;
        System.out.println("Length of Longest Increasing Subsequence is " + LongestIncreasingSubsequenceLength(A, n));
    }
}
