package problems.array;
import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.assertArrayEquals;
/*
 * > PROBLEM 57 (medium): Insert Interval
 *   You are given an array of non-overlapping intervals "intervals"
 *   where intervals[i] = [start_i, end_i] represent the start and 
 *   end of the i-th interval and intervals are sorted in ascending 
 *   order by start_i. 
 *   You are also given an interval "newInterval" = [start, end] 
 *   that represent the start and end of another interval. 
 * 
 *   Insert newInterval into intervals such that intervals is still 
 *   sorted in ascending order by start_i and intervals still does not
 *   have any overlapping intervals (merge overlapping intervals if 
 *   necessary)
 * 
 *   Return intervals after the insertion
 * 
 * > SOLUTION: 
 *   Compute two separated lists, the overlapping list where we 
 *   store the intervals that overlap with newInterval and the result list, 
 *   where we store th list of intervals that do not overlap with newInterval. 
 *   Then we compute the merged intervals by merging newInterval with every 
 *   element in the overlapping list and then we insert the merged in result
 * 
 * > NOTE: 
 *   this is not the optimal solution neither by time or 
 *   space but it was my way vs leetcode, so here we are.
 */
public class InsertInterval {
    public static void main(String[] args) {
        Integer[][] output1 = solution(new Integer[][]{{1,3}, {6, 9}}, new Integer[]{2,5});
        assertArrayEquals(output1, new Integer[][]{{1,5}, {6,9}});

        Integer[][] output2 = solution(new Integer[][]{{1,2}, {3, 5}, {6,7}, {8,10}, {12,16}}, new Integer[]{4,8});
        assertArrayEquals(output2, new Integer[][]{{1,2}, {3,10}, {12,16}});
    }

    public static Integer[][] solution(Integer[][] intervals, Integer[] newInterval){
        List<Integer[]> overlapping = new ArrayList<>();
        List<Integer[]> result = new ArrayList<>();

        for(Integer i = 0; i < intervals.length; i++){
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

    private static Integer[] mergeIntervals(List<Integer[]> overlapping) {
        Integer start = Integer.MAX_VALUE;
        Integer end = Integer.MIN_VALUE;

        for(Integer i = 0; i < overlapping.size(); i++){
            if(overlapping.get(i)[0] <= start)
                start = overlapping.get(i)[0]; 

            if(overlapping.get(i)[1] >= end)
                end = overlapping.get(i)[1];
        }
        return new Integer[]{start, end};
    }
    
    /**
     * @param intervals list of intervals that do not overlap with newInterval
     * @param newInterval the new interval (that maybe a result of merging with the original new interval)
     * @return the array of arrays of non overlapping intervals
     */
    private static Integer[][] insertInterval(List<Integer[]> intervals, Integer[] newInterval) {
        List<Integer[]> inserted = new ArrayList<>();

        // corner case: every interval overlap with newInterval, hence intervals is empty
        // because of the splitting in result - overlapping
        if(intervals.size() == 0)
            return new Integer[][]{newInterval};
        // corner case: new interval is the last starting interval 
        else if(intervals.get(intervals.size()-1)[0] < newInterval[0]){
            inserted.add(newInterval);
            return listOfArraysTo2DArray(intervals);
        }
        // corner case: new interval is the first starting interval
        else if(newInterval[0] <= intervals.get(0)[0]){
            inserted.add(newInterval);
            // insert all the other intervals
            for(Integer[] interval : intervals)
                inserted.add(interval);
            
            return listOfArraysTo2DArray(inserted);
        }

        // we insert new interval in the right spot
        for(Integer i = 0; i <= intervals.size()-1; i++){
            inserted.add(new Integer[]{intervals.get(i)[0], intervals.get(i)[1]});

            // if the new interval start at the same time or later than the i-th interval
            // and ends before or at the same time of the i+1-th interval than newInterval
            // has to be between the interval i and i+1
            if(newInterval[0] >= intervals.get(i)[0] && newInterval[1] <= intervals.get(i+1)[1])
                inserted.add(new Integer[]{newInterval[0], newInterval[1]});
            
        }
        return listOfArraysTo2DArray(inserted);
    }

    private static Integer[][] listOfArraysTo2DArray(List<Integer[]> list){
        Integer[][] result = new Integer[list.size()][2]; 
        for(Integer i = 0; i < list.size(); i++){
            result[i][0] = list.get(i)[0];
            result[i][1] = list.get(i)[1];
        }
        return result;
    }

    private static boolean overlap(Integer[] a, Integer[] b) {
        if(a[0] <= b[1] && a[1] >= b[0])
            return true;

        if(b[1] >= a[0] && b[0] <= a[1])
            return true; 

        return false;
    }
}
