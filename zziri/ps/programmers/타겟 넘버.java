// MEMO : 완탐할 때에는 반드시 시간복잡도 계산하고 각 재기!

class Solution {
    private int cal(int depth, int[] operands, int value, int target) {
        if (depth == operands.length)
            return target == value ? 1 : 0;
        int ret = 0;
        ret += cal(depth+1, operands, value+operands[depth], target);
        ret += cal(depth+1, operands, value-operands[depth], target);
        return ret;
    }

    public int solution(int[] numbers, int target) {
        int answer = 0;
        answer = cal(0, numbers, 0, target);
        return answer;
    }
}
