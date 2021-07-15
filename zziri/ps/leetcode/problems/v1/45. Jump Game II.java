// MEMO : BFS가 은근히 쓸데가 많다 배제하지 말자

// Runtime: 35 ms, faster than 31.69% of Java online submissions for Jump Game II.
// Memory Usage: 39.4 MB, less than 67.27% of Java online submissions for Jump Game II.
class Node {
    int level;
    int index;
    Node() {}
    Node(int l, int i) { this.level = l; this.index = i; }
}

class Solution {
    public int jump(int[] nums) {
        boolean[] visited = new boolean[nums.length];
        int ret = nums.length;
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(0, 0));
        while (!q.isEmpty()) {
            int index = q.peek().index;
            int level = q.peek().level;
            q.poll();
            
            if (index == nums.length - 1) {
                ret = Math.min(ret, level);
                continue;
            }
            
            int limit = Math.min(nums[index] + index, nums.length-1);
            
            for (int nextIndex=index+1; nextIndex <= limit; nextIndex++) {
                if (visited[nextIndex])
                    continue;
                q.add(new Node(level+1, nextIndex));
                visited[nextIndex] = true;
            }
        }
        
        return ret;
    }
}