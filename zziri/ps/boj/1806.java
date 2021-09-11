import java.io.*;
import java.util.*;

class Solution {
    private int[] getArray(String line) {
        String[] split = line.split(" ");
        int[] ret = new int[split.length];
        for (int i=0; i<split.length; i++) {
            ret[i] = Integer.valueOf(split[i]);
        }
        return ret;
    }
    public int solution(int n, int s, String line) {
        int[] arr = getArray(line);
        int left = 0, right = 0;
        int sum = arr[left];
        int ret = Integer.MAX_VALUE;
        while (left <= right && left < n && right < n) {
            if (sum < s) {
                if (right == n-1)
                    break;
                sum += arr[++right];
            } else {
                ret = Math.min(ret, right-left+1);
                sum -= arr[left++];
            }
        }
        if (ret == Integer.MAX_VALUE)
            ret = 0;
        return ret;
    }
}

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] ns = br.readLine().split(" ");
        Solution solution = new Solution();
        System.out.println(solution.solution(Integer.valueOf(ns[0]), Integer.valueOf(ns[1]), br.readLine()));
    }
}
