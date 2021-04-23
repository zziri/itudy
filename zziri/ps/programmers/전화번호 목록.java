// MEMO : Set의 contains는 같은 객체일 때 true 반환한다. Set, Map에서 key로 StringBuilder는 쓰지 말자.

import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        Set<String> set = new HashSet<>();
        for (String str : phone_book) {
            set.add(str);
        }

        for (String str : phone_book) {
            for (int end=1; end<str.length(); end++) {
                if (set.contains(str.substring(0, end)))
                    return false;
            }
        }
        return answer;
    }
}
