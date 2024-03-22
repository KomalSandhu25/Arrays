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

        int i = 0;
        int j=i+1;
        while(i<intervals.length-1 && j<intervals.length){

            if(intervals[i][1] > intervals[j][0]){
                cnt++;
                j++;
            }else {
                i = j;
                j++;

            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        System.out.println(eraseOverlapIntervals(new int[][]{{1,2},{2,3},{3,4},{1,3}}));
    }
}
