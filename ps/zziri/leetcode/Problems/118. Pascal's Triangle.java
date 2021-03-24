// MEMO : 간단한 문제라도 설계는 하자... 너무 지저분!

class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ret = new ArrayList<>();
        ret.add(new ArrayList<>());
        ret.get(0).add(1);
        
        for (int i=1; i<numRows; i++) {
            List<Integer> part = new ArrayList<>();
            part.add(1);
            if (i != 1) {
                for (int j=0; j<ret.get(i-1).size()-1; j++) {
                    part.add(ret.get(i-1).get(j) + ret.get(i-1).get(j+1));
                }
            }
            part.add(1);
            ret.add(part);
        }
        
        return ret;
    }
}
