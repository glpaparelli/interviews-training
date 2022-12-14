package easy;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import datastructures.Interval;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
/*
 * > PROBLEM 252 (easy): Meeting Rooms
 *   Given a list of meeting time interval consisting of start and end times
 *   [s1, e1], [s2, e2], ..., determine if a person could attend all meetings
 *   given that the array is sorted by starting times
 * 
 * > arraySolution: 
 *   A person can attend all meeting if they do not overlap. 
 *   A person can attend all meeting if the meeting i not overlap with the meeting i+1 
 *   and the meeting i+1 do not overlap with the meeting i+2 
 *   (and by def the meeting i and i+2 will not overlap) ... 
 */
public class MeetingRooms {
    public static void main(String[] args) {
        List<Integer[]> test1 = new ArrayList<>();
        test1.add(new Integer[]{0, 30});
        test1.add(new Integer[]{5, 10});
        test1.add(new Integer[]{15, 20});

        List<Interval> test1Interval = new ArrayList<>();
        test1Interval.add(new Interval(0, 30));
        test1Interval.add(new Interval(5, 10));
        test1Interval.add(new Interval(15, 20));

        List<Integer[]> test2 = new ArrayList<>();
        test2.add(new Integer[]{0, 10});
        test2.add(new Integer[]{12, 20});
        test2.add(new Integer[]{25, 29});

        List<Interval> test2Interval = new ArrayList<>();
        test2Interval.add(new Interval(0, 10));
        test2Interval.add(new Interval(12, 20));
        test2Interval.add(new Interval(25, 29));

        assertTrue(arraySolution(test1));
        assertFalse(arraySolution(test2));

        assertTrue(intervalSolution(test1Interval));
        assertFalse(intervalSolution(test2Interval));
    }

    // returns true if intervals overlaps 
    public static boolean arraySolution(List<Integer[]> meetings){
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

    public static boolean intervalSolution(List<Interval> meetings){
        Collections.sort(meetings, (a, b) -> Integer.compare(a.start, b.start));

        for(int i = 0; i < meetings.size() -1; i++)
            if(checkOverlap(meetings.get(i), meetings.get(i+1)))
                return true; 

        return false; 
    }

    private static boolean checkOverlap(Interval i1, Interval i2) {
        if(i1.start <= i2.end && i1.end >= i2.start)
            return true; 
        
        return false;
    }
}
