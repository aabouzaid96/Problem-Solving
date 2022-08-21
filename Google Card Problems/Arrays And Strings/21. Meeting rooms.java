/**
edge cases:
{{0,30},{3,16},{5, 10},{ 15, 20}}
{{0,30},{3,16},{5, 20},{ 18, 60}}
{{0,30},{5,16},{3,19},{18,60},{20, 30}}
{{9,10},{4,9},{4, 17}}
/**

class Interval{
    public int start, end;
    Interval(int [] interval){
        this.start = interval[0];
        this.end   = interval[1];
    }
}
class Solution {
    
    public int minMeetingRooms(int[][] intervals) {
        
        Arrays.sort(intervals, Comparator.comparing(a -> a[0]));
        PriorityQueue<Interval> priortiesInterval = new PriorityQueue<>(new Comparator<Interval>() {
            @Override
            public int compare(Interval t1, Interval t2) {
                if (t1.end > t2.end)
                    return 1;
                else 
                    return -1;
            }
        });

        priortiesInterval.add(new Interval(intervals[0]));
        int minMeetingRoomsValue = 1;
        for (int i = 1; i < intervals.length; i++) {
            Interval previousInterval = priortiesInterval.peek();
            Interval currentInterval = new Interval(intervals[i]);

            if (currentInterval.start < previousInterval.end) {
                priortiesInterval.add(currentInterval);
            } else {
                while (currentInterval.start >= previousInterval.end) {
                    priortiesInterval.poll();
                   if(priortiesInterval.isEmpty()) break;
                       previousInterval = priortiesInterval.peek();
                }
                priortiesInterval.add(currentInterval);
            }
            minMeetingRoomsValue = Math.max(minMeetingRoomsValue, priortiesInterval.size());
        }
        return minMeetingRoomsValue;
    
    }
}

/**

[0,30],[3,17],[5,10],[11,20], [18,23]
0  ------------------ 30    
  3-------------17      
    5--------16                    ->  
                  18 ------ 60       
           
    
    
[7,10],[2,4]

        4---10 
 2---4
              
**/
