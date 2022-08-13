package problems.array;

import static org.junit.Assert.assertArrayEquals;
import java.util.ArrayList;
import java.util.List;
/*
    > problem: Insert Interval
    You are given an array of non-overlapping intervals "intervals"
    where intervals[i] = [start_i, end_i] represent the start and 
    end of the i-th interval and intervas is sorted in ascending 
    order by start_i. You are also given an interval 
    "newInterval" = [start, end] that represent the start and end of 
    another interval. 

    Insert newInterval into intervals such that intervals is still 
    sorted in ascending order by start_i and intervals still does not
    have any overlapping intervals (merge overlapping intervals if 
    necessary)

    Return intervals after the insertion

    > idea: Tompute two separated lists, the overlapping list where we 
    store the intervals that overlap with newInterval and the result list, 
    where we store th list of intervals that do not overlap with newInterval. 
    Then we compute the merged intervals by merging newInterval with every 
    element in the overlapping list and then we insert the merged in result

    > note: this is not the optimal solution neither by time or space but it was
    my way vs leetcode, so here we are.
*/
public class InsertInterval {
    
    public static void main(String[] args) {
        
        int[][] output1 = solution(new int[][]{{1,3}, {6, 9}}, new int[]{2,5});
        assertArrayEquals(output1, new int[][]{{1,5}, {6,9}});

        int[][] output2 = solution(new int[][]{{1,2}, {3, 5}, {6,7}, {8,10}, {12,16}}, new int[]{4,8});
        assertArrayEquals(output2, new int[][]{{1,2}, {3,10}, {12,16}});
    }

    public static int[][] solution(int[][] intervals, int[] newInterval){
        List<int[]> overlapping = new ArrayList<>();
        List<int[]> result = new ArrayList<>();

        for(int i = 0; i < intervals.length; i++){
            if(overlap(intervals[i], newInterval))
                overlapping.add(intervals[i]);
            else
                result.add(intervals[i]);
        }

        if(overlapping.size() != 0){
            overlapping.add(newInterval);
            return insertInterval(result, mergeIntervals(overlapping));
        }else
            return insertInterval(result, newInterval);
    }

    private static int[] mergeIntervals(List<int[]> overlapping) {
        int start = Integer.MAX_VALUE;
        int end = Integer.MIN_VALUE;

        for(int i = 0; i < overlapping.size(); i++){
            if(overlapping.get(i)[0] <= start)
                start = overlapping.get(i)[0]; 

            if(overlapping.get(i)[1] >= end)
                end = overlapping.get(i)[1];
        }
        return new int[]{start, end};
    }
    
    /**
     * @param intervals list of intervals that do not overlap with newInterval
     * @param newInterval the new interval (that maybe a result of merging with the original new interval)
     * @return the array of arrays of non overlapping intervals
     */
    private static int[][] insertInterval(List<int[]> intervals, int[] newInterval) {
        List<int[]> inserted = new ArrayList<>();

        //corner case: every interval overlap with newInterval, hence intervals is empty
        //because of the splitting in result - overlapping
        if(intervals.size() == 0)
            return new int[][]{newInterval};
        //corner case: new interval is the last starting interval 
        else if(intervals.get(intervals.size()-1)[0] < newInterval[0]){
            intervals.add(newInterval);
            return listOfArraysTo2DArray(intervals);
        }
        //corner case: new interval is the first starting interval
        else if(newInterval[0] <= intervals.get(0)[0]){
            inserted.add(newInterval);
            //insert all the other intervals
            for(int[] interval : intervals)
                inserted.add(interval);
            
            return listOfArraysTo2DArray(inserted);
        }

        //we insert new interval in the right spot
        for(int i = 0; i <= intervals.size()-1; i++){
            inserted.add(new int[]{intervals.get(i)[0], intervals.get(i)[1]});

            /* if the new interval start at the same time or later than the i-th interval
            and ends before or at the same time of the i+1-th interval than newInterval
            has to be between the interval i and i+1 */
            if(newInterval[0] >= intervals.get(i)[0] && newInterval[1] <= intervals.get(i+1)[1])
                inserted.add(new int[]{newInterval[0], newInterval[1]});
            
        }
        return listOfArraysTo2DArray(inserted);
    }

    private static int[][] listOfArraysTo2DArray(List<int[]> list){
        int[][] result = new int[list.size()][2]; 
        for(int i = 0; i < list.size(); i++){
            result[i][0] = list.get(i)[0];
            result[i][1] = list.get(i)[1];
        }
        return result;
    }

    private static boolean overlap(int[] a, int[] b) {
        if(a[0] <= b[1] && a[1] >= b[0])
            return true;

        if(b[1] >= a[0] && b[0] <= a[1])
            return true; 

        return false;
    }


}
