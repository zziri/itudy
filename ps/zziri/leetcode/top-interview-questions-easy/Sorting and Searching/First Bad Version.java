// MEMO : 오버플로우 조심!

/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        long l=1, r=n;

        while (l < r) {
            long mid = (l+r)>>1;
            if (isBadVersion((int)mid)) {
                r = mid;
            } else {
                l = mid+1;
            }
        }
        
        return (int)l;
    }
}
