package problems.array;
import static org.junit.Assert.assertArrayEquals;
import java.util.Arrays;
import java.util.LinkedList;
/*
 * > PROBLEM: Merge Intervals
 *   Given an array "intervals" where intervals[i] = [start_i, end_i], 
 *   merge all overlapping intervals and return an array of the 
 *   non-overlapping intervals that cover all the intervals in the workingRes
 * 
 * > SOLUTION: 
 *   We sort the input by the start of the intervals, then we insert 
 *   the first interval in an array and, starting with the second interval, 
 *   if there is no overlap we insert, otherwise we merge and than insert
 */
public class MergeIntervals {
    public static void main(String[] args) {
        int[][] output1 = solution(new int[][]{{1,3},{2,6},{8,10},{15,18}});
        assertArrayEquals(output1, new int[][]{{1,6},{8,10},{15,18}});

        int[][] output2 = solution(new int[][]{{1,4},{4,5}});
        assertArrayEquals(output2, new int[][]{{1,5}});
    }

    public static int[][] solution(int[][] intervals){
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        LinkedList<Integer[]> intervalsCpy = new LinkedList<>();
        for(int [] interval : intervals)
            intervalsCpy.add(Arrays.stream(interval).boxed().toArray(Integer[] :: new));

        LinkedList<Integer[]> workingRes = new LinkedList<>();

        for(Integer[] interval : intervalsCpy){
            if(workingRes.isEmpty())
                workingRes.add(interval);

            /* no overlapping: the end of the last interval is    
            smaller than the start of the current interval to insert */
            if(workingRes.getLast()[1] < interval[0])
                workingRes.add(interval);
            else
                /* here we overlap: we simply update the end of the interval 
                with the biggest one. Since this is the no overlapping list
                and the input is sorted by start, getLast()[0] is surely 
                less that interval[0]! */
                workingRes.getLast()[1] = Math.max(workingRes.getLast()[1], interval[1]);
        }

        int[][] result = new int[workingRes.size()][2];
        for(int i = 0; i < workingRes.size(); i++){
            result[i][0] = workingRes.get(i)[0];
            result[i][1] = workingRes.get(i)[1];
        }
        return result;
    }
}