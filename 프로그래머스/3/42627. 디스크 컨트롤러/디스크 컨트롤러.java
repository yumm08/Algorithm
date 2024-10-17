import java.io.*;
import java.util.*;

class Solution {
    public int solution(int[][] jobs) {
        int answer = 0;
        
        PriorityQueue<int[]> workQue = new PriorityQueue<>((o1, o2) -> {
            return o1[1] - o2[1];
        });
        PriorityQueue<int[]> inQue = new PriorityQueue<>((o1, o2) -> {
            return o1[0] - o2[0];
        });
        
        for(int[] j : jobs)
            inQue.offer(j);
        
        int total = 0;
        int time = 0;
        while (!workQue.isEmpty() || !inQue.isEmpty()) {
            
            while(!inQue.isEmpty() && inQue.peek()[0] <= time){
                workQue.offer(inQue.poll());
            }
            
            if (workQue.isEmpty()) {
                time = inQue.peek()[0];
            } else {
                int[] now = workQue.poll();
                total += time + now[1] - now[0];
                time += now[1];
            }
        }
        
        answer = total / jobs.length;
        return answer;
    }
}