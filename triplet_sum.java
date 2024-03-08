package arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class triplet_sum {
    public static int[] triplet(int []arr, int sum){
        Arrays.sort(arr);
        int s= 0;
        for(int k=1; k<arr.length-2; k++){
            int i=0; int j=arr.length-1;
            while(i<j) {
                s = arr[i] + arr[j] + arr[k];
                if(s==sum)
                    return new int[]{arr[i],arr[j],arr[k]};
                else if(s < sum){
                    i++;
                }else if(s > sum){
                    j--;
                }
            }

        }
        return new int[]{};
    }

    public static void main(String[] args) {
        int [] arr = {12, 4, 3, 1, 9, 6};
        int sum = 24;
        System.out.println(Arrays.toString(triplet(arr, sum)));
    }
}
