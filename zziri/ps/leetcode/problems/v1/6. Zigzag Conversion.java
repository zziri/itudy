// MEMO : 좀 많이 느리다. 답 보고 한번 더 풀이!!

// Runtime: 75 ms, faster than 7.81% of Java online submissions for Zigzag Conversion.
// Memory Usage: 51.7 MB, less than 9.19% of Java online submissions for Zigzag Conversion.
class Solution {
    private static final int[] dx = {0, 1};
    private static final int[] dy = {1, -1};

    private boolean out(int x, int y, char[][] map) {
        return (x < 0 || y < 0 || x >= map[0].length || y >= map.length);
    }
    
    private boolean valid(char[][] map, int x, int y) {
        char c = map[y][x];
        return (
            (c >= 'a' && c <= 'z') ||
            (c >= 'A' && c <= 'Z') ||
            c == ',' ||
            c == '.'
        );
    }

    public String convert(String s, int numRows) {
        if (numRows == 1)
            return s;
        char[][] map = new char[numRows][s.length()/2+1];
        int x = 0, y = 0, i = 0, dir = 0;
        StringBuffer ret = new StringBuffer();
        
        while (i < s.length()) {
            map[y][x] = s.charAt(i);
            int nx = x + dx[dir];
            int ny = y + dy[dir];
            if (out(nx, ny, map)) {
                dir = (dir+1)%2;
                continue;
            }
            i += 1;
            x = nx;
            y = ny;
        }
        
        for (y=0; y<map.length; y++) {
            for (x=0; x<map[0].length; x++) {
                if (!valid(map, x, y))
                    continue;
                ret.append(map[y][x]);
            }
        }
        
        return ret.toString();
    }
}
