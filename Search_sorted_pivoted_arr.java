package arrays;
/*
Input  : arr[] = {5, 6, 7, 8, 9, 10, 1, 2, 3}, key = 3
Output : Found at index 8


 */
public class Search_sorted_pivoted_arr {

    public static int search(int []arr, int l, int r, int mid, int key){
        if(arr.length == 0){
            return -1;
        }
        if(l > r)
            return -1;


        if(arr[mid] == key)
            return mid;
        else if(arr[mid] < key){
            return search(arr, mid, r, (r+mid-1)/2, key);
        }else if(arr[mid] > key){
            return search(arr, l, mid-1, (l+mid-2)/2, key);
        }
        return -1;
    }
    public static int findPivot(int []arr, int l, int r){
        if(arr.length == 0){
            return -1;
        }
        int res = -1;
        if(l >= r)
            return -1;
        int mid = (r+l-1)/2;

        if(mid > l && arr[mid] < arr[mid-1])
            return mid;
        else if(mid < r && arr[mid] > arr[mid+1])
            return mid+1;
        else {
            res = findPivot(arr, l, mid);

            if(res == -1){
                return findPivot(arr, mid + 1, r);
            }
            else
                return res;
        }

    }

    public static void main(String[] args) {
        int arr[] = {5, 6, 7, 8, 9, 10, 1, 2, 3};
        int key = 3;

        int mid = findPivot(arr, 0, arr.length-1);
        System.out.println(search(arr, 0, mid, arr.length-1, key));
    }
}
