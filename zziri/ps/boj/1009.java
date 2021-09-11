import java.io.*;
import java.util.*;

class Solution {
    private int getValue(int a, int b) {
        int temp = 1;
        for (int i=0; i<b; i++) {
            temp = temp * a % 10;
        }
        return temp;
    }
    
    public int solution(String line) {
        String[] split = line.split(" ");
        int a = Integer.valueOf(split[0]);
        int b = Integer.valueOf(split[1]);
        int ret = getValue(a, b);
        if (ret == 0)
            ret = 10;
        return ret;
    }
}

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String tc = br.readLine();
        int t = Integer.valueOf(tc);
        Solution solution = new Solution();
        for (int i=0; i<t; i++) {
            int answer = solution.solution(br.readLine());
            System.out.println(answer);
        }
    }
}
