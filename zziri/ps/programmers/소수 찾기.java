// MEMO : 잔실수 줄이자..!

import java.util.*;

class Solution {
    private List<Integer> toIntegerList(String str) {
        List<Integer> ret = new ArrayList<>();
        for (int i=0; i<str.length(); i++) {
            ret.add(Integer.valueOf(str.charAt(i) - '0'));
        }
        return ret;
    }
    
    private void recursion(List<Integer> list, int val, Set<Integer> set, boolean[] picked, int depth) {
        set.add(val);
        if (depth == list.size())
            return;
        for (int i=0; i<list.size(); i++) {
            if (picked[i])
                continue;
            picked[i] = true;
            int n = list.get(i);
            recursion(list, val*10+n, set, picked, depth+1);
            picked[i] = false;
        }
    }
    
    private boolean prime(int n) {
        if (n < 2)
            return false;
        for (int i=2; i<n; i++) {
            if (n % i == 0)
                return false;
        }
        return true;
    }
    
    private int counting(Set<Integer> set) {
        int ret = 0;
        for (int n : set) {
            if (prime(n))
                ret += 1;
        }
        return ret;
    }
    
    public int solution(String numbers) {
        List<Integer> list = toIntegerList(numbers);
        System.out.println(list);
        Set<Integer> set = new HashSet<>();
        recursion(list, 0, set, new boolean[list.size()], 0);
        return counting(set);
    }
}
