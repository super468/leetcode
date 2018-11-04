

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Creator : wangtaishan
 * Date : 2018/8/28
 * Title :
 * Description :
 * Analysis :
 */

public class MergeIntervals {
    public List<Interval> merge(List<Interval> intervals) {
        //List<Interval> ans = new ArrayList<>();
        Collections.sort(intervals, new Sortbyroll());
        int i = 0;
        for(i = 0; i < intervals.size() - 1; i++){
            if(intervals.get(i).end >= intervals.get(i + 1).start){
                Interval in = new Interval(intervals.get(i).start, Math.max(intervals.get(i).end, intervals.get(i + 1).end));
                //ans.add(in);
                intervals.set(i, in);
                intervals.remove(i + 1);
                i--;
            }
        }
        //if(i == intervals.size() - 1) ans.add(intervals.get(i));
        return intervals;
    }
}

class Sortbyroll implements Comparator<Interval>
{
    // Used for sorting in ascending order of
    // roll number
    public int compare(Interval a, Interval b)
    {
        return a.start - b.start;
    }
}

class Interval {
    int start;
    int end;
    Interval() { start = 0; end = 0; }
    Interval(int s, int e) { start = s; end = e; }
}