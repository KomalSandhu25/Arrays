package arrays.binarySearch;

import java.util.stream.IntStream;
/*
Given an integer array nums and an integer k, split nums into k non-empty subarrays such that the largest sum of any subarray is minimized.

Return the minimized largest sum of the split.

A subarray is a contiguous part of the array.



Example 1:

Input: nums = [7,2,5,10,8], k = 2
Output: 18
Explanation: There are four ways to split nums into two subarrays.
The best way is to split it into [7,2,5] and [10,8], where the largest sum among the two subarrays is only 18.
Example 2:

Input: nums = [1,2,3,4,5], k = 2
Output: 9
Explanation: There are four ways to split nums into two subarrays.
The best way is to split it into [1,2,3] and [4,5], where the largest sum among the two subarrays is only 9.
 */
public class MinimizeSubarraySum {
    public static Boolean feasible(int threshold, int [] nums, int k){
        int count = 1;
        int total = 0;
        for(int i=0; i<nums.length; i++) {
            total += nums[i];
            if (total > threshold) {
                total = nums[i];
                count += 1;
                if (count > k)
                    return Boolean.FALSE;
            }
        }
        return Boolean.TRUE;

    }
    public static int minimize(int nums[], int k){
        int left = IntStream.of(nums).max().getAsInt();
        int right = IntStream.of(nums).sum();

        while(left < right){
            int mid = (right - left)/2 + left ;
            if(feasible(mid, nums, k)){
                right =  mid;
            }else
                left = mid+1;
        }
        return left;
    }

    public static void main(String[] args) {
        System.out.println(minimize(new int[]{7,2,5,10,8}, 2));
    }

}
