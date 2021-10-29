// MEMO : Object의 array를 new 하면 null로 초기화된다

// Runtime: 2 ms, faster than 99.48% of Java online submissions for Course Schedule.
// Memory Usage: 39.4 MB, less than 88.08% of Java online submissions for Course Schedule.

class Solution {
    private static final int PROCEEDING = 1;
    private static final int COMPLETE = 2;
    
    private boolean travel(int course, List<Integer>[] graph, int[] flag) {
        boolean ret = true;
        if (flag[course] == COMPLETE)
            return true;
        if (flag[course] == PROCEEDING)
            return false;
        
        flag[course] = PROCEEDING;
        for (int i=0; i<graph[course].size(); i++) {
            int next = graph[course].get(i);
            ret &= travel(next, graph, flag);
            if (!ret)
                return ret;
        }
        flag[course] = COMPLETE;
        return ret;
    }
    
    private List<Integer>[] getBlankArray(int size) {
        List<Integer>[] ret = new ArrayList[size];
        for (int i=0; i<size; i++) {
            ret[i] = new ArrayList<>();
        }
        return ret;
    }
    
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<Integer>[] graph = getBlankArray(numCourses);
        int[] flag = new int[numCourses];
        
        for (int i=0; i<prerequisites.length; i++) {
            int pre = prerequisites[i][1];
            int next = prerequisites[i][0];
            graph[pre].add(next);
        }
        
        for (int course=0; course<numCourses; course++) {
            if (flag[course] == COMPLETE)
                continue;
            if (!travel(course, graph, flag))
                return false;
        }
        return true;
    }
}
