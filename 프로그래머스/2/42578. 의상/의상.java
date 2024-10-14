import java.io.*;
import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        int answer = 0;
        
        int N = clothes.length;
        
        HashMap<String, List<String>> style = new HashMap<String, List<String>>();
        for (int i = 0; i < N; i++) {
            if (style.containsKey(clothes[i][1])) {
                style.get(clothes[i][1]).add(clothes[i][0]);
            } else {
                List<String> values = new ArrayList<>();
                values.add(clothes[i][0]);
                style.put(clothes[i][1], values);
            }
        }
        
        answer = 1;
        for (String key : style.keySet()) {
		    answer *= style.get(key).size() + 1;
            
        }
        
        answer--;
        return answer;
    }
}