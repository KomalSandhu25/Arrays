package arrays;

public class subarray_with_max_sum {
    public static void subarray(int [] arr){
        int sum = 0;
        int i=0;
        int start = 0;
        int end = 0;
        int res = 0;
        for(i=0; i<arr.length; i++){
            sum+=arr[i];
            if(res < sum) {
                res = sum;
                end = i;
            }
            if(sum < 0){
                sum = 0;
                start = i+1;
            }
        }
        System.out.println(start + " " + end + " sum " + res );

    }

    public static void main(String[] args) {
        subarray(new int[]{-2, -3, 4, -1, -2, 1, 5, -3});
    }
}
