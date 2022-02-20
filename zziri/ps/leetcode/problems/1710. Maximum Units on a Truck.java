// MEMO : 매일매일 간단한 문제라도.. 머리가 굳지 않게 해준다

// Runtime: 7 ms, faster than 90.20% of Java online submissions for Maximum Units on a Truck.
// Memory Usage: 38.8 MB, less than 91.21% of Java online submissions for Maximum Units on a Truck.
class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes, (box1, box2) -> {
            return box2[1] - box1[1];
        });

        int ret = 0;

        for (int i=0; i<boxTypes.length && truckSize > 0; i++) {
            int numOfBox = boxTypes[i][0];
            int units = boxTypes[i][1];
            if (numOfBox > truckSize)
                numOfBox = truckSize;

            truckSize -= numOfBox;
            ret += numOfBox * units;
        }

        return ret;
    }
}