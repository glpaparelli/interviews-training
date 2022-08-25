package problems.array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/*
 * > PROBLEM 759 (hard): Employee Free Time
 *   We are given a list schedule of employees, which represents 
 *   the working time for each employee.
 *   Each employee has a list of non-overlapping Intervals, 
 *   and these intervals are in nonOverlapping order.
 *   Return the list of finite intervals representing common, 
 *   positive-length free time for all employees, also in nonOverlapping order.
 * 
 * > SOLUTION: 
 *   The first thing is to store all the intervals in schedule is a single list and 
 *   then merge the overlapping intervals. 
 *   This is done with two steps:
 *   a) sort all the intervals by starting time
 *   b) if we find an overlap we merge, otherwise we add the interval to the list
 * 
 *   Lastly we iterate over the list of non overlapping intervals sorted by starting 
 *   time: for each adjacent intervals the interval composed by the end time of the 
 *   i-th interval and the start time of the interval i+1 is a free time interval, hence
 *   we add it to the list of free time intervals
 */
class Interval {
    public final int start;
    public final int end;

    public Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public String toString() {
        return "[" + start + "," + end + "]";
    }
}

public class EFT {
    public static void main(String[] args) {
        List<List<Interval>> input1 = new ArrayList<>();
        input1.add(List.of(new Interval(1, 2), new Interval(5, 6)));
        input1.add(List.of(new Interval(1, 3)));
        input1.add(List.of(new Interval(4, 10)));
        List<Interval> output1 = solution(input1);
        output1.forEach(x -> System.out.print(x + " "));

        System.out.println();

        List<List<Interval>> input2 = new ArrayList<>();
        input2.add(List.of(new Interval(1, 3), new Interval(6, 7)));
        input2.add(List.of(new Interval(2, 4)));
        input2.add(List.of(new Interval(2, 5), new Interval(9, 12)));
        List<Interval> output2 = solution(input2);
        output2.forEach(x -> System.out.print(x + " "));
    }

    public static List<Interval> solution(List<List<Interval>> schedule) {
        List<Interval> allSchedules = new ArrayList<Interval>();
        schedule.forEach(x -> allSchedules.addAll(x));
        Collections.sort(allSchedules, (s1, s2) -> Integer.compare(s1.start, s2.start));


        List<Interval> nonOverlapping = new ArrayList<Interval>();
        int start = allSchedules.get(0).start; 
        int end = allSchedules.get(0).end;

        // build the list of non overlapping intervals
        for(int i = 1; i < allSchedules.size(); i++) {
            Interval currentInterval = allSchedules.get(i);
            if (currentInterval.start <= end)
                end = Math.max(end, currentInterval.end);
            else {
                nonOverlapping.add(new Interval(start, end));
                start = currentInterval.start;
                end = currentInterval.end;
            }
        }
        nonOverlapping.add(new Interval(start, end));

        List<Interval> freeTimeList = new ArrayList<Interval>();
        for (int i = 1; i < nonOverlapping.size(); i++)
            freeTimeList.add(new Interval(nonOverlapping.get(i - 1).end, nonOverlapping.get(i).start));
        
        return freeTimeList;
    }
}

