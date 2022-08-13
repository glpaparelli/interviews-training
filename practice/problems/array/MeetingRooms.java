package problems.array;

import java.util.ArrayList;
import java.util.List;
/*
    > problem: Meeting Rooms
    Given a list of meeting time interval consisting of start and end times
    [s1, e1], [s2, e2], ..., determine if a person could attend all meetings
    given that the array is sorted by starting times

    > idea: A person can attend all meeting if they do not overlap. Since
    time is sorted kinda by definition, a person can attend all meeting if 
    the meeting i not overlap with the meeting i+1 and the meeting i+1 do not
    overlap with the meeting i+2 (and by def the meeting i and i+2 will not 
    overlap)... 

    > note that if the array is not sorted by starting times it is enough 
    to sort it and then the solution is the given one
*/
public class MeetingRooms {
    
    public static void main(String[] args) {
        List<Integer[]> test1 = new ArrayList<>();
        test1.add(new Integer[]{0, 30});
        test1.add(new Integer[]{5, 10});
        test1.add(new Integer[]{15, 20});

        List<Integer[]> test2 = new ArrayList<>();
        test2.add(new Integer[]{0, 10});
        test2.add(new Integer[]{12, 20});
        test2.add(new Integer[]{25, 29});

        assert(!solution(test1));
        assert(solution(test2));
    }

    public static boolean solution(List<Integer[]> meetings){
        for(int i = 0; i < meetings.size() -1; i++)
            //check if two consecutive meetings overlap
            if(checkOverlap(meetings.get(i), meetings.get(i+1)))
                return true;

        return false;
    }

    private static boolean checkOverlap(Integer[] m1, Integer[] m2) {    
        if(m1[0] <= m2[1] && m1[1] >= m2[0])
            return true;
    
        return false;
    }
}
