import java.io.*;
import java.util.*;

class Solution {
    boolean solution(String s) {
        boolean answer = true;

        Stack<Character> stack = new Stack<>();
        char[] str = s.toCharArray();
        for (int i = 0; i < str.length; i++) {
            char c = str[i];
            if (c == '(') {
                stack.add(c);
            } else if (!stack.isEmpty()){
                stack.pop();
            } else {
                answer = false;
                break;
            }
        }
        
        if (!stack.isEmpty()) {
            answer = false;
        }

        return answer;
    }
}