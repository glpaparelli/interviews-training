package medium;
import java.util.Arrays;
/*
 * > PROBLEM 435 (medium): Non-Overlapping Intervals
 *   Given an array of intervals "intervals" where at the i-th position
 *   we have [start_i, end_i], return the minimum number of intervals you
 *   need to remove to make the intervals non-overlapping
 * 
 * > SOLUTION: 
 *   We sort the array by the starting of the intervals. 
 *   Then we check for overlappings: if there is an overlapping 
 *   we have to remove one of the two intervals that overlap, so 
 *   we increase the counter of the discarded intervals.
 *   Which interval we discard? the one that lasts longer
 */
public class NOI {
    public static int solution(int[][] intervals){
        int discarded = 0;
        // we sort the array by starting times
        Arrays.sort(intervals, (e1, e2) -> Integer.compare(e1[0], e2[0]));
        
        int previousIntervalEnds = intervals[0][1];
        int currentIntervalStarts = 0;
        int currentIntervalEnds = 0;
        for(int i = 1; i < intervals.length; i++){
            currentIntervalStarts = intervals[i][0];
            currentIntervalEnds = intervals[i][1];

            // the current interval starts before the end of the 
            // previous interval, aka the previous interval is still
            // going when the current interval starts: overlap
            if(currentIntervalStarts < previousIntervalEnds){
                // overlap: one interval has to be discarded
                discarded++; 
                // between two overlapping interval we keep the interval 
                // that last less: more an interval is long and more it is
                // likely to cause overlaps
                previousIntervalEnds = Math.min(previousIntervalEnds, currentIntervalEnds);
            }else
                previousIntervalEnds = currentIntervalEnds;
        }
        return discarded;
    }
}
