package arrays.atmostOccurence;

/*
Given a binary array nums and an integer goal, return the number of non-empty subarrays with a sum goal.

A subarray is a contiguous part of the array.



Example 1:

Input: nums = [1,0,1,0,1], goal = 2
Output: 4

 */
public class binarySum {
        static int  atMost(int []A, int goal) {
            int i = 0, j = 0, N = A.length, sum = 0, ans = 0;
            for (; j < N; j++) {
                sum += A[j];
                while (i <= j && sum > goal) sum -= A[i++];
                ans += j - i;
            }
            return ans;
        }
        public static int numSubarraysWithSum(int []A, int goal) {
            int a  = atMost(A, goal);
            int b = atMost(A, goal - 1);
            return  a-b;
        }
        public static void main(String[] args) {
            System.out.println(numSubarraysWithSum(new int[]{1,0,1,0,1}, 2));
        }

}
