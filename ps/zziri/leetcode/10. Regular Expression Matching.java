import java.util.regex.*;
class Solution {
    public boolean isMatch(String s, String p) {
        Pattern pattern = Pattern.compile(p);
        Matcher matcher = pattern.matcher(s);
        if(!matcher.matches()) {
            return false;
        }
        int start = matcher.start();
        int end = matcher.end();
        String temp = s.substring(start, end);
        if(s.equals(temp)) {
            return true;
        }
        else{
            return false;
        }
    }
}
