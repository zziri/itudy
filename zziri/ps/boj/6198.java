// MEMO : 모노톤 스택 문제 좀 더 풀어보자

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class Solution {
    public long solve(List<Integer> buildings) {
        Stack<Integer> s = new Stack<>();
        long ret = 0;
        for (int height : buildings) {
            while (!s.isEmpty() && s.peek() <= height) {
                s.pop();
            }
            s.push(height);
            ret += (long)s.size()-1L;
        }

        return ret;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        List<Integer> buildings = new ArrayList<>();

        int n = Integer.parseInt(br.readLine());
        for (int i=0; i<n; i++) {
            buildings.add(Integer.parseInt(br.readLine()));
        }

        System.out.println(new Solution().solve(buildings));
    }
}
