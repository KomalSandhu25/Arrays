package arrays.pointers;

import java.util.Arrays;

public class SortByParity {
    public static int[] sortArrayByParity(int[] nums) {
        int e=0;

        int o=nums.length-1;
        while(e<o){
            if(nums[e]%2 == 0){
                e++;

            }
            if(nums[o]%2 !=0){
                o--;
            }
            if(e<o && nums[e]%2 != 0){
                int temp = nums[o];
                nums[o] = nums[e];
                nums[e] = temp;
                o--;
            }
            if(o>=e && nums[o]%2 ==0){
                int temp = nums[e];
                nums[e] = nums[o];
                nums[o] = temp;
                e++;
            }
        }
        return nums;
    }

    public static void main(String[] args) {
        //System.out.println(Arrays.toString(sortArrayByParity(new int[]{3,1,2,4})));
        System.out.println(Arrays.toString(sortArrayByParity(new int[]{0,1})));
    }
}
