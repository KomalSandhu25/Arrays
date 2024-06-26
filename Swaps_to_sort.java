package arrays;
import java.util.*;
/*
Input: {4, 3, 2, 1}
Output: 2
Explanation: Swap index 0 with 3 and 1 with 2 to form the sorted array {1, 2, 3, 4}

Input: {1, 5, 4, 3, 2}
Output: 2
 */
public class Swaps_to_sort {
    public static void min_swaps(int arr[]){
        HashMap<Integer, Integer> sorted_arr = new HashMap<>();
        int [] sa = Arrays.copyOf(arr, arr.length);
        int swap=0;
        Arrays.sort(sa);
        for (int i=0; i<sa.length; i++){
            sorted_arr.put(sa[i], i);
        }

        int i = 0;
        while(i < arr.length){
            if(!sorted_arr.get(arr[i]).equals(i)){
                int sr_ind = sorted_arr.get(arr[i]);
                int temp = arr[sr_ind];
                arr[sr_ind] = arr[i];
                arr[i] = temp;

                swap += 1;
            }else
                i++;

        }
        System.out.println(swap);
    }

    public static void main(String[] args) {
        min_swaps(new int[]{11, 15, 14, 12, 13});
    }
}
