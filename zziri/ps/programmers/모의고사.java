// MEMO : 구현력을 키우자

import java.util.*;

class Solution {
    private int[][] cycle = {
        {1, 2, 3, 4, 5},
        {2, 1, 2, 3, 2, 4, 2, 5},
        {3, 3, 1, 1, 2, 2, 4, 4, 5, 5}
    };
    
    private int getScore(int[] answers, int index) {
        int[] cycle = this.cycle[index];
        int ret = 0;
        for (int i=0; i<answers.length; i++) {
            if (answers[i] == cycle[i%cycle.length])
                ret += 1;
        }
        return ret;
    }
    
    private int getMaxScore(int[] score) {
        int ret = 0;
        for (int i=0; i<score.length; i++) {
            ret = Math.max(ret, score[i]);
        }
        return ret;
    }
    
    private int[] toPrimitiveArray(List<Integer> list) {
        int[] ret = new int[list.size()];
        for (int i=0; i<list.size(); i++) {
            ret[i] = list.get(i);
        }
        return ret;
    }
    
    public int[] solution(int[] answers) {
        List<Integer> answer = new ArrayList<>();
        int[] score = new int[3];
        for (int i=0; i<3; i++) {
            score[i] = getScore(answers, i);
        }
        int maxScore = getMaxScore(score);
        for (int i=0; i<3; i++) {
            if (maxScore == score[i]) {
                answer.add(i+1);
            }
        }
        
        return toPrimitiveArray(answer);
    }
}
