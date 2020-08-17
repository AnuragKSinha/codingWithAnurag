import java.util.*;
/**
 * Time Complexity : O(n)
 * Space Complexity: O(n)
 * Given a list of non-overlapping intervals sorted by their start time, insert a given interval at 
 * the correct position and merge all necessary intervals to produce a list that has only mutually
 * exclusive intervals.
 */
class Interval {
  int start;
  int end;

  public Interval(int start, int end) {
    this.start = start;
    this.end = end;
  }
};

class InsertInterval {

  public static List<Interval> insert(List<Interval> intervals, Interval newInterval) {
    List<Interval> mergedIntervals = new ArrayList<>();
    int i=0;
    while(intervals.get(i).end<newInterval.start){
      mergedIntervals.add(intervals.get(i++));
    }
    int start=newInterval.start;
    int end=newInterval.end;
    while(i<intervals.size() && newInterval.start<intervals.get(i).start && 
    newInterval.end>intervals.get(i).start){
       start=Math.min(start,intervals.get(i).start);
       end=Math.max(end,intervals.get(i).end);
       i++;
    }
    mergedIntervals.add(new Interval(start,end));
    while(i<intervals.size())
        mergedIntervals.add(intervals.get(i++));
    return mergedIntervals;
  }

  public static void main(String[] args) {
      List<Interval> input = new ArrayList<Interval>();
    input.add(new Interval(1, 3));
    input.add(new Interval(5, 7));
    input.add(new Interval(8, 12));
    System.out.print("Intervals after inserting the new interval: ");
    for (Interval interval : InsertInterval.insert(input, new Interval(4, 6)))
      System.out.print("[" + interval.start + "," + interval.end + "] ");
    System.out.println();

    input = new ArrayList<Interval>();
    input.add(new Interval(1, 3));
    input.add(new Interval(5, 7));
    input.add(new Interval(8, 12));
    System.out.print("Intervals after inserting the new interval: ");
    for (Interval interval : InsertInterval.insert(input, new Interval(4, 10)))
      System.out.print("[" + interval.start + "," + interval.end + "] ");
    System.out.println();

    input = new ArrayList<Interval>();
    input.add(new Interval(2, 3));
    input.add(new Interval(5, 7));
    System.out.print("Intervals after inserting the new interval: ");
    for (Interval interval : InsertInterval.insert(input, new Interval(1, 4)))
      System.out.print("[" + interval.start + "," + interval.end + "] ");
    System.out.println();
  }
}