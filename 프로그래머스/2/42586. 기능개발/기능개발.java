import java.io.*;
import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] answer = {};
        
        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < progresses.length; i++) {
            int day = (100 - progresses[i]) / speeds[i];
            if ((100 - progresses[i]) % speeds[i] != 0) {
                day++;
            }
            
            queue.add(day);
        }
        
        int now = queue.poll();
        int[] outDay = new int[speeds.length];
        int index = 0;
        outDay[index]++;
        while (!queue.isEmpty()) {
            int day = queue.poll();
            
            if (now < day) {
                index++;
                now = day; 
            }
            
            outDay[index]++;
        }
        
        answer = new int[index + 1];
        for (int i = 0; i <= index; i++) {
            answer[i] = outDay[i];
        }
        
        return answer;
    }
}