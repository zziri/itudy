// MEMO : 보이어무어 과반수 투표 알고리즘을 알아보자

// 1msec, 99.95%
class Solution {
    public int majorityElement(int[] nums) {
        int major = nums[0];
        int count = 1;

        for (int i=1; i<nums.length; i++) {
            if (nums[i] == major) {
                ++count;
            } else {
                --count;
            }
            
            if (count == 0) {
                major = nums[i];
                count = 1;
            }
        }

        return major;
    }
}

// 7msec, 41.56%
/*
class Solution {
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int n : nums) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }
        
        int maxCount = Integer.MIN_VALUE, maxKey = 0;
        
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int count = entry.getValue();
            int key = entry.getKey();
            if (maxCount < count) {
                maxKey = key;
                maxCount = count;
            }
        }
        
        return maxKey;
    }
}
*/