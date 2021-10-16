// MEMO : 모노톤 스택 좀 더 풀어보기

// Runtime: 5 ms, faster than 44.27% of Java online submissions for Next Greater Element I.
// Memory Usage: 39.3 MB, less than 49.88% of Java online submissions for Next Greater Element I.

class Solution {
    private Map<Integer, Integer> createIndexMap(int[] arr) {
        Map<Integer, Integer> ret = new HashMap<>();
        for (int i=0; i<arr.length; i++) {
            ret.put(arr[i], i);
        }
        return ret;
    }
    
    private int[] createArray(int length) {
        int[] ret = new int[length];
        for (int i=0; i<length; i++) {
            ret[i] = -1;
        }
        return ret;
    }
    
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer, Integer> indexMap = createIndexMap(nums1);
        int[] ret = createArray(nums1.length);
        Stack<Integer> s = new Stack<>();
        for (int n : nums2) {
            while (!s.isEmpty() && s.peek() <= n) {
                if (indexMap.containsKey(s.peek())) {
                    int index = indexMap.get(s.peek());
                    ret[index] = n;
                }
                s.pop();
            }
            s.push(n);
        }
        return ret;
    }
}
