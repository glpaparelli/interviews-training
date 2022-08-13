package problems.array;

import java.util.Arrays;

/*
    > problem: Meeting Rooms 2
    Given an array o fmeeting time intervals consisting of start 
    and end times [[s1, e1], [s2, e2], ...] (obv s_i < e_i), find
    the minimum number of conference rooms rquired
        - e.g: [[0, 30],[5, 10],[15, 20]] -> output 2
    Mind that the array is not sorted by s_i or in any other way

    > idea: first of all we sort by the starting time of the meetings. 
    Then we go through the array from the start: if i and i+1 do overlap
    then they will need two rooms, hence the number of rooms will be 
    incremented. 
    Meetings that do not overlap can be held in the same room, so
    if no meeting overlap only one room is needed
*/
public class MeetingRoomsII {

    public static void main(String[] args) {
        assert(solution(new int[][]{}) == 0);
        assert(solution(new int[][]{{1,4}}) == 1);
        assert(solution(new int[][]{{7,10},{2,4}}) == 1);
        assert(solution(new int[][]{{2,8}, {3,6}}) == 2);
        assert(solution(new int[][]{{0,30},{5,10}, {15,20}}) == 2);
    }

    public static int solution(int[][] meetings){
        if(meetings.length == 0)
            return 0;

        int rooms = 1;
        Arrays.sort(meetings, (m1 , m2) -> Integer.compare(m1[0], m2[0]));

        for(int i = 0; i <= meetings.length-2; i++){
            if(overlap(meetings[i], meetings[i+1]))
                rooms++;
        }

        return rooms;
    }

    private static boolean overlap(int[] m1, int[] m2){
        if(m1[0] <= m2[1] && m1[1] >= m2[0])
            return true;
    
        return false;
    }
}   
