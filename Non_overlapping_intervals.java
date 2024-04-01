package arrays;

import java.sql.SQLOutput;
import java.util.Arrays;

public class Non_overlapping_intervals {
    public static int eraseOverlapIntervals(int[][] intervals) {
        int cnt = 0;
        Arrays.sort(intervals, (a, b) -> {
            if (a[0] != b[0]) {
                return Integer.compare(a[0], b[0]);
            } else {
                return Integer.compare(a[1], b[1]);
            }
        });
        //for(int i=0; i<intervals.length; i++) {
        //    System.out.println(Arrays.toString(intervals[i]));
        //}
        int i = 0;
        int j=i+1;
        while(i<intervals.length-1 && j<intervals.length){

            if(intervals[i][1] > intervals[j][0]){
                cnt++;
                j++;
                System.out.println(Arrays.toString(intervals[j]));
            }else {
                i = j;
                j++;

            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        System.out.println(eraseOverlapIntervals(new int[][]{{-52,31},{-73,-26},{82,97},{-65,-11},{-62,-49},{95,99},{58,95},{-31,49},{66,98},{-63,2},{30,47},{-40,-26}}));
    }
}
