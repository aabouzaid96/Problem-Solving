// using get k top elements using priority queue

class Solution {
    public int scheduleCourse(int[][] courses) {
       // sort courses with 2nd param
        Arrays.sort(courses, (a, b) -> a[1] == b[1] ? a[0]-b[0] : a[1] - b[1]);
        PriorityQueue<Integer> courses_taken = new PriorityQueue<>((a,b) -> b-a);

        int time=0;
        for(int course[]: courses){ 
            // check if duration less than lastDay              
            if(course[0] <= course[1]){
                if(time + course[0] <= course[1]){
                    time+=course[0];
                    courses_taken.offer(course[0]);
                }
                else{
                    if(courses_taken.peek() > course[0]) {
                        time -= courses_taken.poll();
                        time+=course[0];
                        courses_taken.offer(course[0]);
                    }
                }
            }
        }
        return  courses_taken.size();
    }
}
