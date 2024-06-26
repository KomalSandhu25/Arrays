package arrays;
/*
Input: N = 7 , arr[] = {4, 3, 7, 8, 6, 2, 1}
Output: arr[] = {3, 7, 4, 8, 2, 6, 1}
Explanation: The given array is in zig-zag pattern as we can see 3 < 7 > 4 < 8 > 2 < 6 >1
 */
public class zigZag {
    public static void getArray(int arr[]){
        int flag =0;
        for(int i=0; i<arr.length-1; i++){
            if(flag == 0){
                if(arr[i] > arr[i+1]){
                    int temp = arr[i];
                    arr[i] = arr[i+1];
                    arr[i+1] = temp;
                }
                flag = 1;
            }else if(flag == 1){
                if(arr[i] < arr[i+1]){
                    int temp = arr[i];
                    arr[i] = arr[i+1];
                    arr[i+1] = temp;
                }
                flag = 0;
            }
        }
        for(int i=0; i<arr.length; i++)
            System.out.println(arr[i]);
    }

    public static void main(String[] args) {
        getArray(new int[]{4, 3, 7, 8, 6, 2, 1});
    }
}
