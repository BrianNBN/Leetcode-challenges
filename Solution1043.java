
/*
1043. Partition Array for Maximum Sum
Given an integer array arr, partition the array into (contiguous) subarrays of length at most k. After partitioning,
each subarray has their values changed to become the maximum value of that subarray.

Return the largest sum of the given array after partitioning. Test cases are generated so that the answer fits in a 32-bit integer.

Example 1:

Input: arr = [1,15,7,9,2,5,10], k = 3
Output: 84
Explanation: arr becomes [15,15,15,9,10,10,10]
Example 2:

Input: arr = [1,4,1,5,7,3,6,1,9,9,3], k = 4
Output: 83
Example 3:

Input: arr = [1], k = 1
Output: 1

Constraints:

1 <= arr.length <= 500
0 <= arr[i] <= 109
1 <= k <= arr.length
 */

public class Solution1043 {
    public int Solution1043(int[] arr, int k) {
        int n = arr.length;
        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            int max = 0;
            for (int j = 1; j <= k && i - j >= 0; j++) {
                max = Math.max(max, arr[i - j]);
                dp[i] = Math.max(dp[i], dp[i - j] + max * j);
            }
        }
        return dp[n];
    }
    public static void main(String[] args) {
        // Example usage:
        Solution1043 solution = new Solution1043();

        int[] arr1 = {1, 15, 7, 9, 2, 5, 10};
        int k1 = 3;
        int output1 = solution.Solution1043(arr1, k1);
        System.out.println(output1);  // Output: 84

        int[] arr2 = {1, 4, 1, 5, 7, 3, 6, 1, 9, 9, 3};
        int k2 = 4;
        int output2 = solution.Solution1043(arr2, k2);
        System.out.println(output2);  // Output: 83

        int[] arr3 = {1};
        int k3 = 1;
        int output3 = solution.Solution1043(arr3, k3);
        System.out.println(output3);  // Output: 1
    }
}
