package arrays;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;
/*
Input:   arr[] = {1, 0, 0, 1, 1, 0, 1, 0, 1, 1, 1}
         m = 2
Output:  5 7
We are allowed to flip maximum 2 zeroes. If we flip
arr[5] and arr[7], we get 8 consecutive 1's which is
maximum possible under given constraints
 */
public class Zeroes_to_flip {
    public static void  flip(int arr[], int m){
        List<Integer> l = new ArrayList<>();
        for(int i=0; i<arr.length; i++){
            if(arr[i]==0){
                l.add(i);
            }
        }
        int j=0;
        int max = 0;
        int res = 0;
        int start = 0;
        int end = 0;
        //{1, 2, 5, 7}
        if(m>=l.size()){
            start = 0;
            end = l.get(l.size()-1);
            res = arr.length;
        }
        else {
            while (j < l.size() - m) {
                if (j + 1 == l.size() - m)
                    max = (arr.length - 1) - l.get(j);
                else
                    max = l.get(m + j) - l.get(j) + 1;
                if (res < max) {
                    start = l.get(j + 1);
                    end = l.get(m + j);
                    res = max;
                }
                j++;
            }
        }
        System.out.println(start + " " + end + " " + res);
    }

    public static void main(String[] args) {
        flip(new int[]{0,0,0,1}, 4);
        flip(new int[]{1, 0, 0, 1, 1, 0, 1, 0, 1, 1, 1}, 2);
    }
}
