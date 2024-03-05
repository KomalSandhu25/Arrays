package arrays;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/*
Input: arr[] = {1, 4, 20, 3, 10, 5}, sum = 33
Output: Sum found between indexes 2 and 4
Explanation: Sum of elements between indices
2 and 4 is 20 + 3 + 10 = 33

Input: arr[] = {10, 2, -2, -20, 10}, sum = -10
Output: Sum found between indexes 0 to 3
Explanation: Sum of elements between indices
0 and 3 is 10 + 2 – 2 – 20 = -10
 */
public class Subarray_with_given_sum {
    public static int[] subarray(int []arr, int sum){
        int i = 0; int j = 1; int res = arr[i];
        int [] res_list = new int[2];
        while(i <= j){
            if(res == sum)
                return res_list;
            else if(res > sum){
                res -= arr[i];
                i++;
                res_list[0]= i;
            }
            else if(res < sum){
                res += arr[j];
                res_list[1]= j;
                j++;
            }

        }
        return res_list;
    }
    public static int[] subarrayWithNegatives(int []arr, int sum){
        int s = 0;
        HashMap<Integer, Integer> h = new HashMap<>();

        for (int i=0; i<arr.length; i++) {
            s += arr[i];
            if (s == sum)
                return new int[]{0, i};
            h.put(s, i);
            if(h.containsKey(s-sum)){
                return new int[]{h.get(s-sum)+1, i};
            }
        }
        return new int[]{};

    }

    public static void main(String []args){
        int []arr = {11, 2, 10, -20, -2, 10};
        int sum = -10;
        int []a = subarray(arr, sum);
        System.out.println(a[0] +" "+ a[1]);

        int []b = subarrayWithNegatives(arr, sum);
        System.out.println(b[0] +" "+ b[1]);
    }
}
