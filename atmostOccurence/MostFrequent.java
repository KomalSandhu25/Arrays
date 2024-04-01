package arrays.atmostOccurence;

import java.util.Arrays;

/*The frequency of an element is the number of times it occurs in an array.

You are given an integer array nums and an integer k. In one operation, you can choose an index of nums and increment the element at that index by 1.

Return the maximum possible frequency of an element after performing at most k operations.



Example 1:

Input: nums = [1,2,4], k = 5
Output: 3
Explanation: Increment the first element three times and the second element two times to make nums = [4,4,4].
4 has a frequency of 3.

 */
public class MostFrequent {
    static int  slidingWindow(int []A, int k) {
        Arrays.sort(A);
        int i = 0, j = 0, N = A.length, sum = 0;
        for (; j < N; ++j) {
            sum += A[j];
            if ((j - i + 1) * A[j] - sum > k) sum -= A[i++];
        }
        return j - i;
    }
    public static void main(String[] args) {
        System.out.println(slidingWindow(new int[]{1,4,8,13}, 5));
    }
}
