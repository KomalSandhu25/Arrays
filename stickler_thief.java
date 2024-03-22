package arrays;

public class stickler_thief {
    public static void non_adjacent_max_sum(int arr[]){
        int excl = arr[0];
        int incl = arr[1];
        int max = 0;
        for(int i=2; i<arr.length; i++){
            int tmp = Math.max(incl, excl);
            incl = excl + arr[i];
            excl = tmp;
            if(max < incl)
                max = incl;
        }
        System.out.println(max);
    }

    public static void main(String[] args) {
        non_adjacent_max_sum(new int []{5, 5, 10, 100, 10, 5});
        non_adjacent_max_sum(new int[]{3, 2, 7, 10});
    }
}
