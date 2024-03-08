package arrays;

import java.util.Arrays;

/*
Input: ar1[] = {1, 5, 9, 10, 15, 20};
       ar2[] = {2, 3, 8, 13};
Output: ar1[] = {1, 2, 3, 5, 8, 9}
        ar2[] = {10, 13, 15, 20}
 */
public class merge_sorted_array {
    public static void merge(int[] a1, int [] a2){
        for(int i=0; i<a1.length; i++){
                int j=0;
                if(a1[i] > a2[j]){
                    int temp = a1[i];
                    a1[i] = a2[j];
                    a2[j] = temp;
                    Arrays.sort(a2); //findMin to remove it, then complexity will be n2
                }
            }
        System.out.println(Arrays.toString(a1));
        System.out.println(Arrays.toString(a2));
    }
    public static void main(String[] args) {
        int ar1[] = {1, 5, 9, 10, 15, 20};
        int ar2[] = {2, 3, 8, 13};
        merge(ar1, ar2);
    }
}
