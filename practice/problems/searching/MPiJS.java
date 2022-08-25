package problems.searching;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
/*
 * > PROBLEM 1235 (hard): Maximum Problem in Job Scheduling
 *   // TODO dynamic programming
 */
public class MPiJS {
    
    public static int solution(int[] startTime, int[] endTime, int[] profit){
        Map<Integer, Integer> dp = new HashMap<>();
        int[][] jobs = new int[startTime.length][3];
        for(int i = 0; i < jobs.length; i++)
            jobs[i] = new int[]{startTime[i], endTime[i], profit[i]};

        // sort the jobs by starting times
        Arrays.sort(jobs, (e1, e2) -> e1[0] - e2[0]);

        return recursion(jobs, 0, dp);
    }

    private static int recursion(int[][] jobs, int current, Map<Integer, Integer> dp) {
        if(current == jobs.length)
            return 0;

        int nextJob = findNext(jobs, current);
        int jobScheduled = jobs[current][2] + nextJob == -1 ? 0 : recursion(jobs, nextJob, dp);
        int jobNotScheduled = recursion(jobs, current+1, dp);

        return Math.max(jobScheduled, jobNotScheduled);
    }

    private static int findNext(int[][] jobs, int idx) {
        int start = idx + 1;
        int end = jobs.length -1;
        while(start <= end) {
            int mid = start + (end - start)/2;
            if(jobs[mid][0] >= jobs[idx][1]) {
                if(jobs[mid-1][0] >= jobs[idx][1])
                    end = mid - 1;
                else 
                    return mid;
            } else {
                start = mid + 1;
            }
        }
        
        return -1;
    }

}
