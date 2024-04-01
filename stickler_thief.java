package arrays;
/*
Input: arr[] = {5, 5, 10, 100, 10, 5}
Output: 110
Explanation: Pick the subsequence {5, 100, 5}.
The sum is 110 and no two elements are adjacent. This is the highest possible sum.

Input: arr[] = {3, 2, 7, 10}
Output: 13
Explanation: The subsequence is {3, 10}. This gives sum = 13.
This is the highest possible sum of a subsequence following the given criteria
 */
public class stickler_thief {
    public static void non_adjacent_max_sum(int arr[]){
        int excl = arr[0];
        int incl = arr[1];
        int max = 0;
        for(int i=2; i<arr.length; i++){
            int tmp = Math.max(incl, excl);
            incl = excl + arr[i];
            excl = tmp;
            if(max < incl)
                max = incl;
        }
        System.out.println(max);
    }

    public static void main(String[] args) {
        non_adjacent_max_sum(new int []{5, 5, 10, 100, 10, 5});
        non_adjacent_max_sum(new int[]{3, 2, 7, 10});
    }
}
