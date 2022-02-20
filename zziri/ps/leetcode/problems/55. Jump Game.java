// MEMO : Greedy 하게 풀면 O(n)에 풀 수 있다...! 다시 풀어보기

// 385 ms, 20.73 %
class Node {
    int index;
    int value;
    Node(int index, int value) { this.index = index; this.value = value; }
}

class Solution {
    private int[] arr;
    private void init(int[] nums) {
        this.arr = nums;
    }
    
    private boolean bfs() {
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(0, arr[0]));
        arr[0] = -1;

        while (!q.isEmpty()) {
            Node cur = q.poll();
            if (cur.index == arr.length - 1)
                return true;

            int len = cur.value;
            int limit = Math.min(arr.length, cur.index+len+1);
            for (int i=cur.index+1; i<limit; i++) {
                if (arr[i] < 0)
                    continue;
                q.add(new Node(i, arr[i]));
                arr[i] = -1;
            }
        }
        return false;
    }
    
    public boolean canJump(int[] nums) {
        init(nums);
        return bfs();
    }
}
