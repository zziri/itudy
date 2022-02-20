// MEMO : 값의 범위를 이용해서 marking 하는 방법이 꽤 유용하다

class Solution {
    private void sorting(int[][] arr) {
        Arrays.sort(arr, (l, r) -> {
            if (l[0] == r[0])
                return l[1] - r[1];
            else
                return l[0] - r[0];
        });
    }
    
    private boolean overlap(int[] l, int[] r) {
        return l[1] >= r[0];
    }
    
    public int[][] merge(int[][] intervals) {
        List<int[]> list = new ArrayList<>();
        sorting(intervals);

        for (int i=0; i<intervals.length-1; i++) {
            if (overlap(intervals[i], intervals[i+1])) {
                intervals[i+1][0] = Math.min(intervals[i][0], intervals[i+1][0]);
                intervals[i+1][1] = Math.max(intervals[i][1], intervals[i+1][1]);
                intervals[i][0] = intervals[i][1] = -1;
            }
        }
        
        for (int i=0; i<intervals.length; i++) {
            if (intervals[i][0] >= 0 && intervals[i][1] >= 0) {
                int[] tmp = new int[2];
                tmp[0] = intervals[i][0]; tmp[1] = intervals[i][1];
                list.add(tmp);
            }
        }
        
        return list.toArray(new int[list.size()][2]);
    }
}
