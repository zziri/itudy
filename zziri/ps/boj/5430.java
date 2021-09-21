// MEMO : deque 사용법 익혀두자..!

import java.io.*;
import java.util.*;

class Solution {

    private void copy(int[] arr, int s, int e, List<Integer> list) {
        if (s < e) {
            for (int i=s; i<=e; i++) {
                list.add(arr[i]);
            }
        } else {
            for (int i=s; i>=e; i--) {
                list.add(arr[i]);
            }
        }
    }

    public String solution(String p, int length, String array) {
        int[] arr = getIntArray(array.substring(1, array.length()-1), length);
        int left = 0;
        int right = arr.length-1;
        int pointer = left;
        for (int i=0; i<p.length(); i++) {
            Character cmd = p.charAt(i);
            if (cmd.equals('R')) {
                pointer = pointer == left ? right : left;
            } else if (cmd.equals('D')) {
                if (left > right)
                    return "error";
                if (pointer == left) {
                    left += 1;
                    pointer = left;
                } else if (pointer == right) {
                    right -= 1;
                    pointer = right;
                } else {
                    throw new RuntimeException("pointer error");
                }
            }
        }
        List<Integer> ret = new ArrayList<>();
        if (left <= right) {
            if (pointer == left) {
                copy(arr, left, right, ret);
            } else if (pointer == right) {
                copy(arr, right, left, ret);
            }
        }
        return ret.toString().replaceAll("\\s+", "");
    }

    private int[] getIntArray(String array, int length) {
        int[] ret = new int[length];
        int index = 0;
        if (length < 1)
            return ret;
        String[] strArray = array.split(",");
        for (int i=0; i<strArray.length; i++) {
            ret[index++] = Integer.parseInt(strArray[i]);
        }
        return ret;
    }
}

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        for (int t=0; t<tc; t++) {
            Solution solution = new Solution();
            String p = br.readLine();
            int length = Integer.parseInt(br.readLine());
            String array = br.readLine();
            System.out.println(solution.solution(p, length, array));
        }
    }
}
