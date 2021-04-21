// MEMO : 예외처리 꼭 신경쓰자

import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>((l, r) -> {
            return l - r;
        });
        for (int score : scoville) {
            pq.add(score);
        }

        while (pq.peek() != null && pq.peek() < K) {
            if (pq.size() < 2)
                return -1;
            ++answer;
            int first = pq.poll().intValue(), second = pq.poll().intValue();
            pq.add(first + (second*2));
        }

        return pq.peek() == null ? -1 : answer;
    }
}
