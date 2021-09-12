// MEMO : 분할정복 할 줄 아는데.. 안타깝다

import java.io.*;
import java.util.*;

class Solution {
    private int[][] map;

    private int[][] initMap(String[] image) {
        int[][] ret = new int[image.length][image.length];
        for (int i=0; i<image.length; i++) {
            String[] split = image[i].split("");
            for (int j=0; j<split.length; j++) {
                ret[i][j] = Integer.parseInt(split[j]);
            }
        }
        return ret;
    }

    private boolean allSame(int x, int y, int size) {
        int value = -1;
        for (int i=y; i<y+size; i++) {
            for (int j=x; j<x+size; j++) {
                if (value < 0) {
                    value = map[i][j];
                    continue;
                }
                if (value != map[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }

    private void recur(int x, int y, int size, StringBuilder sb) {
        if (allSame(x, y, size)) {
            sb.append(map[y][x]);
        } else {
            sb.append("(");
            int delta = size/2;
            recur(x, y, delta, sb);
            recur(x + delta, y, delta, sb);
            recur(x, y + delta, delta, sb);
            recur(x + delta, y + delta, delta, sb);
            sb.append(")");
        }
    }

    public String solution(String[] image) {
        StringBuilder sb = new StringBuilder();
        map = initMap(image);
        recur(0, 0, image.length, sb);
        return sb.toString();
    }
}

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] image = new String[n];
        for (int i=0; i<n; i++) {
            image[i] = br.readLine();
        }
        Solution solution = new Solution();
        System.out.println(solution.solution(image));
    }
}
