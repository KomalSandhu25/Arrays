package arrays;

import java.util.Arrays;
import java.util.Iterator;

/*
Input: arr[] = {0, -1, 2, -3, 1}, x= -2
Output: Yes
Explanation:  If we calculate the sum of the output,1 + (-3) = -2
 */
public class Pair_with_given_sum {
    public static String isExist(int [] arr, int sum){

        Arrays.sort(arr);
        int i=0; int j=arr.length-1;
        while(i < j){
            if(arr[i]+arr[j]==sum)
                return "Yes";
            else if(arr[i]+arr[j]>sum)
                j--;
            else if(arr[i]+arr[j]<sum){
                i++;
            }
        }
        return "No";
    }
    public static void main(String [] args){
        int []arr = {0, -1, 2, -3, 1};
        int sum = -2;

        System.out.println(isExist(arr,sum));
    }
}



