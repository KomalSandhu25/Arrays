package arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class mergeInterval {
    public static int[][] insert(int[][] intervals, int[] interval) {
        List<int []> res = new ArrayList<>();
        int i = 0;
        for( i=0; i<intervals.length;i++){
            if(intervals[i][1] > interval[0]){
                if(intervals[i][0] > interval[0]){
                    intervals[i][0] = interval[0];

                } else if(intervals[i][1] < interval[1]){
                    intervals[i][1] = interval[1];

                    break;
                }
            }else{
                res.add(intervals[i]);
            }
        }
        int j = 0;
        for( j=i+1; j<intervals.length;j++){
            if(intervals[i][1] < intervals[j][1]){
                if(intervals[i][1] >= intervals[j][0]){
                    res.add(new int []{intervals[i][0],intervals[j][1]});
                    i++;
                    j++;
                    break;
                }else{
                    res.add(intervals[i]);
                    i++;
                    break;
                }
            }
        }
        for(int k=j; k< intervals.length; k++){
            res.add(intervals[k]);
            i++;
        }
        int [][] resarr = new int[res.size()][2];
        for(int s=0; s< res.size(); s++){
            resarr[s] = res.get(s);
        }
        return resarr;
    }

    public static int[][] insertOpt(int[][] intervals, int[] interval) {
        int i = 0;
        int start = 0;
        int end = 0;
        int ind1 = -1;
        int ind2 = -1;

        if(intervals.length == 1 && interval.length == 0){
            return new int [][]{intervals[0]};
        }
        if(intervals.length == 0 && interval.length > 0){
            return new int [][]{interval};
        }
        List<int []> res = new ArrayList<>();

        for( i=0; i<intervals.length;i++){
            if(interval[0] >= intervals[i][0] && interval[0] <= intervals[i][1]){
                start = i;
                ind1 = intervals[i][0];
                break;
            } else if(interval[0] < intervals[i][0]){
                start = i;
                ind1 = interval[0];
            }
        }
        if(ind1 == -1){
            for(int j=0; j<intervals.length; j++) {
                res.add(intervals[j]);
            }
            res.add(interval);
            int [][] resarr = new int[res.size()][2];
            for(int s=0; s< res.size(); s++){
                resarr[s] = res.get(s);
            }
            return resarr;
        }
        i=0;
        for( i=0; i<intervals.length;i++){
            if(interval[1] >= intervals[i][0] && interval[1] <= intervals[i][1]){
                end = i;
                ind2 = intervals[i][1];
                break;
            }else if(interval[1] >= intervals[i][1]){
                end = i;
                ind2 = interval[1];
            }
        }
        if(ind2 == -1){
            res.add(interval);
            for(int j=0; j<intervals.length; j++) {
                res.add(intervals[j]);
            }
            int [][] resarr = new int[res.size()][2];
            for(int s=0; s< res.size(); s++){
                resarr[s] = res.get(s);
            }
            return resarr;
        }

        for(int j=0; j<intervals.length; j++){
            if(j < start)
                res.add(intervals[j]);
            else if(j == start) {
                res.add(new int[]{ind1, ind2});
                j = end;
            }
            else if(j> end)
                res.add(intervals[j]);
        }

        int [][] resarr = new int[res.size()][2];
        for(int s=0; s< res.size(); s++){
            resarr[s] = res.get(s);
        }
        return resarr;

    }
    public int[][] insertfullyOpt(int[][] intervals, int[] newInterval) {
        int n = intervals.length, i = 0;
        List<int[]> res = new ArrayList<>();

        // Case 1: No overlapping before merging intervals
        while (i < n && intervals[i][1] < newInterval[0]) {
            res.add(intervals[i]);
            i++;
        }

        // Case 2: Overlapping and merging intervals
        while (i < n && newInterval[1] >= intervals[i][0]) {
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            i++;
        }
        res.add(newInterval);

        // Case 3: No overlapping after merging newInterval
        while (i < n) {
            res.add(intervals[i]);
            i++;
        }

        // Convert List to array
        return res.toArray(new int[res.size()][]);
    }
    public static void main(String[] args) {
        //int [][] res = insertOpt(new int [][]{{1,3},{6,9}}, new int[]{2, 5});
        //int [][] res = insertOpt(new int [][]{{1,2},{3,5},{6,7},{8,10},{12,16}}, new int[]{4, 8});
        int [][] res = insertOpt(new int [][]{{1,5}}, new int[]{6, 8});
        for(int i=0; i<res.length; i++)
            System.out.println(Arrays.toString(res[i]));
    }

}
