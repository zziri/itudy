// MEMO : 비트연산에 집착할 필요는 없다...

/*
    Runtime: 0 ms, faster than 100.00% of Java online submissions for Sort Colors.
    Memory Usage: 37.7 MB, less than 29.93% of Java online submissions for Sort Colors.
*/
class Solution {
    public void sortColors(int[] nums) {
        int count = 0, idx = 0;
        for (int num : nums) {
            count += (0x01 << (num*10));
        }

        int limit = count & 1023;
        for (int i=0; i<limit; i++) {
            nums[idx++] = 0;
        }
        limit = (count >> 10) & 1023;
        for (int i=0; i<limit; i++) {
            nums[idx++] = 1;
        }
        limit = (count >> 20) & 1023;
        for (int i=0; i<limit; i++) {
            nums[idx++] = 2;
        }
    }
}
